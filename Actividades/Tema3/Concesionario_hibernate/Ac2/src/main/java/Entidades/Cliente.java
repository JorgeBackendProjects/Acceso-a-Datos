package Entidades;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity 
@Table(name = "clientes")
public class Cliente {

	private int id;
	private String nif, nombre, ciudad, calle, numeroCasa;

	public Cliente() {
		id = 0;
		nif = nombre = ciudad = calle = numeroCasa = "";
	}

	@Column(name = "idCliente") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NIF")
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	@Column(name = "Nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Ciudad")
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "Calle")
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	@Column(name = "NCasa")
	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nif=" + nif + ", nombre=" + nombre + ", ciudad=" + ciudad + ", calle=" + calle
				+ ", numeroCasa=" + numeroCasa + "]";
	}

	
}
