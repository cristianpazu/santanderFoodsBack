package com.example.santanderfoods.santanderfoods.restaurantes.service.impl;

import com.example.santanderfoods.santanderfoods.restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.restaurantes.entidades.dto.RestaurantesResponseDTO;
import com.example.santanderfoods.santanderfoods.restaurantes.service.restaurateService;

import java.util.List;

public class restaurantesIMPL implements restaurateService {
    @Override
    public RestaurantesResponseDTO registrarRestaurantes(RestaurantesRequestDTO restaurantesRequestDTO) {
        return null;
    }

    @Override
    public RestaurantesResponseDTO actualizarRestaurantes(Integer id, RestaurantesRequestDTO restaurantesRequestDTO) {
        return null;
    }

    @Override
    public List<RestaurantesResponseDTO> listarRestaurantes() {
        return null;
    }

    @Override
    public RestaurantesResponseDTO traerRestauratesId(Integer id) {
        return null;
    }
}
