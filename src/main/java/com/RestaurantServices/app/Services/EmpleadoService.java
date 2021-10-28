package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RestaurantServices.app.Repository.EmpleadoRepository;
import com.RestaurantServices.app.entity.Empleado;

@Service
public class EmpleadoService implements EmpleadoInterface{

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public Iterable<Empleado> findAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public Page<Empleado> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll(pageable);
	}

	@Override
	public Optional<Empleado> findById(long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id);
	}

	@Override
	public Empleado Save(Empleado empleado) {
		// TODO Auto-generated method stub
		return empleadoRepository.save(empleado);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		empleadoRepository.deleteById(id);
	}

}
