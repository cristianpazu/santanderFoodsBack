package com.example.santanderfoods.santanderfoods.Submenu.entidades.dto;

import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoCompletoResponseDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubMenuCompletoResponseDTO {
    private Integer idSubmenu;
    private String nombre;
    private boolean activo;
    private List<ProductoCompletoResponseDTO> productos;
}
