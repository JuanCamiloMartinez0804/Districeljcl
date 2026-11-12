/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import java.time.LocalDateTime;

public class AutorizacionDisposicion {
 
    // Atributos
    private int idAutorizacion;
    private Reparacion reparacion;
    private Usuario usuarioResponsable;
    private LocalDateTime fechaRegistro;
    private LocalDateTime fechaNotificacionCliente;
    private String medioNotificacion;
    private String tipoDisposicion;
    private String fundamentoDisposicion;
    private String documentoSoporte;
    private String estadoAutorizacion;
    private String observaciones;

    // Constructor vacío
    public AutorizacionDisposicion() {

        this.fechaRegistro = LocalDateTime.now();
        this.estadoAutorizacion = "Pendiente";
    }

    // Constructor principal
    public AutorizacionDisposicion(Reparacion reparacion,
            Usuario usuarioResponsable, String tipoDisposicion) {

        this();

        this.reparacion = reparacion;
        this.usuarioResponsable = usuarioResponsable;
        this.tipoDisposicion = tipoDisposicion;
    }

    // Registrar notificación al cliente (UML)
    public void registrarNotificacion() {

        if (reparacion == null
                || usuarioResponsable == null
                || medioNotificacion == null
                || medioNotificacion.isBlank()
                || fundamentoDisposicion == null
                || fundamentoDisposicion.isBlank()) {
            return;
        }

        // Registrar la fecha de notificación
        this.fechaNotificacionCliente = LocalDateTime.now();
    }

    // Registrar notificación con sus datos
    public boolean registrarNotificacion(String medioNotificacion,
            String fundamentoDisposicion) {

        if (reparacion == null
                || usuarioResponsable == null
                || medioNotificacion == null
                || medioNotificacion.isBlank()
                || fundamentoDisposicion == null
                || fundamentoDisposicion.isBlank()) {
            return false;
        }

        this.medioNotificacion = medioNotificacion;
        this.fundamentoDisposicion = fundamentoDisposicion;

        registrarNotificacion();

        return fechaNotificacionCliente != null;
    }

    // Cambiar estado de la autorización
    public boolean cambiarEstado(String nuevoEstado) {

        if (nuevoEstado == null || nuevoEstado.isBlank()) {
            return false;
        }

        // Estados permitidos
        switch (nuevoEstado) {

            case "Pendiente":
            case "Autorizada":
            case "Rechazada":
            case "Anulada":
                break;

            default:
                return false;
        }

        // Evitar cambios repetidos
        if (nuevoEstado.equals(estadoAutorizacion)) {
            return false;
        }

        // No modificar autorizaciones anuladas
        if ("Anulada".equals(estadoAutorizacion)) {
            return false;
        }

        this.estadoAutorizacion = nuevoEstado;

        return true;
    }

    // Obtener información de la autorización
    public String obtenerInformacion() {

        return "AUTORIZACION DE DISPOSICION"
                + "\n----------------------------"
                + "\nAutorizacion: " + idAutorizacion
                + "\nReparacion: "
                + (reparacion != null
                        ? reparacion.getIdReparacion()
                        : "No asignada")
                + "\nUsuario responsable: "
                + (usuarioResponsable != null
                        ? usuarioResponsable.obtenerNombreCompleto()
                        : "No asignado")
                + "\nFecha de registro: " + fechaRegistro
                + "\nFecha de notificacion: "
                + fechaNotificacionCliente
                + "\nMedio de notificacion: " + medioNotificacion
                + "\nTipo de disposicion: " + tipoDisposicion
                + "\nFundamento: " + fundamentoDisposicion
                + "\nDocumento de soporte: " + documentoSoporte
                + "\nEstado: " + estadoAutorizacion
                + "\nObservaciones: " + observaciones;
    }

    // Getters y setters

    public int getIdAutorizacion() {
        return idAutorizacion;
    }

    public void setIdAutorizacion(int idAutorizacion) {
        this.idAutorizacion = idAutorizacion;
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    public Usuario getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(Usuario usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    // Métodos conservados por compatibilidad
    public Usuario getUsuarioAutoriza() {
        return usuarioResponsable;
    }

    public void setUsuarioAutoriza(Usuario usuarioAutoriza) {
        this.usuarioResponsable = usuarioAutoriza;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaNotificacionCliente() {
        return fechaNotificacionCliente;
    }

    public void setFechaNotificacionCliente(
            LocalDateTime fechaNotificacionCliente) {

        this.fechaNotificacionCliente = fechaNotificacionCliente;
    }

    public String getMedioNotificacion() {
        return medioNotificacion;
    }

    public void setMedioNotificacion(String medioNotificacion) {
        this.medioNotificacion = medioNotificacion;
    }

    public String getTipoDisposicion() {
        return tipoDisposicion;
    }

    public void setTipoDisposicion(String tipoDisposicion) {
        this.tipoDisposicion = tipoDisposicion;
    }

    public String getFundamentoDisposicion() {
        return fundamentoDisposicion;
    }

    public void setFundamentoDisposicion(String fundamentoDisposicion) {
        this.fundamentoDisposicion = fundamentoDisposicion;
    }

    public String getDocumentoSoporte() {
        return documentoSoporte;
    }

    public void setDocumentoSoporte(String documentoSoporte) {
        this.documentoSoporte = documentoSoporte;
    }

    public String getEstadoAutorizacion() {
        return estadoAutorizacion;
    }

    public void setEstadoAutorizacion(String estadoAutorizacion) {
        cambiarEstado(estadoAutorizacion);
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
}
