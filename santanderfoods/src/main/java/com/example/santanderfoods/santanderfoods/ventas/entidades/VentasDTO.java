package com.example.santanderfoods.santanderfoods.ventas.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentasDTO {

    private Long pedidosHoy;

    private Long totalVendido;

    private Long productosVendidos;

    public VentasDTO() {
    }

    public VentasDTO(Long pedidosHoy, Long totalVendido, Long productosVendidos) {
        this.pedidosHoy = pedidosHoy;
        this.totalVendido = totalVendido;
        this.productosVendidos = productosVendidos;
    }

    public Long getPedidosHoy() {
        return pedidosHoy;
    }

    public void setPedidosHoy(Long pedidosHoy) {
        this.pedidosHoy = pedidosHoy;
    }

    public Long getTotalVendido() {
        return totalVendido;
    }

    public void setTotalVendido(Long totalVendido) {
        this.totalVendido = totalVendido;
    }

    public Long getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(Long productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
}
