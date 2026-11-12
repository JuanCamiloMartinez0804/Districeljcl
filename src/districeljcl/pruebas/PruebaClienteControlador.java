/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Cliente;
import districeljcl.controlador.ClienteControlador;
import districeljcl.repositorio.ClienteRepositorio;


public class PruebaClienteControlador {
    
    public static void main(String[] args) {

        ClienteRepositorio repositorio =
                new ClienteRepositorio();

        ClienteControlador controlador =
                new ClienteControlador(repositorio);

        // 1. Guardar clientes
        System.out.println(controlador.guardarCliente(
                "Carlos", "Ramirez", "CC", "12345678"));

        System.out.println(controlador.guardarCliente(
                "Laura", "Gomez", "CC", "87654321"));

        // 2. Probar campos vacíos
        System.out.println(controlador.guardarCliente(
                "", "Lopez", "CC", "55555555"));

        // 3. Probar documento duplicado
        System.out.println(controlador.guardarCliente(
                "Pedro", "Martinez", "CC", "12345678"));

        // 4. Listar clientes
        System.out.println("\nCLIENTES REGISTRADOS");

        for (Cliente c : controlador.listarClientes()) {
            System.out.println(
                    c.getIdCliente() + " - "
                    + c.obtenerNombreCompleto());
        }

        // 5. Buscar por nombre
        System.out.println("\nBuscar Laura: "
                + controlador.buscarClientes("Laura").size());

        // 6. Actualizar contacto
        System.out.println(controlador.actualizarContacto(
                1,
                "3001234567",
                "carlos@gmail.com",
                "Cali"));

        System.out.println("Telefono actualizado: "
                + controlador.buscarPorId(1).getTelefono());

        // 7. Eliminar cliente
        System.out.println(controlador.eliminarCliente(2));

        System.out.println("Clientes restantes: "
                + controlador.listarClientes().size());
    }
}
