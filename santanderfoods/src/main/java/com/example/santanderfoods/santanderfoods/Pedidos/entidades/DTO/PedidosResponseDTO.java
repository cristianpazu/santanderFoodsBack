package com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidosResponseDTO {
    private Integer idPedido;
    private String nombreCliente;
    private String direccionEntrega;
    private String telefonoCliente;

    private LocalDate fecha;
    private LocalTime hora;

    private String metodoPago;
    private Integer totalCuenta;

    private List<PedidoItemResponseDTO> items;
}
