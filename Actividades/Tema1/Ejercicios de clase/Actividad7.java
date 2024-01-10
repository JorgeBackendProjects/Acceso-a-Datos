import java.io.*;
import java.util.ArrayList;

public class Actividad7 implements Serializable {
    private String modelo, matricula, color;
    private int ano;
    private double kilometros;

    public Actividad7(){
        modelo=matricula=color="";
        ano=0;
        kilometros=0;
    }

    public Actividad7(String mo, String ma, String co, int an, double km){
        modelo = mo;
        matricula = ma;
        color = co;
        ano = an;
        kilometros = km;
    }

    public static void escribirFichObject() {
        File f = new File("/home/tarde/Escritorio/cocheSeri.txt");

        try{

            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            ArrayList <Actividad7> cochesSeri = new ArrayList<>();

            Actividad7 coche1 = new Actividad7("Clase 3", "236274KHF", "Blanco", 2, 303.3);
            Actividad7 coche2 = new Actividad7("Clase X", "223647ASS", "Negro", 1, 780.1);
            Actividad7 coche3 = new Actividad7("Camero", "773285FSA", "Azul", 7, 1032.4);

            cochesSeri.add(coche1);
            cochesSeri.add(coche2);
            cochesSeri.add(coche3);

            for(int i=0; i<cochesSeri.size(); i++){
                oos.writeObject(cochesSeri.get(i));
            }

            fos.close();
            oos.close();

        }catch(IOException error){
            System.err.println(error);
        }
    }

    public static void leerFichObject(){

        File f = new File("/home/tarde/Escritorio/cocheSeri.txt");

        try{

            Actividad7 coche;

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream dataIS = new ObjectInputStream(fis);

            while((coche = (Actividad7) dataIS.readObject())!= null){
                System.out.println(coche.toString());
            }

            fis.close();
            dataIS.close();

        }catch(IOException error){

            System.err.println(error);

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        return "CocheSerializable{" +
                "modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", ano=" + ano +
                ", kilometros=" + kilometros +
                '}';
    }
}
