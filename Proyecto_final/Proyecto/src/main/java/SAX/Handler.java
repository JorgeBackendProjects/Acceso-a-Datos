package SAX;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler{

	private ArrayList<TrayectoSAX> trayectos = new ArrayList<TrayectoSAX>();
	private TrayectoSAX trayecto;
	private StringBuilder data;
	
	private boolean esFe, esHS, esHL, esDu, esPre, esIDTr, cO, cL;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("Trayecto")) {
			String id = attributes.getValue("id");
			trayecto = new TrayectoSAX();
			trayecto.setIdTrayecto(Integer.parseInt(id));
			
		}else if(qName.equalsIgnoreCase("Fecha")) {
			esFe = true;
		}else if(qName.equalsIgnoreCase("HoraSalida")) {
			esHS = true;
		}else if(qName.equalsIgnoreCase("HoraLlegada")) {
			esHL = true;
		}else if(qName.equalsIgnoreCase("Duracion")) {
			esDu = true;
		}else if(qName.equalsIgnoreCase("Precio")) {
			esPre = true;
		}else if(qName.equalsIgnoreCase("Transporte")) {
			esIDTr = true;
		}else if(qName.equalsIgnoreCase("CiudadSalida")) {
			cO = true;
		}else if(qName.equalsIgnoreCase("CiudadLlegada")) {
			cL = true;
		}
		
		data = new StringBuilder();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(esFe) {
			trayecto.setFecha(data.toString());
			esFe = false;
		}else if(esHS) {
			trayecto.setHoraSalida(data.toString());
			esHS = false;
		}else if(esHL) {
			trayecto.setHoraLlegada(data.toString());
			esHL = false;
		}else if(esDu) {
			trayecto.setDuracion(data.toString());
			esDu = false;
		}else if(esPre) {
			trayecto.setPrecio(data.toString());
			esPre = false;
		}else if(esIDTr) {
			trayecto.setTransporte(data.toString());
			esIDTr = false;
		}else if(cO) {
			trayecto.setCiudadSalida(data.toString());
			cO = false;
		}else if(cL) {
			trayecto.setCiudadLlegada(data.toString());
			cL = false;
		}
		
		if(qName.equalsIgnoreCase("Trayecto")){
            trayectos.add(trayecto);
        }
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data.append(new String(ch, start, length));
	}

	public ArrayList<TrayectoSAX> getTrayectos() {
		return trayectos;
	}

	

}
