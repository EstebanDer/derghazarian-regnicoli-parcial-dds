package com.parcialdds.disney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DisneyApplication implements CommandLineRunner{
	static Scanner scanner = new Scanner(System.in);
	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
		//TODO: agregar logica de repeticion


	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario("Lucho", "esactamente", "1234567");
		usuarioService.save(usuario); // Parece que estas cosas hay que hacer el este metodo (Lo que se de DB)
		menuInicio();
		menuPrincipal();
	}

	private static void menuInicio(){
		System.out.println("Desea iniciar sesion (1) o registrarse? (2)");
		Integer accion = scanner.nextInt();
		switch(accion) {
			case 1: {
				//TODO: ingresar al sistema
			} break;
			case 2: {
				//TODO: registrarse en el sistema
				//TODO: ingresar al sistema
			} break;
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
					} break;
					case 2: {
						//TODO: eliminar medio de pago
					} break;
					case 3: {
						//TODO: cargar tarjeta Disney
					} break;
					default:
						throw new IllegalStateException("Operacion desconocida: " + accion);
				}

			} break;
			case 2: {
				//TODO: realizar compra
			} break;
			default:
				throw new IllegalStateException("Operacion desconocida: " + accion);
		}
	}


}
