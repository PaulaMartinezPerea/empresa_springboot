package com.aprendec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aprendec.model.Empleado;
import com.aprendec.model.Nomina;
import com.aprendec.repository.EmpleadoRepository;
import com.aprendec.repository.NominaRepository;
import com.aprendec.service.EmpleadoService;

//Implementacion de EmpleadoService
@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

	private final EmpleadoRepository empleadoRepo;
	private final NominaRepository nominaRepo;

	public EmpleadoServiceImpl(EmpleadoRepository e, NominaRepository n) {
		this.empleadoRepo = e;
		this.nominaRepo = n;
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoRepo.findAll();
	}

	@Override
	public double obtenerSueldo(String dni) {
		return nominaRepo.findById(dni).map(Nomina::getSueldo).orElse(0.0);
	}

	@Override
	public void modificarEmpleado(Empleado e) {
		empleadoRepo.save(e);
		double nuevoSalario = calcularSueldo(e.getCategoria(), e.getAniosTrabajados());
		nominaRepo.save(new Nomina(e.getDni(), nuevoSalario));
	}

	private double calcularSueldo(int categoria, int anyos) {
		double base = switch (categoria) {
		case 1 -> 1000;
		case 2 -> 1400;
		case 3 -> 1800;
		case 4 -> 2300;
		default -> 900;
		};
		return Math.round(base + anyos * 25);
	}
}