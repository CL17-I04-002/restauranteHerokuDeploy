package com.RestaurantServices.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestaurantServices.app.entity.Empleado;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
