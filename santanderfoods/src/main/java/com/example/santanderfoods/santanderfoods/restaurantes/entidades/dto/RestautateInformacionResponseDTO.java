package com.example.santanderfoods.santanderfoods.restaurantes.entidades.dto;

import com.example.santanderfoods.santanderfoods.Menu.entidades.dto.MenuCompletoResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestautateInformacionResponseDTO {

        private Integer idRestaurante;
        private String nombre;
        private String direccion;
        String descripcion;
        private String telefono;
        private boolean activo;


}
