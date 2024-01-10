package Entidades;

import javax.persistence.*;

@Entity
@Table(name="pago")
public class Pago {

	@Column(name="idPago")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	
	private String numeroTarjeta;
	private int pin;
	
	@OneToOne()
	@JoinColumn(name = "dni")
	private Cliente cliente;
	
	@OneToOne()
	@JoinColumn(name = "idTrayecto")
	private Trayecto trayecto;
	
	public Pago() {
		this.idPago = 0;
		this.numeroTarjeta = "";
		this.pin = 0;
		this.cliente = new Cliente();
		this.trayecto = new Trayecto();
	}

	public Pago(int idPago, String numeroTarjeta, int pin, Cliente cliente, Trayecto trayecto) {

		this.idPago = idPago;
		this.numeroTarjeta = numeroTarjeta;
		this.pin = pin;
		this.cliente = cliente;
		this.trayecto = trayecto;
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}

	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", numeroTarjeta=" + numeroTarjeta + ", pin=" + pin + ", cliente=" + cliente
				+ ", trayecto=" + trayecto + "]";
	}
	
}
