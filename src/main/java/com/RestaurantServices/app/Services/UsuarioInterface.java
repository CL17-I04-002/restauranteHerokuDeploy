package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RestaurantServices.app.entity.Usuario;



public interface UsuarioInterface {

public Iterable<Usuario> findAll();
	
	public Page<Usuario> findAll(Pageable pageable);
	
	public Optional<Usuario> findById(long id);
	
	public Usuario Save(Usuario usuario);
	
	public void deleteById(long id);
	
	
}
