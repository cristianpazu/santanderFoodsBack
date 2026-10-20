package com.example.santanderfoods.santanderfoods.Menu.entidades;

import com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes;
import com.example.santanderfoods.santanderfoods.Submenu.entidades.SubMenu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
    public class Menu {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer idMenu;

        String nombreMenu;

        boolean activo;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    List<SubMenu> submenus;

        @ManyToOne
        @JoinColumn(name = "id_restaurante", nullable = false)
        private Restaurantes restaurante;
    }
