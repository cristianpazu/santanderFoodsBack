package com.example.santanderfoods.santanderfoods.Submenu.entidades;

import com.example.santanderfoods.santanderfoods.Menu.entidades.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class SubMenu {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idSubmenu;

    String nombre;

    boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    Menu menu;
/*
    @OneToMany(mappedBy = "submenu")
    @JsonManagedReference
    List<Productos> productos; */
}
