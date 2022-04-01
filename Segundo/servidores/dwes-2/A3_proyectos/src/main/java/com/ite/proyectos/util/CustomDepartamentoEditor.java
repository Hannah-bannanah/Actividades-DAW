package com.ite.proyectos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.proyectos.modelo.bean.Cliente;
import com.ite.proyectos.modelo.bean.Departamento;
import com.ite.proyectos.modelo.repository.IntDepartamentoRepo;
import com.ite.proyectos.modelo.service.IntClienteSvc;

@Component
public class CustomDepartamentoEditor extends PropertyEditorSupport {
	@Autowired
	IntDepartamentoRepo iDepartamentos;
	
	@Override
	public String getAsText() {
		Departamento dpto = (Departamento) getValue();
        return dpto == null ? "" : String.valueOf(dpto.getIdDepar());
	}
	
	@Override
	public void setAsText(String text) {
		if (text.equals(""))
			setValue(null);
		else {
			Departamento dpto = iDepartamentos.findById(Integer.parseInt(text));
            setValue(dpto);
		}
	}
}
