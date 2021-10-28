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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RestaurantServices.app.Services.UsuarioInterface;
import com.RestaurantServices.app.entity.Usuario;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {


	@Autowired
	private UsuarioInterface mesainterface;
	
	
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(mesainterface.Save(usuario));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id")  Long id)
	{
		Optional<Usuario> oUsuario = mesainterface.findById(id);
		 
		
		if(oUsuario.isPresent()) 
		{
			return ResponseEntity.ok(oUsuario);
		}
		else {
		
			return ResponseEntity.notFound().build();
		}
	}
	/*update a mesa register
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario mesaDetails,@PathVariable(value="id")  Long id)
	{
		Optional<Usuario> oMesa = mesainterface.findById(id);
		
		if(oMesa.isPresent()) 
		{
			oMesa.get().setId(0)
			oMesa.get().setCodigo(mesaDetails.getCodigo());
			return ResponseEntity.status(HttpStatus.CREATED).body(mesainterface.Save(oMesa.get()));
		}
		else {
		
			
			return ResponseEntity.notFound().build();
		}
	}
	
	*///delete  a register
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id")  Long id)
	{
		if(mesainterface.findById(id).isPresent()){
			mesainterface.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	//Read all element
	@GetMapping
	public List<Usuario> readAll()
	{
		List<Usuario> usuarios= StreamSupport
				.stream(mesainterface.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
		return usuarios;
	}
}
