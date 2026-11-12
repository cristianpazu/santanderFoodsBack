package com.example.santanderfoods.santanderfoods.ventas.service.impl;


import com.example.santanderfoods.santanderfoods.Pedidos.repository.PedidoRepository;
import com.example.santanderfoods.santanderfoods.ventas.entidades.VentasDTO;
import com.example.santanderfoods.santanderfoods.ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceImpl implements VentaService {


    @Autowired
    PedidoRepository pedidoRepository;

    @Override
    public VentasDTO consultarVentasHoy2() {
        try{


           VentasDTO resultado =
                    pedidoRepository.consultarVentasHoy2();
            System.out.println("resultado = " + resultado);
return resultado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
