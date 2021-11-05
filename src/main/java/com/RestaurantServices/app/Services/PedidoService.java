package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import com.RestaurantServices.app.Repository.PedidoRepository;
import com.RestaurantServices.app.entity.Pedido;

public class PedidoService implements PedidoInterface{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Iterable<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	@Override
	public Page<Pedido> findAll(Pageable pageable){
		return pedidoRepository.findAll(pageable);
	}
	@Override
	public Optional<Pedido> findById(long id){
		return pedidoRepository.findById(id);
	}
	@Override
	public Pedido Save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	@Override
	public void deleteById(long id) {
		pedidoRepository.deleteById(id);
	}
}
