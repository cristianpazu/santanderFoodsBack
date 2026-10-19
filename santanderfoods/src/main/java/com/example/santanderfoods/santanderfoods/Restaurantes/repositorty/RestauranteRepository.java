package com.example.santanderfoods.santanderfoods.Restaurantes.repositorty;

import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurantes, Integer> {


    @Query(value = "SELECT new com.example.santanderfoods.santanderfoods.Restaurantes.entidades.dto.RestaurantesResponseDTO(rs.idRestaurante ,rs.nombre, rs.direccion, rs.telefono, rs.activo) " +
            "FROM Restaurantes rs")
    List<RestaurantesResponseDTO> listarTodosRestaurantes();

}
