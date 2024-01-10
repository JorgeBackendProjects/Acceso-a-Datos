import javax.persistence.*; 

@Entity 
@Table(name = "asignatura") 
public class Asignatura {

	private int id, numeroTemas, creditos;
	private String nombre, curso;
	
	public Asignatura() {
		id = -1;
		numeroTemas = creditos = 0;
		nombre = curso = " ";
	}

	@Column(name = "idAsignatura") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "numeroTemas")
	public int getNumeroTemas() {
		return numeroTemas;
	}

	public void setNumeroTemas(int numeroTemas) {
		this.numeroTemas = numeroTemas;
	}

	@Column(name = "creditos")
	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@Column(name = "curso")
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", numeroTemas=" + numeroTemas + ", creditos=" + creditos + ", nombre=" + nombre
				+ ", curso=" + curso + "]";
	}


}
