package com.example.santanderfoods.santanderfoods.Restaurantes.service;

import     com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestauranteCompletoResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;
import com.example.santanderfoods.santanderfoods.restaurantes.entidades.dto.RestautateInformacionResponseDTO;

import java.util.List;

public interface RestaurateService {

    RestaurantesResponseDTO registrarRestaurantes(RestaurantesRequestDTO restaurantesRequestDTO);

    RestaurantesResponseDTO actualizarRestaurantes(Integer id, RestaurantesRequestDTO restaurantesRequestDTO);

    List<RestaurantesResponseDTO> listarRestaurantes();

    RestauranteCompletoResponseDTO traerRestauratesId(Integer id);

    RestautateInformacionResponseDTO consultarInformacionRestaurante(Integer id);




}
