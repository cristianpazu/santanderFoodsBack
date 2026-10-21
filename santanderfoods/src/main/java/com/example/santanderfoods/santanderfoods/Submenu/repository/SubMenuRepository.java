package com.example.santanderfoods.santanderfoods.Submenu.repository;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.SubMenu;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuResponseDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubMenuRepository extends JpaRepository<SubMenu, Integer> {

    @Query(value = "SELECT new com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuResponseDTO(sm.idSubmenu, sm.nombre, sm.activo, sm.idSubmenu)" +
            "FROM SubMenu sm ")
    List<SubMenuResponseDTO> findSubMenuResponseDtoList();


}
