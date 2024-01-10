package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;

import Entidades.Cliente;
import Entidades.Estacion;
import Entidades.MedioTransporte;
import Entidades.Pago;
import Entidades.Trayecto;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);

			System.out.println("El servidor está esperando peticiones...");

			while (true) {

				Socket newSocket = serverSocket.accept();
				DataInputStream dis = new DataInputStream(newSocket.getInputStream());
				DataOutputStream dos = new DataOutputStream(newSocket.getOutputStream());

				System.out.println("Se ha recibido una petición");

				JSONObject peticion = new JSONObject(dis.readUTF());
				int eleccion = peticion.getInt("Eleccion");

				JSONObject respuesta;
				JSONArray respuestaM;

				switch (eleccion) {

				// LOGIN
				case 1:
					respuesta = new JSONObject();
					respuesta = consultarCliente(peticion.getString("nombre"));
					dos.writeUTF(respuesta.toString());

					System.out.println("El usuario ha iniciado sesión");
					break;

				// REGISTRO
				case 2:
					altaCliente(peticion.getString("dni"), peticion.getString("nombre"), peticion.getString("email"),
							peticion.getString("password"));

					System.out.println("Se ha registrado el usuario: " + peticion.toString());
					break;

				// CONSULTAR TRAYECTOS MEDIANTE FECHA Y ESTACIONES
				case 3:
					respuestaM = new JSONArray();

					JSONObject estaciones = consultarEstaciones(peticion.getString("ciudadOrigen"),
							peticion.getString("ciudadDestino"));

					respuestaM = buscarTrayectos(peticion.getString("fecha"), estaciones.getString("estacionOrigen"),
							estaciones.getString("estacionLlegada"));

					dos.writeUTF(respuestaM.toString());

					System.out.println("Se han consultado dos estaciones para varios trayectos");

					break;

				// CONSULTAR TRAYECTO
				case 4:
					respuesta = new JSONObject();
					respuesta = consultarTrayecto(peticion.getInt("id"));
					dos.writeUTF(respuesta.toString());

					System.out.println("Se ha consultado un trayecto");
					break;

				// REALIZAR PAGO
				case 5:

				// Para realizar un pago debe crearse anteriormente un cliente y un trayecto para asociarlos.
					JSONObject trayecto = consultarTrayecto(peticion.getInt("idTrayecto"));
					JSONObject cliente = consultarCliente(peticion.getString("nombre"));
					JSONObject estacions = consultarEstaciones(peticion.getString("ciudadSalida"),
							peticion.getString("ciudadLlegada"));

					realizarPago(peticion.getString("tarjeta"), peticion.getInt("pin"), trayecto, estacions, cliente);

					System.out.println("Se ha realizado un pago");
					break;

				//REGISTRO DE TRAYECTOS (SAX)
				case 6:
					respuestaM = new JSONArray();
					respuestaM = registroTrayectos();

					dos.writeUTF(respuestaM.toString());

					System.out.println("Se ha consultado el registro de trayectos");
					
					break;
					
				//CONSULTAR PAGOS	
				case 7:
					respuestaM = new JSONArray();
					respuestaM = consultarPagos(peticion.getString("dni"));

					dos.writeUTF(respuestaM.toString());

					System.out.println("Se ha consultado el registro de trayectos");
					
					
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static JSONObject consultarCliente(String nombreUsuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select cli from Cliente cli where nombre = '" + 
												nombreUsuario + "'");
		Cliente cliente = (Cliente) query.getSingleResult();

		JSONObject datos = new JSONObject();
		datos.put("dni", cliente.getDniCliente());
		datos.put("nombre", cliente.getNombre());
		datos.put("email", cliente.getEmail());
		datos.put("password", cliente.getPassword());

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return datos;
	}

	public static void altaCliente(String dni, String nombre, String email, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Cliente cliente = new Cliente();
		cliente.setDniCliente(dni);
		cliente.setNombre(nombre);
		cliente.setEmail(email);
		cliente.setPassword(password);
		cliente.setTrayecto(null);

		entityManager.persist(cliente);

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();
	}

	private static JSONObject consultarEstaciones(String ciudadOrigen, String ciudadLlegada) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		JSONObject datos = new JSONObject();

		Query query = entityManager.createQuery("Select es from Estacion es where ciudad = '" + ciudadOrigen + "'");
		Estacion origen = (Estacion) query.getSingleResult();
		datos.put("ciudadOrigen", origen.getCiudad());
		datos.put("estacionOrigen", origen.getNombreEstacion());

		query = entityManager.createQuery("Select es from Estacion es where ciudad = '" + ciudadLlegada + "'");
		Estacion llegada = (Estacion) query.getSingleResult();
		datos.put("ciudadLlegada", llegada.getCiudad());
		datos.put("estacionLlegada", llegada.getNombreEstacion());

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return datos;
	}

	public static JSONArray buscarTrayectos(String fecha, String estacionOrigen, String estacionLlegada) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();
		Query query = entityManager.createQuery("Select tra from Trayecto tra where fecha = '" + fecha
				+ "' and estacionOrigen = '" + estacionOrigen + "' and estacionLlegada = '" + estacionLlegada + "'");
		trayectos = (ArrayList<Trayecto>) query.getResultList();

		JSONObject datos = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < trayectos.size(); i++) {

			datos.put("idTrayecto" + i, trayectos.get(i).getIdTrayecto());
			datos.put("fecha" + i, trayectos.get(i).getFecha());
			datos.put("horaSalida" + i, trayectos.get(i).getHoraSalida());
			datos.put("horaLlegada" + i, trayectos.get(i).getHoraLlegada());
			datos.put("duracion" + i, trayectos.get(i).getDuracion());
			datos.put("precio" + i, trayectos.get(i).getPrecio());
			datos.put("idTransporte" + i, trayectos.get(i).getTransporte().getIdTransporte());
			datos.put("estacionSalida" + i, trayectos.get(i).getEstacionSalida().getNombreEstacion());
			datos.put("estacionLlegada" + i, trayectos.get(i).getEstacionLlegada().getNombreEstacion());

			array.put(datos);

		}

		System.out.println(array.toString());

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return array;
	}

	public static JSONObject consultarTrayecto(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select tra from Trayecto tra where idTrayecto = '" + id + "'");

		Trayecto trayecto = (Trayecto) query.getSingleResult();

		JSONObject datos = new JSONObject();
		datos.put("idTrayecto", trayecto.getIdTrayecto());
		datos.put("fecha", trayecto.getFecha());
		datos.put("horaSalida", trayecto.getHoraSalida());
		datos.put("horaLlegada", trayecto.getHoraLlegada());
		datos.put("duracion", trayecto.getDuracion());
		datos.put("precio", trayecto.getPrecio());
		datos.put("idTransporte", trayecto.getTransporte().getIdTransporte());
		datos.put("estacionSalida", trayecto.getEstacionSalida().getNombreEstacion());
		datos.put("estacionLlegada", trayecto.getEstacionLlegada().getNombreEstacion());

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return datos;
	}

	public static void realizarPago(String tarjeta, int pin, JSONObject tra, JSONObject es, JSONObject cli) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();

		MedioTransporte transporte = new MedioTransporte();
		transporte.setConductor(null);
		transporte.setTipo("AUTOBUS");

		Estacion salida = new Estacion();
		salida.setCiudad(es.getString("ciudadOrigen"));
		salida.setNombreEstacion(es.getString("estacionOrigen"));

		Estacion llegada = new Estacion();
		salida.setCiudad(es.getString("ciudadLlegada"));
		salida.setNombreEstacion(es.getString("estacionLlegada"));

		Trayecto trayecto = new Trayecto();
		trayecto.setIdTrayecto(tra.getInt("idTrayecto"));
		trayecto.setFecha(tra.getString("fecha"));
		trayecto.setHoraSalida(tra.getString("horaSalida"));
		trayecto.setHoraLlegada(tra.getString("horaLlegada"));
		trayecto.setDuracion(tra.getString("duracion"));
		trayecto.setPrecio(tra.getString("precio"));
		trayecto.setTransporte(transporte);
		trayecto.setEstacionSalida(salida);
		trayecto.setEstacionLlegada(llegada);

		Cliente cliente = new Cliente();
		cliente.setDniCliente(cli.getString("dni"));
		cliente.setNombre(cli.getString("nombre"));
		cliente.setEmail(cli.getString("email"));
		cliente.setPassword(cli.getString("password"));
		cliente.setTrayecto(null);

		Pago pago = new Pago();
		pago.setNumeroTarjeta(tarjeta);
		pago.setPin(pin);
		pago.setTrayecto(trayecto);
		pago.setCliente(cliente);

		entityManager.persist(pago);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
	
	public static JSONArray registroTrayectos() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();
		Query query = entityManager.createQuery("Select tra from Trayecto tra");
		trayectos = (ArrayList<Trayecto>) query.getResultList();

		JSONObject datos = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < trayectos.size(); i++) {

			datos.put("idTrayecto" + i, trayectos.get(i).getIdTrayecto());
			datos.put("fecha" + i, trayectos.get(i).getFecha());
			datos.put("horaSalida" + i, trayectos.get(i).getHoraSalida());
			datos.put("horaLlegada" + i, trayectos.get(i).getHoraLlegada());
			datos.put("duracion" + i, trayectos.get(i).getDuracion());
			datos.put("precio" + i, trayectos.get(i).getPrecio());
			datos.put("ciudadSalida" + i, trayectos.get(i).getEstacionSalida().getCiudad());
			datos.put("ciudadLlegada" + i, trayectos.get(i).getEstacionLlegada().getCiudad());
			datos.put("transporte" + i, trayectos.get(i).getTransporte().getTipo());

			array.put(datos);

		}

		System.out.println(array.toString());

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return array;
	}
	
	public static JSONArray consultarPagos(String dni) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		Query query = entityManager.createQuery("Select pa from Pago pa where dni = '" + dni + "'");
		pagos = (ArrayList<Pago>) query.getResultList();

		JSONObject datos = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < pagos.size(); i++) {

			datos.put("idPago" + i, pagos.get(i).getIdPago());
			datos.put("numeroTarjeta" + i, pagos.get(i).getNumeroTarjeta());
			datos.put("trayecto" + i, pagos.get(i).getTrayecto());

			array.put(datos);

		}

		System.out.println(array.toString());

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return array;
	}

}
