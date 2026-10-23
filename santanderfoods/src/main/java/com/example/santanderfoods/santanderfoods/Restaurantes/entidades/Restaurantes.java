package com.example.santanderfoods.santanderfoods.Restaurantes.entidades;

import com.example.santanderfoods.santanderfoods.Menu.entidades.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Restaurantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRestaurante;

    String nombre;

    String direccion;

    String descripcion;

    String telefono;

    boolean activo;


    @JsonIgnore
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    List<Menu> menus;

    public Restaurantes() {
    }

    public Restaurantes(Integer idRestaurante, String nombre, String direccion, String telefono, boolean activo) {
        this.idRestaurante = idRestaurante;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.activo = activo;
    }
}
