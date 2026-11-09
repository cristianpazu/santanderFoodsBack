package com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponseDTO {
    private Integer idPedido;
    private String nombreCliente;
    private String direccionEntrega;
    private String telefonoCliente;

    private LocalDate fecha;
    private LocalTime hora;

    private String metodoPago;

    private String nombre;
    private String descripcion;
    private Integer precio;

    private Integer cantidad;

    private Integer totalCuenta;
    private Integer precioUnitario;
}
