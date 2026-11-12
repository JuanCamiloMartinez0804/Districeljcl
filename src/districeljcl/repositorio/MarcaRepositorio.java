/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.repositorio;

import districeljcl.modelo.Marca;
import java.util.ArrayList;

public class MarcaRepositorio {
 
    private ArrayList<Marca> marcas;
    private int siguienteId;

    // Constructor
    public MarcaRepositorio() {
        marcas = new ArrayList<>();
        siguienteId = 1;
        cargarDatosDePrueba();
    }

    // Guardar una marca
    public void guardar(Marca marca) {
        marca.setIdMarca(siguienteId);
        siguienteId++;
        marcas.add(marca);
    }

    // Listar todas las marcas
    public ArrayList<Marca> listar() {
        return new ArrayList<>(marcas);
    }

    // Buscar una marca por ID
    public Marca buscarPorId(int id) {
        for (Marca m : marcas) {
            if (m.getIdMarca() == id) {
                return m;
            }
        }
        return null;
    }

    // Buscar una marca por nombre
    public Marca buscarPorNombre(String nombre) {
        for (Marca m : marcas) {
            if (m.getNombreMarca()
                    .equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

    // Actualizar una marca
    public boolean actualizar(Marca marcaNueva) {
        for (int i = 0; i < marcas.size(); i++) {
            if (marcas.get(i).getIdMarca()
                    == marcaNueva.getIdMarca()) {

                marcas.set(i, marcaNueva);
                return true;
            }
        }
        return false;
    }

    // Eliminar una marca
    public boolean eliminar(int id) {
        for (int i = 0; i < marcas.size(); i++) {
            if (marcas.get(i).getIdMarca() == id) {
                marcas.remove(i);
                return true;
            }
        }
        return false;
    }

    // Marcas iniciales para las pruebas
    private void cargarDatosDePrueba() {
        guardar(new Marca(0, "Samsung"));
        guardar(new Marca(0, "Apple"));
        guardar(new Marca(0, "Xiaomi"));
        guardar(new Marca(0, "Motorola"));
    }
}
