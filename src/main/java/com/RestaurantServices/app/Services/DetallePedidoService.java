package com.RestaurantServices.app.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.RestaurantServices.app.Repository.DetallePedidoRepository;
import com.RestaurantServices.app.entity.Detalle_pedido;

public class DetallePedidoService implements DetallePedidoInterface{
	
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Detalle_pedido> findAll(){
		return detallePedidoRepository.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Detalle_pedido> findAll(Pageable pageable){
		return detallePedidoRepository.findAll(pageable);
	}
	@Override
	@Transactional(readOnly = true)
	public Optional<Detalle_pedido> findById(long id){
		return detallePedidoRepository.findById(id);
	}
	@Override
	@Transactional
	public Detalle_pedido Save(Detalle_pedido detalle_pedido) {
		return detallePedidoRepository.save(detalle_pedido);
	}
	@Override
	@Transactional
	public void deleteById(long id) {
		detallePedidoRepository.deleteById(id);
	}
}
