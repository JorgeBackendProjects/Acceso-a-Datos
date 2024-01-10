package Interfaz;

import javax.swing.JPanel;

import org.json.JSONArray;
import org.xml.sax.SAXException;

import Entidades.Cliente;
import SAX.Handler;
import SAX.TrayectoSAX;

import java.awt.BorderLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LogTrayectos extends JPanel {

	private JPanel panel = this;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JButton botonAtras;
	
	private Cliente cliente;
	private ArrayList<TrayectoSAX> trayectos;
	private FileWriter fw;
	private BufferedWriter bw;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public LogTrayectos(JSONArray array) throws IOException, ParserConfigurationException, SAXException {
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		model = new DefaultTableModel(new Object[][] {},
				new String[] { "idTrayecto", "Fecha", "HoraSalida", "HoraLlegada", "Duracion", "Precio", "CiudadOrigen", "CiudadLlegada", "Transporte"});
		setLayout(null);

		table = new JTable();
		table.setModel(model);
		table.setEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 796, 414);
		scrollPane.setViewportView(table);
		//scrollPane.setColumnHeaderView(table);
		add(scrollPane);
		
		trayectos = new ArrayList<TrayectoSAX>();
		fw = new FileWriter("src/main/java/SAX/Trayectos.xml");
		bw = new BufferedWriter(fw);
		
		trayectoria(array);
		
		botonAtras = new JButton("Atrás");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				table.setVisible(false);
				scrollPane.setVisible(false);
				botonAtras.setVisible(false);
				
				Opciones opciones = new Opciones();
				opciones.setSize(1000, 600);
				opciones.setLocation(0, 0);
				opciones.setVisible(true);
				opciones.setCliente(cliente);
				
				panel.add(opciones);
				
				panel.paint(getGraphics());
				
				
			}
		});
		botonAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		botonAtras.setBounds(23, 447, 115, 45);
		add(botonAtras);
		

	}
	
	public void trayectoria(JSONArray trayectoss) throws IOException, ParserConfigurationException, SAXException {
		//LEYENDO ARRAY JSON Y PASANDO A UN ARRAYLIST DE TRAYECTOS
		for (int i = 0; i < trayectoss.length(); i++) {

			int idTray = trayectoss.getJSONObject(i).getInt("idTrayecto" + i);
			String fe = trayectoss.getJSONObject(i).get("fecha" + i).toString();
			String hS = trayectoss.getJSONObject(i).get("horaSalida" + i).toString();
			String hL = trayectoss.getJSONObject(i).get("horaLlegada" + i).toString();
			String du = trayectoss.getJSONObject(i).get("duracion" + i).toString();
			String pre = trayectoss.getJSONObject(i).get("precio" + i).toString();
			String cS = trayectoss.getJSONObject(i).get("ciudadSalida" + i).toString();
			String cL = trayectoss.getJSONObject(i).get("ciudadLlegada" + i).toString();
			String tran = trayectoss.getJSONObject(i).get("transporte" + i).toString();
			
			TrayectoSAX trayecto = new TrayectoSAX(idTray, fe, hS, hL, du, pre, cS, cL, tran);
			trayectos.add(trayecto);
			
		}
		
		//ESCRIBIENDO XML A PARTIR DEL ARRAYLIST DE TRAYECTOS
		bw.write("<Trayectos>");
		bw.newLine();
		
		for(int j = 0; j<trayectos.size(); j++) {
			bw.write("	<Trayecto id='" + trayectos.get(j).getIdTrayecto() + "'>");
			bw.newLine();
			bw.write("		<fecha>" + trayectos.get(j).getFecha() + "</fecha>");
			bw.newLine();
			bw.write("		<horaSalida>" + trayectos.get(j).getHoraSalida() + "</horaSalida>");
			bw.newLine();
			bw.write("		<horaLlegada>" + trayectos.get(j).getHoraLlegada() + "</horaLlegada>");
			bw.newLine();
			bw.write("		<duracion>" + trayectos.get(j).getDuracion() + "</duracion>");
			bw.newLine();
			bw.write("		<precio>" + trayectos.get(j).getPrecio() + "</precio>");
			bw.newLine();
			bw.write("		<ciudadSalida>" + trayectos.get(j).getCiudadSalida() + "</ciudadSalida>");
			bw.newLine();
			bw.write("		<ciudadLlegada>" + trayectos.get(j).getCiudadLlegada() + "</ciudadLlegada>");
			bw.newLine();
			bw.write("		<transporte>" + trayectos.get(j).getTransporte() + "</transporte>");
			bw.newLine();
			bw.write("	</Trayecto>");
			bw.newLine();
		}
		
		bw.write("</Trayectos>");
		
		bw.close();
		fw.close();
		
		//LEYENDO EL XML DE TRAYECTOS PARA MOSTRAR LOS DATOS EN LA TABLA
		SAXParserFactory factory = SAXParserFactory.newInstance() ;
		SAXParser parser = factory.newSAXParser();
		Handler handler = new Handler();
	    parser.parse("src/main/java/SAX/Trayectos.xml", handler);

	    ArrayList<TrayectoSAX> listado = handler.getTrayectos();

	    for(TrayectoSAX x : listado) {
	    	int id = x.getIdTrayecto();
	    	String fe = x.getFecha();
			String hS = x.getHoraSalida();
			String hL = x.getHoraLlegada();
			String du = x.getDuracion();
			String pre = x.getPrecio();
			String cS = x.getCiudadSalida();
			String cL = x.getCiudadLlegada();
			String tran = x.getTransporte();
			
			String[] datos = new String[] { id+ "", fe, hS, hL, du, pre, cS, cL, tran};
			model.addRow(datos);
	    }
		
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
