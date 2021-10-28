package com.RestaurantServices.app.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.RestaurantServices.app.Repository.CategoriaRepository;
import com.RestaurantServices.app.entity.Categoria;


@Service
public class CategoriaService implements CategoriaInterface {
	
	@Autowired 
	private CategoriaRepository categoriaRepository;


	@Override
	@Transactional(readOnly = true)
	public Iterable<Categoria> findAll() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Categoria> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Categoria> findById(long id) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(id);
	}

	@Override
	@Transactional
	public Categoria Save(Categoria mesa) {
		// TODO Auto-generated method stub
		return categoriaRepository.save(mesa);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		categoriaRepository.deleteById(id);
	}

}
