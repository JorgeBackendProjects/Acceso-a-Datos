package Entidades;
import javax.persistence.*;

@Entity
@Table(name="estacion")
public class Estacion {

	@Column(name="nombreEstacion")
	@Id
	private String nombreEstacion;

	private String ciudad;
	
	public Estacion() {
		this.nombreEstacion = "";
		this.ciudad = "";
		
	} 
	
	public Estacion(String nombreEstacion, String ciudad) {
		this.nombreEstacion = nombreEstacion;
		this.ciudad = ciudad;
	}

	public String getNombreEstacion() {
		return nombreEstacion;
	}

	public void setNombreEstacion(String nombreEstacion) {
		this.nombreEstacion = nombreEstacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Estacion [nombreEstacion=" + nombreEstacion + ", ciudad=" + ciudad + "]";
	}

}
