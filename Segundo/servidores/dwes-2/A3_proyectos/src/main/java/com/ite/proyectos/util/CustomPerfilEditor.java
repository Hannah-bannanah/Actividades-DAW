package com.ite.proyectos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.proyectos.modelo.bean.Perfil;
import com.ite.proyectos.modelo.service.IntPerfilSvc;

@Component
public class CustomPerfilEditor extends PropertyEditorSupport{
	@Autowired
	IntPerfilSvc iPerfilSvc;
	
	@Override
	public String getAsText() {
		Perfil perfil = (Perfil) getValue();
		return perfil != null ? perfil.toString() : "";
	}
	
	@Override
	public void setAsText(String text) {
		if (text.equals("")) setValue(null);
		else {
			Perfil perfil = iPerfilSvc.findById(Integer.parseInt(text));
			setValue(perfil);
		}
	}
}
