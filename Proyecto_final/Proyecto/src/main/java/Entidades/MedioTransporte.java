package Entidades;
import javax.persistence.*;

@Entity
@Table(name="mediotransporte")
public class MedioTransporte {

	@Column(name="idTransporte")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransporte;
	
	private String tipo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idConductor")
	private Conductor conductor;
	
	public MedioTransporte() {
		this.idTransporte = 0;
		this.tipo = "";
		this.conductor = null;
	}

	public MedioTransporte(int idTransporte, String tipo, Conductor conductor) {

		this.idTransporte = idTransporte;
		this.tipo = tipo;
		this.conductor = conductor;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	@Override
	public String toString() {
		return "MedioTransporte [idTransporte=" + idTransporte + ", tipo=" + tipo + ", conductor=" + conductor + "]";
	}

	

}
