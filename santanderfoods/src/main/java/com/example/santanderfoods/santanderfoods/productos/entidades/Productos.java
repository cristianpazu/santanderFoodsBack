package com.example.santanderfoods.santanderfoods.productos.entidades;

import com.example.santanderfoods.santanderfoods.Submenu.entidades.SubMenu;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idProductos;

    String Nombre;

    String Descripcion;

    Integer Precio;

    boolean activo;

    @ManyToOne
    @JoinColumn(name = "submenu_id")
    @JsonBackReference
    private SubMenu submenu;
}
