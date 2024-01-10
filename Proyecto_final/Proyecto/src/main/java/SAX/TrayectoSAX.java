package SAX;

public class TrayectoSAX {


	private int idTrayecto;
	
	private String fecha, horaSalida, horaLlegada, duracion, precio, ciudadSalida, ciudadLlegada, transporte;
	
	public TrayectoSAX() {

		this.idTrayecto = 0;
		this.fecha = "";
		this.duracion = "";
		this.precio = "";
		this.horaSalida = "";
		this.horaLlegada = "";
		this.ciudadSalida = "";
		this.ciudadLlegada = "";
		this.transporte = "";
	} 
	
	public TrayectoSAX(int idTrayecto, String fecha, String horaSalida, String horaLlegada,
			String duracion, String precio, String ciudadSalida, String ciudadLlegada, String transporte) {

		this.idTrayecto = idTrayecto;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.duracion = duracion;
		this.precio = precio;
		this.ciudadSalida = ciudadSalida;
		this.ciudadLlegada = ciudadLlegada;
		this.transporte = transporte;
	}

	public String getCiudadSalida() {
		return ciudadSalida;
	}

	public void setCiudadSalida(String ciudadSalida) {
		this.ciudadSalida = ciudadSalida;
	}

	public String getCiudadLlegada() {
		return ciudadLlegada;
	}

	public void setCiudadLlegada(String ciudadLlegada) {
		this.ciudadLlegada = ciudadLlegada;
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

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "TrayectoSAX [idTrayecto=" + idTrayecto + ", fecha=" + fecha + ", horaSalida=" + horaSalida
				+ ", horaLlegada=" + horaLlegada + ", duracion=" + duracion + ", precio=" + precio + ", ciudadSalida="
				+ ciudadSalida + ", ciudadLlegada=" + ciudadLlegada + ", transporte=" + transporte + "]";
	}

	
}
