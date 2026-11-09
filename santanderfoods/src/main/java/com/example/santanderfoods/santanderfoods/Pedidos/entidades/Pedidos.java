package com.example.santanderfoods.santanderfoods.Pedidos.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    private String nombreCliente;

    private String telefonoCliente;

    private String direccionEntrega;

    private String metodoPago;

    private Integer totalCuenta;

    private LocalDate fecha;

    private LocalTime hora;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private com.example.santanderfoods.santanderfoods.Restaurantes.entidades.Restaurantes restaurante;

    @OneToMany(
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PedidoItem> items;
}
