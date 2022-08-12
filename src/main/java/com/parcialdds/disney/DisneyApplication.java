package com.parcialdds.disney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DisneyApplication {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
		//TODO: agregar logica de repeticion
		menuInicio();
		menuPrincipal();

	}

	private static void menuInicio(){
		System.out.println("Desea iniciar sesion (1) o registrarse? (2)");
		Integer accion = scanner.nextInt();
		switch(accion) {
			case 1: {
				//TODO: ingresar al sistema
			}
			case 2: {
				//TODO: registrarse en el sistema
				//TODO: ingresar al sistema
			}
			default:
				throw new IllegalStateException("Operacion desconocida: " + accion);
		}
	}

	private static void menuPrincipal() {
		System.out.println("Si desea administrar sus medios de pago ingrese 1 \n" +
				"Si desea comprar un producto ingrese 2\n");
		Integer accion = scanner.nextInt();
		switch(accion){
			case 1: {
				System.out.println("Si desea registrar un nuevo medio de pago ingrese 1 \n" +
						"Si desea eliminar un medio de pago ingrese 2\n" +
						"Si desea cargar su tarjeta Disney 3\n");
				Integer accionTarjeta = scanner.nextInt();
				switch (accionTarjeta) {
					case 1: {
						//TODO: registrar medio de pago
					}
					case 2: {
						//TODO: eliminar medio de pago
					}
					case 3: {
						//TODO: cargar tarjeta Disney
					}
					default:
						throw new IllegalStateException("Operacion desconocida: " + accion);
				}

			}
			case 2: {
				//TODO: realizar compra
			}
			default:
				throw new IllegalStateException("Operacion desconocida: " + accion);
		}
	}

}
