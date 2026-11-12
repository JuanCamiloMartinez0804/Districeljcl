/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Cliente;

public class PruebaCliente {
    
     public static void main(String[] args) {

        System.out.println("PRUEBA DE LA CLASE CLIENTE");
        System.out.println("----------------------------");

        // 1. Crear un cliente
        Cliente cliente = new Cliente(
                "Andres",
                "Gonzalez",
                "CC",
                "123456789"
        );

        // 2. Asignar información adicional
        cliente.setIdCliente(1);

        cliente.actualizarContacto(
                "3001234567",
                "andres@gmail.com",
                "Cali"
        );

        // 3. Mostrar nombre completo
        System.out.println("\nNOMBRE COMPLETO");

        System.out.println(cliente.obtenerNombreCompleto());

        // 4. Mostrar toda la información
        System.out.println("\nINFORMACION DEL CLIENTE");

        System.out.println(cliente.obtenerInformacion());

        // 5. Modificar el contacto
        cliente.actualizarContacto(
                "3109876543",
                "andres.nuevo@gmail.com",
                "Dosquebradas"
        );

        // 6. Consultar información actualizada
        System.out.println("\nCONTACTO ACTUALIZADO");

        System.out.println("Telefono: " + cliente.getTelefono());
        System.out.println("Correo: " + cliente.getCorreo());
        System.out.println("Direccion: " + cliente.getDireccion());

        // 7. Intentar asignar un identificador negativo
        System.out.println("\nIDENTIFICADOR INVALIDO");

        cliente.setIdCliente(-5);

        System.out.println("ID despues del intento: "
                + cliente.getIdCliente());

        // 8. Intentar asignar un nombre vacío
        System.out.println("\nNOMBRE VACIO");

        cliente.setNombre("");

        System.out.println("Nombre despues del intento: "
                + cliente.getNombre());

        // 9. Intentar asignar un apellido nulo
        System.out.println("\nAPELLIDO NULO");

        cliente.setApellido(null);

        System.out.println("Apellido despues del intento: "
                + cliente.getApellido());

        // 10. Intentar asignar un documento vacío
        System.out.println("\nDOCUMENTO VACIO");

        cliente.setDocumento("");

        System.out.println("Documento despues del intento: "
                + cliente.getDocumento());

        // 11. Intentar asignar datos de contacto inválidos
        System.out.println("\nCONTACTO INVALIDO");

        cliente.actualizarContacto(
                "",
                null,
                "   "
        );

        System.out.println("Telefono despues del intento: "
                + cliente.getTelefono());

        System.out.println("Correo despues del intento: "
                + cliente.getCorreo());

        System.out.println("Direccion despues del intento: "
                + cliente.getDireccion());

        // 12. Comprobar eliminación de espacios
        System.out.println("\nDATOS CON ESPACIOS");

        cliente.setNombre("   Andres   ");
        cliente.setApellido("   Gonzalez   ");

        System.out.println("Nombre completo: "
                + cliente.obtenerNombreCompleto());

        // 13. Comprobar constructor vacío
        System.out.println("\nCONSTRUCTOR VACIO");

        Cliente clienteVacio = new Cliente();

        System.out.println("Nombre completo: ["
                + clienteVacio.obtenerNombreCompleto() + "]");

        System.out.println("ID inicial: "
                + clienteVacio.getIdCliente());

        // 14. Asignar datos al cliente vacío
        System.out.println("\nASIGNACION DE DATOS");

        clienteVacio.setIdCliente(2);
        clienteVacio.setNombre("Laura");
        clienteVacio.setApellido("Martinez");
        clienteVacio.setTipoDocumento("CC");
        clienteVacio.setDocumento("987654321");

        clienteVacio.actualizarContacto(
                "3201234567",
                "laura@gmail.com",
                "Cali"
        );

        System.out.println(clienteVacio.obtenerInformacion());

        // 15. Mostrar información final
        System.out.println("\nINFORMACION FINAL");

        System.out.println("Cliente 1: "
                + cliente.obtenerNombreCompleto());

        System.out.println("Cliente 2: "
                + clienteVacio.obtenerNombreCompleto());

        System.out.println("\nFIN DE LA PRUEBA.");
    }
}
