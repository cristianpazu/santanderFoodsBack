package com.example.santanderfoods.santanderfoods.Restaurantes.service;

import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;

import java.util.List;

public interface RestaurateService {

    RestaurantesResponseDTO registrarRestaurantes(RestaurantesRequestDTO restaurantesRequestDTO);

    RestaurantesResponseDTO actualizarRestaurantes(Integer id, RestaurantesRequestDTO restaurantesRequestDTO);

    List<RestaurantesResponseDTO> listarRestaurantes();

    RestaurantesResponseDTO traerRestauratesId(Integer id);




}
