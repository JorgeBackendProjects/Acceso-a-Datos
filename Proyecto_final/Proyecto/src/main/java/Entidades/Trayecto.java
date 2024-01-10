package Entidades;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="trayecto")
public class Trayecto {

	@Column(name="idTrayecto")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTrayecto;
	
	private String fecha, horaSalida, horaLlegada, duracion, precio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idTransporte")
	private MedioTransporte transporte = new MedioTransporte();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estacionOrigen")
	private Estacion estacionSalida = new Estacion(); 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estacionLlegada")
	private Estacion estacionLlegada = new Estacion(); 
	
	public Trayecto() {

		this.idTrayecto = 0;
		this.fecha = "";
		this.duracion = "";
		this.precio = "";
		this.horaSalida = "";
		this.horaLlegada = "";
		this.estacionSalida = new Estacion();
		this.estacionLlegada = new Estacion();
		this.transporte = new MedioTransporte();
	} 

	public Trayecto(int idTrayecto, String duracion, String precio, String fecha, String horaSalida, String horaLlegada,
			MedioTransporte transporte, Estacion estacionSalida, Estacion estacionLlegada, List<Cliente> clientes) {
	
		this.idTrayecto = idTrayecto;
		this.duracion = duracion;
		this.precio = precio;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.transporte = transporte;
		this.estacionSalida = estacionSalida;
		this.estacionLlegada = estacionLlegada;
	}

	public Estacion getEstacionSalida() {
		return estacionSalida;
	}

	public void setEstacionSalida(Estacion estacionSalida) {
		this.estacionSalida = estacionSalida;
	}

	public Estacion getEstacionLlegada() {
		return estacionLlegada;
	}

	public void setEstacionLlegada(Estacion estacionLlegada) {
		this.estacionLlegada = estacionLlegada;
	}

	public int getIdTrayecto() {
		return idTrayecto;
	}

	public void setIdTrayecto(int idTrayecto) {
		this.idTrayecto = idTrayecto;
	}
	
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public MedioTransporte getTransporte() {
		return transporte;
	}

	public void setTransporte(MedioTransporte transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "Trayecto [idTrayecto=" + idTrayecto + ", duracion=" + duracion + ", precio=" + precio + ", fecha="
				+ fecha + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", transporte=" + transporte
				+ ", estacionSalida=" + estacionSalida + ", estacionLlegada=" + estacionLlegada + "]";
	}
	
	
}
