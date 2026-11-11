package com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemResponseDTO {
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer cantidad;
    private Integer precioUnitario;
}
