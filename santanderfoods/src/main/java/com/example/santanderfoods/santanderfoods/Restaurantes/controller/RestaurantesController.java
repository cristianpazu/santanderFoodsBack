package com.example.santanderfoods.santanderfoods.Restaurantes.controller;

import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.service.RestaurateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurantes")
public class RestaurantesController {


    RestaurateService restaurateService;



    @PostMapping("/registrar/restaurantes")
    public ResponseEntity<RestaurantesResponseDTO> registrarRestaurantes(@RequestBody RestaurantesRequestDTO restaurantesRequestDTO){

        return ResponseEntity.ok(restaurateService.registrarRestaurantes(restaurantesRequestDTO));

    }

    @PutMapping("/actualizar/restaurantes")
    public ResponseEntity<RestaurantesResponseDTO> actualizarRestaurantes(@PathVariable Integer idRestaurante, @RequestBody RestaurantesRequestDTO restaurantesRequestDTO){

        return ResponseEntity.ok(restaurateService.actualizarRestaurantes(idRestaurante, restaurantesRequestDTO));

    }

    @GetMapping("/listar/restaurantes")
    public ResponseEntity<List<RestaurantesResponseDTO>> listarRestaurantes(){

        return ResponseEntity.ok(restaurateService.listarRestaurantes());

    }


}
