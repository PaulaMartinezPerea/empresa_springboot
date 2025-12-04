package com.aprendec.controller;

import com.aprendec.model.Empleado;
import com.aprendec.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Api Rest
@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestController {

	private final EmpleadoService service;

	public EmpleadoRestController(EmpleadoService service) {
		this.service = service;
	}

	@GetMapping
	public List<Empleado> listar() {
		return service.listarEmpleados();
	}

	@GetMapping("/{dni}/sueldo")
	public ResponseEntity<Double> obtenerSueldo(@PathVariable String dni) {
		double sueldo = service.obtenerSueldo(dni);
		if (sueldo == 0.0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(sueldo);
	}

	@PutMapping("/{dni}")
	public ResponseEntity<String> actualizarEmpleado(@PathVariable String dni, @RequestBody Empleado empleado) {

		if (!dni.equals(empleado.getDni())) {
			return ResponseEntity.badRequest().body("El DNI no coincide con el empleado");
		}

		service.modificarEmpleado(empleado);
		return ResponseEntity.ok("Empleado actualizado correctamente");
	}
}
