package Entidades;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Interfaz.Compra;

public class Controlador {

	private static EntityManager entityManager;

//------------------INSERTAR----------------------
	public static void insertarConductor() {
		Conductor conductor = new Conductor();
		conductor.setNombre("Jorge");

		entityManager.persist(conductor);
	}

	public static void insertarCliente() {
		Cliente cliente = new Cliente();
		cliente.setDniCliente("47545544K");
		cliente.setNombre("Ylenia");
		cliente.setEmail("ylenia@hotmail.com");
		cliente.setPassword("023400");
		cliente.setTrayecto(null);

		entityManager.persist(cliente);
	}

	public static void insertarEstacion() {
		Estacion estacion = new Estacion();
		estacion.setCiudad("Ceuta");
		estacion.setNombreEstacion("San Fronte");

		entityManager.persist(estacion);
	}

	public static void insertarMedioTransporte() {
		MedioTransporte bus = new MedioTransporte();
		bus.setTipo("AutoCar");
		bus.setConductor(null);

		entityManager.persist(bus);
	}

	public static void insertarPago() {
		Pago pago = new Pago();
		pago.setNumeroTarjeta("2111112391");
		pago.setPin(1341);
		pago.setTrayecto(null);

		entityManager.persist(pago);
	}

//------------------CONSULTAR----------------------
	public static void consultarConductor() {
		Query query = entityManager.createQuery("Select co from Conductor co where idConductor = '1'");

		ArrayList<Conductor> lista = new ArrayList<Conductor>();
		lista = (ArrayList<Conductor>) query.getResultList();

		String resultado = "";

		for (Conductor co : lista) {
			resultado += co.toString() + "\n";
		}

		System.out.println(resultado);
	}

	public static void consultarCliente() {
		Query query = entityManager.createQuery("Select cli from Cliente cli where dni = '45124434K'");

		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		lista = (ArrayList<Cliente>) query.getResultList();

		String resultado = "";

		for (Cliente cli : lista) {
			resultado += cli.toString() + "\n";
		}

		System.out.println(resultado);
	}

	public static void consultarEstacion() {
		Query query = entityManager.createQuery("Select es from Estacion es where idEstacion = '1'");

		ArrayList<Estacion> lista = new ArrayList<Estacion>();
		lista = (ArrayList<Estacion>) query.getResultList();

		String resultado = "";

		for (Estacion es : lista) {
			resultado += es.toString() + "\n";
		}

		System.out.println(resultado);
	}

	public static void consultarMedioTransporte() {
		Query query = entityManager.createQuery("Select mt from MedioTransporte mt where idTransporte = '1'");

		ArrayList<MedioTransporte> lista = new ArrayList<MedioTransporte>();
		lista = (ArrayList<MedioTransporte>) query.getResultList();

		String resultado = "";

		for (MedioTransporte mt : lista) {
			resultado += mt.toString() + "\n";
		}

		System.out.println(resultado);
	}

	public static void consultarPago() {
		Query query = entityManager.createQuery("Select pa from Pago pa where idPago = '1'");

		ArrayList<Pago> lista = new ArrayList<Pago>();
		lista = (ArrayList<Pago>) query.getResultList();

		String resultado = "";

		for (Pago pa : lista) {
			resultado += pa.toString() + "\n";
		}

		System.out.println(resultado);
	}

//------------------ACTUALIZAR----------------------
	public static void actualizarConductor() {
		Conductor conductor = new Conductor();

		conductor.setIdConductor(1);
		conductor.setNombre("JORGITO");

		entityManager.merge(conductor);
	}

	public static void actualizarCliente() {
		Cliente cliente = new Cliente();

		cliente.setDniCliente("45124434K");
		cliente.setNombre("JORGITOX");
		cliente.setEmail("JORGITO@hotmail.com");

		entityManager.merge(cliente);
	}

	public static void actualizarEstacion() {
		Estacion estacion = new Estacion();

		estacion.setNombreEstacion("PEDRITOLAGUITARRA");
		estacion.setCiudad("MURCIA");

		entityManager.merge(estacion);
	}

	public static void actualizarMedioTransporte() {
		MedioTransporte transporte = new MedioTransporte();

		Conductor c = new Conductor();
		c.setNombre("PEDRITOLD");
		entityManager.persist(c);

		transporte.setTipo("BUSX");
		transporte.setConductor(c);

		entityManager.merge(transporte);
	}

	public static void actualizarPago() {
		Pago pago = new Pago();

		pago.setIdPago(1);
		pago.setNumeroTarjeta("0");
		pago.setPin(0);
		pago.setTrayecto(null);

		entityManager.merge(pago);
	}

//------------------BORRAR----------------------

	public static void borrarConductor() {
		Conductor conductor = entityManager.getReference(Conductor.class, 1);
		entityManager.remove(conductor);
	}

	public static void borrarCliente() {
		Cliente cliente = entityManager.getReference(Cliente.class, "45124434K");
		entityManager.remove(cliente);
	}

	public static void borrarEstacion() {
		Estacion estacion = entityManager.getReference(Estacion.class, 1);
		entityManager.remove(estacion);
	}

	public static void borrarMedioTransporte() {
		MedioTransporte transporte = entityManager.getReference(MedioTransporte.class, 1);
		entityManager.remove(transporte);
	}

	public static void borrarPago() {
		Pago pago = entityManager.getReference(Pago.class, 1);
		entityManager.remove(pago);
	}

	public static void insertarTrayecto() {
		Trayecto trayecto = new Trayecto();
		
		Estacion estacionSalida = new Estacion();
		estacionSalida.setNombreEstacion("La Primitiva");
		estacionSalida.setCiudad("Barcelona");

		MedioTransporte autocar = new MedioTransporte();
		autocar.setConductor(null);
		autocar.setTipo("Autocar");
	
		Cliente cliente = new Cliente();
		cliente.setDniCliente("42665643K");
		cliente.setNombre("Paula");
		cliente.setEmail("paula@hotmail.com");

		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
		
		Estacion estacionLlegada = new Estacion();
		estacionLlegada.setNombreEstacion("RUSSS");
		estacionLlegada.setCiudad("Rusia");
		
		trayecto.setFecha("31/12/2017");
		trayecto.setHoraSalida("21:00");
		trayecto.setHoraLlegada("23:15");
		trayecto.setDuracion("2.15");
		trayecto.setPrecio("20.00");
		trayecto.setTransporte(autocar);
		trayecto.setEstacionLlegada(estacionLlegada);
		trayecto.setEstacionSalida(estacionSalida);
		
		entityManager.persist(trayecto);
	}

	public static void consultarTrayecto() {
		Query query = entityManager.createQuery("Select tra from Trayecto tra where idTrayecto = '3'");

		Trayecto tra = (Trayecto) query.getSingleResult();
		System.out.println(tra.toString());

	}

	// NO FUNCIONA
	public static void actualizarTrayecto() {
		Trayecto trayecto = new Trayecto();

		trayecto.setIdTrayecto(1);
		trayecto.setFecha("2023-02-09");
		trayecto.setHoraSalida("13:00");
		trayecto.setHoraLlegada("17:15");
		trayecto.setDuracion("19.15");
		trayecto.setPrecio("15.95");
		trayecto.setTransporte(null);
		trayecto.setEstacionLlegada(null);
		trayecto.setEstacionSalida(null);

		entityManager.merge(trayecto);
	}

	public static void borrarTrayecto() {
		Trayecto trayecto = entityManager.getReference(Trayecto.class, 2);
		entityManager.remove(trayecto);
	}
	
	public static void prueba() {
		
		Trayecto trayecto = new Trayecto();

		trayecto.setFecha("07/01/2017");
		trayecto.setHoraSalida("20:00");
		trayecto.setHoraLlegada("21:15");
		trayecto.setDuracion("1.15");
		trayecto.setPrecio("5.95");
		trayecto.setTransporte(null);
		trayecto.setEstacionLlegada(null);
		trayecto.setEstacionSalida(null);
		
		entityManager.persist(trayecto);
		
		Cliente cliente = new Cliente();
		cliente.setDniCliente("12453454F");
		cliente.setNombre("Monica");
		cliente.setEmail("monica@gmail.com");
		
		entityManager.persist(cliente);
		
		Pago pago = new Pago();
		pago.setCliente(cliente);
		pago.setNumeroTarjeta("13333333");
		pago.setPin(044440);
		pago.setTrayecto(trayecto);
		
		entityManager.persist(pago);
		
	}
	
	private static Cliente consultarCli() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("Select cli from Cliente cli where nombre = 'JOSE'");
		Cliente cliente= (Cliente) query.getSingleResult();
		
		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();
		
		return cliente;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		// FUNCIONES...
		// consultarTrayecto();

		// actualizarTrayecto();

		// borrarTrayecto();

		// insertarTrayecto();
		
		insertarPago();

		//prueba();
		
		//consultar();
		
		//insertarCliente();
	
		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();
	}

}
