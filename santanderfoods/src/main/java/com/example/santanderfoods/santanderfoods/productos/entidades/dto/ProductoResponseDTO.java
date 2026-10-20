package com.example.santanderfoods.santanderfoods.productos.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponseDTO {
    Integer id;
    String nombre;
    String descripcion;
    Integer precio;
    boolean activo;
    Integer idSubmenu;
}
