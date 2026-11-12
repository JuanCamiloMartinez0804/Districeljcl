/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Rol;


public class PruebaRol {
    
     public static void main(String[] args) {

        System.out.println("PRUEBA DE LA CLASE ROL");
        System.out.println("----------------------------");

        // 1. Crear objeto mediante constructor vacío
        Rol rol1 = new Rol();

        rol1.setIdRol(1);
        rol1.setNombreRol("Administrador");
        rol1.setDescripcion("Acceso completo al sistema");

        // Mostrar información
        System.out.println("\nPrimer objeto:");
        System.out.println(rol1.obtenerInformacion());

        // 2. Crear objeto mediante constructor parametrizado
        Rol rol2 = new Rol(
                2,
                "Vendedor",
                "Gestion de ventas y clientes"
        );

        System.out.println("\nSegundo objeto:");
        System.out.println(rol2.obtenerInformacion());

        // 3. Modificar un atributo
        rol2.setDescripcion(
                "Gestion de ventas, clientes y celulares"
        );

        System.out.println("\nDescripcion actualizada:");
        System.out.println(rol2.getDescripcion());

        // 4. Consultar un atributo
        System.out.println("\nNombre del primer rol:");
        System.out.println(rol1.getNombreRol());

        // 5. Intentar asignar un identificador negativo
        System.out.println("\nIDENTIFICADOR INVALIDO");

        rol1.setIdRol(-5);

        System.out.println("ID despues del intento: "
                + rol1.getIdRol());

        // 6. Intentar asignar un nombre vacío
        System.out.println("\nNOMBRE VACIO");

        rol1.setNombreRol("");

        System.out.println("Nombre despues del intento: "
                + rol1.getNombreRol());

        // 7. Intentar asignar un nombre nulo
        System.out.println("\nNOMBRE NULO");

        rol1.setNombreRol(null);

        System.out.println("Nombre despues del intento: "
                + rol1.getNombreRol());

        // 8. Asignar un nombre con espacios innecesarios
        System.out.println("\nNOMBRE CON ESPACIOS");

        rol2.setNombreRol("   Tecnico   ");

        System.out.println("Nombre actualizado: "
                + rol2.getNombreRol());

        // 9. Intentar asignar una descripción nula
        System.out.println("\nDESCRIPCION NULA");

        rol2.setDescripcion(null);

        System.out.println("Descripcion despues del intento: "
                + rol2.getDescripcion());

        // 10. Crear un rol con datos inválidos
        System.out.println("\nCONSTRUCTOR CON DATOS INVALIDOS");

        Rol rol3 = new Rol(
                -3,
                "",
                null
        );

        System.out.println("ID: " + rol3.getIdRol());
        System.out.println("Nombre: " + rol3.getNombreRol());
        System.out.println("Descripcion: " + rol3.getDescripcion());

        // 11. Mostrar información final
        System.out.println("\nINFORMACION FINAL");

        System.out.println("Rol 1: "
                + rol1.obtenerInformacion());

        System.out.println("Rol 2: "
                + rol2.obtenerInformacion());

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
