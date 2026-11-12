/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Repuesto;
import districeljcl.modelo.DetalleReparacion;

public class PruebaDetalleReparacion {
    public static void main(String[] args) {
        System.out.println("PRUEBA DEL MODULO DE DETALLES DE REPARACION");
        System.out.println("------------------------------------------");

        // 1. Crear repuesto
        Repuesto repuesto = new Repuesto(
                "Pantalla",
                "Samsung",
                120000,
                180000,
                5
        );

        repuesto.setIdRepuesto(1);

        // 2. Crear detalle de reparación
        DetalleReparacion detalle = new DetalleReparacion(
                "Cambio de pantalla",
                1,
                180000,
                50000
        );

        detalle.setIdDetalleReparacion(1);
        detalle.setRepuesto(repuesto);
        detalle.setCostoUnitario(repuesto.getPrecioCompra());

        // 3. Mostrar información inicial
        System.out.println("\nINFORMACION DEL DETALLE");
        System.out.println(detalle.obtenerInformacion());

        // 4. Calcular subtotal
        System.out.println("\nCALCULO DEL SUBTOTAL");

        System.out.println("Subtotal: $"
                + detalle.calcularSubtotal());

        // 5. Calcular costo total
        System.out.println("\nCALCULO DEL COSTO TOTAL");

        System.out.println("Costo total: $"
                + detalle.calcularCostoTotal());

        // 6. Calcular diferencia entre precio y costo
        System.out.println("\nDIFERENCIA ENTRE PRECIO Y COSTO");

        double diferencia = detalle.calcularSubtotal()
                - detalle.calcularCostoTotal();

        System.out.println("Diferencia: $" + diferencia);

        // 7. Modificar cantidad
        System.out.println("\nMODIFICANDO CANTIDAD");

        detalle.setCantidad(2);

        System.out.println("Cantidad actual: "
                + detalle.getCantidad());

        System.out.println("Nuevo subtotal: $"
                + detalle.getSubtotal());

        System.out.println("Nuevo costo total: $"
                + detalle.calcularCostoTotal());

        // 8. Modificar precio unitario
        System.out.println("\nMODIFICANDO PRECIO UNITARIO");

        detalle.setPrecioUnitario(200000);

        System.out.println("Precio unitario: $"
                + detalle.getPrecioUnitario());

        System.out.println("Subtotal actualizado: $"
                + detalle.getSubtotal());

        // 9. Modificar mano de obra
        System.out.println("\nMODIFICANDO MANO DE OBRA");

        detalle.setCostoManoObra(60000);

        System.out.println("Mano de obra: $"
                + detalle.getCostoManoObra());

        System.out.println("Subtotal actualizado: $"
                + detalle.getSubtotal());

        // 10. Intentar asignar cantidad negativa
        System.out.println("\nCANTIDAD INVALIDA");

        detalle.setCantidad(-3);

        System.out.println("Cantidad despues del intento: "
                + detalle.getCantidad());

        // 11. Intentar asignar precio negativo
        System.out.println("\nPRECIO INVALIDO");

        detalle.setPrecioUnitario(-100000);

        System.out.println("Precio despues del intento: $"
                + detalle.getPrecioUnitario());

        // 12. Intentar modificar subtotal manualmente
        System.out.println("\nMODIFICACION MANUAL DEL SUBTOTAL");

        detalle.setSubtotal(1000);

        System.out.println("Subtotal real: $"
                + detalle.getSubtotal());

        // 13. Mostrar información final
        System.out.println("\nINFORMACION FINAL");
        System.out.println(detalle.obtenerInformacion());

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
