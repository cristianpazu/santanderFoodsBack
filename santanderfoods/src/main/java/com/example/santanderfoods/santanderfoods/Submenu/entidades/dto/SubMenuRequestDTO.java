package com.example.santanderfoods.santanderfoods.Submenu.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubMenuRequestDTO {
    private String nombre;

    private boolean activo;

    private Integer menuId;
}
