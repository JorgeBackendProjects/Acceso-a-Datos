public class Clientes {

    private int idCliente;
    private String nombre;
    private Peliculas pelicula;

    public Clientes(){
        idCliente = 0;
        nombre = "";
        pelicula = new Peliculas();
    }

    public Clientes(int i, String no){
        idCliente = i;
        nombre = no;
        pelicula = new Peliculas();
    }


    public Clientes(int iD, String no, Peliculas p){
        nombre = no;
        idCliente = iD;
        pelicula = new Peliculas(p);
    }

    public Clientes(Clientes other){
        nombre = other.nombre;
        idCliente = other.idCliente;
        pelicula = other.pelicula;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int iD) {
        this.idCliente = iD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = new Peliculas(pelicula);
    }

    public String toString(){
        return  "\n ID Cliente: " + getIdCliente()  +
                "\n Nombre del cliente: " + getNombre() +
                "\n Tiene en alquiler la pelicula: " + pelicula.getTitulo() + "\n";
    }
}
