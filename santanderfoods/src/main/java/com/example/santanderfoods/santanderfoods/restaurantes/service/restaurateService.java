package com.example.santanderfoods.santanderfoods.restaurantes.service;

import com.example.santanderfoods.santanderfoods.restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.restaurantes.entidades.dto.RestaurantesResponseDTO;

import java.util.List;

public interface restaurateService {

    RestaurantesResponseDTO registrarRestaurantes(RestaurantesRequestDTO restaurantesRequestDTO);

    RestaurantesResponseDTO actualizarRestaurantes(Integer id, RestaurantesRequestDTO restaurantesRequestDTO);

    List<RestaurantesResponseDTO> listarRestaurantes();

    RestaurantesResponseDTO traerRestauratesId(Integer id);




}
