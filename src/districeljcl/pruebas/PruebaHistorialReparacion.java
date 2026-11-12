/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;



import districeljcl.modelo.Rol;
import districeljcl.modelo.Usuario;
import districeljcl.modelo.Cliente;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Marca;
import districeljcl.modelo.Reparacion;
import districeljcl.modelo.HistorialReparacion;

public class PruebaHistorialReparacion {
    
    
    public static void main(String[] args) {

        System.out.println("PRUEBA DEL HISTORIAL DE REPARACIONES");
        System.out.println("------------------------------------");

        // 1. Crear usuario
        Rol rolTecnico = new Rol(
                1, "Tecnico", "Personal tecnico"
        );

        Usuario tecnico = new Usuario(
                "tecnico01",
                "hash_prueba",
                "Carlos",
                "Ramirez",
                rolTecnico
        );

        tecnico.setIdUsuario(1);

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
                tecnico,
                tecnico,
                "Pantalla rota"
        );

        reparacion.setIdReparacion(1);

        System.out.println("\nESTADO INICIAL");
        System.out.println(
                "Estado: " + reparacion.getEstadoReparacion()
        );

        // 5. Registrar cambio de estado
        boolean cambioExitoso = reparacion.actualizarEstado(
                "En diagnóstico",
                tecnico
        );

        System.out.println("\nCAMBIO DE ESTADO");
        System.out.println(
                "Cambio exitoso: " + cambioExitoso
        );
        System.out.println(
                "Estado actual: " + reparacion.getEstadoReparacion()
        );

        // 6. Obtener el registro histórico generado
        HistorialReparacion historial = null;

        if (!reparacion.getHistorial().isEmpty()) {
            historial = reparacion.getHistorial().get(0);
        }

        // 7. Mostrar información del historial
        System.out.println("\nINFORMACION DEL HISTORIAL");

        if (historial != null) {
            System.out.println(historial.obtenerInformacion());
        } else {
            System.out.println("No se registraron cambios.");
        }

        System.out.println("\nFIN DE LA PRUEBA");
    }
    
}
