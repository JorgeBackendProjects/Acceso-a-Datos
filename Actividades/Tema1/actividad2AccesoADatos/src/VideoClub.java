import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoClub {

    private ArrayList <Clientes> clientes;
    private ArrayList <Peliculas> peliculas;

    private String pathClientesTxt, pathPeliculasTxt;

    public VideoClub(String rC, String rP){

        clientes = new ArrayList<Clientes>();
        peliculas = new ArrayList<Peliculas>();
        pathClientesTxt = rC;
        pathPeliculasTxt = rP;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = new ArrayList<Clientes>(clientes);
    }

    public ArrayList<Peliculas> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<Peliculas> peliculas) {
        this.peliculas = new ArrayList<Peliculas>(peliculas);
    }

    public String getPathClientesTxt() {
        return pathClientesTxt;
    }

    public void setPathClientesTxt(String pathClientesTxt) {
        this.pathClientesTxt = pathClientesTxt;
    }

    public String getPathPeliculasTxt() {
        return pathPeliculasTxt;
    }

    public void setPathPeliculasTxt(String pathPeliculasTxt) {
        this.pathPeliculasTxt = pathPeliculasTxt;
    }

    /**
     * Este metodo lee las peliculas existentes en el fichero para instanciarlas en el programa
     * mediante objetos de la clase Peliculas, y asi operar con ellas mas facilmente.
     */
    public void cargarPeliculas(){
        File archivoPeliculas = new File(pathPeliculasTxt);

        try {

            FileReader pf = new FileReader(archivoPeliculas);
            BufferedReader pb = new BufferedReader(pf);

            String linea = "";
            ArrayList<String> lineas = new ArrayList<>();

            while ((linea = pb.readLine())!=null){
                lineas.add(linea);
            }

            String [] array = new String[6];

            for(int i = 0; i<lineas.size(); i++){
                array = lineas.get(i).toString().split("-");
                Peliculas a = new Peliculas(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), array[3], array[4], array[5]);
                peliculas.add(a);

            }

            pf.close();
            pb.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    /**
     * Este metodo lee los clientes existentes en el fichero para instanciarlos en el programa
     * mediante objetos de la clase Clientes, y asi operar con ellos mas facilmente.
     */
    public void cargarClientes(){
        File archivoClientes = new File(pathClientesTxt);

        try{

            FileReader cf = new FileReader(archivoClientes);
            BufferedReader cb = new BufferedReader(cf);

            String linea = "";
            String [] array = new String[2];

            while ((linea = cb.readLine())!=null){
                array = linea.split("-");
                Clientes b = new Clientes(Integer.parseInt(array[0]), array[1]);
                clientes.add(b);

            }

            cb.close();
            cf.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    /**
     * Este metodo permite dar de alta a un nuevo cliente, que sera añadido
     * tanto al Arraylist como al fichero de clientes.
     */
    public void addCliente(){
        Scanner scan = new Scanner(System.in);

        int ultimoID = clientes.get(clientes.size()-1).getIdCliente();

        System.out.println("Introduce el nombre del cliente a añadir: ");
        String nombreCliente = scan.next();

        Clientes x = new Clientes(ultimoID+1, nombreCliente);
        System.out.println(clientes.add(x));

        File archivoClientes = new File(pathClientesTxt);
        int ultimoElemento = clientes.size()-1;

        try{

            FileWriter fw = new FileWriter(archivoClientes);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0; i<clientes.size(); i++) {
                bw.write(clientes.get(i).getIdCliente() + "-" +
                        clientes.get(i).getNombre() + "-" +
                        clientes.get(i).getPelicula().getTitulo() + "\n");
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    /**
     * Este metodo permite dar de baja a un cliente, que se eliminara
     * tanto del ArrayList como del fichero de clientes.
     */
    public void deleteCliente(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el ID del cliente a eliminar: ");
        int id = scan.nextInt();

        for(int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getIdCliente() == id){
                System.out.println(clientes.remove(clientes.get(i)));
            }
        }

        File archivoClientes = new File(pathClientesTxt);

        try {

            FileWriter fw = new FileWriter(archivoClientes);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < clientes.size(); i++) {

                bw.write(clientes.get(i).getIdCliente() + "-" +
                             clientes.get(i).getNombre() + "-" +
                             clientes.get(i).getPelicula().getTitulo() + "\n");
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    /**
     * Este metodo permite dar de alta una nueva pelicula, que sera añadido
     * tanto al Arraylist como al fichero de peliculas.
     */
    public void addPelicula(){

        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        int ultimoID = peliculas.get(peliculas.size()-1).getID();

        System.out.println("Introduce el titulo de la pelicula: ");
        String titulo = scanString.next();

        System.out.println("Introduce el año de la pelicula: ");
        int fechaPub = scanInt.nextInt();

        System.out.println("Introduce la sinopsis de la pelicula: ");
        String sinopsis = scanString.next();

        System.out.println("Introduce la categoria: ");
        String categoria = scanString.next();

        System.out.println("Introduce la duracion de la pelicula: ");
        String duracion = scanString.next();

        Peliculas x = new Peliculas(ultimoID+1, titulo, fechaPub, sinopsis, categoria, duracion);
        System.out.println(peliculas.add(x));


        File archivoPeliculas = new File(pathPeliculasTxt);

        try {

            FileWriter fw = new FileWriter(archivoPeliculas);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < peliculas.size(); i++) {

                bw.write(peliculas.get(i).getID() + "-" +
                             peliculas.get(i).getTitulo() + "-" +
                             peliculas.get(i).getFechaPub() + "-" +
                             peliculas.get(i).getSinopsis() + "-" +
                             peliculas.get(i).getCategoria() + "-" +
                             peliculas.get(i).getDuracion() + "\n");
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    /**
     * Este metodo permite eliminar una pelicula,
     * tanto del ArrayList como del fichero de peliculas.
     */
    public void deletePelicula(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el titulo de la pelicula a eliminar: ");
        String titulo = scan.next();

        for(int i = 0; i< peliculas.size(); i++){
            if(peliculas.get(i).getTitulo() == titulo){
                System.out.println(peliculas.remove(peliculas.get(i)));
            }
        }


        File archivoPeliculas = new File(pathPeliculasTxt);

        try {

            FileWriter fw = new FileWriter(archivoPeliculas);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < peliculas.size(); i++) {

                bw.write(peliculas.get(i).getID() + "-" +
                        peliculas.get(i).getTitulo() + "-" +
                        peliculas.get(i).getFechaPub() + "-" +
                        peliculas.get(i).getSinopsis() + "-" +
                        peliculas.get(i).getCategoria() + "-" +
                        peliculas.get(i).getDuracion() + "\n");
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    /**
     * Este metodo sirve para que un cliente alquile una pelicula.
     */
    public void alquilarPelicula(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el nombre del cliente que quiere alquilar: ");
        String nombreCliente = scan.next();

        System.out.println("Introduce el titulo de la pelicula que va a ser alquilada: ");
        String tituloPelicula = scan.next();

        for(int i = 0; i<peliculas.size(); i++){

            if(peliculas.get(i).getTitulo() == tituloPelicula){
                Peliculas alquiler = new Peliculas(peliculas.get(i));

                for(int j = 0; j<peliculas.size(); j++){

                    if(clientes.get(i).getNombre() == nombreCliente){
                        clientes.get(i).setPelicula(alquiler);
                    }
                }
            }
        }


        File archivoClientes = new File(pathClientesTxt);

        try {

            FileWriter fw = new FileWriter(archivoClientes);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < clientes.size(); i++) {

                bw.write(clientes.get(i).getIdCliente() + "-" +
                        clientes.get(i).getNombre() + "-" +
                        clientes.get(i).getPelicula().getTitulo() + "\n");
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }

    }

    /**
     * Este metodo sirve para devolver una pelicula alquilada.
     */
    public void devolverPelicula(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el nombre del cliente que hace la devolucion: ");
        String nombreCliente = scan.next();

        for(int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getNombre() == nombreCliente){
                clientes.get(i).setPelicula(null);
            }
        }


        File archivoClientes = new File(pathClientesTxt);

        try {

            FileWriter fw = new FileWriter(archivoClientes);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < clientes.size(); i++) {

                bw.write(clientes.get(i).getIdCliente() + "-" +
                        clientes.get(i).getNombre() + "-" +
                        clientes.get(i).getPelicula().getTitulo() + "\n");
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    public String toString(){
        return "LISTADO DE CLIENTES: \n" + clientes.toString() + "\n\nLISTADO DE PELICULAS: \n" + peliculas.toString();
    }

}
