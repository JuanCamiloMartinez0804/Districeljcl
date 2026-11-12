/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.controlador;

import districeljcl.modelo.Cliente;
import districeljcl.repositorio.ClienteRepositorio;
import java.util.ArrayList;

public class ClienteControlador {
    
    private ClienteRepositorio repositorio;

    // Constructor: recibe el repositorio de clientes
    public ClienteControlador(ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // Registrar un cliente
    public String guardarCliente(
            String nombres,
            String apellidos,
            String tipoDocumento,
            String documento) {

        // Validar campos obligatorios
        if (nombres == null || nombres.isBlank()
                || apellidos == null || apellidos.isBlank()
                || tipoDocumento == null || tipoDocumento.isBlank()
                || documento == null || documento.isBlank()) {

            return "Complete todos los campos obligatorios";
        }

        // Evitar documentos repetidos
        for (Cliente c : repositorio.listar()) {
            if (c.getDocumento().equalsIgnoreCase(documento.trim())) {
                return "Ya existe un cliente con ese documento";
            }
        }

        Cliente cliente = new Cliente(
                nombres.trim(),
                apellidos.trim(),
                tipoDocumento.trim(),
                documento.trim());

        repositorio.guardar(cliente);

        return "Cliente guardado correctamente";
    }

    // Listar clientes
    public ArrayList<Cliente> listarClientes() {
        return repositorio.listar();
    }

    // Buscar clientes por nombre
    public ArrayList<Cliente> buscarClientes(String texto) {
        if (texto == null || texto.isBlank()) {
            return repositorio.listar();
        }

        return repositorio.buscarPorNombre(texto.trim());
    }

    // Buscar un cliente por ID
    public Cliente buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    // Actualizar información de contacto
    public String actualizarContacto(
            int id,
            String telefono,
            String correo,
            String ciudad) {

        Cliente cliente = repositorio.buscarPorId(id);

        if (cliente == null) {
            return "Seleccione un cliente válido";
        }

        cliente.actualizarContacto(
                telefono, correo, ciudad);

        repositorio.actualizar(cliente);

        return "Cliente actualizado correctamente";
    }

    // Eliminar un cliente
    public String eliminarCliente(int id) {

        if (repositorio.eliminar(id)) {
            return "Cliente eliminado correctamente";
        }

        return "Seleccione un cliente válido";
    }
    
    
    // Actualizar todos los datos de un cliente
    public String actualizarCliente(
            int id,
            String nombre,
            String apellido,
            String tipoDocumento,
            String documento,
            String telefono,
            String correo,
            String direccion) {

        // Buscar el cliente
        Cliente cliente = repositorio.buscarPorId(id);

        if (cliente == null) {
            return "Seleccione un cliente válido";
        }

        // Validar los campos obligatorios
        if (nombre == null || nombre.isBlank()
                || apellido == null || apellido.isBlank()
                || tipoDocumento == null || tipoDocumento.isBlank()
                || documento == null || documento.isBlank()) {

            return "Complete todos los campos obligatorios";
        }

        // Evitar documentos duplicados
        for (Cliente c : repositorio.listar()) {

            if (c.getIdCliente() != id
                    && c.getDocumento().equalsIgnoreCase(documento.trim())) {

                return "Ya existe otro cliente con ese documento";
            }
        }

        // Actualizar datos personales
        cliente.setNombre(nombre.trim());
        cliente.setApellido(apellido.trim());
        cliente.setTipoDocumento(tipoDocumento.trim());
        cliente.setDocumento(documento.trim());

        // Actualizar información de contacto
        cliente.actualizarContacto(
                telefono, correo, direccion);

        // Guardar los cambios en el repositorio
        if (repositorio.actualizar(cliente)) {
            return "Cliente actualizado correctamente";
        }

        return "No se pudo actualizar el cliente";
    }

}
