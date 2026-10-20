package com.example.santanderfoods.santanderfoods.Submenu.service;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.SubMenu;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuResponseDTO;

import java.util.List;

public interface SubMenuService {

    SubMenuResponseDTO registrarSubmenu(SubMenuRequestDTO subMenuRequestDTO);

    SubMenuResponseDTO actualizarSubmenu(Integer id, SubMenuRequestDTO subMenuRequestDTO);

    List<SubMenuResponseDTO> traerSubmenu();

    SubMenuResponseDTO inactivarSubmenu(Integer id, Boolean inactivarSubmenu);

    List<SubMenuResponseDTO> consultarSubmenu();
}
