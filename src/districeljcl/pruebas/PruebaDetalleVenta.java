/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Marca;
import districeljcl.modelo.Celular;
import districeljcl.modelo.DetalleVenta;

public class PruebaDetalleVenta {
    public static void main(String[] args) {
        System.out.println("PRUEBA DEL MODULO DE DETALLES DE VENTA");
        System.out.println("-------------------------------------");

        // 1. Crear marca
        Marca marca = new Marca(1, "Samsung");

        // 2. Crear celular
        Celular celular = new Celular(
                marca,
                "Galaxy S23",
                "123456789012345",
                "Nuevo"
        );

        // 3. Crear detalle de venta
        DetalleVenta detalle = new DetalleVenta(
                celular,
                1500000,
                1200000,
                100000
        );

        detalle.setIdDetalleVenta(1);

        // 4. Mostrar información inicial
        System.out.println("\nINFORMACION DEL DETALLE");
        System.out.println(detalle.obtenerInformacion());

        // 5. Calcular subtotal
        System.out.println("\nCALCULO DEL SUBTOTAL");

        System.out.println("Subtotal: $"
                + detalle.calcularSubtotal());

        // 6. Calcular utilidad
        System.out.println("\nCALCULO DE LA UTILIDAD");

        System.out.println("Utilidad: $"
                + detalle.calcularUtilidad());

        // 7. Modificar precio de venta
        System.out.println("\nMODIFICANDO PRECIO DE VENTA");

        detalle.setPrecioVenta(1600000);

        System.out.println("Precio actualizado: $"
                + detalle.getPrecioVenta());

        System.out.println("Nuevo subtotal: $"
                + detalle.calcularSubtotal());

        System.out.println("Nueva utilidad: $"
                + detalle.calcularUtilidad());

        // 8. Modificar descuento
        System.out.println("\nMODIFICANDO DESCUENTO");

        detalle.setDescuento(200000);

        System.out.println("Descuento actualizado: $"
                + detalle.getDescuento());

        System.out.println("Subtotal actualizado: $"
                + detalle.calcularSubtotal());

        System.out.println("Utilidad actualizada: $"
                + detalle.calcularUtilidad());

        // 9. Intentar asignar precio negativo
        System.out.println("\nPRECIO INVALIDO");

        detalle.setPrecioVenta(-500000);

        System.out.println("Precio despues del intento: $"
                + detalle.getPrecioVenta());

        // 10. Intentar asignar descuento negativo
        System.out.println("\nDESCUENTO NEGATIVO");

        detalle.setDescuento(-100000);

        System.out.println("Descuento despues del intento: $"
                + detalle.getDescuento());

        // 11. Intentar descuento mayor al precio
        System.out.println("\nDESCUENTO SUPERIOR AL PRECIO");

        detalle.setDescuento(2000000);

        System.out.println("Descuento despues del intento: $"
                + detalle.getDescuento());

        // 12. Intentar costo negativo
        System.out.println("\nCOSTO INVALIDO");

        detalle.setCostoUnitario(-100000);

        System.out.println("Costo despues del intento: $"
                + detalle.getCostoUnitario());

        // 13. Intentar reducir precio por debajo del descuento
        System.out.println("\nPRECIO MENOR AL DESCUENTO");

        detalle.setPrecioVenta(100000);

        System.out.println("Precio despues del intento: $"
                + detalle.getPrecioVenta());

        // 14. Mostrar información final
        System.out.println("\nINFORMACION FINAL");
        System.out.println(detalle.obtenerInformacion());

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
