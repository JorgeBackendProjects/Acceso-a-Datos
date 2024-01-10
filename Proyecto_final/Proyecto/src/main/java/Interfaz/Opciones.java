package Interfaz;

import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import Entidades.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Opciones extends JPanel {

	private JPanel panel = this;
	private JLabel titulo;
	private JButton botonBuscar, botonSesion, botonSAX, botonInfo;
	private Cliente cliente;
	
	/**
	 * Create the panel.
	 */
	public Opciones() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		titulo = new JLabel("¿Qué quieres hacer?");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(103, 41, 233, 32);
		add(titulo);
		
		botonBuscar = new JButton("Buscar trayectos");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Busqueda busqueda = new Busqueda();
				busqueda.setSize(1000, 600);
				busqueda.setLocation(0, 0);
				busqueda.setVisible(true);
				busqueda.setCliente(cliente);
				
				titulo.setVisible(false);
				botonBuscar.setVisible(false); 
				botonSesion.setVisible(false);
				botonSAX.setVisible(false);
				
				panel.add(busqueda);
			}
		});
		botonBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonBuscar.setBounds(84, 106, 223, 38);
		add(botonBuscar);
		
		botonSesion = new JButton("Cerrar sesión");
		botonSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio inicio = new Inicio();
				inicio.setSize(1000, 600);
				inicio.setLocation(0, 0);
				inicio.setVisible(true);
				
				titulo.setVisible(false);
				botonBuscar.setVisible(false); 
				botonSesion.setVisible(false);
				botonSAX.setVisible(false);
				
				panel.add(inicio);
			}
		});
		botonSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonSesion.setBounds(84, 256, 223, 38);
		add(botonSesion);
		
		botonSAX = new JButton("Registro de trayectos");
		botonSAX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress("localhost", 5555);
					socket.connect(address);
					
					DataInputStream dis = new DataInputStream(socket.getInputStream());
	                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	                
	                JSONObject peticion = new JSONObject();
	                peticion.put("Eleccion", 6);
	                dos.writeUTF(peticion.toString());
	                
	                JSONArray respuesta = new JSONArray(dis.readUTF());
	                
	                botonSesion.setVisible(false); 
					botonSAX.setVisible(false); 
					titulo.setVisible(false); 
					botonBuscar.setVisible(false);
					
	                LogTrayectos listado = new LogTrayectos(respuesta);
					listado.setSize(1000, 600);
					listado.setLocation(0, 0);
					listado.setVisible(true);
					listado.setCliente(cliente);
					
					panel.add(listado);
					
					panel.paint(getGraphics());
	                
				}catch(Exception error) {
					System.err.println(error.toString());
				}
				
			}
		});
		botonSAX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonSAX.setBounds(84, 180, 223, 38);
		add(botonSAX);
		

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
