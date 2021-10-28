package com.RestaurantServices.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestaurantServices.app.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{

}
