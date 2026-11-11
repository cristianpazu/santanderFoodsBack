package com.example.santanderfoods.santanderfoods.Pedidos.service.impl;

import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.*;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.PedidoItem;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.Pedidos;
import com.example.santanderfoods.santanderfoods.Pedidos.repository.PedidoRepository;
import com.example.santanderfoods.santanderfoods.Pedidos.service.PedidoService;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Restaurantes.repositorty.RestauranteRepository;
import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import com.example.santanderfoods.santanderfoods.productos.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoIMPL implements PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;    @Autowired
   RestauranteRepository restauranteRepository;    @Autowired
   ProductosRepository productosRepository;
    @Override
    public Pedidos registrarPedido(PedidoRequestDTO pedidoRequestDTO) {
        try{
            // 1. Buscar el restaurante
        Restaurantes restaurante = restauranteRepository
                    .findById(pedidoRequestDTO.getRestauranteId())
                    .orElseThrow(() ->
                            new RuntimeException("Restaurante no encontrado")
                    );

            // 2. Crear el pedido
            Pedidos pedido = new Pedidos();

            pedido.setRestaurante(restaurante);
            pedido.setNombreCliente(pedidoRequestDTO.getNombreCliente());
            pedido.setTelefonoCliente(pedidoRequestDTO.getTelefonoCliente());
            pedido.setDireccionEntrega(pedidoRequestDTO.getDireccionEntrega());
            pedido.setMetodoPago(pedidoRequestDTO.getMetodoPago());

            pedido.setFecha(LocalDate.now());
            pedido.setHora(LocalTime.now());
            pedido.setEstado("PENDIENTE");

            // 3. Crear los detalles del pedido
            List<PedidoItem> items = new ArrayList<>();

            int totalPedido = 0;

            for (PedidoItemRequestDTO itemRequest : pedidoRequestDTO.getItems()) {

                // Buscar producto
                Productos producto = productosRepository
                        .findById(itemRequest.getProductoId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Producto no encontrado: " + itemRequest.getProductoId()
                                )
                        );

                // Validar cantidad
                if (itemRequest.getCantidad() == null ||
                        itemRequest.getCantidad() <= 0) {

                    throw new RuntimeException("Cantidad inválida");
                }

                // Validar que el producto pertenezca al restaurante
                if (!producto.getSubmenu()
                        .getMenu()
                        .getRestaurante()
                        .getIdRestaurante()
                        .equals(pedidoRequestDTO.getRestauranteId())) {

                    throw new RuntimeException(
                            "El producto no pertenece al restaurante seleccionado"
                    );
                }

                // Obtener el precio actual desde la base de datos
                int precioUnitario = producto.getPrecio();

                // Calcular subtotal
                int subtotal = precioUnitario * itemRequest.getCantidad();

                // Crear detalle
                PedidoItem pedidoItem = new PedidoItem();

                pedidoItem.setPedido(pedido);
                pedidoItem.setProductos(producto);
                pedidoItem.setCantidad(itemRequest.getCantidad());
                pedidoItem.setPrecioUnitario(precioUnitario);
                pedidoItem.setTotal(subtotal);

                items.add(pedidoItem);

                totalPedido += subtotal;
            }

            // 4. Asignar detalles y total al pedido
            pedido.setItems(items);
            pedido.setTotalCuenta(totalPedido);

            // 5. Guardar pedido
            return pedidoRepository.save(pedido);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PedidosResponseDTO> consultarPedidosHoy() {
        try {
            List<PedidoResponseDTO> historial = pedidoRepository.consultarPedidoHoy();
            if (historial.isEmpty()) {
                throw new RuntimeException("La lista esta vacia");
            }
            Map<Integer, PedidosResponseDTO> pedidos = new LinkedHashMap<>();
            for (PedidoResponseDTO item : historial) {

                PedidosResponseDTO pedido =
                        pedidos.get(item.getIdPedido());

                if (pedido == null) {

                    pedido = new PedidosResponseDTO();

                    pedido.setIdPedido(item.getIdPedido());
                    pedido.setNombreCliente(item.getNombreCliente());
                    pedido.setDireccionEntrega(item.getDireccionEntrega());
                    pedido.setTelefonoCliente(item.getTelefonoCliente());
                    pedido.setFecha(item.getFecha());
                    pedido.setHora(item.getHora());
                    pedido.setMetodoPago(item.getMetodoPago());
                    pedido.setTotalCuenta(item.getTotalCuenta());
                    pedido.setItems(new ArrayList<>());

                    pedidos.put(item.getIdPedido(), pedido);
                }
                pedido.getItems().add(
                        new PedidoItemResponseDTO(
                                item.getNombre(),
                                item.getDescripcion(),
                                item.getPrecio(),
                                item.getCantidad(),
                                item.getPrecioUnitario()
                        )
                );
            }

            return new ArrayList<>(pedidos.values());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
