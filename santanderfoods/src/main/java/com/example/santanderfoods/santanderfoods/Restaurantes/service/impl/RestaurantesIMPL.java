package com.example.santanderfoods.santanderfoods.Restaurantes.service.impl;

import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesRequestDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;
import com.example.santanderfoods.santanderfoods.Restaurantes.repositorty.RestauranteRepository;
import com.example.santanderfoods.santanderfoods.Restaurantes.service.RestaurateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
public class RestaurantesIMPL implements RestaurateService {


    @Autowired
    RestauranteRepository restauranteRepository;

    @Override
    public RestaurantesResponseDTO registrarRestaurantes(RestaurantesRequestDTO restaurantesRequestDTO) {
        try {



            Restaurantes restaurante = new Restaurantes();

            restaurante.setNombre(restaurantesRequestDTO.getNombre());
            restaurante.setActivo(restaurantesRequestDTO.isActivo());
            restaurante.setDireccion(restaurantesRequestDTO.getDireccion());
            restaurante.setTelefono(restaurantesRequestDTO.getTelefono());

            Restaurantes guardado =  restauranteRepository.save(restaurante);

            RestaurantesResponseDTO response = new RestaurantesResponseDTO();

            response.setIdRestaurante(guardado.getIdRestaurante());
            response.setNombre(guardado.getNombre());
            response.setDireccion(guardado.getDireccion());
            response.setTelefono(guardado.getTelefono());
            response.setActivo(guardado.isActivo());



            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RestaurantesResponseDTO actualizarRestaurantes(Integer id, RestaurantesRequestDTO restaurantesRequestDTO) {

try {

    Restaurantes restaurantesRequestDTO1 = restauranteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "El restaurante con ID " + id + " no existe"
    ));

    restaurantesRequestDTO1.setNombre(restaurantesRequestDTO.getNombre());
    restaurantesRequestDTO1.setDireccion(restaurantesRequestDTO.getDireccion());
    restaurantesRequestDTO1.setTelefono(restaurantesRequestDTO.getTelefono());

    Restaurantes restauranteActualizado = restauranteRepository.save(restaurantesRequestDTO1);

    RestaurantesResponseDTO responseDTO = new RestaurantesResponseDTO();

    responseDTO.setIdRestaurante(restauranteActualizado.getIdRestaurante());
    responseDTO.setNombre(restauranteActualizado.getNombre());
    responseDTO.setDireccion(restauranteActualizado.getDireccion());
    responseDTO.setTelefono(restauranteActualizado.getTelefono());

    return responseDTO;

} catch (Exception e) {
    throw new RuntimeException(e);
}


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
