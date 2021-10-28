package com.RestaurantServices.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RestaurantServices.app.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

	@Query(value = "SELECT * FROM menus  a where a.categoria=:id", nativeQuery = true)
	List<Menu> forCategory(@Param("id") long id);
}
