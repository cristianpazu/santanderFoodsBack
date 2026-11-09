package com.example.santanderfoods.santanderfoods.Pedidos.service;

import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoRequestDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.Pedidos;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoRequestDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO;

public interface PedidoService {

    Pedidos registrarPedido(PedidoRequestDTO pedidoRequestDTO);
}
