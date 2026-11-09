package com.example.santanderfoods.santanderfoods.Pedidos.entidades;

import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedidoItem;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference
    private Pedidos pedido;

    @ManyToOne
    @JoinColumn(name = "productos_id", nullable = false)
    private Productos productos;

    private Integer cantidad;

    private Integer precioUnitario;

    private Integer total;
}
