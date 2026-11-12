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
import districeljcl.modelo.Venta;
import districeljcl.modelo.Reparacion;
import districeljcl.modelo.Repuesto;
import districeljcl.modelo.DetalleReparacion;
import districeljcl.modelo.Pago;


public class PruebaPago {
    
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DEL MODULO DE PAGOS");
        System.out.println("--------------------------");

        // 1. Crear usuario
        Rol rol = new Rol(
                1, "Administrador", "Administrador del sistema"
        );

        Usuario usuario = new Usuario(
                "admin01",
                "hash_prueba",
                "Juan",
                "Martinez",
                rol
        );

        usuario.setIdUsuario(1);

        // Crear técnico para finalizar la reparación
        Rol rolTecnico = new Rol(
                2, "Tecnico", "Personal tecnico"
        );

        Usuario tecnico = new Usuario(
                "tecnico01",
                "hash_prueba",
                "Carlos",
                "Ramirez",
                rolTecnico
        );

        tecnico.setIdUsuario(2);

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
                "Galaxy S23",
                "123456789012345",
                "Nuevo"
        );

        celular.setIdCelular(1);
        celular.setCostoCompra(400000);
        celular.setPrecioVenta(500000);

        // 4. Crear venta
        Venta venta = new Venta(cliente, usuario);
        venta.setIdVenta(1);

        boolean agregado = venta.agregarCelular(celular, 0);
        boolean ventaConfirmada = venta.confirmar();

        System.out.println("\nVENTA REGISTRADA");
        System.out.println("Celular agregado: " + agregado);
        System.out.println("Venta confirmada: " + ventaConfirmada);
        System.out.println("Total venta: $" + venta.calcularTotal());

        // 5. Crear pago de venta
        Pago pagoVenta = new Pago(
                usuario,
                500000,
                "Efectivo"
        );

        pagoVenta.setIdPago(1);
        pagoVenta.setReferenciaPago("VENTA-001");

        boolean resultadoVenta =
                pagoVenta.registrarPagoVenta(venta);

        System.out.println("\nPAGO DE VENTA");
        System.out.println("Registro exitoso: " + resultadoVenta);
        System.out.println(pagoVenta.obtenerInformacion());

        // 6. Cambiar estado del pago
        boolean estadoActualizado =
                pagoVenta.cambiarEstado("Confirmado");

        System.out.println("\nESTADO ACTUALIZADO");
        System.out.println("Cambio exitoso: " + estadoActualizado);
        System.out.println("Estado: " + pagoVenta.getEstadoPago());

        // 7. Crear reparación
        Celular celularReparacion = new Celular(
                marca,
                "Galaxy A54",
                "987654321098765",
                "Usado"
        );

        celularReparacion.setIdCelular(2);

        Reparacion reparacion = new Reparacion(
                celularReparacion,
                cliente,
                usuario,
                tecnico,
                "Problema de bateria"
        );

        reparacion.setIdReparacion(1);

        // Crear repuesto
        Repuesto repuesto = new Repuesto(
                "Bateria",
                "Samsung",
                40000,
                70000,
                5
        );

        // Crear detalle de reparación
        DetalleReparacion detalle = new DetalleReparacion(
                "Cambio de bateria",
                1,
                70000,
                30000
        );

        detalle.setRepuesto(repuesto);
        detalle.setCostoUnitario(repuesto.getPrecioCompra());

        reparacion.agregarDetalle(detalle);

        // Finalizar reparación
        boolean reparacionFinalizada =
                reparacion.finalizarReparacion(tecnico);

        System.out.println("\nREPARACION REGISTRADA");
        System.out.println("Reparacion finalizada: "
                + reparacionFinalizada);
        System.out.println("Estado: "
                + reparacion.getEstadoReparacion());
        System.out.println("Total reparacion: $"
                + reparacion.calcularTotal());

        // 8. Crear pago de reparación
        Pago pagoReparacion = new Pago(
                usuario,
                100000,
                "Transferencia"
        );

        pagoReparacion.setIdPago(2);
        pagoReparacion.setReferenciaPago("REP-001");

        boolean resultadoReparacion =
                pagoReparacion.registrarPagoReparacion(reparacion);

        System.out.println("\nPAGO DE REPARACION");
        System.out.println("Registro exitoso: "
                + resultadoReparacion);
        System.out.println(pagoReparacion.obtenerInformacion());

        // 9. Confirmar pago de reparación
        boolean pagoConfirmado =
                pagoReparacion.cambiarEstado("Confirmado");

        System.out.println("\nCONFIRMACION DEL PAGO");
        System.out.println("Pago confirmado: " + pagoConfirmado);
        System.out.println("Estado: "
                + pagoReparacion.getEstadoPago());

        // 10. Intentar cambiar a un estado inválido
        System.out.println("\nESTADO INVALIDO");

        boolean estadoInvalido =
                pagoReparacion.cambiarEstado("Desconocido");

        System.out.println("Cambio permitido: " + estadoInvalido);
        System.out.println("Estado actual: "
                + pagoReparacion.getEstadoPago());

        System.out.println("\nFIN DE LA PRUEBA");
    }
    
}
