package com.example.santanderfoods.santanderfoods.Menu.service;

import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuResponseDTO;

import java.util.List;

public interface MenuService {

    MenuResponseDTO registrarMenu(MenuRequestDTO menuRequestDTO);

    MenuResponseDTO actualizarMenu(Integer id, MenuRequestDTO menuRequestDTO);

    MenuResponseDTO inactivarMenu(Integer id, Boolean inactiva);

    List<MenuResponseDTO> taerMenu();


}
