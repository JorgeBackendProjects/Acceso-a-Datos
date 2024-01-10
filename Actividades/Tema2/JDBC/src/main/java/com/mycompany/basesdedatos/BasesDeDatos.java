/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.basesdedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author tarde
 */
public class BasesDeDatos {

    private ResultSet rs;

    public static void menuPrincipal() throws SQLException {

        ManejadorDB db = new ManejadorDB("world_x");
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
                                String nombreColumna = rs.getString(rsmd.getColumnName(j));
                                System.out.println("" + rsmd.getColumnName(j) + ": " + nombreColumna);
                            }
                        }

                    break;

                    //INSERTAR FILAS
                    case 2:
                        
                        Scanner scanTabla = new Scanner(System.in);
                        
                        System.out.println("Selecciona una tabla:\n 1) City\n 2) Country\n 3) CountryLanguage");
                        int tabla = scanTabla.nextInt();
                        
                        if(tabla == 1){
                            
                            System.out.println("SE VAN A ANIADIR ELEMENTOS A LA TABLA CITY . . .");
                            
                            Scanner scanName = new Scanner(System.in);
                        
                            System.out.println("Escribe el nombre de la ciudad a insertar");
                            String name = scanName.nextLine();

                            Scanner scanCountryCode = new Scanner(System.in);

                            System.out.println("Escribe el codigo de la ciudad a insertar");
                            String countryCode = scanCountryCode.nextLine();


                            Scanner scanDistrict = new Scanner(System.in);

                            System.out.println("Escribe el distrito de la ciudad a insertar");
                            String distrito = scanCountryCode.nextLine();
                            
                            db.manipularTabla("insert into city (Name, CountryCode, District) values ('"+name+"', '"+countryCode+"', '"+distrito+"');");
                        }
                        
                        if(tabla == 2){
                            
                            System.out.println("SE VAN A ANIADIR ELEMENTOS A LA TABLA COUNTRY . . .");
                            
                            Scanner scanCode = new Scanner(System.in);
                        
                            System.out.println("Escribe el codigo del pais a insertar");
                            String code = scanCode.nextLine();

                            Scanner scanName = new Scanner(System.in);

                            System.out.println("Escribe el nombre del pais a insertar");
                            String name = scanName.nextLine();
                            
                            Scanner scanCapital = new Scanner(System.in);

                            System.out.println("Escribe el capital(int) del pais a insertar");
                            int capital = scanCapital.nextInt();

                            Scanner scanCode2 = new Scanner(System.in);
                            
                            System.out.println("Introduce el codigo2 del pais a insertar");
                            String code2 = scanCode2.nextLine();
                            
                            db.manipularTabla("insert into country (Code, Name, Capital, Code2) values ('"+code+"', '"+name+"', "+capital+", '"+code2+"');");
                        }
                        
                        if(tabla == 3){
                        
                            System.out.println("SE VAN A ANIADIR ELEMENTOS A LA TABLA COUNTRYLANGUAGE . . .");
                            
                            Scanner scanCode = new Scanner(System.in);
                        
                            System.out.println("Escribe el codigo del pais a insertar");
                            String code = scanCode.nextLine();

                            Scanner scanLanguage = new Scanner(System.in);

                            System.out.println("Escribe el lenguaje del pais a insertar");
                            String language = scanLanguage.nextLine();
                            
                            Scanner scanEsOficial = new Scanner(System.in);

                            System.out.println("Escribe si es o no oficial [T/F] el pais a insertar");
                            String esOficial = scanEsOficial.nextLine();

                            Scanner scanPorcentaje = new Scanner(System.in);
                            
                            System.out.println("Introduce el porcentaje del pais a insertar");
                            double porcentaje = scanPorcentaje.nextDouble();
                            
                            System.out.println("insert into countrylanguage (CountryCode, Language, IsOfficial, Percentage) values ('"+code+"', '"+language+"', '"+esOficial+"', "+porcentaje+");");
                            db.manipularTabla("insert into countrylanguage (CountryCode, Language, IsOfficial, Percentage) values ('"+code+"', '"+language+"', '"+esOficial+"', "+porcentaje+");");
                            
                        }
                   
                    break;
                    
                    //ACTUALIZAR FILAS
                    case 3:
                        
                        Scanner scanTablas = new Scanner(System.in);
                        
                        System.out.println("Selecciona una tabla:\n 1) City\n 2) Country\n 3) CountryLanguage");
                        int tablas = scanTablas.nextInt();
                        
                        if(tablas == 1){
                            
                            System.out.println("SE VAN A ACTUALIZAR ELEMENTOS DE LA TABLA CITY . . .");
                            
                            Scanner scanID = new Scanner(System.in);
                            
                            System.out.println("Elige el ID de la fila a actualizar");
                            int iD = scanID.nextInt();
                            
                            Scanner scanName = new Scanner(System.in);
                        
                            System.out.println("Escribe el nombre de la ciudad a insertar");
                            String name = scanName.nextLine();

                            Scanner scanCountryCode = new Scanner(System.in);

                            System.out.println("Escribe el codigo de la ciudad a insertar");
                            String countryCode = scanCountryCode.nextLine();


                            Scanner scanDistrict = new Scanner(System.in);

                            System.out.println("Escribe el distrito de la ciudad a insertar");
                            String distrito = scanCountryCode.nextLine();
                            
                            db.manipularTabla("update city set Name= '" + name + "' , CountryCode= '" + countryCode + "' , District='" + distrito + "' where ID=" + iD + ";");
                        }
                        
                        if(tablas == 2){
                            
                            System.out.println("SE VAN A ACTUALIZAR ELEMENTOS DE LA TABLA COUNTRY . . .");
                            
                            Scanner scanNombrePaisFila = new Scanner(System.in);

                            System.out.println("Escribe el nombre del pais de la fila a actualizar");
                            String nombrePais = scanNombrePaisFila.nextLine();
                            
                            Scanner scanCode = new Scanner(System.in);
                        
                            System.out.println("Escribe el codigo del pais a insertar");
                            String code = scanCode.nextLine();

                            Scanner scanName = new Scanner(System.in);

                            System.out.println("Escribe el nombre del pais a insertar");
                            String name = scanName.nextLine();
                            
                            Scanner scanCapital = new Scanner(System.in);

                            System.out.println("Escribe el capital(int) del pais a insertar");
                            int capital = scanCapital.nextInt();

                            Scanner scanCode2 = new Scanner(System.in);
                            
                            System.out.println("Introduce el codigo2 del pais a insertar");
                            String code2 = scanCode2.nextLine();
                            
                            db.manipularTabla("update country set Code= '" + code + "' , Name= '" + name + "' , Capital=" + capital +" , Code2='" + code2 + "' where Name='" + nombrePais + "';");
                        }
                        
                        if(tablas == 3){
                        
                            System.out.println("SE VAN A ACTUALIZAR ELEMENTOS DE LA TABLA COUNTRYLANGUAGE . . .");
                            
                            Scanner scanCodeFila = new Scanner(System.in);
                        
                            System.out.println("Escribe el codigo de la fila a actualizar");
                            String codeFila = scanCodeFila.nextLine();
                            
                            Scanner scanCode = new Scanner(System.in);
                        
                            System.out.println("Escribe el codigo del pais a insertar");
                            String code = scanCode.nextLine();

                            Scanner scanLanguage = new Scanner(System.in);

                            System.out.println("Escribe el lenguaje del pais a insertar");
                            String language = scanLanguage.nextLine();
                            
                            Scanner scanEsOficial = new Scanner(System.in);

                            System.out.println("Escribe si es o no oficial [T/F] el pais a insertar");
                            String esOficial = scanEsOficial.nextLine();

                            Scanner scanPorcentaje = new Scanner(System.in);
                            
                            System.out.println("Introduce el porcentaje del pais a insertar");
                            double porcentaje = scanPorcentaje.nextDouble();
                            
                            db.manipularTabla("update countrylanguage set CountryCode= '" + code + "' , Language= '" + language + "' , IsOfficial='" + esOficial + "' , Percentage=" + porcentaje + " where CountryCode='" + codeFila + "';");
                            
                        }
                   
                    break;
                    
                    //BORRAR FILAS
                    case 4:
                        
                        Scanner scanTablas1 = new Scanner(System.in);
                        
                        System.out.println("Selecciona una tabla:\n 1) City\n 2) Country\n 3) CountryLanguage");
                        int tablas1 = scanTablas1.nextInt();
                        
                        if(tablas1 == 1){
                            
                            System.out.println("ELIGE QUE FILA SE VA A ELIMINAR DE CITY");
                            
                            Scanner scanID = new Scanner(System.in);

                            System.out.println("Escribe el ID de la ciudad a eliminar");
                            int id = scanID.nextInt();
                            
                            db.manipularTabla("delete from city where ID="+id+";");
                        }
                        
                        if(tablas1 == 2){
                            
                            System.out.println("ELIGE QUE FILA SE VA A ELIMINAR DE COUNTRY");
                            
                            Scanner scanName = new Scanner(System.in);

                            System.out.println("Escribe el nombre del pais a eliminar");
                            String nombrePais = scanName.nextLine();
                            
                            db.manipularTabla("delete from country where Name='"+nombrePais+"';");
                        }
                        
                        
                        if(tablas1 == 3){
                        
                            System.out.println("ELIGE QUE FILA SE VA A ELIMINAR DE COUNTRYLANGUAGE");
                            
                            Scanner scanCode = new Scanner(System.in);

                            System.out.println("Escribe el ID de la fila a eliminar");
                            String codigoPais = scanCode.nextLine();
                            
                            db.manipularTabla("delete from countrylanguage where CountryCode='"+codigoPais+"';");
                        }
                        
                    break;

                }

            }
        }while(seleccion!=5);
        
        db.cerrar();
    }


    //LAS COLUMNAS EMPIEZAN A ENUMERARSE DESDE 1
    public static void main(String[] args) throws SQLException {
        menuPrincipal();
    }
}
