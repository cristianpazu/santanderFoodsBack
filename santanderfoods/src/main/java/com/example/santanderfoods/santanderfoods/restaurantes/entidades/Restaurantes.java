package com.example.santanderfoods.santanderfoods.restaurantes.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Restaurantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idRestaurante;

    String nombre;

    boolean activo;
/*
    @JsonIgnore
    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL)
    List<Menu> menus; */
}
