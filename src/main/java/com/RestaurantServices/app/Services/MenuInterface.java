package com.RestaurantServices.app.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.RestaurantServices.app.entity.Menu;


public interface MenuInterface {
	
public Iterable<Menu> findAll();
	
	public Page<Menu> findAll(Pageable pageable);
	
	public Optional<Menu> findById(long id);
	
	public Menu Save(Menu menu);
	
	public void deleteById(long id);
	
	public List<Menu> forCategory(long id);
}
