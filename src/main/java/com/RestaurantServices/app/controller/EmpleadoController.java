package com.RestaurantServices.app.controller;

import java.io.Console;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.function.Consumer;
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

import com.RestaurantServices.app.Services.EmpleadoInterface;
import com.RestaurantServices.app.entity.Empleado;
import com.RestaurantServices.app.entity.Usuario;



@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired 
	private EmpleadoInterface empleadoInterface;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Empleado empleado){
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoInterface.Save(empleado));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id")  Long id)
	{
		Optional<Empleado> oEmpleado = empleadoInterface.findById(id);
		 
		
		if(oEmpleado.isPresent()) 
		{
			return ResponseEntity.ok(oEmpleado);
		}
		else {
		
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id")  Long id)
	{
		if(empleadoInterface.findById(id).isPresent()){
			empleadoInterface.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else 
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	//Read all element
	@GetMapping
	public List<Empleado> readAll()
	{
		List<Empleado> empleados= StreamSupport
				.stream(empleadoInterface.findAll().spliterator(), false)
				.collect(Collectors.toList());
				
		return empleados;
	}
	
	@GetMapping("/login")
	public Empleado login(@RequestBody Usuario usuario)
	{
		Empleado e =new Empleado();
		List<Empleado> empleados= StreamSupport
				.stream(empleadoInterface.findAll().spliterator(), false)
				.collect(Collectors.toList());
			
		for(Empleado emp:empleados)
		{
						
			if(emp.getUsuario().getUsername().equals(usuario.getUsername()) && emp.getUsuario().getPassword().equals(usuario.getPassword())) 
			{
				e.setApellidos(emp.getApellidos());
				e.setDireccion(emp.getDireccion());
				e.setDUI(emp.getDUI());
				e.setId(emp.getId());
				e.setNombres(emp.getNombres());
				e.setTelefono(emp.getTelefono());
				e.getUsuario().setId(emp.getUsuario().getId());
				e.getUsuario().setPassword(emp.getUsuario().getPassword());
				e.getUsuario().setUsername(emp.getUsuario().getUsername());
				
			}
			
			
		}
		
				
		return e;
	}
}
