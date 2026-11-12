/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Marca;

public class PruebaMarca {
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DE LA CLASE MARCA");
        System.out.println("----------------------------");

        // Crear objeto mediante constructor vacío
        Marca marca1 = new Marca();

        marca1.setIdMarca(1);
        marca1.setNombreMarca("Samsung");

        System.out.println("\nPrimer objeto:");
        System.out.println(marca1.obtenerInformacion());

        // Crear objeto mediante constructor parametrizado
        Marca marca2 = new Marca(2, "Apple");

        System.out.println("\nSegundo objeto:");
        System.out.println(marca2.obtenerInformacion());

        // Modificar un atributo
        marca2.setNombreMarca("Motorola");

        System.out.println("\nNombre actualizado:");
        System.out.println(marca2.getNombreMarca());

        // Consultar un atributo
        System.out.println("\nNombre de la primera marca:");
        System.out.println(marca1.getNombreMarca());
    }
}
