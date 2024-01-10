import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        actividad8();
    }

    public static void actividad1(String args){

        System.out.println("Archivos del directorio:");
        File f = new File(args);

        if(f.isDirectory() && f.canRead()){
            String [] contenido = f.list();
            for(int i = 0; i<contenido.length;i++){
                System.out.println(contenido[i]);
            }
        }
    }

    public static void actividad2(String args){

        File f = new File(args);

        if(f.isFile() && f.canRead()){

            try{

                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                int count=0;
                int i;
                while((i=br.read())!=-1){
                    System.out.print((char)i);
                    count++;
                }

                System.out.println("\n" + count);

                fr.close();
                br.close();

            }catch(IOException error){System.err.println(error);}
        }
    }

    public static void actividad3() {

        File r = new File("/home/tarde/Escritorio/1.jpeg");
        File w = new File("/home/tarde/Escritorio/2.jpeg");

        try {
            FileInputStream fis = new FileInputStream(r);
            FileOutputStream fos = new FileOutputStream(w);
            int caracter;

            while((caracter=fis.read())!=-1){
                fos.write(caracter);
            }

            fis.close();
            fos.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    public static void actividad4(){

        File r = new File("/home/tarde/Escritorio/1.jpeg");
        File w = new File("/home/tarde/Escritorio/2.jpeg");

        try {
            FileInputStream fis = new FileInputStream(r);
            FileOutputStream fos = new FileOutputStream(w);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte [] array = bis.readAllBytes();

            byte clave = 6;

            for(int i = 0; i<array.length; i++){
                bos.write(array[i]^clave);
            }

            fis.close();
            fos.close();
            bis.close();
            bos.close();

        }catch(IOException error){
            System.err.println(error);
        }

    }

    public static void actividad5(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Codificar archivo: \n");

        System.out.println("Introduce el nombre del archivo:");

        String eleccion = scan.next();

        File r = new File("/home/tarde/Escritorio/" + eleccion);
        File w = new File("/home/tarde/Escritorio/" + "z" + eleccion);

        try {
            FileInputStream fis = new FileInputStream(r);
            FileOutputStream fos = new FileOutputStream(w);
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte [] array = bis.readAllBytes();

            System.out.println("Introduce una clave de codificacion:");
            byte clave = scan.nextByte();

            for(int i = 0; i<array.length; i++){
                bos.write(array[i]^clave);
            }

            r.deleteOnExit();

            fis.close();
            fos.close();
            bis.close();
            bos.close();

        }catch(IOException error){
            System.err.println(error);
        }

    }

    public static void actividad6(){

        Coche a = new Coche("Clase 3", "236274KHF", "Blanco", 2, 303.3);
        Coche e = new Coche("Clase X", "223647ASS", "Negro", 1, 780.1);
        Coche o = new Coche("Camero", "773285FSA", "Azul", 7, 1032.4);

        Coche bmw = new Coche();
        Coche mercedes = new Coche();
        Coche chevrolet = new Coche();

        ArrayList <Coche> coches = new ArrayList<>();
        coches.add(a);
        coches.add(e);
        coches.add(o);

        File w = new File("/home/tarde/Escritorio/Coches.txt");

        try{

            FileOutputStream fos = new FileOutputStream(w);
            DataOutputStream dos = new DataOutputStream(fos);

            for(int i = 0; i<coches.size(); i++){
                dos.writeUTF(coches.get(i).getModelo());
                dos.writeUTF(coches.get(i).getMatricula());
                dos.writeUTF(coches.get(i).getColor());
                dos.writeInt(coches.get(i).getAno());
                dos.writeDouble(coches.get(i).getKilometros());
            }

            fos.close();
            dos.close();

            FileInputStream fis = new FileInputStream(w);
            DataInputStream dis = new DataInputStream(fis);

            bmw.setModelo(dis.readUTF());
            bmw.setMatricula(dis.readUTF());
            bmw.setColor(dis.readUTF());
            bmw.setAno(dis.readInt());
            bmw.setKilometros(dis.readDouble());

            mercedes.setModelo(dis.readUTF());
            mercedes.setMatricula(dis.readUTF());
            mercedes.setColor(dis.readUTF());
            mercedes.setAno(dis.readInt());
            mercedes.setKilometros(dis.readDouble());

            chevrolet.setModelo(dis.readUTF());
            chevrolet.setMatricula(dis.readUTF());
            chevrolet.setColor(dis.readUTF());
            chevrolet.setAno(dis.readInt());
            chevrolet.setKilometros(dis.readDouble());

            System.out.println(bmw.toString());
            System.out.println(mercedes.toString());
            System.out.println(chevrolet.toString());

            fis.close();
            dis.close();

        }catch(IOException error){
            System.err.println(error);
        }

    }

    public static void actividad8() throws FileNotFoundException {

        File f = new File("/home/tarde/Escritorio/Coches.txt");

        try {

            RandomAccessFile raf = new RandomAccessFile(f, "rw");

            ArrayList<Coche> coches = new ArrayList<Coche>();
            Coche a = new Coche("Clase 3", "236274KHF", "Blanco", 2, 303.3);
            Coche e = new Coche("Clase X", "223647ASS", "Negro", 1, 780.1);
            Coche o = new Coche("Camero", "773285FSA", "Azul", 7, 1032.4);

            coches.add(a);
            coches.add(e);
            coches.add(o);

            StringBuffer buffer = null; //para almacenar Strings con limite de caracteres

            //Escritura de los objetos coche en un fichero de texto

            for (int i = 0; i < coches.size(); i++) {
                buffer = new StringBuffer(coches.get(i).getModelo());
                buffer.setLength(10);
                raf.writeChars(buffer.toString());

                buffer = new StringBuffer(coches.get(i).getMatricula());
                buffer.setLength(7);
                raf.writeChars(buffer.toString());

                buffer = new StringBuffer(coches.get(i).getColor());
                buffer.setLength(10);
                raf.writeChars(buffer.toString());

                raf.writeInt(coches.get(i).getAno());

                raf.writeDouble(coches.get(i).getKilometros());
            }


            //Lectura del fichero para inicializar los objetos y listarlos

            raf.seek(0);

            ArrayList<Coche> cochesNuevos = new ArrayList<Coche>();

            //Numero de coches que tiene el archivo
            int aux = (int) (f.length() / 66);

            for(int i = 0; i<aux; i++) {

                char modeloCoche[] = new char[10];
                char matriculaCoche[] = new char[7];
                char colorCoche[] = new char[10];

                for (int j = 0; j < 10; j++) {
                    modeloCoche[j] = raf.readChar();
                }

                for (int b = 0; b < 7; b++) {
                    matriculaCoche[b] = raf.readChar();
                }

                for (int c = 0; c < 10; c++) {
                    colorCoche[c] = raf.readChar();
                }

                String modelo, matricula, color;

                modelo = new String(modeloCoche);
                matricula = new String(matriculaCoche);
                color = new String(colorCoche);

                int ano = raf.readInt();
                double km = raf.readDouble();

                Coche nuevo1 = new Coche (modelo, matricula, color, ano, km);
                System.out.println(nuevo1.toString());
                cochesNuevos.add(nuevo1);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}