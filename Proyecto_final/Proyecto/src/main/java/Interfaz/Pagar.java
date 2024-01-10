package Interfaz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import Entidades.Cliente;
import Entidades.Pago;
import Entidades.Trayecto;

import javax.swing.JSeparator;
import java.awt.Color;

public class Pagar extends JPanel {

	private JPanel panel = this;
	private JLabel titulo, precioL, tarjetaL, pinL;
	private JButton botonCancelar, botonPagar;
	private JTextField tarjetaI, pinI;
	private JSeparator separator, separator_1;
	
	private Cliente cliente;
	private int id;
	private String ciudadSalida, ciudadLlegada;
	
	/**
	 * Create the panel.
	 */
	public Pagar(int i, String precio) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		id = i;
		
		titulo = new JLabel("Pago");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(44, 45, 95, 35);
		add(titulo);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Busqueda busqueda = new Busqueda();
				busqueda.setSize(1000, 600);
				busqueda.setLocation(0, 0);
				busqueda.setVisible(true);
				busqueda.setCliente(cliente);
				
				titulo.setVisible(false); 
				precioL.setVisible(false);
				tarjetaL.setVisible(false); 
				pinL.setVisible(false);
				botonCancelar.setVisible(false);
				botonPagar.setVisible(false);
				tarjetaI.setVisible(false); 
				pinI.setVisible(false);
				separator.setVisible(false);
				separator_1.setVisible(false);
				
				panel.add(busqueda);
				
				panel.paint(getGraphics());
			}
		});
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonCancelar.setBounds(35, 326, 89, 32);
		add(botonCancelar);
		
		precioL = new JLabel(precio);
		precioL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precioL.setBounds(54, 91, 302, 32);
		add(precioL);
		
		tarjetaI = new JTextField();
		tarjetaI.setColumns(10);
		tarjetaI.setBounds(98, 158, 181, 20);
		add(tarjetaI);
		
		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(98, 183, 181, 2);
		add(separator);
		
		pinI = new JTextField();
		pinI.setColumns(10);
		pinI.setBounds(98, 216, 181, 20);
		add(pinI);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(98, 241, 181, 2);
		add(separator_1);
		
		tarjetaL = new JLabel("Numero de tarjeta:");
		tarjetaL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tarjetaL.setBounds(98, 134, 116, 26);
		add(tarjetaL);
		
		pinL = new JLabel("Numero PIN:");
		pinL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pinL.setBounds(98, 189, 116, 35);
		add(pinL);
		
		botonPagar = new JButton("Pagar");
		botonPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress("localhost", 5555);
					socket.connect(address);
					
					DataInputStream dis = new DataInputStream(socket.getInputStream());
	                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	                
	                JSONObject peticion = new JSONObject();
	                
	                peticion.put("Eleccion", 5);
	                peticion.put("idTrayecto", id);
	                peticion.put("nombre", cliente.getNombre());
	                peticion.put("ciudadSalida", ciudadSalida);
	                peticion.put("ciudadLlegada", ciudadLlegada);
	                peticion.put("tarjeta", tarjetaI.getText());
	                peticion.put("pin", pinI.getText());
	                
	                dos.writeUTF(peticion.toString());
	                
				precioL.setText("Se ha pagado correctamente");
				
				}catch(Exception error) {
					System.err.println(error.toString());
				}
				
			}
		});
		botonPagar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonPagar.setBounds(228, 326, 89, 32);
		add(botonPagar);

	}
	
	public void realizarPago() {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Pago pago = new Pago();
		pago.setNumeroTarjeta(tarjetaI.getText());
		pago.setPin(Integer.parseInt(pinI.getText()));
		//pago.setTrayecto(null);
		pago.setCliente(cliente);

		entityManager.persist(pago);
		
		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();
	}

	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCiudadSalida() {
		return ciudadSalida;
	}

	public void setCiudadSalida(String ciudadSalida) {
		this.ciudadSalida = ciudadSalida;
	}

	public String getCiudadLlegada() {
		return ciudadLlegada;
	}

	public void setCiudadLlegada(String ciudadLlegada) {
		this.ciudadLlegada = ciudadLlegada;
	}

	
}
