package com.RestaurantServices.app.controller;

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

import com.RestaurantServices.app.Services.DetallePedidoInterface;
import com.RestaurantServices.app.entity.Detalle_pedido;

import java.util.List;

@RestController
@RequestMapping("/api/detalle_pedido")
public class DetallePedidoController {
	
	@Autowired
	private DetallePedidoInterface detallePedidoInterface;
	
	@PostMapping
	public ResponseEntity<Detalle_pedido> create(@RequestBody Detalle_pedido detalle_pedido){
		return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoInterface.Save(detalle_pedido));
	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long id){
		Optional<Detalle_pedido> oDetalle_pedido = detallePedidoInterface.findById(id);
		
		if(oDetalle_pedido.isPresent()) {
			return ResponseEntity.ok(oDetalle_pedido);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}/")
	public ResponseEntity<?> update(@RequestBody Detalle_pedido detalle_pedido, @PathVariable(value = "id") Long id){
		Optional<Detalle_pedido> oDetallePedido = detallePedidoInterface.findById(id);
		
		if(oDetallePedido.isPresent()) {
			oDetallePedido.get().setId(detalle_pedido.getId());
			oDetallePedido.get().setPedido(detalle_pedido.getPedido());
			oDetallePedido.get().setMenu(detalle_pedido.getMenu());
			oDetallePedido.get().setCantidad(detalle_pedido.getCantidad());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoInterface.Save(oDetallePedido.get()));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}/")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		if(detallePedidoInterface.findById(id).isPresent()) {
			detallePedidoInterface.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping
	public List<Detalle_pedido> readAll(){
		List<Detalle_pedido> detalle = StreamSupport
				.stream(detallePedidoInterface.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return detalle;
	}

}
