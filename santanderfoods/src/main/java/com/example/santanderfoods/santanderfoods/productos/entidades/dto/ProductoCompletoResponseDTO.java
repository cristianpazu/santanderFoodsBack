package com.example.santanderfoods.santanderfoods.productos.entidades.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoCompletoResponseDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private boolean activo;
}
