package Interfaz;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JPanel;

import Entidades.Cliente;
import Entidades.Estacion;
import Entidades.Trayecto;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Busqueda extends JPanel {
	
	private JPanel panel = this;
	private JTextField destinoI, fechaI, origenI;
	private JLabel titulo, fechaL, origenL, destinoL;
	private JSeparator separator1, separator2, separator3;
	private JButton botonBuscar, botonAtras;
	
	private Cliente cliente;
	private String estacionLlegada, estacionOrigen;
	private ArrayList<Trayecto> trayectos;

	/**
	 * Create the panel.
	 */
	public Busqueda() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		titulo = new JLabel("Encuentra los trayectos disponibles ");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(39, 56, 335, 25);
		add(titulo);
		
		fechaL = new JLabel("Fecha:");
		fechaL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fechaL.setBounds(61, 126, 60, 25);
		add(fechaL);
		
		origenL = new JLabel("Origen:");
		origenL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		origenL.setBounds(61, 182, 60, 25);
		add(origenL);
		
		destinoL = new JLabel("Destino:");
		destinoL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		destinoL.setBounds(61, 249, 60, 25);
		add(destinoL);
		
		destinoI = new JTextField();
		destinoI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		destinoI.setColumns(10);
		destinoI.setBounds(131, 249, 186, 25);
		add(destinoI);
		
		botonBuscar = new JButton("Buscar");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress("localhost", 5555);
					socket.connect(address);
					
					DataInputStream dis = new DataInputStream(socket.getInputStream());
	                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	                
	                JSONObject peticion = new JSONObject();
	                
	                peticion.put("Eleccion", 3);
	                peticion.put("fecha", fechaI.getText());
	                peticion.put("ciudadOrigen", origenI.getText());
	                peticion.put("ciudadDestino", destinoI.getText());
	                
	                dos.writeUTF(peticion.toString());
	                
	                JSONArray respuesta = new JSONArray(dis.readUTF());
	                
	                ListaTrayectos listado = new ListaTrayectos(respuesta, origenI.getText(), destinoI.getText());
					listado.setSize(1000, 600);
					listado.setLocation(0, 0);
					listado.setVisible(true);
					listado.setCliente(cliente);
					
					destinoI.setVisible(false); 
					fechaI.setVisible(false); 
					origenI.setVisible(false);
					titulo.setVisible(false); 
					fechaL.setVisible(false); 
					origenL.setVisible(false); 
					destinoL.setVisible(false);
					separator1.setVisible(false);
					separator2.setVisible(false); 
					separator3.setVisible(false);
					botonBuscar.setVisible(false);
					botonAtras.setVisible(false);
					
					panel.add(listado);
					
					panel.paint(getGraphics());
	                
				}catch(Exception error) {
					System.err.println(error.toString());
				}
					
				
			}
		});
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonBuscar.setBounds(215, 304, 102, 42);
		add(botonBuscar);
		
		separator3 = new JSeparator();
		separator3.setBackground(Color.DARK_GRAY);
		separator3.setBounds(131, 275, 186, 2);
		add(separator3);
		
		separator2 = new JSeparator();
		separator2.setBackground(Color.DARK_GRAY);
		separator2.setBounds(131, 209, 186, 2);
		add(separator2);
		
		origenI = new JTextField();
		origenI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		origenI.setColumns(10);
		origenI.setBounds(131, 183, 186, 25);
		add(origenI);
		
		fechaI = new JTextField();
		fechaI.setText("dd/mm/año");
		fechaI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fechaI.setColumns(10);
		fechaI.setBounds(131, 126, 186, 25);
		add(fechaI);
		
		separator1 = new JSeparator();
		separator1.setBackground(Color.DARK_GRAY);
		separator1.setBounds(131, 152, 186, 2);
		add(separator1);
		
		botonAtras = new JButton("Atrás");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Opciones opciones = new Opciones();
				opciones.setSize(1000, 600);
				opciones.setLocation(0, 0);
				opciones.setVisible(true);
				opciones.setCliente(cliente);
				
				destinoI.setVisible(false);
				fechaI.setVisible(false); 
				origenI.setVisible(false);
				titulo.setVisible(false);
				fechaL.setVisible(false); 
				origenL.setVisible(false); 
				destinoL.setVisible(false);
				separator1.setVisible(false); 
				separator2.setVisible(false); 
				separator3.setVisible(false);
				botonBuscar.setVisible(false); 
				botonAtras.setVisible(false);
				
				panel.add(opciones);
				
				panel.paint(getGraphics());
			}
		});
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAtras.setBounds(46, 404, 102, 42);
		add(botonAtras);

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


}
