package com.example.santanderfoods.santanderfoods.Submenu.service.impl;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuResponseDTO;
import com.example.santanderfoods.santanderfoods.Submenu.service.SubMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubMenuIMPL implements SubMenuService {


    @Override
    public SubMenuResponseDTO registrarSubmenu(SubMenuRequestDTO subMenuRequestDTO) {
        return null;
    }

    @Override
    public SubMenuResponseDTO actualizarSubmenu(Integer id, SubMenuRequestDTO subMenuRequestDTO) {
        return null;
    }

    @Override
    public List<SubMenuResponseDTO> traerSubmenu() {
        return List.of();
    }

    @Override
    public SubMenuResponseDTO inactivarSubmenu(Integer id, Boolean inactivarSubmenu) {
        return null;
    }

    @Override
    public List<SubMenuResponseDTO> consultarSubmenu() {
        return List.of();
    }
}
