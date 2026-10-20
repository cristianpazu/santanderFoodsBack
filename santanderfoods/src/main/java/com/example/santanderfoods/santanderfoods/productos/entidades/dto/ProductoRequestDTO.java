package com.example.santanderfoods.santanderfoods.productos.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoRequestDTO {
    Integer id;
    String nombre;
    String descripcion;
    Integer precio;
    boolean activo;
    private Integer idSubMenu;
}
