package com.example.santanderfoods.santanderfoods.Menu.repository;

import com.example.santanderfoods.santanderfoods.Menu.entidades.Menu;
import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT new com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuResponseDTO( m.idMenu, m.nombreMenu, m.activo, m.restaurante.idRestaurante) " +
            " FROM Menu  m ")
    List<MenuResponseDTO> findAllMenu();
}
