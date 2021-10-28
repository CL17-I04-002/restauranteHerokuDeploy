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

import com.RestaurantServices.app.Services.CategoriaInterface;
import com.RestaurantServices.app.entity.Categoria;


@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaInterface categoriaInterface;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Categoria categ){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaInterface.Save(categ));
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id")  Long id)
	{
		Optional<Categoria> oCateg = categoriaInterface.findById(id);
		
		if(oCateg.isPresent()) 
		{
			return ResponseEntity.ok(oCateg);
		}
		else {
		
			
			return ResponseEntity.notFound().build();
		}
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Categoria categDetails,@PathVariable(value="id")  Long id)
	{
		Optional<Categoria> oCateg = categoriaInterface.findById(id);
		
		if(oCateg.isPresent()) 
		{
			oCateg.get().setCategoria(categDetails.getCategoria());
			return ResponseEntity.status(HttpStatus.CREATED).body(categoriaInterface.Save(oCateg.get()));
		}
		else {
		
			
			return ResponseEntity.notFound().build();
		}
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id")  Long id)
	{
		if(categoriaInterface.findById(id).isPresent()){
			categoriaInterface.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@GetMapping
	public List<Categoria> readAll()
	{
		List<Categoria> categorias= StreamSupport
				.stream(categoriaInterface.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
		return categorias;
	}
}
