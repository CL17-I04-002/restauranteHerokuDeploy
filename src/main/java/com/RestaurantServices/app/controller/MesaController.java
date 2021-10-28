package com.RestaurantServices.app.controller;

import java.util.List;
import java.util.stream.*;
import java.util.*;

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

import com.RestaurantServices.app.Services.MesaInterface;
import com.RestaurantServices.app.entity.Mesa;

@RestController
@RequestMapping("/api/mesa")
public class MesaController {

	@Autowired
	private MesaInterface mesainterface;
	
	//Create a new Mesa
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Mesa mesa){
		return ResponseEntity.status(HttpStatus.CREATED).body(mesainterface.Save(mesa));
	}
	
	//create a new mesa register
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id")  Long id)
	{
		Optional<Mesa> oMesa = mesainterface.findById(id);
		
		if(oMesa.isPresent()) 
		{
			return ResponseEntity.ok(oMesa);
		}
		else {
		
			
			return ResponseEntity.notFound().build();
		}
	}
	//update a mesa register
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Mesa mesaDetails,@PathVariable(value="id")  Long id)
	{
		Optional<Mesa> oMesa = mesainterface.findById(id);
		
		if(oMesa.isPresent()) 
		{
			oMesa.get().setCodigo(mesaDetails.getCodigo());
			return ResponseEntity.status(HttpStatus.CREATED).body(mesainterface.Save(oMesa.get()));
		}
		else {
		
			
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete  a register
	
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
	public List<Mesa> readAll()
	{
		List<Mesa> mesas= StreamSupport
				.stream(mesainterface.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
		return mesas;
	}
	
	
	}
