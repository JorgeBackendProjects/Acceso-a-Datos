
import javax.persistence.*; 

@Entity // Indica que esta clase es una entidad del modelo relacional.
@Table(name = "usuarios") // Indica cual es el nombre de la tabla en la DB.
public class Usuarios {

	private int id;
	private String nombre, correo, password;
	
	public Usuarios() {
		id = -1;
		nombre = correo = password = "";
	}

	@Column(name = "ID") // Indica el nombre de la columna de la DB a la que se asociara el dato
	@Id // Indica que es clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENT
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

	@Column(name = "correo")
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password + "]";
	}
	
	
}
