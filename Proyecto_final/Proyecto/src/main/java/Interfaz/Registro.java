package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import org.json.JSONObject;

import Entidades.Cliente;
import Entidades.Trayecto;

public class Registro extends JPanel {

	private JPanel panel = this;
	private JTextField dniI, passwordI, nombreI, emailI;
	private JLabel tituloRegistro, titulo2, dniL, nombreL, emailL, passwordL;
	private JSeparator separator, separator_1, separator_1_1, separator_1_1_1;
	private JButton botonRegistro, botonAtras;
	
	/**
	 * Create the panel.
	 */
	public Registro() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		tituloRegistro = new JLabel("Regístrate ");
		tituloRegistro.setBounds(40, 44, 125, 32);
		tituloRegistro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.add(tituloRegistro);
		
		titulo2 = new JLabel("Inserta los siguientes datos:");
		titulo2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		titulo2.setBounds(76, 98, 333, 32);
		this.add(titulo2);
		
		dniL = new JLabel("DNI:");
		dniL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dniL.setBounds(76, 141, 69, 26);
		this.add(dniL);
		
		dniI = new JTextField();
		dniI.setBounds(76, 169, 254, 20);
		this.add(dniI);
		dniI.setColumns(10);
		
		separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(76, 194, 254, 2);
		this.add(separator);
		
		nombreI = new JTextField();
		nombreI.setColumns(10);
		nombreI.setBounds(76, 228, 254, 20);
		this.add(nombreI);
		
		nombreL = new JLabel("Nombre de usuario: ");
		nombreL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreL.setBounds(76, 200, 134, 26);
		this.add(nombreL);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(76, 253, 254, 2);
		this.add(separator_1);
		
		emailI = new JTextField();
		emailI.setColumns(10);
		emailI.setBounds(76, 287, 254, 20);
		this.add(emailI);
		
		emailL = new JLabel("E-mail:");
		emailL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailL.setBounds(76, 259, 69, 26);
		this.add(emailL);
		
		separator_1_1 = new JSeparator();
		separator_1_1.setBackground(Color.DARK_GRAY);
		separator_1_1.setBounds(76, 312, 254, 2);
		this.add(separator_1_1);
		
		passwordI = new JTextField();
		passwordI.setColumns(10);
		passwordI.setBounds(76, 346, 254, 20);
		this.add(passwordI);
		
		passwordL = new JLabel("Contraseña:");
		passwordL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordL.setBounds(76, 318, 89, 26);
		this.add(passwordL);
		
		separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBackground(Color.DARK_GRAY);
		separator_1_1_1.setBounds(76, 371, 254, 2);
		this.add(separator_1_1_1);
		
		botonRegistro = new JButton("Regístrame");
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress("localhost", 5555);
					socket.connect(address);
					
					DataInputStream dis = new DataInputStream(socket.getInputStream());
	                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	                
	                JSONObject peticion = new JSONObject();
	                
	                peticion.put("Eleccion", 2);
	                peticion.put("dni", dniI.getText());
	                peticion.put("nombre", nombreI.getText());
	                peticion.put("email", emailI.getText());
	                peticion.put("password", passwordI.getText());
	                
	                dos.writeUTF(peticion.toString());
	                
					titulo2.setText("Te has registrado correctamente");
					dniI.setText("");
					nombreI.setText("");
					emailI.setText("");
					passwordI.setText("");
	                
				}catch(Exception error) {
					System.err.println(error.toString());
				}
				
				
			}
		});
		botonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonRegistro.setBounds(227, 402, 104, 38);
		this.add(botonRegistro);
		
		botonAtras = new JButton("Atrás");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Inicio inicio = new Inicio();
				inicio.setSize(1000, 600);
				inicio.setLocation(0, 0);
				inicio.setVisible(true);
				
				tituloRegistro.setVisible(false);
				titulo2.setVisible(false); 
				dniL.setVisible(false); 
				nombreL.setVisible(false); 
				emailL.setVisible(false); 
				passwordL.setVisible(false);
				separator.setVisible(false); 
				separator_1.setVisible(false); 
				separator_1_1.setVisible(false); 
				separator_1_1_1.setVisible(false);
				dniI.setVisible(false);
				passwordI.setVisible(false);
				nombreI.setVisible(false);
				emailI.setVisible(false);
				botonRegistro.setVisible(false); 
				botonAtras.setVisible(false);
				
				panel.add(inicio);
				
				panel.paint(getGraphics());
				
			}
		});
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAtras.setBounds(76, 402, 104, 38);
		this.add(botonAtras);
	}
	
	

}
