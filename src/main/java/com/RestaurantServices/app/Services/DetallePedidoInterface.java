package com.RestaurantServices.app.Services;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.RestaurantServices.app.entity.Detalle_pedido;

public interface DetallePedidoInterface {
	
	public Iterable<Detalle_pedido> findAll();
	
	public Page<Detalle_pedido> findAll(Pageable pageable);
	
	public Optional<Detalle_pedido> findById(long id);
	
	public Detalle_pedido Save(Detalle_pedido detalle_pedido);
	
	public void deleteById(long id);
}
