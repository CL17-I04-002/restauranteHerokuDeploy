package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestaurantServices.app.Repository.EmpleadoRepository;
import com.RestaurantServices.app.Repository.UsuarioRepository;
import com.RestaurantServices.app.entity.Empleado;
import com.RestaurantServices.app.entity.Usuario;

@Service
public class UsuarioService implements UsuarioInterface{

	@Autowired
	private UsuarioRepository mesaRepository;


	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return mesaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return mesaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(long id){
		// TODO Auto-generated method stub
		Optional<Usuario> u = mesaRepository.findById(id);
		return u;
		
	}

	@Override
	@Transactional
	public Usuario Save(Usuario mesa) {
		// TODO Auto-generated method stub
		return mesaRepository.save(mesa);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		mesaRepository.deleteById(id);
	}



}
