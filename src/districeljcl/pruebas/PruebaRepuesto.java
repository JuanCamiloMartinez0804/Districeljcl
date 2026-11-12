/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Repuesto;

public class PruebaRepuesto {
    public static void main(String[] args) {
        System.out.println("PRUEBA DEL MODULO DE REPUESTOS");
        System.out.println("------------------------------");

        // 1. Crear repuesto
        Repuesto repuesto = new Repuesto(
                "Pantalla",
                "Samsung",
                120000,
                180000,
                5
        );

        repuesto.setIdRepuesto(1);
        repuesto.setDescripcion("Pantalla original");
        repuesto.setModeloCompatible("Galaxy A54");
        repuesto.setStockMinimo(2);

        // 2. Mostrar información inicial
        System.out.println("\nINFORMACION DEL REPUESTO");

        System.out.println("ID: " + repuesto.getIdRepuesto());
        System.out.println("Nombre: " + repuesto.getNombre());
        System.out.println("Marca: " + repuesto.getMarca());
        System.out.println("Modelo compatible: "
                + repuesto.getModeloCompatible());
        System.out.println("Precio compra: $"
                + repuesto.getPrecioCompra());
        System.out.println("Precio venta: $"
                + repuesto.getPrecioVenta());
        System.out.println("Stock inicial: "
                + repuesto.getStock());
        System.out.println("Stock minimo: "
                + repuesto.getStockMinimo());
        System.out.println("Estado: " + repuesto.getEstado());

        // 3. Calcular utilidad
        System.out.println("\nCALCULO DE UTILIDAD");

        System.out.println("Utilidad por unidad: $"
                + repuesto.calcularUtilidad());

        // 4. Consultar existencias
        System.out.println("\nCONSULTA DE EXISTENCIAS");

        System.out.println("Hay existencias: "
                + repuesto.hayExistencias());

        System.out.println("Hay 3 unidades disponibles: "
                + repuesto.hayExistencias(3));

        System.out.println("Hay 10 unidades disponibles: "
                + repuesto.hayExistencias(10));

        // 5. Descontar stock
        System.out.println("\nDESCONTANDO STOCK");

        System.out.println("Descontar 3 unidades: "
                + repuesto.descontarStock(3));

        System.out.println("Stock actual: "
                + repuesto.getStock());

        // 6. Verificar reposición
        System.out.println("\nVERIFICANDO REPOSICION");

        System.out.println("Necesita reposicion: "
                + repuesto.necesitaReposicion());

        // 7. Intentar descontar más unidades
        System.out.println("\nDESCUENTO INVALIDO");

        System.out.println("Descontar 5 unidades: "
                + repuesto.descontarStock(5));

        System.out.println("Stock actual: "
                + repuesto.getStock());

        // 8. Aumentar stock
        System.out.println("\nAUMENTANDO STOCK");

        System.out.println("Aumentar 10 unidades: "
                + repuesto.aumentarStock(10));

        System.out.println("Stock actual: "
                + repuesto.getStock());

        System.out.println("Necesita reposicion: "
                + repuesto.necesitaReposicion());

        // 9. Probar cantidad negativa
        System.out.println("\nCANTIDAD INVALIDA");

        System.out.println("Aumentar -3 unidades: "
                + repuesto.aumentarStock(-3));

        System.out.println("Stock actual: "
                + repuesto.getStock());

        // 10. Probar repuesto inactivo
        System.out.println("\nREPUESTO INACTIVO");

        repuesto.setEstado("Inactivo");

        System.out.println("Estado: " + repuesto.getEstado());

        System.out.println("Descontar 1 unidad: "
                + repuesto.descontarStock(1));

        System.out.println("Stock final: "
                + repuesto.getStock());

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
