/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.repositorio;

import districeljcl.modelo.Celular;
import java.util.ArrayList;



public class CelularRepositorio {
 
    private ArrayList<Celular> celulares;
    private int siguienteId;

    public CelularRepositorio() {
        celulares = new ArrayList<>();
        siguienteId = 1;
    }

    // Guardar un celular
    public void guardar(Celular celular) {
        celular.setIdCelular(siguienteId);
        siguienteId++;
        celulares.add(celular);
    }

    // Listar todos los celulares
    public ArrayList<Celular> listar() {
        return new ArrayList<>(celulares);
    }

    // Buscar un celular por su ID
    public Celular buscarPorId(int id) {
        for (Celular c : celulares) {
            if (c.getIdCelular() == id) {
                return c;
            }
        }
        return null;
    }

    // Buscar celulares por modelo
    public ArrayList<Celular> buscarPorModelo(String texto) {
        ArrayList<Celular> encontrados = new ArrayList<>();

        for (Celular c : celulares) {
            if (c.getModelo() != null &&
                c.getModelo().toLowerCase()
                    .contains(texto.toLowerCase())) {
                encontrados.add(c);
            }
        }

        return encontrados;
    }

    // Actualizar un celular
    public boolean actualizar(Celular celularNuevo) {
        for (int i = 0; i < celulares.size(); i++) {
            if (celulares.get(i).getIdCelular()
                    == celularNuevo.getIdCelular()) {

                celulares.set(i, celularNuevo);
                return true;
            }
        }
        return false;
    }

    // Marcar un celular como vendido
    public boolean marcarVendido(int id) {
        Celular c = buscarPorId(id);

        if (c != null && c.estaDisponible()) {
            return c.actualizarEstado("Vendido");
        }

        return false;
    }
    
    
    // Eliminar un celular por ID
    public boolean eliminar(int id) {

        for (int i = 0; i < celulares.size(); i++) {

            if (celulares.get(i).getIdCelular() == id) {
                celulares.remove(i);
                return true;
            }
        }

        return false;
    }

}
