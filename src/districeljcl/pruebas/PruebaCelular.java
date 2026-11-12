/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Celular;
import districeljcl.modelo.Marca;

public class PruebaCelular {
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DE LA CLASE CELULAR");
        System.out.println("----------------------------");

        Marca samsung = new Marca(1, "Samsung");

        Celular celular = new Celular(
                samsung,
                "Galaxy S23",
                "123456789012345",
                "Usado"
        );

        celular.setIdCelular(1);
        celular.setAlmacenamiento(256);
        celular.setColor("Negro");
        celular.setOrigenEquipo("Compra a particular");
        celular.setCostoCompra(1500000);
        celular.setPrecioVenta(1800000);
        celular.setObservaciones("Equipo en buen estado.");

        System.out.println("\nINFORMACION DEL CELULAR");
        System.out.println(celular.obtenerInformacion());

        System.out.println("\nCALCULO DE UTILIDAD");
        System.out.println("Utilidad: $"
                + celular.calcularUtilidad());

        celular.actualizarPrecio(1900000);

        System.out.println("\nPRECIO ACTUALIZADO");
        System.out.println("Nuevo precio: $"
                + celular.getPrecioVenta());

        System.out.println("\nDISPONIBILIDAD INICIAL");
        System.out.println(celular.estaDisponible());

        System.out.println("\nACTUALIZACION DE ESTADO");
        boolean actualizado = celular.actualizarEstado("Vendido");

        System.out.println("Actualizacion exitosa: " + actualizado);
        System.out.println("Estado: " + celular.getEstadoEquipo());
        System.out.println("Disponible: " + celular.estaDisponible());

        System.out.println("\nPRUEBA DE ESTADO INVALIDO");
        boolean invalido = celular.actualizarEstado("Desconocido");

        System.out.println("Actualizacion exitosa: " + invalido);
        System.out.println("Estado conservado: "
                + celular.getEstadoEquipo());

        System.out.println("\nFIN DE LA PRUEBA.");
    }
}
