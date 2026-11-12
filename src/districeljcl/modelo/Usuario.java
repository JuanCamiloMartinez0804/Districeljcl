/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import districeljcl.util.Seguridad;

public class Usuario {
 
    // Atributos
    private int idUsuario;
    private Rol rol;
    private String nombreUsuario;
    private String contrasenaHash;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String documento;
    private String telefono;
    private String correo;
    private String direccion;
    private String estado;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor principal
    public Usuario(String nombreUsuario, String contrasenaHash,
            String nombre, String apellido, Rol rol) {

        this.nombreUsuario = nombreUsuario;
        this.contrasenaHash = contrasenaHash;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.estado = "Activo";
    }

    // Verifica si la contraseña ingresada es correcta
    public boolean verificarContrasena(String contrasena) {

        if (contrasena == null || contrasenaHash == null
                || contrasenaHash.isBlank()) {
            return false;
        }

        return Seguridad.verificarContrasena(
                contrasena,
                contrasenaHash
        );
    }

    // Verifica si el usuario tiene el rol de administrador
    public boolean esAdministrador() {

        return rol != null
                && rol.getNombreRol() != null
                && rol.getNombreRol().equalsIgnoreCase("Administrador");
    }

    // Verifica si el usuario tiene el rol de vendedor
    public boolean esVendedor() {

        return rol != null
                && rol.getNombreRol() != null
                && rol.getNombreRol().equalsIgnoreCase("Vendedor");
    }

    // Verifica si el usuario tiene el rol de técnico
    public boolean esTecnico() {

        if (rol == null || rol.getNombreRol() == null) {
            return false;
        }

        return rol.getNombreRol().equalsIgnoreCase("Tecnico")
                || rol.getNombreRol().equalsIgnoreCase("Técnico");
    }

    // Cambia el estado del usuario
    public boolean cambiarEstado(String estado) {

        if (estado == null || estado.isBlank()) {
            return false;
        }

        String nuevoEstado = estado.trim();

        if (!nuevoEstado.equalsIgnoreCase("Activo")
                && !nuevoEstado.equalsIgnoreCase("Inactivo")) {
            return false;
        }

        if (nuevoEstado.equalsIgnoreCase("Activo")) {
            this.estado = "Activo";
        } else {
            this.estado = "Inactivo";
        }

        return true;
    }

    // Obtiene el nombre completo del usuario
    public String obtenerNombreCompleto() {

        String nombreCompleto = nombre != null
                ? nombre.trim() : "";

        String apellidoCompleto = apellido != null
                ? apellido.trim() : "";

        return (nombreCompleto + " " + apellidoCompleto).trim();
    }

    // Getters y setters

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        cambiarEstado(estado);
    }
}
