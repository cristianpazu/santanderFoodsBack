package com.example.santanderfoods.santanderfoods.Menu.entidades.dto;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuCompletoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCompletoResponseDTO {
    private Integer idMenu;
    private String nombreMenu;
    private boolean activo;

    private List<SubMenuCompletoResponseDTO> submenus;
}
