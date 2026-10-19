package com.example.santanderfoods.santanderfoods.Menu.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponseDTO {

    private Integer idMenu;
    private String nombreMenu;
    private boolean activo;
    private Integer idRestaurante;
}
