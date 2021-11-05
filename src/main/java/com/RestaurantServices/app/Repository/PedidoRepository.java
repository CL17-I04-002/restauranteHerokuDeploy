package com.RestaurantServices.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RestaurantServices.app.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
