/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Rol;
import districeljcl.modelo.Usuario;
import districeljcl.modelo.Cliente;
import districeljcl.modelo.Marca;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Repuesto;
import districeljcl.modelo.DetalleReparacion;
import districeljcl.modelo.Reparacion;
import districeljcl.modelo.HistorialReparacion;



public class PruebaReparacion {
    
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DEL MODULO DE REPARACIONES");
        System.out.println("----------------------------------");

        // 1. Crear rol y usuarios
        Rol rolTecnico = new Rol(1, "Tecnico", "Personal tecnico");

        Usuario tecnico = new Usuario(
                "tecnico01",
                "hash_prueba",
                "Carlos",
                "Ramirez",
                rolTecnico
        );

        Usuario usuarioRecibe = new Usuario(
                "recepcion01",
                "hash_prueba",
                "Laura",
                "Gomez",
                rolTecnico
        );

        // 2. Crear cliente
        Cliente cliente = new Cliente(
                "Andres",
                "Gonzalez",
                "CC",
                "123456789"
        );

        // 3. Crear celular
        Marca marca = new Marca(1, "Samsung");

        Celular celular = new Celular(
                marca,
                "Galaxy A54",
                "123456789012345",
                "Usado"
        );

        // 4. Crear repuesto
        Repuesto repuesto = new Repuesto(
                "Pantalla",
                "Samsung",
                120000,
                180000,
                5
        );

        // 5. Crear reparación
        Reparacion reparacion = new Reparacion(
                celular,
                cliente,
                usuarioRecibe,
                tecnico,
                "Pantalla rota"
        );

        reparacion.setIdReparacion(1);

        System.out.println("\nREPARACION REGISTRADA");
        System.out.println("Cliente: " + cliente.obtenerNombreCompleto());
        System.out.println("Equipo: "
                + celular.getMarca().getNombreMarca()
                + " " + celular.getModelo());
        System.out.println("Problema: "
                + reparacion.getDescripcionProblema());
        System.out.println("Tecnico: "
                + tecnico.obtenerNombreCompleto());

        // 6. Crear detalle de reparación
        DetalleReparacion detalle = new DetalleReparacion(
                "Cambio de pantalla",
                1,
                180000,
                50000
        );

        detalle.setRepuesto(repuesto);
        detalle.setCostoUnitario(repuesto.getPrecioCompra());

        // 7. Agregar detalle a la reparación
        reparacion.agregarDetalle(detalle);

        System.out.println("\nDETALLE DEL TRABAJO");
        System.out.println(detalle.obtenerInformacion());

        // 8. Calcular total
        System.out.println("\nCALCULO DE LA REPARACION");
        System.out.println("Total: $" + reparacion.calcularTotal());

        // 9. Registrar diagnóstico
        System.out.println("\nDIAGNOSTICO");

        reparacion.actualizarDiagnostico(
                "La pantalla presenta daños y requiere reemplazo."
        );

        System.out.println("Diagnostico: "
                + reparacion.getDiagnostico());

        // 10. Actualizar estado
        System.out.println("\nACTUALIZANDO ESTADO");

        boolean cambioEstado = reparacion.actualizarEstado(
                "En reparación", tecnico
        );

        System.out.println("Cambio exitoso: " + cambioEstado);
        System.out.println("Estado actual: "
                + reparacion.getEstadoReparacion());

        // 11. Registrar actividad
        System.out.println("\nREGISTRANDO ACTIVIDAD");

        boolean actividadRegistrada = reparacion.registrarActividad(
                tecnico,
                "Se realizó el reemplazo de la pantalla."
        );

        System.out.println("Actividad registrada: "
                + actividadRegistrada);

        // 12. Finalizar reparación
        System.out.println("\nFINALIZANDO REPARACION");

        boolean resultado = reparacion.finalizarReparacion(tecnico);

        System.out.println("Resultado: " + resultado);
        System.out.println("Estado: "
                + reparacion.getEstadoReparacion());
        System.out.println("Fecha finalizacion: "
                + reparacion.getFechaFinalizacion());

        // 13. Mostrar historial
        System.out.println("\nHISTORIAL DE REPARACION");

        for (HistorialReparacion registro : reparacion.getHistorial()) {
            System.out.println("----------------------------");
            System.out.println(registro.obtenerInformacion());
        }

        System.out.println("\nCantidad de registros: "
                + reparacion.getHistorial().size());

        System.out.println("\nFIN DE LA PRUEBA");
    }
    
}
