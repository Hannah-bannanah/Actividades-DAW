package com.ite.proyectos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.proyectos.modelo.bean.Cliente;
import com.ite.proyectos.modelo.repository.IntClienteRepo;
import com.ite.proyectos.modelo.service.IntClienteSvc;

@Component
public class CustomClienteEditor extends PropertyEditorSupport {
	@Autowired
	IntClienteSvc iClienteSvc;
	
	@Override
	public String getAsText() {
		Cliente cliente = (Cliente) getValue();     
        return cliente == null ? "" : String.valueOf(cliente.getCif());
	}
	
	@Override
	public void setAsText(String text) {
		if (text.equals(""))
			setValue(null);
		else {
			Cliente cliente = iClienteSvc.findByCif(text);
            setValue(cliente);
		}
	}
}
