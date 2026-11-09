package com.example.santanderfoods.santanderfoods.Pedidos.controller;

import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoRequestDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.DTO.PedidoResponseDTO;
import com.example.santanderfoods.santanderfoods.Pedidos.entidades.Pedidos;
import com.example.santanderfoods.santanderfoods.Pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping("/registrar")
    public ResponseEntity<Pedidos> registrarPedido(
            @RequestBody PedidoRequestDTO request) {

        Pedidos pedido = pedidoService.registrarPedido(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }


    @GetMapping("/consultar/pedido")
    public ResponseEntity<List<PedidoResponseDTO>> consultarPedido(){

        return ResponseEntity.ok(pedidoService.consultarPedidosHoy());

    }
}
