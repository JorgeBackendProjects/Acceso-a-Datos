package Interfaz;

import javax.swing.JPanel;

import org.json.JSONObject;

import Entidades.Cliente;
import Entidades.Controlador;
import Entidades.Estacion;
import Entidades.Trayecto;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Compra extends JPanel {
	
	private JPanel panel = this;
	private JLabel titulo, titulo2, fechaL, horaSL, horaLL, duracionL, precioL, ciudadSL, ciudadLL, transporteL, estacionS, estacionL;
	private JButton botonCancelar, botonPagar;
	
	private JSONObject trayecto;
	private Cliente cliente;
	private String ciudadSalida, ciudadLlegada;
	
	/**
	 * Create the panel.
	 */
	public Compra(JSONObject tra, String cS, String cL) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		ciudadSalida = cS;
		ciudadLlegada = cL;
		
		trayecto = tra;
		
		titulo = new JLabel("Compra de billete");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titulo.setBounds(55, 49, 173, 32);
		add(titulo);
		
		fechaL = new JLabel("Fecha: " + trayecto.getString("fecha"));
		fechaL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fechaL.setBounds(55, 155, 173, 14);
		add(fechaL);
		
		horaSL = new JLabel("Hora de salida: " + trayecto.getString("horaSalida"));
		horaSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		horaSL.setBounds(55, 205, 206, 14);
		add(horaSL);
		
		horaLL = new JLabel("Hora de llegada: " + trayecto.getString("horaLlegada"));
		horaLL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		horaLL.setBounds(299, 205, 219, 14);
		add(horaLL);
		
		duracionL = new JLabel("Duración: " + trayecto.getString("duracion"));
		duracionL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		duracionL.setBounds(55, 350, 180, 14);
		add(duracionL);
		
		precioL = new JLabel("Precio: " + trayecto.getString("precio") + "€");
		precioL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		precioL.setBounds(299, 350, 219, 14);
		add(precioL);
		
		ciudadSL = new JLabel("Origen: " + cS);
		ciudadSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ciudadSL.setBounds(55, 254, 206, 21);
		add(ciudadSL);
		
		ciudadLL = new JLabel("Destino: " + cL);
		ciudadLL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ciudadLL.setBounds(299, 257, 254, 14);
		add(ciudadLL);
		
		transporteL = new JLabel("Número del transporte: " + trayecto.getInt("idTransporte"));
		transporteL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		transporteL.setBounds(299, 155, 244, 14);
		add(transporteL);
		
		titulo2 = new JLabel("Vas a comprar un billete para el siguiente trayecto:");
		titulo2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		titulo2.setBounds(55, 96, 397, 21);
		add(titulo2);
		
		estacionS = new JLabel("Estacion origen: " + trayecto.getString("estacionSalida"));
		estacionS.setFont(new Font("Tahoma", Font.PLAIN, 15));
		estacionS.setBounds(55, 305, 206, 14);
		add(estacionS);
		
		estacionL = new JLabel("Estacion destino: " + trayecto.getString("estacionLlegada"));
		estacionL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		estacionL.setBounds(299, 307, 206, 14);
		add(estacionL);
		
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Busqueda busqueda = new Busqueda();
				busqueda.setSize(1000, 600);
				busqueda.setLocation(0, 0);
				busqueda.setVisible(true);
				busqueda.setCliente(cliente);
				
				titulo.setVisible(false); 
				titulo2.setVisible(false); 
				fechaL.setVisible(false); 
				horaSL.setVisible(false); 
				horaLL.setVisible(false); 
				duracionL.setVisible(false);  
				precioL.setVisible(false);  
				ciudadSL.setVisible(false);  
				ciudadLL.setVisible(false);  
				transporteL.setVisible(false);  
				estacionS.setVisible(false);  
				estacionL.setVisible(false); 
				botonCancelar.setVisible(false);  
				botonPagar.setVisible(false); 
				
				panel.add(busqueda);
				
				panel.paint(getGraphics());
			}
		});
		botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonCancelar.setBounds(55, 403, 89, 32);
		add(botonCancelar);
		
		botonPagar = new JButton("Pagar");
		botonPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(trayecto.getInt("idTrayecto"));
				
				Pagar pago = new Pagar(trayecto.getInt("idTrayecto"), precioL.getText());
				pago.setSize(1000, 600);
				pago.setLocation(0, 0);
				pago.setVisible(true);
				pago.setCliente(cliente);
				pago.setCiudadSalida(ciudadSalida);
				pago.setCiudadLlegada(ciudadLlegada);
				
				titulo.setVisible(false); 
				titulo2.setVisible(false); 
				fechaL.setVisible(false); 
				horaSL.setVisible(false); 
				horaLL.setVisible(false); 
				duracionL.setVisible(false);  
				precioL.setVisible(false);  
				ciudadSL.setVisible(false);  
				ciudadLL.setVisible(false);  
				transporteL.setVisible(false);  
				estacionS.setVisible(false);  
				estacionL.setVisible(false); 
				botonCancelar.setVisible(false);  
				botonPagar.setVisible(false); 
				
				panel.add(pago);
				
				panel.paint(getGraphics());
				
			}
		});
		botonPagar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonPagar.setBounds(361, 403, 89, 32);
		add(botonPagar);

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
