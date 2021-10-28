package com.RestaurantServices.app.Services;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RestaurantServices.app.entity.Mesa;

public interface MesaInterface {
	
	public Iterable<Mesa> findAll();
	
	public Page<Mesa> findAll(Pageable pageable);
	
	public Optional<Mesa> findById(long id);
	
	public Mesa Save(Mesa mesa);
	
	public void deleteById(long id);

}
