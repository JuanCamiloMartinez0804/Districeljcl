package districeljcl.pruebas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import districeljcl.util.Seguridad;

/**
 *
 * @author juanc
 */
public class PruebaSeguridad {
    
    public static void main(String[] args) {
          
        String contrasena = "MiClave123";

        // Generar dos hashes para la misma contraseña.
        String hash1 = Seguridad.generarHash(contrasena);

        String hash2 = Seguridad.generarHash(contrasena);

        System.out.println("PRUEBA DE SEGURIDAD");
        System.out.println("-------------------------");

        // Comprobar que se generó un hash.
        System.out.println("Hash generado: " + !hash1.isEmpty());

        // Verificar la contraseña correcta.
        boolean resultadoCorrecto =
                Seguridad.verificarContrasena(contrasena, hash1);

        System.out.println(
                "Contraseña correcta: " + resultadoCorrecto
        );

        // Verificar una contraseña incorrecta.
        boolean resultadoIncorrecto =
                Seguridad.verificarContrasena("OtraClave456", hash1);

        System.out.println(
                "Contraseña incorrecta: " + resultadoIncorrecto
        );

        // Comprobar que los hashes son diferentes.
        System.out.println(
                "Hashes diferentes: " + !hash1.equals(hash2)
        );

    }
    
}
