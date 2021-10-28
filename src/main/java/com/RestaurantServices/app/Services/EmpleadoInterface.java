package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RestaurantServices.app.entity.Empleado;



public interface EmpleadoInterface {

	public Iterable<Empleado> findAll();
	
	public Page<Empleado> findAll(Pageable pageable);
	
	public Optional<Empleado> findById(long id);
	
	public Empleado Save(Empleado empleado);
	
	public void deleteById(long id);
}
