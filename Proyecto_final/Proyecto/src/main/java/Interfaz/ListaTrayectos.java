package Interfaz;

import javax.swing.JPanel;

import Entidades.Cliente;
import Entidades.Trayecto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class ListaTrayectos extends JPanel {

	private JPanel panel = this;
	private JLabel titulo, compraL;
	private JButton botonAtras, botonComprar;
	private JTextField compraI;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;

	private Cliente cliente;
	private ArrayList<Trayecto> trayectoss;
	private String ciudadO, ciudadL;

	/**
	 * Create the panel.
	 */
	public ListaTrayectos(JSONArray trayectos, String cO, String cL) {
		setBackground(new Color(255, 255, 255));

		ciudadO = cO;
		ciudadL = cL;

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "idTrayecto", "Fecha", "HoraSalida", "HoraLlegada", "Duracion", "Precio", "CiudadOrigen",
						"EstacionOrigen", "CiudadLlegada", "EstacionLlegada", "idTransporte" });
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 78, 995, 427);
		add(scrollPane);

		table = new JTable();
		table.setModel(model);
		table.setEnabled(true);
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);

		botonAtras = new JButton("Atrás");
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAtras.setBounds(20, 532, 119, 45);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Busqueda busqueda = new Busqueda();
				busqueda.setSize(1000, 600);
				busqueda.setLocation(0, 0);
				busqueda.setVisible(true);

				titulo.setVisible(false);
				table.setVisible(false);
				scrollPane.setVisible(false);
				botonAtras.setVisible(false);
				compraL.setVisible(false);
				botonComprar.setVisible(false);
				compraI.setVisible(false);

				panel.add(busqueda);

				panel.paint(getGraphics());
			}
		});
		add(botonAtras);

		titulo = new JLabel("Lista de trayectos:");
		titulo.setBounds(385, 0, 177, 60);
		add(titulo);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		compraL = new JLabel("Comprar billete para el trayecto con id:");
		compraL.setFont(new Font("Tahoma", Font.PLAIN, 12));
		compraL.setBounds(264, 532, 230, 15);
		add(compraL);

		compraI = new JTextField();
		compraI.setBounds(488, 530, 72, 20);
		add(compraI);
		compraI.setColumns(10);

		botonComprar = new JButton("Comprar");
		botonComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Socket socket = new Socket();
					InetSocketAddress address = new InetSocketAddress("localhost", 5555);
					socket.connect(address);

					DataInputStream dis = new DataInputStream(socket.getInputStream());
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

					JSONObject peticion = new JSONObject();

					peticion.put("Eleccion", 4);
					peticion.put("id", compraI.getText());

					dos.writeUTF(peticion.toString());

					JSONObject respuesta = new JSONObject(dis.readUTF());
					System.out.println(respuesta.toString());

					titulo.setVisible(false);
					table.setVisible(false);
					scrollPane.setVisible(false);
					botonAtras.setVisible(false);
					compraL.setVisible(false);
					botonComprar.setVisible(false);
					compraI.setVisible(false);
					
					Compra compra = new Compra(respuesta, ciudadO, ciudadL);
					compra.setSize(1000, 600);
					compra.setLocation(0, 0);
					compra.setVisible(true);
					compra.setCliente(cliente);

					panel.add(compra);

					panel.paint(getGraphics());
					
				} catch (Exception error) {
					System.err.println(error.toString());
				}
				

			}
		});
		botonComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonComprar.setBounds(591, 528, 119, 23);
		add(botonComprar);

		trayectoria(trayectos);

	}

	public void trayectoria(JSONArray trayectoss) {
		for (int i = 0; i < trayectoss.length(); i++) {

			int idTray = trayectoss.getJSONObject(i).getInt("idTrayecto" + i);
			String fe = trayectoss.getJSONObject(i).get("fecha" + i).toString();
			String hS = trayectoss.getJSONObject(i).get("horaSalida" + i).toString();
			String hL = trayectoss.getJSONObject(i).get("horaLlegada" + i).toString();
			String du = trayectoss.getJSONObject(i).get("duracion" + i).toString();
			String pre = trayectoss.getJSONObject(i).get("precio" + i).toString();
			String eS = trayectoss.getJSONObject(i).get("estacionSalida" + i).toString();
			String eL = trayectoss.getJSONObject(i).get("estacionLlegada" + i).toString();
			int idTran = trayectoss.getJSONObject(i).getInt("idTransporte" + i);

			String[] datos = new String[] { idTray + "", fe, hS, hL, du, pre, ciudadO, eS, ciudadL, eL, idTran + "" };

			model.addRow(datos);

		}
	}

	public Trayecto consultarTrayecto(int id) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsuariosDB");
		EntityManager entityManager = factory.createEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select tra from Trayecto tra where idTrayecto = '" + id + "'");

		Trayecto trayecto = (Trayecto) query.getSingleResult();

		entityManager.getTransaction().commit();

		entityManager.close();

		factory.close();

		return trayecto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
