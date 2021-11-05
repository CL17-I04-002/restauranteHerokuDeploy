package com.RestaurantServices.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestaurantServices.app.Repository.PedidoRepository;
import com.RestaurantServices.app.Services.PedidoInterface;
import com.RestaurantServices.app.entity.Categoria;
import com.RestaurantServices.app.entity.Pedido;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	///Inyección de dependencia
	@Autowired
	private PedidoInterface pedidoInterface;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Pedido pedi){
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoInterface.Save(pedi));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long id)
	{
		Optional<Pedido> oPedido = pedidoInterface.findById(id);
		if(oPedido.isPresent()) {
			
			return ResponseEntity.ok(oPedido);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> update(@RequestBody Pedido pedido, @PathVariable(value = "id") Long id)
	{
		
		Optional<Pedido> oPedido = pedidoInterface.findById(id);
		
		if(oPedido.isPresent()) 
		{
			oPedido.get().setEmpleado(pedido.getEmpleado());
			oPedido.get().setMesa(pedido.getMesa());
			oPedido.get().setFecha_pedido(pedido.getFecha_pedido());
			oPedido.get().setMesa(pedido.getMesa());
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoInterface.Save(oPedido.get()));
		}
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete (@PathVariable(value="id")  Long id)
		{
			if(pedidoInterface.findById(id).isPresent()){
				pedidoInterface.deleteById(id);
				return ResponseEntity.ok().build();
			}
			else 
			{
				return ResponseEntity.notFound().build();
			}
		}
		
		@GetMapping
		public List<Pedido> readAll()
		{
			List<Pedido> pedido= StreamSupport
					.stream(pedidoInterface.findAll().spliterator(), false)
					.collect(Collectors.toList());
					
			return pedido;
		}
	}

