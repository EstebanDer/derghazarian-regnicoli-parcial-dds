package com.parcialdds.disney;

import com.parcialdds.disney.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class DisneyApplication implements CommandLineRunner{
	static Scanner scanner = new Scanner(System.in);
	private Usuario usuario;

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
		while(true) {
			menuPrincipal();
		}
	}

	private void menuInicio(){
		System.out.println("Desea iniciar sesion (1) o registrarse? (2)");
		Integer accion = scanner.nextInt();
		switch(accion) {
			case 1: {
                ingresar();
			} break;
			case 2: {
                registrar();
                ingresar();
			} break;
			default:
				throw new IllegalStateException("Operacion desconocida: " + accion);
		}
	}

    private void registrar() {
        System.out.println("Ingrese un nombre de usuario");
        String nombre = scanner.next();
        System.out.println("Ingrese su CUIL");
        String cuil = scanner.next();
        System.out.println("Ingrese una contrasenia");
        String contrasenia = scanner.next();
		String nroTarjeta = generarNumeroTarjeta();
		TarjetaDisney tarjetaDisney = new TarjetaDisney(nroTarjeta, nombre, 100, (new Amarillo()));
		List<TarjetaCredito> tarjetasCredito = new ArrayList<TarjetaCredito>();
		usuario = new Usuario(nombre, contrasenia, cuil, tarjetaDisney, tarjetasCredito);
		usuarioService.save(usuario);
    }

	private String generarNumeroTarjeta() {
		String nroTarjeta = "";
		do {
			for(int i = 0; i < 16; i++){
				int random = (int)(Math.random() * 10 + 1);
				nroTarjeta = nroTarjeta + String.valueOf(random);
			}
		} while(tarjetaDisneyService.existsByNroTarjeta(nroTarjeta));

		return nroTarjeta;
	}

	private void ingresar() {
        System.out.println("Ingrese su nombre de usuario");
        String nombre = scanner.next();
        System.out.println("Ingrese su contrasenia");
        String contrasenia = scanner.next();
        if(!usuarioService.existsByNombreAndContrasenia(nombre, contrasenia)){
            System.out.println("Credenciales incorrectas, intente nuevamente");
            ingresar();//TODO: Corregir
        }
		if(usuarioService.findByNombreAndContrasenia(nombre, contrasenia).isPresent()){
			usuario = usuarioService.findByNombreAndContrasenia(nombre, contrasenia).get();
			usuario.getTarjetaDisney().inicializarEstado();
		} else{
			throw new NoSuchElementException();
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
						"Si desea cargar su tarjeta Disney ingrese 3");
				Integer accionTarjeta = scanner.nextInt();
				switch (accionTarjeta) {
					case 1: {
						//TODO: registrar medio de pago
					} break;
					case 2: {
						System.out.println("Ingrese el numero de la tarjeta a borrar");
						String nroTarjeta = scanner.next();

						usuario.borrarTarjeta(nroTarjeta);
						tarjetaCreditoService.deleteByNroTarjeta(nroTarjeta);
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
			case 3: {
				 System.exit(0);
			} break;
			default:
				throw new IllegalStateException("Operacion desconocida: " + accion);
		}
	}


}
