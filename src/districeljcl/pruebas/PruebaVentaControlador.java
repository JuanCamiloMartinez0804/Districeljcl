/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.controlador.VentaControlador;
import districeljcl.modelo.Cliente;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Marca;
import districeljcl.modelo.Venta;
import districeljcl.repositorio.ClienteRepositorio;
import districeljcl.repositorio.CelularRepositorio;
import districeljcl.repositorio.VentaRepositorio;

public class PruebaVentaControlador {
    
    
    public static void main(String[] args) {

        ClienteRepositorio clientes = new ClienteRepositorio();
        CelularRepositorio celulares = new CelularRepositorio();
        VentaRepositorio ventas = new VentaRepositorio();

        VentaControlador controlador = new VentaControlador(
                ventas, clientes, celulares);

        // Registrar clientes
        Cliente cliente1 = new Cliente(
                "Carlos", "Ramirez", "CC", "12345678");

        Cliente cliente2 = new Cliente(
                "Laura", "Gomez", "CC", "87654321");

        clientes.guardar(cliente1);
        clientes.guardar(cliente2);

        // Registrar celulares
        Marca samsung = new Marca(1, "Samsung");
        Marca apple = new Marca(2, "Apple");

        Celular celular1 = new Celular(
                samsung, "Galaxy A54",
                "111111111111111", "Usado");

        celular1.actualizarPrecio(950000);

        Celular celular2 = new Celular(
                apple, "iPhone 13",
                "222222222222222", "Usado");

        celular2.actualizarPrecio(1800000);

        celulares.guardar(celular1);
        celulares.guardar(celular2);

        // Consultar disponibilidad inicial
        System.out.println("CELULARES DISPONIBLES: "
                + controlador.listarCelularesDisponibles().size());

        // Registrar primera venta
        System.out.println("\nREGISTRO DE VENTAS");

        System.out.println(controlador.registrarVenta(1, 1));

        // Intentar vender nuevamente el mismo celular
        System.out.println(controlador.registrarVenta(2, 1));

        // Intentar vender a un cliente inexistente
        System.out.println(controlador.registrarVenta(99, 2));

        // Registrar segunda venta
        System.out.println(controlador.registrarVenta(2, 2));

        // Consultar las ventas registradas
        System.out.println("\nVENTAS REGISTRADAS");

        for (Venta venta : controlador.listarVentas()) {

            System.out.println(
                    venta.getIdVenta() + " - "
                    + venta.getCliente().obtenerNombreCompleto()
                    + " - Total: $" + venta.calcularTotal());
        }

        // Consultar una venta por ID
        Venta encontrada = controlador.buscarPorId(1);

        System.out.println("\nBuscar venta 1: "
                + encontrada.getCliente().obtenerNombreCompleto());

        // Comprobar inventario
        System.out.println("Celulares disponibles: "
                + controlador.listarCelularesDisponibles().size());

        System.out.println("Estado celular 1: "
                + celulares.buscarPorId(1).getEstadoEquipo());

        System.out.println("Estado celular 2: "
                + celulares.buscarPorId(2).getEstadoEquipo());
    }
}
