/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Tienda;

public class PruebaTienda {
    public static void main(String[] args) {
        System.out.println("PRUEBA DE LA CLASE TIENDA");
        System.out.println("----------------------------");

        // 1. Crear una tienda
        Tienda tienda = new Tienda(
                "Districeljcl",
                "900123456-7",
                "Cali, Colombia",
                "3001234567"
        );

        // 2. Asignar identificador
        tienda.setId(1);

        // 3. Mostrar información de la tienda
        System.out.println("\nINFORMACION DE LA TIENDA");

        System.out.println("ID: " + tienda.getId());
        System.out.println("Nombre: " + tienda.getNombre());
        System.out.println("NIT: " + tienda.getNit());
        System.out.println("Direccion: " + tienda.getDireccion());
        System.out.println("Telefono: " + tienda.getTelefono());

        // 4. Mostrar encabezado comercial
        System.out.println("\nENCABEZADO DE LA TIENDA");

        System.out.println(tienda.obtenerEncabezado());

        // 5. Actualizar información comercial
        System.out.println("\nACTUALIZACION DE INFORMACION");

        tienda.setNombre("Districeljcl Tecnologia");
        tienda.setNit("900987654-3");
        tienda.setDireccion("Cali, Valle del Cauca");
        tienda.setTelefono("3109876543");

        System.out.println("Nombre actualizado: "
                + tienda.getNombre());

        System.out.println("NIT actualizado: "
                + tienda.getNit());

        System.out.println("Direccion actualizada: "
                + tienda.getDireccion());

        System.out.println("Telefono actualizado: "
                + tienda.getTelefono());

        // 6. Intentar asignar identificador negativo
        System.out.println("\nIDENTIFICADOR INVALIDO");

        tienda.setId(-5);

        System.out.println("ID despues del intento: "
                + tienda.getId());

        // 7. Intentar asignar nombre vacío
        System.out.println("\nNOMBRE VACIO");

        tienda.setNombre("");

        System.out.println("Nombre despues del intento: "
                + tienda.getNombre());

        // 8. Intentar asignar NIT nulo
        System.out.println("\nNIT NULO");

        tienda.setNit(null);

        System.out.println("NIT despues del intento: "
                + tienda.getNit());

        // 9. Intentar asignar dirección vacía
        System.out.println("\nDIRECCION VACIA");

        tienda.setDireccion("   ");

        System.out.println("Direccion despues del intento: "
                + tienda.getDireccion());

        // 10. Intentar asignar teléfono nulo
        System.out.println("\nTELEFONO NULO");

        tienda.setTelefono(null);

        System.out.println("Telefono despues del intento: "
                + tienda.getTelefono());

        // 11. Comprobar eliminación de espacios
        System.out.println("\nDATOS CON ESPACIOS");

        tienda.setNombre("   Districeljcl Tecnologia   ");

        System.out.println("Nombre sin espacios: ["
                + tienda.getNombre() + "]");

        // 12. Comprobar constructor vacío
        System.out.println("\nCONSTRUCTOR VACIO");

        Tienda tiendaVacia = new Tienda();

        System.out.println("ID inicial: "
                + tiendaVacia.getId());

        System.out.println("Nombre inicial: "
                + tiendaVacia.getNombre());

        // 13. Asignar datos a la tienda vacía
        System.out.println("\nASIGNACION DE DATOS");

        tiendaVacia.setId(2);
        tiendaVacia.setNombre("Sucursal Districeljcl");
        tiendaVacia.setNit("901234567-8");
        tiendaVacia.setDireccion("Dosquebradas, Risaralda");
        tiendaVacia.setTelefono("3201234567");

        System.out.println("ID: " + tiendaVacia.getId());
        System.out.println(tiendaVacia.obtenerEncabezado());

        // 14. Mostrar información final
        System.out.println("\nINFORMACION FINAL");

        System.out.println("Tienda principal: "
                + tienda.getNombre());

        System.out.println("Sucursal: "
                + tiendaVacia.getNombre());

        System.out.println("\nFIN DE LA PRUEBA.");
    }
}
