package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RestaurantServices.app.entity.Categoria;



public interface CategoriaInterface {

public Iterable<Categoria> findAll();
	
	public Page<Categoria> findAll(Pageable pageable);
	
	public Optional<Categoria> findById(long id);
	
	public Categoria Save(Categoria categoria);
	
	public void deleteById(long id);
}
