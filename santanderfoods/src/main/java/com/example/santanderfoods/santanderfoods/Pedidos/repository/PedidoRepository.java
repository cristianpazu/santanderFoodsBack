package com.example.santanderfoods.santanderfoods.Pedidos.repository;

import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoResponseDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidosResponseDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.Pedidos;
import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {

    @Query(value = "SELECT new com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoResponseDTO(p.idPedido,p.nombreCliente ,p.direccionEntrega, " +
            "p.telefonoCliente, p.fecha, p.hora, p.metodoPago, pr.Nombre, pr.Descripcion, pr.Precio, ped.cantidad, p.totalCuenta, ped.precioUnitario ) " +
            "FROM Pedidos p " +
            "JOIN PedidoItem ped ON p.idPedido = ped.pedido.idPedido " +
            "JOIN Productos pr ON pr.idProductos = ped.productos.idProductos " +
            "WHERE p.fecha = CURRENT_DATE")
    List<PedidoResponseDTO> consultarPedidoHoy();

    @Query(value = "SELECT new com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoResponseDTO(p.idPedido,p.nombreCliente ,p.direccionEntrega, " +
            "p.telefonoCliente, p.fecha, p.hora, p.metodoPago, pr.Nombre, pr.Descripcion, pr.Precio, ped.cantidad, p.totalCuenta, ped.precioUnitario ) " +
            "FROM Pedidos p " +
            "JOIN PedidoItem ped ON p.idPedido = ped.pedido.idPedido " +
            "JOIN Productos pr ON pr.idProductos = ped.productos.idProductos " +
            "WHERE p.fecha = CURRENT_DATE")
    List<PedidosResponseDTO> consultarPedidosHoy();

}
