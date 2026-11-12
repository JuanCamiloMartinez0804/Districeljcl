/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.controlador;

import districeljcl.modelo.Cliente;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Venta;
import districeljcl.repositorio.ClienteRepositorio;
import districeljcl.repositorio.CelularRepositorio;
import districeljcl.repositorio.VentaRepositorio;
import java.util.ArrayList;


public class VentaControlador {
    
    private VentaRepositorio ventas;
    private ClienteRepositorio clientes;
    private CelularRepositorio celulares;

    public VentaControlador(
            VentaRepositorio ventas,
            ClienteRepositorio clientes,
            CelularRepositorio celulares) {

        this.ventas = ventas;
        this.clientes = clientes;
        this.celulares = celulares;
    }

    // Registrar una venta
    public String registrarVenta(int idCliente, int idCelular) {

        Cliente cliente = clientes.buscarPorId(idCliente);

        if (cliente == null) {
            return "Seleccione un cliente válido";
        }

        Celular celular = celulares.buscarPorId(idCelular);

        if (celular == null) {
            return "Seleccione un celular válido";
        }

        if (!celular.estaDisponible()) {
            return "El celular no está disponible para la venta";
        }

        Venta venta = new Venta();

        venta.setCliente(cliente);
        venta.agregarCelular(celular, 0);

        venta.calcularTotal();
        venta.calcularUtilidad();

        // Registrar la venta
        ventas.guardar(venta);

        // Actualizar el inventario
        celulares.marcarVendido(idCelular);

        return "Venta registrada correctamente";
    }

    // Consultar todas las ventas
    public ArrayList<Venta> listarVentas() {
        return ventas.listar();
    }

    // Consultar una venta por su ID
    public Venta buscarPorId(int id) {
        return ventas.buscarPorId(id);
    }

    // Consultar clientes disponibles
    public ArrayList<Cliente> listarClientes() {
        return clientes.listar();
    }

    // Consultar celulares disponibles
    public ArrayList<Celular> listarCelularesDisponibles() {

        ArrayList<Celular> disponibles = new ArrayList<>();

        for (Celular celular : celulares.listar()) {

            if (celular.estaDisponible()) {
                disponibles.add(celular);
            }
        }

        return disponibles;
    }
}
