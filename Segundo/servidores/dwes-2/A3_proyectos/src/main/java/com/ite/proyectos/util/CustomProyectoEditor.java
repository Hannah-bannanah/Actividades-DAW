package com.ite.proyectos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.proyectos.modelo.service.IntProyectoSvc;


@Component
public class CustomProyectoEditor extends PropertyEditorSupport{
	@Autowired
	IntProyectoSvc iProyectoSvc;
	
	@Override
	public void setAsText(String text) {
		setValue(iProyectoSvc.findById(text));
	}
}
