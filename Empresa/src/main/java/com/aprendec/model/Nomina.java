package com.aprendec.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nominas")
public class Nomina {

	@Id
	@Column(name = "empleado_dni")
	private String empleadoDni;
	private double sueldo;

	public Nomina() {
	}

	public Nomina(String empleadoDni, double sueldo) {
		this.empleadoDni = empleadoDni;
		this.sueldo = sueldo;
	}

	public String getEmpleadoDni() {
		return empleadoDni;
	}

	public void setEmpleadoDni(String empleadoDni) {
		this.empleadoDni = empleadoDni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
}
