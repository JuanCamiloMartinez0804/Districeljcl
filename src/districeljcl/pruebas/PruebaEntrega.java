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
import districeljcl.modelo.Reparacion;
import districeljcl.modelo.DetalleReparacion;
import districeljcl.modelo.Entrega;

public class PruebaEntrega {
    
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DEL MODULO DE ENTREGAS");
        System.out.println("-----------------------------");

        // 1. Crear usuario
        Rol rol = new Rol(
                1, "Tecnico", "Personal tecnico"
        );

        Usuario tecnico = new Usuario(
                "tecnico01",
                "hash_prueba",
                "Carlos",
                "Ramirez",
                rol
        );

        Usuario empleado = new Usuario(
                "empleado01",
                "hash_prueba",
                "Laura",
                "Gomez",
                rol
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

        // 4. Crear reparación
        Reparacion reparacion = new Reparacion(
                celular,
                cliente,
                empleado,
                tecnico,
                "Pantalla rota"
        );

        reparacion.setIdReparacion(1);

        // 5. Agregar detalle a la reparación
        DetalleReparacion detalle = new DetalleReparacion(
                "Cambio de pantalla",
                1,
                180000,
                50000
        );

        reparacion.agregarDetalle(detalle);

        // 6. Finalizar reparación
        boolean finalizada =
                reparacion.finalizarReparacion(tecnico);

        System.out.println("\nFINALIZACION DE REPARACION");
        System.out.println("Finalizacion exitosa: " + finalizada);

        System.out.println("\nESTADO DE LA REPARACION");
        System.out.println(reparacion.getEstadoReparacion());

        // 7. Crear entrega
        Entrega entrega = new Entrega(
                reparacion,
                empleado,
                "Andres Gonzalez",
                "CC",
                "123456789"
        );

        entrega.setIdEntrega(1);
        entrega.setObservaciones(
                "Equipo entregado en buenas condiciones"
        );

        // 8. Registrar entrega
        boolean resultado = entrega.registrarEntrega();

        System.out.println("\nREGISTRO DE ENTREGA");
        System.out.println("Resultado: " + resultado);
        System.out.println("Fecha de entrega: "
                + entrega.getFechaEntrega());

        // 9. Mostrar estado final
        System.out.println("\nESTADO FINAL DE LA REPARACION");
        System.out.println(reparacion.getEstadoReparacion());

        // 10. Mostrar comprobante
        System.out.println("\nCOMPROBANTE");
        System.out.println(entrega.obtenerComprobante());

        // 11. Intentar registrar la misma entrega nuevamente
        System.out.println("\nPRUEBA DE ENTREGA DUPLICADA");

        boolean entregaDuplicada = entrega.registrarEntrega();

        System.out.println("Segunda entrega permitida: "
                + entregaDuplicada);

        // 12. Intentar entregar una reparación no finalizada
        System.out.println("\nPRUEBA DE REPARACION PENDIENTE");

        Celular otroCelular = new Celular(
                marca,
                "Galaxy S22",
                "987654321098765",
                "Usado"
        );

        Reparacion reparacionPendiente = new Reparacion(
                otroCelular,
                cliente,
                empleado,
                tecnico,
                "Problema de bateria"
        );

        reparacionPendiente.setIdReparacion(2);

        Entrega entregaPendiente = new Entrega(
                reparacionPendiente,
                empleado,
                "Andres Gonzalez",
                "CC",
                "123456789"
        );

        boolean resultadoPendiente =
                entregaPendiente.registrarEntrega();

        System.out.println("Estado de reparacion: "
                + reparacionPendiente.getEstadoReparacion());

        System.out.println("Entrega permitida: "
                + resultadoPendiente);

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
