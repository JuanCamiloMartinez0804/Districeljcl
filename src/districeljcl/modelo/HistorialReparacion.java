/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;


import java.time.LocalDateTime;

public class HistorialReparacion {
  
    // Atributos
    private int idHistorial;
    private Reparacion reparacion;
    private Usuario usuario;
    private LocalDateTime fechaHora;
    private String estadoAnterior;
    private String estadoNuevo;
    private String descripcionActividad;

    // Constructor vacío
    public HistorialReparacion() {
        this.fechaHora = LocalDateTime.now();
    }

    // Constructor parametrizado
    public HistorialReparacion(Reparacion reparacion,
            Usuario usuario, String estadoNuevo,
            String descripcionActividad) {

        this();

        this.reparacion = reparacion;
        this.usuario = usuario;
        this.estadoNuevo = estadoNuevo;
        this.descripcionActividad = descripcionActividad;

        if (reparacion != null) {
            this.estadoAnterior = reparacion.getEstadoReparacion();
        }
    }

    // Registra los datos de un cambio de estado
    public void registrarCambioEstado(
            String estadoAnterior, String estadoNuevo) {

        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.fechaHora = LocalDateTime.now();
    }

    // Obtiene la información del historial
    public String obtenerInformacion() {

        String numeroReparacion = reparacion != null
                ? String.valueOf(reparacion.getIdReparacion())
                : "Sin reparación";

        String nombreUsuario = usuario != null
                ? usuario.obtenerNombreCompleto()
                : "Sin usuario";

        String anterior = estadoAnterior != null
                ? estadoAnterior : "No aplica";

        String nuevo = estadoNuevo != null
                ? estadoNuevo : "No aplica";

        return "Historial: " + idHistorial
                + "\nReparacion: " + numeroReparacion
                + "\nUsuario: " + nombreUsuario
                + "\nFecha y hora: " + fechaHora
                + "\nEstado anterior: " + anterior
                + "\nEstado nuevo: " + nuevo
                + "\nActividad: " + descripcionActividad;
    }

    // Getters y setters

    public int getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getEstadoNuevo() {
        return estadoNuevo;
    }

    public void setEstadoNuevo(String estadoNuevo) {
        this.estadoNuevo = estadoNuevo;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }
}
