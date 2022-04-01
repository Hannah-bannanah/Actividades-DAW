package testing;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Familia;
import modelo.dao.AbstractFactory;
import modelo.dao.GestionFamiliaImplJpa;
import modelo.dao.IntGestionFamiliaJpa;

public class TestFamilia {

	public TestFamilia() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		IntGestionFamiliaJpa fam = new GestionFamiliaImplJpa();
		
		//crear familias
		Familia f1 = new Familia();
		f1.setDescripcion("familia 1");
		Familia f2 = new Familia();
		f2.setDescripcion("familia 2");
		Familia f3 = new Familia();
		f3.setDescripcion("familia 3");
		System.out.println("Familias creadas:");
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		//insertar familias
		int f1Insert = fam.insertOne(f1);
		int f2Insert = fam.insertOne(f2);
		int f3Insert = fam.insertOne(f3);
		if (f1Insert == 1 && f2Insert == 1 && f3Insert == 1)
			System.out.println("familias insertadas con éxito");
		else 
			System.out.println("error al insertar familias");
		
		// fetchAll
		List<Familia> familias = fam.fetchAll();
		System.out.println("Lista de familias tras el insert");
		for (Familia familia: familias)
			System.out.println(familia);
		
		//actualizar familias
		f1 = fam.findById(12);
		f1.setDescripcion("familia 12");
		f2 = fam.findById(15);
		f2.setDescripcion("familia 15");
		f3 = fam.findById(16);
		f3.setDescripcion("familia 16");
		int f1Update = fam.update(f1);
		int f2Update = fam.update(f2);
		int f3Update = fam.update(f3);
		if (f1Update == 1 && f2Update == 1 && f3Update == 1)
			System.out.println("familias modificadas con exito");
		else
			System.out.println("error al modificar familias");
	
		// fetchAll
		familias = fam.fetchAll();
		System.out.println("Lista de familias tras el update");
		for (Familia familia: familias)
			System.out.println(familia);
		
		//findById
		Familia fam1 = fam.findById(f1.getIdFamilia());
		System.out.println("familia de id 1:" + fam1);
		
		//eliminar familias
		int f2Del = fam.removeById(f2.getIdFamilia());
		int f3Del = fam.removeById(f3.getIdFamilia());
		if (f2Del == 1 && f3Del == 1)
			System.out.println("familias eliminadas con exito");
		else
			System.out.println("error al eliminar familias");
		
		// fetchAll
		familias = fam.fetchAll();
		System.out.println("Lista de familias tras el delete");
		for (Familia familia: familias)
			System.out.println(familia);
	}

}
