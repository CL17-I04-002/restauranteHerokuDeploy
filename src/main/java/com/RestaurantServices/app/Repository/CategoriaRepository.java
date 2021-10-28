package com.RestaurantServices.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestaurantServices.app.entity.Categoria;
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
