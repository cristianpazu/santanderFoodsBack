package com.example.santanderfoods.santanderfoods.ventas.controller;


import com.example.santanderfoods.santanderfoods.ventas.entidades.VentasDTO;
import com.example.santanderfoods.santanderfoods.ventas.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/venta")
public class VentaController {

    VentaService ventaService;

    @GetMapping("/ventaHoy")
    public ResponseEntity<VentasDTO> consultarPedido(){

        return ResponseEntity.ok(ventaService.consultarVentasHoy2());

    }

}
