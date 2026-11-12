/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.repositorio;

import districeljcl.modelo.Reparacion;
import java.util.ArrayList;

public class ReparacionRepositorio {
    
    private ArrayList<Reparacion> reparaciones;
    private int siguienteId;

    public ReparacionRepositorio() {
        reparaciones = new ArrayList<>();
        siguienteId = 1;
    }

    // Guardar una reparación
    public void guardar(Reparacion reparacion) {
        reparacion.setIdReparacion(siguienteId);
        siguienteId++;
        reparaciones.add(reparacion);
    }

    // Listar todas las reparaciones
    public ArrayList<Reparacion> listar() {
        return new ArrayList<>(reparaciones);
    }

    // Buscar una reparación por ID
    public Reparacion buscarPorId(int id) {
        for (Reparacion r : reparaciones) {
            if (r.getIdReparacion() == id) {
                return r;
            }
        }
        return null;
    }

    // Buscar reparaciones por estado
    public ArrayList<Reparacion> buscarPorEstado(String estado) {
        ArrayList<Reparacion> encontradas = new ArrayList<>();

        for (Reparacion r : reparaciones) {
            if (r.getEstadoReparacion() != null &&
                r.getEstadoReparacion()
                    .equalsIgnoreCase(estado)) {
                encontradas.add(r);
            }
        }

        return encontradas;
    }

    // Actualizar una reparación
    public boolean actualizar(Reparacion reparacionNueva) {
        for (int i = 0; i < reparaciones.size(); i++) {
            if (reparaciones.get(i).getIdReparacion()
                    == reparacionNueva.getIdReparacion()) {

                reparaciones.set(i, reparacionNueva);
                return true;
            }
        }
        return false;
    }

    // Eliminar una reparación
    public boolean eliminar(int id) {
        for (int i = 0; i < reparaciones.size(); i++) {
            if (reparaciones.get(i).getIdReparacion() == id) {
                reparaciones.remove(i);
                return true;
            }
        }
        return false;
    }
}
