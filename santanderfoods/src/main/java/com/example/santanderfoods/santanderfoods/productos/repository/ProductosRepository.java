package com.example.santanderfoods.santanderfoods.productos.repository;

import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {

    @Query(value = "SELECT new com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO(  p.idProductos," +
            "p.Nombre, " +
            "p.Descripcion, " +
            "p.Precio, " +
            "p.activo, " +
            "p.submenu.idSubmenu)" +
            "  FROM Productos p" )
    List<ProductoResponseDTO> findProductoResponseDtos();
}
