package Entidades;
import javax.persistence.*;

@Entity
@Table(name = "revisiones")
public class Revision {

	private int id;
	private String cambioAceite, cambioFiltro, cambioFrenos, otrosCambios;

	public Revision() {
		id = 0;
		cambioAceite = cambioFiltro = cambioFrenos = otrosCambios = "";
	}

	@Column(name = "idRevision") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CambioAceite")
	public String getCambioAceite() {
		return cambioAceite;
	}

	public void setCambioAceite(String cambioAceite) {
		this.cambioAceite = cambioAceite;
	}

	@Column(name = "CambioFiltro")
	public String getCambioFiltro() {
		return cambioFiltro;
	}

	public void setCambioFiltro(String cambioFiltro) {
		this.cambioFiltro = cambioFiltro;
	}

	@Column(name = "CambioFrenos")
	public String getCambioFrenos() {
		return cambioFrenos;
	}

	public void setCambioFrenos(String cambioFrenos) {
		this.cambioFrenos = cambioFrenos;
	}

	@Column(name = "otrosCambios")
	public String getOtrosCambios() {
		return otrosCambios;
	}

	public void setOtrosCambios(String otrosCambios) {
		this.otrosCambios = otrosCambios;
	}

	@Override
	public String toString() {
		return "Revision [id=" + id + ", cambioAceite=" + cambioAceite + ", cambioFiltro=" + cambioFiltro
				+ ", cambioFrenos=" + cambioFrenos + ", otrosCambios=" + otrosCambios + "]";
	}

	
}
