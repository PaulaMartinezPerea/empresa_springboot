package com.aprendec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aprendec.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

}
