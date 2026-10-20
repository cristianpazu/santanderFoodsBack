package com.example.santanderfoods.santanderfoods.productos.service;

import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoRequestDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {
    ProductoResponseDTO registrarProducto(ProductoRequestDTO productoRequestDTO);

    ProductoResponseDTO actualizarProducto(Integer id,ProductoRequestDTO productoRequestDTO);

    ProductoResponseDTO inactivarProductos(Integer id, Boolean inactiva);

    List<ProductoResponseDTO> consultarProductos();

}
