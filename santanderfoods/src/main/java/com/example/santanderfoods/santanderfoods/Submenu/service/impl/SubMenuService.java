package com.example.santanderfoods.santanderfoods.Submenu.service.impl;

import java.util.List;

public class SubMenuService {

    SubMenu registrarSubmenu(SubMenu subMenu);

    SubMenu actualizarSubmenu(Integer id, SubMenu subMenu);

    List<SubMenu> traerSubmenu();

    SubMenu inactivarSubmenu(Integer id, Boolean inactivarSubmenu);

    List<SubMenuResponseDTO> consultarSubmenu();


}
