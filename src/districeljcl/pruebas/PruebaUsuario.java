/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.pruebas;

import districeljcl.modelo.Rol;
import districeljcl.modelo.Usuario;
import districeljcl.util.Seguridad;

public class PruebaUsuario {
    
    public static void main(String[] args) {
        
        System.out.println("PRUEBA DE LA CLASE USUARIO");
        System.out.println("----------------------------");

        // 1. Crear un rol
        Rol rolAdministrador = new Rol(
                1,
                "Administrador",
                "Acceso completo al sistema"
        );

        // 2. Generar hash de una contraseña
        String hash = Seguridad.generarHash("Clave123");

        // 3. Crear un usuario
        Usuario usuario = new Usuario(
                "carlos",
                hash,
                "Carlos",
                "Ramirez",
                rolAdministrador
        );

        // 4. Asignar información adicional
        usuario.setIdUsuario(1);
        usuario.setTipoDocumento("CC");
        usuario.setDocumento("1234567890");
        usuario.setTelefono("3001234567");
        usuario.setCorreo("carlos@districeljcl.com");
        usuario.setDireccion("Cali");

        // 5. Mostrar información
        System.out.println("\nINFORMACION DEL USUARIO");

        System.out.println("ID: " + usuario.getIdUsuario());
        System.out.println("Usuario: " + usuario.getNombreUsuario());
        System.out.println("Nombre completo: "
                + usuario.obtenerNombreCompleto());
        System.out.println("Rol: "
                + usuario.getRol().getNombreRol());
        System.out.println("Estado: " + usuario.getEstado());

        // 6. Comprobar el rol
        System.out.println("\nVERIFICACION DEL ROL");

        System.out.println("Es administrador: "
                + usuario.esAdministrador());

        System.out.println("Es vendedor: "
                + usuario.esVendedor());

        System.out.println("Es tecnico: "
                + usuario.esTecnico());

        // 7. Comprobar contraseña
        System.out.println("\nVERIFICACION DE CONTRASENA");

        System.out.println("Contraseña correcta: "
                + usuario.verificarContrasena("Clave123"));

        System.out.println("Contraseña incorrecta: "
                + usuario.verificarContrasena("OtraClave"));

        // 8. Cambiar estado
        boolean resultadoEstado = usuario.cambiarEstado("Inactivo");

        System.out.println("\nCAMBIO DE ESTADO");

        System.out.println("Cambio exitoso: "
                + resultadoEstado);

        System.out.println("Nuevo estado: "
                + usuario.getEstado());

        // 9. Intentar asignar un estado inválido
        System.out.println("\nESTADO INVALIDO");

        boolean estadoInvalido = usuario.cambiarEstado("Suspendido");

        System.out.println("Cambio permitido: "
                + estadoInvalido);

        System.out.println("Estado actual: "
                + usuario.getEstado());

        // 10. Intentar asignar estado nulo
        System.out.println("\nESTADO NULO");

        boolean estadoNulo = usuario.cambiarEstado(null);

        System.out.println("Cambio permitido: "
                + estadoNulo);

        System.out.println("Estado actual: "
                + usuario.getEstado());

        // 11. Reactivar usuario
        System.out.println("\nREACTIVACION DEL USUARIO");

        boolean reactivacion = usuario.cambiarEstado(" Activo ");

        System.out.println("Reactivacion exitosa: "
                + reactivacion);

        System.out.println("Estado actual: "
                + usuario.getEstado());

        // 12. Comprobar contraseña nula
        System.out.println("\nCONTRASENA NULA");

        System.out.println("Verificacion permitida: "
                + usuario.verificarContrasena(null));

        // 13. Crear rol Vendedor
        Rol rolVendedor = new Rol(
                2,
                "Vendedor",
                "Gestion de ventas y clientes"
        );

        Usuario vendedor = new Usuario(
                "laura",
                Seguridad.generarHash("Venta123"),
                "Laura",
                "Gomez",
                rolVendedor
        );

        System.out.println("\nVERIFICACION DEL VENDEDOR");

        System.out.println("Nombre: "
                + vendedor.obtenerNombreCompleto());

        System.out.println("Es administrador: "
                + vendedor.esAdministrador());

        System.out.println("Es vendedor: "
                + vendedor.esVendedor());

        System.out.println("Es tecnico: "
                + vendedor.esTecnico());

        // 14. Crear rol Tecnico
        Rol rolTecnico = new Rol(
                3,
                "Tecnico",
                "Gestion de reparaciones"
        );

        Usuario tecnico = new Usuario(
                "andres",
                Seguridad.generarHash("Tecnico123"),
                "Andres",
                "Martinez",
                rolTecnico
        );

        System.out.println("\nVERIFICACION DEL TECNICO");

        System.out.println("Nombre: "
                + tecnico.obtenerNombreCompleto());

        System.out.println("Es administrador: "
                + tecnico.esAdministrador());

        System.out.println("Es vendedor: "
                + tecnico.esVendedor());

        System.out.println("Es tecnico: "
                + tecnico.esTecnico());

        // 15. Comprobar rol nulo
        System.out.println("\nROL NULO");

        Usuario usuarioSinRol = new Usuario(
                "sinrol",
                Seguridad.generarHash("Prueba123"),
                "Pedro",
                "Lopez",
                null
        );

        System.out.println("Es administrador: "
                + usuarioSinRol.esAdministrador());

        System.out.println("Es vendedor: "
                + usuarioSinRol.esVendedor());

        System.out.println("Es tecnico: "
                + usuarioSinRol.esTecnico());

        // 16. Comprobar constructor vacío
        System.out.println("\nCONSTRUCTOR VACIO");

        Usuario usuarioVacio = new Usuario();

        System.out.println("Nombre completo: ["
                + usuarioVacio.obtenerNombreCompleto() + "]");

        System.out.println("Es administrador: "
                + usuarioVacio.esAdministrador());

        System.out.println("Estado inicial: "
                + usuarioVacio.getEstado());

        // 17. Información final
        System.out.println("\nINFORMACION FINAL");

        System.out.println("Administrador: "
                + usuario.obtenerNombreCompleto());

        System.out.println("Vendedor: "
                + vendedor.obtenerNombreCompleto());

        System.out.println("Tecnico: "
                + tecnico.obtenerNombreCompleto());

        System.out.println("\nFIN DE LA PRUEBA.");
    }
}
