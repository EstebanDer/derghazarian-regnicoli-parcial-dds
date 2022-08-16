package com.parcialdds.disney;

import com.parcialdds.disney.entity.Usuario;
import com.parcialdds.disney.entity.paquete.Paquete;
import com.parcialdds.disney.entity.paquete.TipoHospedaje;
import com.parcialdds.disney.entity.personaje.Personaje;
import com.parcialdds.disney.entity.producto.Producto;
import com.parcialdds.disney.entity.tarjetas.TarjetaCredito;
import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.Amarillo;
import com.parcialdds.disney.entity.tarjetas.tarjetaDisney.TarjetaDisney;
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
    private AtraccionService atraccionService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private TuristaService turistaService;

    @Autowired
    private PersonajeService personajeService;
    //endregion

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//generarPrototipos(); --> Se ejecuta en una unica ejecucion para generar los prototipos
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
		Boolean valor = true;
		do {
			System.out.println("Ingrese su nombre de usuario");
			String nombre = scanner.next();
			System.out.println("Ingrese su contrasenia");
			String contrasenia = scanner.next();
			if(!usuarioService.existsByNombreAndContrasenia(nombre, contrasenia)){
				System.out.println("Credenciales incorrectas, intente nuevamente");
			} else {
				if(usuarioService.findByNombreAndContrasenia(nombre, contrasenia).isPresent()){
					usuario = usuarioService.findByNombreAndContrasenia(nombre, contrasenia).get();
					usuario.getTarjetaDisney().inicializarEstado();
					valor = false;
				} else{
					throw new NoSuchElementException();
				}
			}
		} while(valor);
    }

    private void menuPrincipal() {
		System.out.println("Si desea administrar sus medios de pago ingrese 1 \n" +
				"Si desea comprar un producto ingrese 2\n" +
				"Si desea salir del sistema ingrese 3");
		Integer accion = scanner.nextInt();
		switch(accion){
			case 1: {
				System.out.println("Si desea agregar una nueva tarjeta de credito ingrese 1 \n" +
						"Si desea eliminar un medio de pago ingrese 2\n" +
						"Si desea cargar su tarjeta Disney ingrese 3");
				Integer accionTarjeta = scanner.nextInt();
				switch (accionTarjeta) {
					case 1: {
						System.out.println("Ingrese el numero de la tarjeta");
						String numeroTarjeta = scanner.next();
						System.out.println("Ingrese el nombre del titular");
						String titular = scanner.next();
						System.out.println("Ingrese el limite de la tarjeta");
						Integer limite = scanner.nextInt();

						TarjetaCredito tarjetaCredito = new TarjetaCredito(numeroTarjeta, titular, limite);
						usuario.agregarTarjetaCredito(tarjetaCredito);
						tarjetaCreditoService.save(tarjetaCredito);
						usuarioService.save(usuario);
					} break;
					case 2: {
						System.out.println("Ingrese el numero de la tarjeta a borrar");
						String nroTarjeta = scanner.next();

						usuario.borrarTarjeta(nroTarjeta);
						tarjetaCreditoService.deleteByNroTarjeta(nroTarjeta);
					} break;
					case 3: {
						System.out.println("Ingrese el monto de la carga");
						Integer monto = scanner.nextInt();
						System.out.println("Ingrese el numero de la tarjeta de credito que utilizara para la carga");
						String numeroTarjeta = scanner.next();
						Optional<TarjetaCredito> tarjetaCredito = tarjetaCreditoService.findByNroTarjeta(numeroTarjeta);

						if(usuario.cargarTarjetaDisney(monto, tarjetaCredito.get()) == 1) {
							System.out.println("Carga realizada");
							tarjetaCreditoService.save(tarjetaCredito.get());
							tarjetaDisneyService.save(usuario.getTarjetaDisney());
						} else {
							System.out.println("No se pudo realizar la carga");
						}
					} break;
					default:
						throw new IllegalStateException("Operacion desconocida: " + accion);
				}

			} break;
			case 2: {
				Compra compra = new Compra();
                Iterable<Paquete> paquetes = paqueteService.findByEsPrototipoTrue();
                Iterable<Personaje> personajes = personajeService.findAll();
                Producto producto = compra.realizar(usuario, paquetes, personajes);
				paqueteService.save(producto.getPaquete());
				turistaService.saveAll(producto.getTurista());
				productoService.save(producto);
				usuarioService.save(usuario);
			} break;
			case 3: {
				 System.exit(0);
			} break;
			default:
				throw new IllegalStateException("Operacion desconocida: " + accion);
		}
	}

	// esto ya no se usa porque ya estan en la bd
	private void generarPrototipos() {
		Paquete paquetePareja, paqueteFamiliar, paquetePremium;

		paquetePareja = new Paquete(
				7,
				300,
				TipoHospedaje.UNAHABITACION,
				true,
				true);

		paqueteFamiliar = new Paquete(
				10,
				350,
				TipoHospedaje.DOSHABITACIONES,
				true,
				false);

		paquetePremium = new Paquete(
				14,
				500,
				TipoHospedaje.SUITE,
				true,
				true);

		paqueteService.save(paquetePareja);
		paqueteService.save(paqueteFamiliar);
		paqueteService.save(paquetePremium);
	}


}
