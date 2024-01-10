/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.basesdedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Profesor
 */
public class ManejadorDB {
   
    private Connection conexion = null;
    private Statement sta;
    private ResultSet rs;
     
    public ManejadorDB(String baseDeDatos) throws SQLException{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","000000");
        sta = conexion.createStatement();
    }
    
    public ResultSet realizarConsulta(String consulta) throws SQLException{
        rs = sta.executeQuery(consulta);
        return rs;
    }
    
    public void manipularTabla(String consulta) throws SQLException{
       sta.executeUpdate(consulta); 
    }
    
    public void cerrar() throws SQLException{
        rs.close();
        sta.close();
        conexion.close();
    }
}