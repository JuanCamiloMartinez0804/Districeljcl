/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Venta;
import districeljcl.modelo.Cliente;
import districeljcl.modelo.Celular;
import districeljcl.repositorio.VentaRepositorio;


public class PruebaVentaRepositorio {
 
    public static void main(String[] args) {

        VentaRepositorio repo = new VentaRepositorio();

        // Crear clientes
        Cliente cliente1 = new Cliente(
                "Carlos", "Ramirez", "CC", "12345678");

        Cliente cliente2 = new Cliente(
                "Laura", "Gomez", "CC", "87654321");

        // Crear celulares
        Celular celular1 = new Celular();
        celular1.setModelo("Galaxy A54");
        celular1.setPrecioVenta(950000);
        celular1.setCostoCompra(650000);

        Celular celular2 = new Celular();
        celular2.setModelo("iPhone 13");
        celular2.setPrecioVenta(1800000);
        celular2.setCostoCompra(1400000);

        // Crear ventas
        Venta venta1 = new Venta();
        venta1.setCliente(cliente1);

        Venta venta2 = new Venta();
        venta2.setCliente(cliente2);

        // Agregar celulares a las ventas
        venta1.agregarCelular(celular1, 0);
        venta2.agregarCelular(celular2, 0);

        // Guardar ventas
        repo.guardar(venta1);
        repo.guardar(venta2);

        // Listar ventas
        System.out.println("VENTAS REGISTRADAS");

        for (Venta v : repo.listar()) {
            System.out.println(
                    v.getIdVenta() + " - "
                    + v.getCliente().obtenerNombreCompleto()
                    + " - Total: $" + v.calcularTotal());
        }

        // Buscar por ID
        Venta encontrada = repo.buscarPorId(1);

        System.out.println("\nBuscar ID 1: "
                + encontrada.getCliente()
                    .obtenerNombreCompleto());

        // Buscar por estado
        System.out.println("Ventas en estado inicial: "
                + repo.buscarPorEstado(
                    venta1.getEstadoVenta()).size());

        // Consultar utilidad
        System.out.println("Utilidad venta 1: $"
                + venta1.calcularUtilidad());

        // Eliminar una venta
        repo.eliminar(2);

        System.out.println("Ventas restantes: "
                + repo.listar().size());
    }
}
