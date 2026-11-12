/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.repositorio;

import districeljcl.modelo.Cliente;
import java.util.ArrayList;

public class ClienteRepositorio {
 
    private ArrayList<Cliente> clientes;
    private int siguienteId;

    public ClienteRepositorio() {
        clientes = new ArrayList<>();
        siguienteId = 1;
    }

    // Guardar un cliente
    public void guardar(Cliente cliente) {
        cliente.setIdCliente(siguienteId);
        siguienteId++;
        clientes.add(cliente);
    }

    // Listar todos los clientes
    public ArrayList<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    // Buscar un cliente por su ID
    public Cliente buscarPorId(int id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                return c;
            }
        }
        return null;
    }

    // Buscar clientes por nombre
    public ArrayList<Cliente> buscarPorNombre(String texto) {
        ArrayList<Cliente> encontrados = new ArrayList<>();

        for (Cliente c : clientes) {
            if (c.obtenerNombreCompleto().toLowerCase()
                    .contains(texto.toLowerCase())) {
                encontrados.add(c);
            }
        }

        return encontrados;
    }

    // Actualizar un cliente
    public boolean actualizar(Cliente clienteNuevo) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente()
                    == clienteNuevo.getIdCliente()) {

                clientes.set(i, clienteNuevo);
                return true;
            }
        }
        return false;
    }

    // Eliminar un cliente
    public boolean eliminar(int id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente() == id) {
                clientes.remove(i);
                return true;
            }
        }
        return false;
    }
}
