/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Reparacion;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Cliente;
import districeljcl.repositorio.ReparacionRepositorio;



public class PruebaReparacionRepositorio {
    
    public static void main(String[] args) {

        ReparacionRepositorio repo =
                new ReparacionRepositorio();

        // Crear celulares
        Celular celular1 = new Celular();
        celular1.setModelo("Galaxy A54");

        Celular celular2 = new Celular();
        celular2.setModelo("Redmi Note 12");
        
        // Crear clientes
        Cliente cliente1 = new Cliente(
        "Carlos", "Ramirez", "CC", "12345678");
        
        Cliente cliente2 = new Cliente(
        "Laura", "Gomez", "CC", "87654321");
        // Crear reparaciones
        Reparacion reparacion1 = new Reparacion();
        reparacion1.setCelular(celular1);
        reparacion1.setCliente(cliente1);
        reparacion1.setDescripcionProblema(
                "La pantalla no enciende");

        Reparacion reparacion2 = new Reparacion();
        reparacion2.setCelular(celular2);
        reparacion2.setCliente(cliente2);
        reparacion2.setDescripcionProblema(
                "La bateria se descarga rapido");

        // Guardar reparaciones
        repo.guardar(reparacion1);
        repo.guardar(reparacion2);

        System.out.println("REPARACIONES REGISTRADAS");

        for (Reparacion r : repo.listar()) {
            System.out.println(
                    r.getIdReparacion() + " - "
                    + r.getCelular().getModelo() + " - "
                    + r.getDescripcionProblema());
        }

        // Buscar por ID
        Reparacion encontrada = repo.buscarPorId(1);

        System.out.println("\nBuscar ID 1: "
                + encontrada.getCelular().getModelo());

        // Actualizar diagnóstico
        reparacion1.actualizarDiagnostico(
                "Pantalla defectuosa");

        repo.actualizar(reparacion1);

        System.out.println("Diagnostico actualizado: "
                + repo.buscarPorId(1).getDiagnostico());

        // Buscar por estado
        System.out.println("Reparaciones en estado inicial: "
                + repo.buscarPorEstado(
                    reparacion1.getEstadoReparacion()).size());

        // Eliminar una reparación
        repo.eliminar(2);

        System.out.println("Reparaciones restantes: "
                + repo.listar().size());
    }
}
