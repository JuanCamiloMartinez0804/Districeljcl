/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import java.time.LocalDateTime;


public class Entrega {
 
    // Atributos
    private int idEntrega;
    private Reparacion reparacion;
    private Usuario usuarioEntrega;
    private LocalDateTime fechaEntrega;
    private String nombreRecibe;
    private String tipoDocumentoRecibe;
    private String documentoRecibe;
    private String observaciones;

    // Constructor vacío
    public Entrega() {

        // La fecha se asignará al registrar la entrega.
        this.fechaEntrega = null;
    }

    // Constructor principal
    public Entrega(Reparacion reparacion,
            Usuario usuarioEntrega, String nombreRecibe,
            String tipoDocumentoRecibe, String documentoRecibe) {

        this();

        this.reparacion = reparacion;
        this.usuarioEntrega = usuarioEntrega;
        this.nombreRecibe = nombreRecibe;
        this.tipoDocumentoRecibe = tipoDocumentoRecibe;
        this.documentoRecibe = documentoRecibe;
    }

    // Registrar entrega
    public boolean registrarEntrega() {

        // Validar información obligatoria
        if (reparacion == null
                || usuarioEntrega == null
                || nombreRecibe == null
                || nombreRecibe.isBlank()
                || tipoDocumentoRecibe == null
                || tipoDocumentoRecibe.isBlank()
                || documentoRecibe == null
                || documentoRecibe.isBlank()) {

            return false;
        }

        // Evitar registrar la misma entrega dos veces
        if (fechaEntrega != null) {
            return false;
        }

        // La reparación debe estar finalizada
        if (!"Reparado".equalsIgnoreCase(
                reparacion.getEstadoReparacion())) {

            return false;
        }

        // Actualizar estado de la reparación
        boolean estadoActualizado =
                reparacion.actualizarEstado(
                        "Entregado", usuarioEntrega
                );

        if (!estadoActualizado) {
            return false;
        }

        // Registrar fecha solamente si la entrega fue exitosa
        this.fechaEntrega = LocalDateTime.now();

        return true;
    }

    // Obtener comprobante de entrega
    public String obtenerComprobante() {

        String equipo = "No disponible";

        if (reparacion != null
                && reparacion.getCelular() != null) {

            Celular celular = reparacion.getCelular();

            String marca = celular.getMarca() != null
                    ? celular.getMarca().getNombreMarca()
                    : "Sin marca";

            equipo = marca + " " + celular.getModelo();
        }

        return "COMPROBANTE DE ENTREGA"
                + "\n----------------------------"
                + "\nEntrega: " + idEntrega
                + "\nFecha: "
                + (fechaEntrega != null
                        ? fechaEntrega
                        : "Pendiente")
                + "\nReparacion: "
                + (reparacion != null
                        ? reparacion.getIdReparacion()
                        : "No asignada")
                + "\nCliente: "
                + (reparacion != null
                        && reparacion.getCliente() != null
                        ? reparacion.getCliente().obtenerNombreCompleto()
                        : "No disponible")
                + "\nEquipo: " + equipo
                + "\nRecibe: " + nombreRecibe
                + "\nTipo de documento: " + tipoDocumentoRecibe
                + "\nDocumento: " + documentoRecibe
                + "\nUsuario que entrega: "
                + (usuarioEntrega != null
                        ? usuarioEntrega.obtenerNombreCompleto()
                        : "No asignado")
                + "\nObservaciones: " + observaciones;
    }

    // Getters y setters

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    public Usuario getUsuarioEntrega() {
        return usuarioEntrega;
    }

    public void setUsuarioEntrega(Usuario usuarioEntrega) {
        this.usuarioEntrega = usuarioEntrega;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public void setNombreRecibe(String nombreRecibe) {
        this.nombreRecibe = nombreRecibe;
    }

    public String getTipoDocumentoRecibe() {
        return tipoDocumentoRecibe;
    }

    public void setTipoDocumentoRecibe(String tipoDocumentoRecibe) {
        this.tipoDocumentoRecibe = tipoDocumentoRecibe;
    }

    public String getDocumentoRecibe() {
        return documentoRecibe;
    }

    public void setDocumentoRecibe(String documentoRecibe) {
        this.documentoRecibe = documentoRecibe;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
