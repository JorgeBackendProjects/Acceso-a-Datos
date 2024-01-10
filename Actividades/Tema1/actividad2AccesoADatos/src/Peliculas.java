public class Peliculas {

    private int idPelicula, fechaPub;
    private String titulo, sinopsis, categoria;
    private String duracion;

    public Peliculas(){
        idPelicula = 0;
        titulo = sinopsis = categoria = duracion = "";
        fechaPub = 0;
    }

    public Peliculas(int iD, String ti, int an, String si, String ca, String du){
        idPelicula = iD;
        titulo = ti;
        fechaPub = an;
        sinopsis = si;
        categoria = ca;
        duracion = du;
    }

    public Peliculas(Peliculas other){
        idPelicula = other.idPelicula;
        titulo = other.titulo;
        fechaPub = other.fechaPub;
        sinopsis = other.sinopsis;
        categoria = other.categoria;
        duracion = other.duracion;
    }

    public int getID(){ return idPelicula; }

    public void setID(int id){ idPelicula = id; }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String ti) {
        this.titulo = ti;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String si) {
        this.sinopsis = si;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String ca) {
        this.categoria = ca;
    }

    public int getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(int an) {
        this.fechaPub = an;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String du) {
        this.duracion = du;
    }

    public String toString(){
        return "\n ID Pelicula: " + getID() +
                "\n Titulo: " + getTitulo() +
                "\n Sinopsis: " + getSinopsis() +
                "\n Categoria: " + getCategoria() +
                "\n Duracion: " + getDuracion() + "\n";
    }
}
