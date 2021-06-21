import java.util.Scanner;
import com.itt.maquinaexpendedora.*;

import exceptions.*;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		//Creamos el objeto máquina y lo llenamos de bebidas
		Maquina maquina = new Maquina(Collections.nCopies(4, new Bebida("Coca Loca", 1.30F)));
		maquina.reponer(Collections.nCopies(4, new Bebida("Fanta Stica", 1.35F)));
		maquina.reponer(Collections.nCopies(4, new Bebida("Fanta Smagórica", 10.00F)));
		maquina.reponer(Collections.nCopies(4, new Bebida("Aqua Man", 1.00F)));

		//Creamos objeto Scanner para obtener input del usuario
		Scanner sc = new Scanner(System.in);
		
		int accion; //variable de control de la acción 
		
		//Mostramos el menú hasta que el usuario seleccione salir
		do {
			mostrarMenu();
			accion = sc.nextInt();
			sc.nextLine();
			/*
			for (Bebida bebida: maquina.getBebidas()) {
				System.out.println(bebida);
			}
			*/
			try {
				switch (accion) {
					case 1:
						maquina.expenderBebida(new Bebida("Coca Loca", 1.30F));
						System.out.println("Marchando una Coca Loca!");
						break;
					case 2:
						maquina.expenderBebida(new Bebida("Fanta Stica", 1.35F));
						System.out.println("Marchando una Fanta Stica!");
						break;
					case 3:
						maquina.expenderBebida(new Bebida("Fanta Smagórica", 10.00F));
						System.out.println("Marchando una Fanta Smagórica!");
						break;
					case 4:
						maquina.expenderBebida(new Bebida("Aqua Man", 1.00F));
						System.out.println("Marchando un Aqua Man!");
						break;
					case 5:
						String contrasena;
						int numIntentos = 0;
						boolean usuarioValidado = false;
						do {
							System.out.println("Ha solicitado acceder al menú de operario.\n"
									+ "Introduzca la contraseña de operario\n"
									+ "ATENCIÓN: no intente adivinar la contraseña. ES INHACKEABLE!!!");
							contrasena = sc.nextLine();
							try {
								usuarioValidado = maquina.validarOperario(contrasena);
							} catch (UsuarioNoAutorizadoException e) {
								e.printStackTrace();
							}
							numIntentos ++;
							if (numIntentos >= 3) {
								System.out.println("Excedido el límite de intentos. Esta máquina se autodestruirá en 5ns");
							}
						} while (!usuarioValidado && numIntentos <3);
						if(maquina.validarOperario(contrasena)) {
							do {
								mostrarMenuOperario();
								accion = sc.nextInt();
								sc.nextLine();	
								switch (accion) {
								case 1:
									System.out.println("Introduzca nombre de la bebida");
									String nombreBebida = sc.nextLine();
									System.out.println("Introduzca precio de la bebida");
									float precioBebida = sc.nextFloat();
									sc.nextLine();
									maquina.reponer(new Bebida(nombreBebida, precioBebida));
									break;
								case 2: 
									List<Bebida> bebidasRepuestas = new ArrayList<Bebida>();
									String nombre = "";
									while (!nombre.toUpperCase().equals("FIN")) {
										System.out.println("Indroduzca una bebida o la palabra FIN para terminar");
										nombre = sc.nextLine();
										if (!nombre.toUpperCase().equals("FIN")) {
											System.out.println("Indroduzca el precio de la bebida");
											float precio = sc.nextFloat();
											sc.nextLine();
											bebidasRepuestas.add(new Bebida(nombre, precio));
										}
									}
									
									maquina.reponer(bebidasRepuestas);		
									break;
								case 3:
									System.out.println("Se han recogido " + maquina.recogerRecoleccion() + "€.");
									break;
								case 4:
									System.out.println("Volviendo al menú de plebeyos");
									break;
								default:
									System.out.println("Opción no válida");
								}
							} while (accion != 4);
						}
						break;
					case 0:
						System.out.println("Transacción completa");
						break;
					default:
						System.out.print("Opción no válida");
				}
			} catch (bebidaAgotadaException e) {
				e.printStackTrace();
			}
			/*
			for (Bebida bebida: maquina.getBebidas()) {
				System.out.println(bebida);
			}
			*/
		} while (accion != 0);
		
		

	}
	
	public static void mostrarMenu() {
		System.out.println("MÁQUINA DE BEBIDAS");
		System.out.println("--------------------------------");
		System.out.println("1. Coca Loca ---- 1,30€");
		System.out.println("2. Fanta Stica ---- 1,35€");
		System.out.println("3. Fanta Smagórica ---- 10,00€");
		System.out.println("4. Aqua Man ---- 1,00€");
		System.out.println("--------------------------------");
		System.out.println("Elija opción para comprar bebida");
		System.out.println("Pulse 5 para el menú de Operario");
		System.out.println("Pulse 0 para salir");
	}

	public static void mostrarMenuOperario() {
		System.out.println("MÁQUINA DE BEBIDAS - MODO OPERARIO");
		System.out.println("--------------------------------");
		System.out.println("¿Qué desea hacer?");
		System.out.println("1. Reponer una bebida");
		System.out.println("2. Reponer varias bebidas");
		System.out.println("3. Recoger recolección");
		System.out.println("4. Volver al menú principal");
		System.out.println("--------------------------------");
		System.out.println("Pulse 0 para salir");
	}
}
