/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Marca;
import districeljcl.repositorio.MarcaRepositorio;

public class PruebaMarcaRepositorio {
 
    public static void main(String[] args) {

        MarcaRepositorio repo = new MarcaRepositorio();

        // Listar marcas
        System.out.println("MARCAS REGISTRADAS");

        for (Marca m : repo.listar()) {
            System.out.println(
                    m.getIdMarca() + " - "
                    + m.getNombreMarca());
        }

        // Buscar por ID
        Marca encontrada = repo.buscarPorId(1);

        System.out.println("\nBuscar ID 1: "
                + encontrada.getNombreMarca());

        // Buscar por nombre
        Marca apple = repo.buscarPorNombre("Apple");

        System.out.println("Buscar Apple: "
                + apple.getIdMarca());

        // Guardar una marca
        repo.guardar(new Marca(0, "Honor"));

        System.out.println("Marcas registradas: "
                + repo.listar().size());

        // Actualizar una marca
        Marca nueva = new Marca(5, "HONOR");
        repo.actualizar(nueva);

        System.out.println("Marca actualizada: "
                + repo.buscarPorId(5).getNombreMarca());

        // Eliminar una marca
        repo.eliminar(5);

        System.out.println("Marcas restantes: "
                + repo.listar().size());
    }
}
