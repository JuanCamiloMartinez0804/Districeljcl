/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Cliente;
import districeljcl.repositorio.ClienteRepositorio;

public class PruebaClienteRepositorio {
 
    public static void main(String[] args) {

        ClienteRepositorio repo = new ClienteRepositorio();

        // Crear clientes
        Cliente cliente1 = new Cliente(
                "Carlos", "Ramirez", "CC", "12345678");

        Cliente cliente2 = new Cliente(
                "Laura", "Gomez", "CC", "87654321");

        // Guardar clientes
        repo.guardar(cliente1);
        repo.guardar(cliente2);

        // Listar clientes
        System.out.println("CLIENTES REGISTRADOS");

        for (Cliente c : repo.listar()) {
            System.out.println(
                    c.getIdCliente() + " - "
                    + c.obtenerNombreCompleto()
                    + " - " + c.getDocumento());
        }

        // Buscar por ID
        Cliente encontrado = repo.buscarPorId(1);

        System.out.println("\nBuscar ID 1: "
                + encontrado.obtenerNombreCompleto());

        // Buscar por nombre
        System.out.println("Buscar Laura: "
                + repo.buscarPorNombre("Laura").size());

        // Actualizar contacto
        cliente1.actualizarContacto(
                "3001234567",
                "carlos@ejemplo.com",
                "Cali");

        repo.actualizar(cliente1);

        System.out.println("Telefono actualizado: "
                + repo.buscarPorId(1).getTelefono());

        // Eliminar cliente
        repo.eliminar(2);

        System.out.println("Clientes restantes: "
                + repo.listar().size());
    }
}
