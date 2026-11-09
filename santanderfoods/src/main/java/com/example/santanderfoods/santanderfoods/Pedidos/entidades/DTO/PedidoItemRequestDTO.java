package com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoItemRequestDTO {
    private Integer productoId;

    private Integer cantidad;

}
