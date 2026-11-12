/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.repositorio;

import districeljcl.modelo.Venta;
import java.util.ArrayList;

public class VentaRepositorio {

    private ArrayList<Venta> ventas;
    private int siguienteId;

    public VentaRepositorio() {
        ventas = new ArrayList<>();
        siguienteId = 1;
    }

    // Guardar una venta
    public void guardar(Venta venta) {
        venta.setIdVenta(siguienteId);
        siguienteId++;
        ventas.add(venta);
    }

    // Listar todas las ventas
    public ArrayList<Venta> listar() {
        return new ArrayList<>(ventas);
    }

    // Buscar una venta por ID
    public Venta buscarPorId(int id) {
        for (Venta v : ventas) {
            if (v.getIdVenta() == id) {
                return v;
            }
        }
        return null;
    }

    // Buscar ventas por estado
    public ArrayList<Venta> buscarPorEstado(String estado) {
        ArrayList<Venta> encontradas = new ArrayList<>();

        for (Venta v : ventas) {
            if (v.getEstadoVenta() != null &&
                v.getEstadoVenta().equalsIgnoreCase(estado)) {
                encontradas.add(v);
            }
        }

        return encontradas;
    }

    // Actualizar una venta
    public boolean actualizar(Venta ventaNueva) {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getIdVenta()
                    == ventaNueva.getIdVenta()) {

                ventas.set(i, ventaNueva);
                return true;
            }
        }
        return false;
    }

    // Eliminar una venta
    public boolean eliminar(int id) {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getIdVenta() == id) {
                ventas.remove(i);
                return true;
            }
        }
        return false;
    }
}
