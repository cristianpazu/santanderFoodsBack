package com.example.santanderfoods.santanderfoods.Menu.entidades.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuRequestDTO {
    private Integer idRestaurante;
    private String nombreMenu;
    private boolean activo;
}
