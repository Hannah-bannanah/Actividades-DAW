package com.ite.eventos.util;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ite.eventos.modelo.bean.Tipo;
import com.ite.eventos.modelo.repository.IntTipoRepo;

@Component
public class CustomTipoEditor extends PropertyEditorSupport{
	
	@Autowired
	IntTipoRepo iTipos;
	
	@Override
	public String getAsText() {
		Tipo tipo = (Tipo) getValue();
        
        return tipo == null ? "" : String.valueOf(tipo.getIdTipo());
	}
	
	public void setAsText(String text) {
		if (text.equals(""))
			setValue(null);
		else {
			int idTipo = Integer.parseInt(text);
			Tipo tipo = iTipos.findById(idTipo);
            setValue(tipo);
		}
	}
	
}
