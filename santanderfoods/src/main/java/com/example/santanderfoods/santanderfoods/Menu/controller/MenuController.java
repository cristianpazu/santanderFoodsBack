package com.example.santanderfoods.santanderfoods.Menu.controller;


import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.Menu.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    MenuService menuService;

    @PostMapping("/registrar/menu")
    public ResponseEntity<MenuResponseDTO> registrarRestaurantes(@RequestBody MenuRequestDTO menuRequestDTO){

        return ResponseEntity.ok(menuService.registrarMenu(menuRequestDTO));

    }

    @PutMapping("/actualizar/menu")
    public ResponseEntity<MenuResponseDTO> actualizarRestaurantes(@PathVariable Integer idRestaurante, @RequestBody MenuRequestDTO menuRequestDTO){

        return ResponseEntity.ok(menuService.actualizarMenu(idRestaurante, menuRequestDTO));

    }

    @GetMapping("/listar/menu")
    public ResponseEntity<List<MenuResponseDTO>> listarRestaurantes(){

        return ResponseEntity.ok(menuService.taerMenu());

    }

}
