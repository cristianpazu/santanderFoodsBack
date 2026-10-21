package com.example.santanderfoods.santanderfoods.Submenu.entidades.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubMenuResponseDTO {
    Integer idSubmen;
    String nombre;
    boolean activo;
    private Integer menuId;
}
