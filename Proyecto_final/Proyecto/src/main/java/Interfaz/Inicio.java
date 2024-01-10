package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.json.JSONObject;

import Entidades.Cliente;

public class Inicio extends JPanel {

	private JPanel panel = this;
	private JTextField usuarioI, passwordI;
	private JLabel tituloIniciarSesion, usuarioL, passwordL, tituloBienvenida, registroL;
	private JSeparator separator, separator_1;
	private JButton botonRegistro, botonAcceder;
	

	/**
	 * Create the panel.
	 */
	public Inicio() {
		setBackground(new Color(255, 255, 255));
		this.setLayout(null);
		
		usuarioI = new JTextField();
		usuarioI.setBackground(Color.WHITE);
		usuarioI.setBounds(82, 198, 254, 20);
		this.add(usuarioI);
		usuarioI.setColumns(10);
		
		tituloBienvenida = new JLabel("Bienvenido a la app!");
		tituloBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloBienvenida.setBounds(39, 45, 205, 45);
		this.add(tituloBienvenida);
		
		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(82, 220, 254, 2);
		this.add(separator);
		
		tituloIniciarSesion = new JLabel("Iniciar sesión");
		tituloIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tituloIniciarSesion.setBounds(82, 115, 138, 45);
		this.add(tituloIniciarSesion);
		
		usuarioL = new JLabel("Usuario/E-mail:");
		usuarioL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usuarioL.setBounds(82, 171, 127, 26);
		this.add(usuarioL);
		
		passwordL = new JLabel("Contraseña:");
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordL.setBounds(82, 229, 127, 26);
		this.add(passwordL);
		
		passwordI = new JTextField();
		passwordI.setColumns(10);
		passwordI.setBackground(Color.WHITE);
		passwordI.setBounds(82, 255, 254, 20);
		this.add(passwordI);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(82, 277, 254, 2);
		this.add(separator_1);
		
		registroL = new JLabel("¿Aún no tienes una cuenta? Regístrate");
		registroL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		registroL.setBounds(60, 393, 241, 26);
		this.add(registroL);
		
		botonAcceder = new JButton("Acceder");
		botonAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = compCredenciales();
				
				try {
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress("localhost", 5555);
					socket.connect(address);
					
					DataInputStream dis = new DataInputStream(socket.getInputStream());
	                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	                
	                JSONObject peticion = new JSONObject();
	                
	                peticion.put("Eleccion", 1);
	                peticion.put("nombre", usuarioI.getText());
	                
	                dos.writeUTF(peticion.toString());
	                
	                JSONObject respuesta = new JSONObject(dis.readUTF());
	                
	                if(passwordI.getText().equals(respuesta.getString("password"))) {
						Opciones opciones = new Opciones();
						opciones.setSize(1000, 600);
						opciones.setLocation(0, 0);
						opciones.setVisible(true);
						opciones.setCliente(cliente);
						
						usuarioI.setVisible(false);
						passwordI.setVisible(false);
						tituloIniciarSesion.setVisible(false); 
						usuarioL.setVisible(false); 
						passwordL.setVisible(false); 
						tituloBienvenida.setVisible(false); 
						registroL.setVisible(false);
						separator.setVisible(false); 
						separator_1.setVisible(false);
						botonRegistro.setVisible(false);
						botonAcceder.setVisible(false);
						
						panel.add(opciones);
					}
	                
				}catch(Exception error) {
					System.err.println(error.toString());
				}
				
			}
		});
		botonAcceder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAcceder.setBounds(228, 308, 108, 39);
		this.add(botonAcceder);
		
		botonRegistro = new JButton("aquí");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				registro.setSize(1000,600);
				registro.setLocation(0, 0);
				registro.setVisible(true);
				
				usuarioI.setVisible(false);
				passwordI.setVisible(false);
				tituloIniciarSesion.setVisible(false); 
				usuarioL.setVisible(false); 
				passwordL.setVisible(false); 
				tituloBienvenida.setVisible(false); 
				registroL.setVisible(false);
				separator.setVisible(false); 
				separator_1.setVisible(false);
				botonRegistro.setVisible(false);
				botonAcceder.setVisible(false);
				
				panel.add(registro);
				
				
			}
		});
		botonRegistro.setBackground(new Color(245, 255, 250));
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		botonRegistro.setBounds(296, 396, 68, 23);
		this.add(botonRegistro);
	}
	
	private  Cliente compCredenciales() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("Select cli from Cliente cli where nombre = '" + usuarioI.getText() + "'");
		Cliente cliente= (Cliente) query.getSingleResult();
		
		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();
		
		return cliente;
	}

}
