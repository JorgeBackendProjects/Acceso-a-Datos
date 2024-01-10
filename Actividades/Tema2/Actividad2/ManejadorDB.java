/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ManejadorDB {
    
    private Connection conexion = null;
    private Statement sta;
    private ResultSet rs;
    
    public ManejadorDB(String nombreBD) throws SQLException{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nombreBD+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","000000");
        sta = conexion.createStatement();
    }
    
    public ResultSet realizarConsulta(String consulta) throws SQLException{
        rs = sta.executeQuery(consulta);
        return rs;
    }
    
    public void manipularTablas(String consulta) throws SQLException{
        sta.executeUpdate(consulta);
    }
    
    public void cerrar() throws SQLException{
        rs.close();
        sta.close();
        conexion.close();
    }
}
