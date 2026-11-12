/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Celular;
import districeljcl.repositorio.CelularRepositorio;


public class PruebaCelularRepositorio {
 
    public static void main(String[] args) {

        CelularRepositorio repo = new CelularRepositorio();

        Celular celular1 = new Celular();
        celular1.setModelo("Galaxy A54");
        celular1.setImei("123456789012345");
        celular1.setPrecioVenta(950000);

        Celular celular2 = new Celular();
        celular2.setModelo("iPhone 13");
        celular2.setImei("987654321098765");
        celular2.setPrecioVenta(1800000);

        repo.guardar(celular1);
        repo.guardar(celular2);

        System.out.println("CELULARES REGISTRADOS");

        for (Celular c : repo.listar()) {
            System.out.println(
                c.getIdCelular() + " - "
                + c.getModelo() + " - $"
                + c.getPrecioVenta()
            );
        }

        System.out.println();

        Celular encontrado = repo.buscarPorId(1);
        System.out.println("Buscar ID 1: "
                + encontrado.getModelo());

        System.out.println("Buscar Galaxy: "
                + repo.buscarPorModelo("Galaxy").size());

        repo.marcarVendido(1);

        System.out.println("Estado del celular 1: "
                + celular1.getEstadoEquipo());
    }
}
