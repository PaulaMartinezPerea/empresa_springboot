package com.aprendec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.aprendec.model.Empleado;
import com.aprendec.service.EmpleadoService;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	private final EmpleadoService service;

	public EmpresaController(EmpleadoService service) {
		this.service = service;
	}

	@GetMapping("/")
	public String inicio() {
		System.out.println("Se accedió a la página de inicio");
		return "pagina";
	}

	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("empleados", service.listarEmpleados());
		return "MostrarEmpleados";
	}

	@GetMapping("/sueldo")
	public String sueldoForm() {
		return "MostrarSalario";
	}

	@GetMapping("/sueldo/buscar")
	public String buscarSueldo(@RequestParam String dni, Model model) {
		model.addAttribute("dni", dni);
		model.addAttribute("sueldo", service.obtenerSueldo(dni));
		return "MostrarSalario";
	}

	@GetMapping("/modificar")
	public String modificar() {
		return "ModificarDatos";
	}

	@PostMapping("/modificar/guardar")
	public String guardar(Empleado e, Model model) {
		service.modificarEmpleado(e);
		model.addAttribute("mensaje", "El empleado ha sido modificado correctamente");
		return "ModificarDatos";
	}
}
