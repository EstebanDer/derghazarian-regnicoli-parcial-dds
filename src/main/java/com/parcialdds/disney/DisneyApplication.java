package com.parcialdds.disney;

import com.parcialdds.disney.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DisneyApplication implements CommandLineRunner{
	static Scanner scanner = new Scanner(System.in);

    //region Servicios
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TarjetaDisneyService tarjetaDisneyService;

    @Autowired
    private TarjetaCreditoService tarjetaCreditoService;

    @Autowired
    private PaqueteService paqueteService;

    @Autowired
    private PersonajeService personajeService;

    @Autowired
    private AtraccionService atraccionService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private TuristaService turistaService;
    //endregion

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
		//TODO: agregar logica de repeticion


	}

	@Override
	public void run(String... args) throws Exception {
//		Optional<Usuario> usuario = usuarioService.findById(4L);
//		System.out.println(usuario.get().toString());
//		TarjetaDisney tarjetaDisney = new TarjetaDisney(1500, "amarillo");
//		tarjetaDisneyService.save(tarjetaDisney);


//		Iterable<Usuario> usuarios = usuarioService.findAll();
//		for(Usuario usuario : usuarios){
//			System.out.println(usuario.toString());
//		}


		menuInicio();
		menuPrincipal();
	}

	private void menuInicio(){
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

	private void menuPrincipal() {
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
