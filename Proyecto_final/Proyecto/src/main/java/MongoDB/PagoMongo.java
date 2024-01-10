package MongoDB;

public class PagoMongo {

	private int idPago;
	private String numeroTarjeta, fecha, horaSalida, horaLlegada, duracion, precio, estacionSalida, estacionLlegada;
	public PagoMongo(int idPago, String numeroTarjeta, String fecha, String horaSalida, String horaLlegada,
			String duracion, String precio, String estacionSalida, String estacionLlegada) {
		super();
		this.idPago = idPago;
		this.numeroTarjeta = numeroTarjeta;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.duracion = duracion;
		this.precio = precio;
		this.estacionSalida = estacionSalida;
		this.estacionLlegada = estacionLlegada;
	}
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	public String getEstacionSalida() {
		return estacionSalida;
	}
	public void setEstacionSalida(String estacionSalida) {
		this.estacionSalida = estacionSalida;
	}
	public String getEstacionLlegada() {
		return estacionLlegada;
	}
	public void setEstacionLlegada(String estacionLlegada) {
		this.estacionLlegada = estacionLlegada;
	}
	@Override
	public String toString() {
		return "PagoMongo [idPago=" + idPago + ", numeroTarjeta=" + numeroTarjeta + ", fecha=" + fecha + ", horaSalida="
				+ horaSalida + ", horaLlegada=" + horaLlegada + ", duracion=" + duracion + ", precio=" + precio
				+ ", estacionSalida=" + estacionSalida + ", estacionLlegada=" + estacionLlegada + "]";
	}
	
	
}
