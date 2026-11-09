package com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {
    private Integer restauranteId;

    private String nombreCliente;

    private String telefonoCliente;

    private String direccionEntrega;

    private String metodoPago;

    private List<PedidoItemRequestDTO> items;
}
