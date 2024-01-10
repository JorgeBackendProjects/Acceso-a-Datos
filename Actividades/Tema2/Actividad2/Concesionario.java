/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Concesionario {
    
    private ResultSet rs;
    
    public void crearTablaCoche() throws SQLException{

        ManejadorDB db = new ManejadorDB("concesionario");
        rs = null;
        
        db.manipularTablas("create table Coche( "
                + "ID int primary key, "
                + "Marca varchar(45), "
                + "Modelo varchar(45), "
                + "Color varchar(45), "
                + "Disponible varchar(1) "
                + ");");
        
    }
    
    public void menuPrincipal() throws SQLException {

        com.mycompany.basesdedatos.ManejadorDB db = new com.mycompany.basesdedatos.ManejadorDB("concesionario");
        ResultSet rs = null;

        Scanner scan = new Scanner(System.in);
        int seleccion;
        
        do{
            System.out.println("---Selecciona una opcion---\n 1) Realizar consulta\n 2) Insertar datos\n 3) Actualizar datos\n 4) Borrar datos\n 5) Salir");
            seleccion = scan.nextInt();
        
            if(seleccion != 1 && seleccion != 2 && seleccion != 3 && seleccion != 4){

            System.err.println("Opcion incorrecta");
            
            }else{

                switch (seleccion) {

                    //REALIZAR CONSULTAS
                    case 1:

                        Scanner scanConsulta = new Scanner(System.in);

                        System.out.println("Haz una consulta SQL: ");
                        String consulta = scanConsulta.nextLine();
                        rs = db.realizarConsulta(consulta);

                        ResultSetMetaData rsmd = rs.getMetaData(); //RECOGE LOS METADATOS DE LA CONSULTA
                        int total = rsmd.getColumnCount(); // RECOGE EN CONCRETO EL NUMERO DE COLUMNAS QUE TIENE LA TABLA DE LA CONSULTA

                        while (rs.next()) {
                            for (int j = 1; j <= total; j++) {
                                String nombreColumna = rs.getString(rsmd.getColumnName(j)); // MUESTRA EL NOMBRE DE CADA COLUMNA DE LA TABLA
                                System.out.println("" + rsmd.getColumnName(j) + ": " + nombreColumna);
                            }
                        }

                    break;

                    //INSERTAR FILAS
                    case 2:
                        
                        System.out.println("SE VAN A ANIADIR ELEMENTOS A LA TABLA COCHE . . .");
                            
                        Scanner scanMarca = new Scanner(System.in);
                        
                        System.out.println("Escribe la marca del coche: ");
                        String marca = scanMarca.nextLine();

                        Scanner scanModelo = new Scanner(System.in);

                        System.out.println("Escribe el modelo del coche: ");
                        String modelo = scanModelo.nextLine();

                        Scanner scanColor = new Scanner(System.in);

                        System.out.println("Escribe el color del coche: ");
                        String color = scanColor.nextLine();

                        Scanner scanDisponible = new Scanner(System.in);

                        System.out.println("Escribe si el coche esta disponible T/F: ");
                        String disponible = scanDisponible.nextLine();
                            
                        db.manipularTabla("insert into coche (Marca, Modelo, Color, Disponible) values ('"+marca+"', '"+modelo+"', '"+color+"', '"+disponible+"');");
                        
                        
                    break;
                    
                    //ACTUALIZAR FILAS
                    case 3:
                        
                            System.out.println("SE VAN A ACTUALIZAR ELEMENTOS DE LA TABLA COCHE . . .");
                            
                            Scanner scanID = new Scanner(System.in);
                            
                            System.out.println("Elige el ID de la fila a actualizar");
                            int iD = scanID.nextInt();
                            
                            Scanner scanMarca2 = new Scanner(System.in);
                        
                            System.out.println("Escribe la marca del coche: ");
                            String marca2 = scanMarca2.nextLine();

                            Scanner scanModelo2 = new Scanner(System.in);

                            System.out.println("Escribe el modelo del coche: ");
                            String modelo2 = scanModelo2.nextLine();

                            Scanner scanColor2 = new Scanner(System.in);

                            System.out.println("Escribe el color del coche: ");
                            String color2 = scanColor2.nextLine();

                            Scanner scanDisponible2 = new Scanner(System.in);

                            System.out.println("Escribe si el coche esta disponible T/F: ");
                            String disponible2 = scanDisponible2.nextLine();
                            
                            db.manipularTabla("update coche set Marca= '" + marca2 + "' , Modelo= '" + modelo2 + "' , Color='" + color2 + "' , Disponible='" + disponible2 + "' where ID=" + iD + ";");
                      
                    break;
                    
                    //BORRAR FILAS
                    case 4:
                        
                            System.out.println("ELIGE QUE FILA SE VA A ELIMINAR DE COCHE");
                            
                            Scanner scanID2 = new Scanner(System.in);

                            System.out.println("Escribe el ID del coche a eliminar");
                            int id2 = scanID2.nextInt();
                            
                            db.manipularTabla("delete from coche where ID="+id2+";");
                        
                        
                    break;

                }

            }
        }while(seleccion!=5);
        
        db.cerrar();
    }
    
    public static void main(String [] args) throws SQLException{
        Concesionario x = new Concesionario();
        
        //x.crearTablaCoche();
        x.menuPrincipal();
    }
    
}
