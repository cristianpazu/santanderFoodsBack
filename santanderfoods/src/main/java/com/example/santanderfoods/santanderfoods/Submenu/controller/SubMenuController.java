package com.example.santanderfoods.santanderfoods.Submenu.controller;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuRequestDTO;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.dto.SubMenuResponseDTO;
import com.example.santanderfoods.santanderfoods.Submenu.service.SubMenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/submenu")
public class SubMenuController {
    SubMenuService subMenuService;

    @PostMapping("/registrar/submenu")
    public ResponseEntity<SubMenuResponseDTO> registrarSubmenu(@RequestBody SubMenuRequestDTO subMenuRequestDTO){
        return ResponseEntity.ok(subMenuService.registrarSubmenu(subMenuRequestDTO));
    }



    @GetMapping("/traer/submenus")
    public ResponseEntity<List<SubMenuResponseDTO>> treaerSubmenu() {
        return ResponseEntity.ok(subMenuService.traerSubmenu());

    }

    @GetMapping("/listar/submenus")
    public ResponseEntity<List<SubMenuResponseDTO>> consultarSubmenu() {
        return ResponseEntity.ok(subMenuService.consultarSubmenu());

    }
}
