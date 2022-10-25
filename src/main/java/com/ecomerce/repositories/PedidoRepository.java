package com.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecomerce.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
