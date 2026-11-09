package com.example.santanderfoods.santanderfoods.Pedidos.repository;

import com.example.santanderfoods.santanderfoods.Pedidos.entidades.Pedidos;
import com.example.santanderfoods.santanderfoods.productos.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedidos, Integer> {
}
