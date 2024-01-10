import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        VideoClub videoClub = new VideoClub("C:\\Users\\Propietario\\IdeaProjects\\actividad2AccesoADatos\\src\\Clientes.txt", "C:\\Users\\Propietario\\IdeaProjects\\actividad2AccesoADatos\\src\\Peliculas.txt");

        //Instanciando y guardando objetos en Arraylist para su manipulacion.
        videoClub.cargarPeliculas();
        videoClub.cargarClientes();

        videoClub.addCliente();

        //crearInforme(videoClub, "C:\\Users\\Propietario\\IdeaProjects\\actividad2AccesoADatos\\src\\RegistroVideoClub.txt");

    }

    public static void crearInforme(VideoClub x, String pathRegistro){

        try{

            File registro = new File(pathRegistro);

            FileWriter fw = new FileWriter(registro);
            BufferedWriter bw = new BufferedWriter(fw);

            for(int i = 0; i<x.getClientes().size(); i++){
                System.out.println(x.getClientes().get(i).toString());
                bw.write(x.getClientes().get(i).toString());
            }

            for(int i = 0; i<x.getPeliculas().size(); i++){
                bw.write(x.getPeliculas().get(i).toString());
            }

            bw.close();
            fw.close();

        }catch(IOException error){
            System.err.println(error);
        }
        System.out.println(x.toString());
    }

}

