package Entidades;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity 
@Table(name = "coches")
public class Coche {

	private String matricula, marca, modelo, color;
	private int precio;

	public Coche() {
		matricula = marca = modelo = color = "";
		precio = 0;
	}

	@Column(name = "Matricula") 
	@Id 
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Column(name = "Marca")
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Column(name = "Modelo")
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "Color")
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "Precio")
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color
				+ ", precio=" + precio + "]";
	}
	
	

}
