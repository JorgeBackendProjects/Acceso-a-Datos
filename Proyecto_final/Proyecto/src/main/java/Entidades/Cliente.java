package Entidades;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

	@Column(name="dni")
	@Id
	private String dniCliente;
	
	private String nombre, email, password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTrayecto")
	private Trayecto trayecto;

	public Cliente() {
		this.dniCliente = "";
		this.nombre = "";
		this.email = "";
		this.password = "";
		this.trayecto = new Trayecto();
	}

	public Cliente(String dniCliente, String nombre, String email, Pago pago, String password, Trayecto trayecto) {
		this.dniCliente = dniCliente;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.trayecto = trayecto;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}

	@Override
	public String toString() {
		return "{\n" + 
				"dniCliente: " + dniCliente + ",\n" + 
				"nombre: " + nombre + ",\n" + 
				"email:" + email + ",\n" + 
				"password: " + password + ",\n" + 
				"idTrayecto=" + trayecto + "\n" +
				"}";
	}


}
