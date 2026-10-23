package com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantesResponseDTO {
    private Integer idRestaurante;
    private String nombre;
    private String direccion;
    String descripcion;
    private String telefono;
    private boolean activo;
}
