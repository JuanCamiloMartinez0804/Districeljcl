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
import districeljcl.modelo.AutorizacionDisposicion;

public class PruebaAutorizacionDisposicion {
    
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DE AUTORIZACION DE DISPOSICION");
        System.out.println("-------------------------------------");

        // 1. Crear usuario
        Rol rol = new Rol(
                1, "Administrador", "Administrador del sistema"
        );

        Usuario administrador = new Usuario(
                "admin01",
                "hash_prueba",
                "Juan",
                "Martinez",
                rol
        );

        administrador.setIdUsuario(1);

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

        celular.setIdCelular(1);

        // 4. Crear reparación
        Reparacion reparacion = new Reparacion(
                celular,
                cliente,
                administrador,
                administrador,
                "Equipo pendiente de reclamacion"
        );

        reparacion.setIdReparacion(1);

        // 5. Crear autorización
        AutorizacionDisposicion autorizacion =
                new AutorizacionDisposicion(
                        reparacion,
                        administrador,
                        "Disposicion por abandono"
                );

        autorizacion.setIdAutorizacion(1);

        System.out.println("\nAUTORIZACION REGISTRADA");
        System.out.println(
                "Estado: " + autorizacion.getEstadoAutorizacion()
        );

        // 6. Registrar notificación
        boolean resultado = autorizacion.registrarNotificacion(
                "Correo electronico",
                "Se registra la notificacion al cliente sobre "
                + "la situacion del equipo."
        );

        System.out.println("\nREGISTRO DE NOTIFICACION");
        System.out.println("Resultado: " + resultado);
        System.out.println("Fecha de notificacion: "
                + autorizacion.getFechaNotificacionCliente());

        // 7. Cambiar estado
        // Simulamos que se obtuvo una autorización válida.
        autorizacion.setDocumentoSoporte("AUT-001.pdf");

        boolean cambioExitoso =
                autorizacion.cambiarEstado("Autorizada");

        System.out.println("\nESTADO ACTUALIZADO");
        System.out.println("Cambio exitoso: " + cambioExitoso);
        System.out.println(
                "Estado: " + autorizacion.getEstadoAutorizacion()
        );

        // 8. Mostrar información
        System.out.println("\nINFORMACION DE LA AUTORIZACION");
        System.out.println(autorizacion.obtenerInformacion());

        // 9. Intentar cambiar a un estado inválido
        System.out.println("\nPRUEBA DE ESTADO INVALIDO");

        boolean estadoInvalido =
                autorizacion.cambiarEstado("Desconocido");

        System.out.println("Cambio permitido: " + estadoInvalido);
        System.out.println("Estado actual: "
                + autorizacion.getEstadoAutorizacion());

        // 10. Comprobar el método del UML sin parámetros
        System.out.println("\nPRUEBA DE NOTIFICACION SIN PARAMETROS");

        AutorizacionDisposicion otraAutorizacion =
                new AutorizacionDisposicion(
                        reparacion,
                        administrador,
                        "Disposicion pendiente"
                );

        otraAutorizacion.setMedioNotificacion("Telefono");
        otraAutorizacion.setFundamentoDisposicion(
                "Aviso de seguimiento al cliente"
        );

        otraAutorizacion.registrarNotificacion();

        System.out.println("Notificacion registrada: "
                + (otraAutorizacion.getFechaNotificacionCliente()
                        != null));

        System.out.println("\nFIN DE LA PRUEBA");
    }
}
