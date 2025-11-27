package com.aprendec.service;

import java.util.List;
import com.aprendec.model.Empleado;

public interface EmpleadoService {

    List<Empleado> listarEmpleados();

    double obtenerSueldo(String dni);

    void modificarEmpleado(Empleado e);
}
