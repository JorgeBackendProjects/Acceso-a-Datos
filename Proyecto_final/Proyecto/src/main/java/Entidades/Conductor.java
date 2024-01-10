package Entidades;

import javax.persistence.*;

@Entity
@Table(name="conductor")
public class Conductor {

	@Column(name="idConductor")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConductor;
	
	private String nombre;
	
	public Conductor() {
		this.idConductor = 0;
		this.nombre = "";
	}
	
	public Conductor(int idConductor, String nombre) {
		this.idConductor = idConductor;
		this.nombre = nombre;
	}

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Conductor [idConductor=" + idConductor + ", nombre=" + nombre + "]";
	}
	
	
}
