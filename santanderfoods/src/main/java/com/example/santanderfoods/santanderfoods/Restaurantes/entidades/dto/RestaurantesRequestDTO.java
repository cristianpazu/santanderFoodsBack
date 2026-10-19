package com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class RestaurantesRequestDTO {

    private String nombre;
    private String direccion;
    private String telefono;
    private boolean activo;
}
