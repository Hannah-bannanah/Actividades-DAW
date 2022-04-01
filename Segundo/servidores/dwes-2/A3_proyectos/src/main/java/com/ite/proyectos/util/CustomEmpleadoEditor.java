package com.ite.proyectos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.proyectos.modelo.bean.Empleado;
import com.ite.proyectos.modelo.service.IntEmpleadoSvc;

@Component
public class CustomEmpleadoEditor extends PropertyEditorSupport{
	@Autowired
	IntEmpleadoSvc iEmpleadoSvc;
	
	@Override
	public String getAsText() {
		Empleado empleado = (Empleado) getValue();
		return empleado != null ? empleado.toString() : "";
	}
	
	@Override
	public void setAsText(String text) {
		Empleado empleado = iEmpleadoSvc.findById(Integer.parseInt(text));
		setValue(empleado);
	}
}
