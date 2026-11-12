/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Repuesto;
import districeljcl.repositorio.RepuestoRepositorio;

public class PruebaRepuestoRepositorio {
 
    public static void main(String[] args) {

        RepuestoRepositorio repo = new RepuestoRepositorio();

        Repuesto repuesto1 = new Repuesto(
                "Pantalla", "Samsung", 80000, 150000, 10);

        Repuesto repuesto2 = new Repuesto(
                "Bateria", "Xiaomi", 30000, 65000, 15);

        // Guardar repuestos
        repo.guardar(repuesto1);
        repo.guardar(repuesto2);

        // Listar repuestos
        System.out.println("REPUESTOS REGISTRADOS");

        for (Repuesto r : repo.listar()) {
            System.out.println(
                    r.getIdRepuesto() + " - "
                    + r.getNombre() + " - Stock: "
                    + r.getStock());
        }

        // Buscar por ID
        Repuesto encontrado = repo.buscarPorId(1);

        System.out.println("\nBuscar ID 1: "
                + encontrado.getNombre());

        // Buscar por nombre
        System.out.println("Buscar Pantalla: "
                + repo.buscarPorNombre("Pantalla").size());

        // Descontar unidades del inventario
        repuesto1.descontarStock(3);

        System.out.println("Stock actualizado: "
                + repo.buscarPorId(1).getStock());

        // Eliminar un repuesto
        repo.eliminar(2);

        System.out.println("Repuestos restantes: "
                + repo.listar().size());
    }
}
