package com.example.santanderfoods.santanderfoods.Pedidos.service.impl;

import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoItemRequestDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoRequestDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoResponseDTO;
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
import java.util.List;

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
    public List<PedidoResponseDTO> consultarPedidosHoy() {
        try {
            List<PedidoResponseDTO> historial = pedidoRepository.consultarPedidoHoy();
            if (historial.isEmpty()) {
                throw new RuntimeException("La lista esta vacia");
            }

            return historial;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
