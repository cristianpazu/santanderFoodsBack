package com.example.santanderfoods.santanderfoods.productos.controller;

import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoRequestDTO;
import com.example.santanderfoods.santanderfoods.productos.entidades.dto.ProductoResponseDTO;
import com.example.santanderfoods.santanderfoods.productos.service.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {


    ProductoService productosService;


    @PostMapping("/registrar/productos")
    public ResponseEntity<ProductoResponseDTO> registrarProducto(@RequestBody ProductoRequestDTO productos){
        return ResponseEntity.ok(productosService.registrarProducto(productos));
    }


    @GetMapping("/listar/productos")
    public ResponseEntity<List<ProductoResponseDTO>> listarMesas(){
        return ResponseEntity.ok(productosService.consultarProductos());

    }
}
