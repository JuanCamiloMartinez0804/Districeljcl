/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.repositorio;

import districeljcl.modelo.Repuesto;
import java.util.ArrayList;


public class RepuestoRepositorio {

    private ArrayList<Repuesto> repuestos;
    private int siguienteId;

    public RepuestoRepositorio() {
        repuestos = new ArrayList<>();
        siguienteId = 1;
    }

    // Guardar un repuesto
    public void guardar(Repuesto repuesto) {
        repuesto.setIdRepuesto(siguienteId);
        siguienteId++;
        repuestos.add(repuesto);
    }

    // Listar todos los repuestos
    public ArrayList<Repuesto> listar() {
        return new ArrayList<>(repuestos);
    }

    // Buscar un repuesto por ID
    public Repuesto buscarPorId(int id) {
        for (Repuesto r : repuestos) {
            if (r.getIdRepuesto() == id) {
                return r;
            }
        }
        return null;
    }

    // Buscar repuestos por nombre
    public ArrayList<Repuesto> buscarPorNombre(String texto) {
        ArrayList<Repuesto> encontrados = new ArrayList<>();

        for (Repuesto r : repuestos) {
            if (r.getNombre() != null &&
                r.getNombre().toLowerCase()
                    .contains(texto.toLowerCase())) {
                encontrados.add(r);
            }
        }

        return encontrados;
    }

    // Actualizar un repuesto
    public boolean actualizar(Repuesto repuestoNuevo) {
        for (int i = 0; i < repuestos.size(); i++) {
            if (repuestos.get(i).getIdRepuesto()
                    == repuestoNuevo.getIdRepuesto()) {

                repuestos.set(i, repuestoNuevo);
                return true;
            }
        }
        return false;
    }

    // Eliminar un repuesto
    public boolean eliminar(int id) {
        for (int i = 0; i < repuestos.size(); i++) {
            if (repuestos.get(i).getIdRepuesto() == id) {
                repuestos.remove(i);
                return true;
            }
        }
        return false;
    }
}
