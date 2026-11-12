/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.controlador.CelularControlador;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Marca;
import districeljcl.repositorio.CelularRepositorio;
import districeljcl.repositorio.MarcaRepositorio;

public class PruebaCelularControlador {
    
    public static void main(String[] args) {

        MarcaRepositorio marcas = new MarcaRepositorio();
        CelularRepositorio celulares = new CelularRepositorio();

        CelularControlador controlador =
                new CelularControlador(celulares, marcas);

        // 1. Mostrar marcas disponibles
        System.out.println("MARCAS DISPONIBLES");

        for (Marca m : controlador.listarMarcas()) {
            System.out.println(
                    m.getIdMarca() + " - "
                    + m.getNombreMarca());
        }

        // 2. Guardar celulares
        System.out.println("\nREGISTRO DE CELULARES");

        System.out.println(controlador.guardarCelular(
                1, "Galaxy A54", "111111111111111",
                "Usado", "950000"));

        System.out.println(controlador.guardarCelular(
                2, "iPhone 13", "222222222222222",
                "Usado", "1800000"));

        // 3. Probar campos vacíos
        System.out.println(controlador.guardarCelular(
                1, "", "333333333333333",
                "Usado", "800000"));

        // 4. Probar precio incorrecto
        System.out.println(controlador.guardarCelular(
                1, "Galaxy S23", "333333333333333",
                "Nuevo", "abc"));

        // 5. Probar IMEI duplicado
        System.out.println(controlador.guardarCelular(
                1, "Galaxy A54", "111111111111111",
                "Usado", "950000"));

        // 6. Listar celulares
        System.out.println("\nCELULARES REGISTRADOS");

        for (Celular c : controlador.listarCelulares()) {
            System.out.println(
                    c.getIdCelular() + " - "
                    + c.getModelo() + " - $"
                    + c.getPrecioVenta());
        }

        // 7. Buscar por modelo
        System.out.println("\nBuscar Galaxy: "
                + controlador.buscarCelulares("Galaxy").size());

        // 8. Actualizar precio
        System.out.println(controlador.actualizarPrecio(
                1, "1000000"));

        System.out.println("Precio actualizado: $"
                + controlador.buscarPorId(1).getPrecioVenta());

        // 9. Marcar un celular como vendido
        System.out.println(controlador.marcarVendido(1));

        System.out.println("Estado del celular 1: "
                + controlador.buscarPorId(1).getEstadoEquipo());
        
        
        // Intentar eliminar un celular vendido
        System.out.println(controlador.eliminarCelular(1));
        
        // Eliminar un celular disponible
        System.out.println(controlador.eliminarCelular(2));
        
        // Consultar los registros restantes
        System.out.println("Celulares restantes: "
        + controlador.listarCelulares().size());
        
        
        
        
        
        
        
        
        
        
        
        
        // Registrar otro celular para probar la actualización
        System.out.println("\nPRUEBA DE ACTUALIZACION COMPLETA");
        
        System.out.println(controlador.guardarCelular(
                3,
                "Redmi Note 12",
                "333333333333333",
                "Usado",
                "600000"));

        
        // Actualizar sus datos
        System.out.println(controlador.actualizarCelular(
                3,
                1,
                "Galaxy S23",
                "333333333333333",
                "Nuevo",
                "1200000"));

        // Consultar los datos actualizados
        Celular actualizado = controlador.buscarPorId(3);
        
        System.out.println("Modelo: " + actualizado.getModelo());
        System.out.println("Marca: "
                + actualizado.getMarca().getNombreMarca());
        System.out.println("IMEI: " + actualizado.getImei());
        System.out.println("Condicion: " + actualizado.getCondicion());
        System.out.println("Precio: $" + actualizado.getPrecioVenta());

        
        
        
        
    }
}
