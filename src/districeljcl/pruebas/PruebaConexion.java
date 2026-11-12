/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;


import districeljcl.util.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    
    public static void main(String[] args) {
        
        System.out.println("INICIANDO PRUEBA...");
        
        try (Connection conexion = Conexion.obtenerConexion()) {
            
            System.out.println("Conexion exitosa con MySQL.");
            System.out.println("Base de datos: " + conexion.getCatalog());
        
        } catch (SQLException e) {

            System.out.println("Error al conectar con MySQL.");
            e.printStackTrace();

        }

        System.out.println("FIN DE LA PRUEBA.");

    }
    
}
