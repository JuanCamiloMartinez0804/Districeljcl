/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.controlador.ClienteControlador;
import districeljcl.modelo.Cliente;
import districeljcl.repositorio.ClienteRepositorio;

public class PruebaActualizarCliente {
    
    public static void main(String[] args) {

        ClienteRepositorio repositorio = new ClienteRepositorio();

        ClienteControlador controlador =
                new ClienteControlador(repositorio);

        // Registrar dos clientes
        controlador.guardarCliente(
                "Carlos", "Ramirez", "CC", "12345678");

        controlador.guardarCliente(
                "Laura", "Gomez", "CC", "87654321");

        System.out.println("CLIENTES ANTES DE ACTUALIZAR");

        for (Cliente c : controlador.listarClientes()) {
            System.out.println(
                    c.getIdCliente() + " - "
                    + c.obtenerNombreCompleto());
        }

        // Actualizar todos los datos del primer cliente
        System.out.println("\nACTUALIZACION COMPLETA");

        System.out.println(controlador.actualizarCliente(
                1,
                "Juan",
                "Martinez",
                "CC",
                "11223344",
                "3001234567",
                "juan@gmail.com",
                "Cali"));

        // Consultar los datos actualizados
        Cliente actualizado = controlador.buscarPorId(1);

        System.out.println("\nDATOS ACTUALIZADOS");

        System.out.println("Nombre: "
                + actualizado.obtenerNombreCompleto());

        System.out.println("Tipo documento: "
                + actualizado.getTipoDocumento());

        System.out.println("Documento: "
                + actualizado.getDocumento());

        System.out.println("Telefono: "
                + actualizado.getTelefono());

        System.out.println("Correo: "
                + actualizado.getCorreo());

        System.out.println("Direccion: "
                + actualizado.getDireccion());

        // Probar documento duplicado
        System.out.println("\nPRUEBA DE VALIDACION");

        System.out.println(controlador.actualizarCliente(
                1,
                "Juan",
                "Martinez",
                "CC",
                "87654321",
                "3001234567",
                "juan@gmail.com",
                "Cali"));

        // Comprobar que el documento original se conserva
        System.out.println("Documento final: "
                + controlador.buscarPorId(1).getDocumento());
    }
}
