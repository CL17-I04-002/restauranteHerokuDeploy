package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestaurantServices.app.Repository.MesaRepository;
import com.RestaurantServices.app.entity.Mesa;

@Service
public class MesaService implements MesaInterface{
	
	@Autowired
	private MesaRepository mesaRepository;
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<Mesa> findAll() {
		// TODO Auto-generated method stub
		return mesaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Mesa> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return mesaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mesa> findById(long id) {
		// TODO Auto-generated method stub
		return mesaRepository.findById(id);
	}

	@Override
	@Transactional
	public Mesa Save(Mesa mesa) {
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
