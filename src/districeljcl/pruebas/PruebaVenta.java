/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.*;


public class PruebaVenta {
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DEL MODULO DE VENTAS");
        System.out.println("----------------------------");

        // 1. Crear un rol
        Rol rol = new Rol(
                1, "Vendedor", "Personal de ventas"
        );

        // 2. Crear un vendedor
        Usuario vendedor = new Usuario(
                "juan",
                "hash_de_prueba",
                "Juan",
                "Martinez",
                rol
        );

        vendedor.setIdUsuario(1);

        // 3. Crear un cliente
        Cliente cliente = new Cliente(
                "Andres",
                "Gonzalez",
                "CC",
                "123456789"
        );

        cliente.setIdCliente(1);

        // 4. Crear las marcas
        Marca samsung = new Marca(1, "Samsung");
        Marca motorola = new Marca(2, "Motorola");

        // 5. Crear el primer celular
        Celular celular1 = new Celular(
                samsung,
                "Galaxy S23",
                "111111111111111",
                "Usado"
        );

        celular1.setIdCelular(1);
        celular1.setCostoCompra(1500000);
        celular1.setPrecioVenta(1800000);

        // 6. Crear el segundo celular
        Celular celular2 = new Celular(
                motorola,
                "Edge 40",
                "222222222222222",
                "Usado"
        );

        celular2.setIdCelular(2);
        celular2.setCostoCompra(700000);
        celular2.setPrecioVenta(900000);

        // 7. Crear la venta
        Venta venta = new Venta(cliente, vendedor);
        venta.setIdVenta(1);

        // 8. Agregar celulares
        System.out.println("\nAGREGANDO CELULARES");

        System.out.println("Primer celular agregado: "
                + venta.agregarCelular(celular1, 50000));

        System.out.println("Segundo celular agregado: "
                + venta.agregarCelular(celular2, 0));

        // 9. Intentar agregar un celular duplicado
        System.out.println("\nPRUEBA DE DUPLICADOS");

        System.out.println("Agregar nuevamente el primero: "
                + venta.agregarCelular(celular1, 0));

        // 10. Consultar los detalles
        System.out.println("\nDETALLES DE LA VENTA");

        System.out.println("Cantidad de celulares: "
                + venta.getDetalles().size());

        // 11. Calcular total y utilidad
        System.out.println("\nCALCULOS DE LA VENTA");

        System.out.println("Total: $"
                + venta.calcularTotal());

        System.out.println("Utilidad: $"
                + venta.calcularUtilidad());

        // 12. Eliminar un detalle
        System.out.println("\nELIMINANDO UN DETALLE");

        System.out.println("Eliminacion exitosa: "
                + venta.quitarDetalle(1));

        System.out.println("Cantidad de celulares: "
                + venta.getDetalles().size());

        System.out.println("Nuevo total: $"
                + venta.calcularTotal());

        // 13. Probar un indice invalido
        System.out.println("\nPRUEBA DE INDICE INVALIDO");

        System.out.println("Eliminar indice 10: "
                + venta.quitarDetalle(10));

        // 14. Agregar nuevamente el segundo celular
        System.out.println("\nAGREGANDO NUEVAMENTE EL CELULAR");

        System.out.println("Resultado: "
                + venta.agregarCelular(celular2, 0));

        // 15. Crear los datos de la tienda
        Tienda tienda = new Tienda(
                "DISTRICELJCL",
                "900123456-1",
                "Cali, Colombia",
                "3001234567"
        );

        // 16. Generar comprobante
        System.out.println("\nGENERANDO COMPROBANTE");

        System.out.println(venta.generarComprobante(tienda));

        // 17. Confirmar la venta
        System.out.println("\nCONFIRMANDO VENTA");

        System.out.println("Resultado: "
                + venta.confirmar());

        System.out.println("Estado de la venta: "
                + venta.getEstadoVenta());

        System.out.println("Estado del primer celular: "
                + celular1.getEstadoEquipo());

        System.out.println("Estado del segundo celular: "
                + celular2.getEstadoEquipo());

        // 18. Intentar confirmar nuevamente
        System.out.println("\nCONFIRMACION DUPLICADA");

        System.out.println("Resultado: "
                + venta.confirmar());

        // 19. Intentar modificar una venta confirmada
        System.out.println("\nMODIFICAR VENTA CONFIRMADA");

        System.out.println("Eliminar detalle: "
                + venta.quitarDetalle(0));

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
