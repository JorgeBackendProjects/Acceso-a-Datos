import javax.persistence.*; 

@Entity 
@Table(name = "profesor") 
public class Profesor {

	private int id, edad;
	private String nombre, apellidos, correo;
	
	public Profesor() {
		id = -1;
		edad = 0;
		nombre = apellidos = correo = " ";
	}

	@Column(name = "idProfesor") 
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
	
	@Column(name = "apellidos")
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "correo")
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "edad")
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo="
				+ correo + "]";
	}
	
	
}
