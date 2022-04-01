package com.ite.proyectos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.proyectos.modelo.service.IntProductoSvc;

@Component
public class CustomProductoEditor extends PropertyEditorSupport{
	@Autowired
	IntProductoSvc iProductoSvc;
	
	@Override
	public void setAsText(String text) {
		setValue(iProductoSvc.findById(Integer.parseInt(text)));
	}
}
