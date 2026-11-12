/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reparacion {
 
    // Atributos
    private int idReparacion;
    private Celular celular;
    private Cliente cliente;
    private Usuario usuarioRecibe;
    private Usuario tecnico;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaFinalizacion;
    private String descripcionProblema;
    private String diagnostico;
    private double totalReparacion;
    private String estadoReparacion;
    private ArrayList<DetalleReparacion> detalles;
    private ArrayList<HistorialReparacion> historial;

    // Constructor vacío
    public Reparacion() {
        this.fechaIngreso = LocalDateTime.now();
        this.totalReparacion = 0.0;
        this.estadoReparacion = "Recibido";
        this.detalles = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    // Constructor principal
    public Reparacion(Celular celular, Cliente cliente,
            Usuario usuarioRecibe, Usuario tecnico,
            String descripcionProblema) {

        this();

        this.celular = celular;
        this.cliente = cliente;
        this.usuarioRecibe = usuarioRecibe;
        this.tecnico = tecnico;
        this.descripcionProblema = descripcionProblema;
    }

    // Asigna un técnico a la reparación
    public void asignarTecnico(Usuario tecnico) {
        if (tecnico != null && tecnico.esTecnico()) {
            this.tecnico = tecnico;
        }
    }

    // Actualiza el diagnóstico
    public void actualizarDiagnostico(String diagnostico) {
        if (diagnostico != null && !diagnostico.isBlank()) {
            this.diagnostico = diagnostico;
        }
    }

    // Actualiza el estado y registra el cambio
    public boolean actualizarEstado(String nuevoEstado, Usuario usuario) {

        if (usuario == null || nuevoEstado == null
                || nuevoEstado.isBlank()) {
            return false;
        }

        // Comprobar estados permitidos
        switch (nuevoEstado) {
            case "Recibido":
            case "En diagnóstico":
            case "En reparación":
            case "Reparado":
            case "Entregado":
            case "Cancelado":
                break;
            default:
                return false;
        }

        // Evitar cambios innecesarios
        if (nuevoEstado.equals(estadoReparacion)) {
            return false;
        }

        // Una reparación entregada o cancelada no cambia de estado
        if ("Entregado".equals(estadoReparacion)
                || "Cancelado".equals(estadoReparacion)) {
            return false;
        }

        String estadoAnterior = estadoReparacion;

        // Crear registro del historial
        HistorialReparacion registro = new HistorialReparacion();

        registro.setReparacion(this);
        registro.setUsuario(usuario);
        registro.setEstadoAnterior(estadoAnterior);
        registro.setEstadoNuevo(nuevoEstado);
        registro.setFechaHora(LocalDateTime.now());
        registro.setDescripcionActividad(
                "Cambio de estado de " + estadoAnterior
                + " a " + nuevoEstado
        );

        // Actualizar estado y guardar historial
        this.estadoReparacion = nuevoEstado;
        historial.add(registro);

        if ("Reparado".equals(nuevoEstado)
                && fechaFinalizacion == null) {
            fechaFinalizacion = LocalDateTime.now();
        }

        return true;
    }

    // Registra una actividad sin cambiar el estado
    public boolean registrarActividad(Usuario usuario,
            String descripcion) {

        if (usuario == null || descripcion == null
                || descripcion.isBlank()) {
            return false;
        }

        HistorialReparacion registro = new HistorialReparacion();

        registro.setReparacion(this);
        registro.setUsuario(usuario);
        registro.setFechaHora(LocalDateTime.now());
        registro.setDescripcionActividad(descripcion);

        // No hubo cambio de estado
        registro.setEstadoAnterior(null);
        registro.setEstadoNuevo(null);

        historial.add(registro);

        return true;
    }

    // Agrega un detalle a la reparación
    public void agregarDetalle(DetalleReparacion detalle) {

        if (detalle != null) {
            detalles.add(detalle);
            calcularTotal();
        }
    }

    // Calcula el total de la reparación
    public double calcularTotal() {

        totalReparacion = 0.0;

        for (DetalleReparacion detalle : detalles) {
            totalReparacion += detalle.calcularSubtotal();
        }

        return totalReparacion;
    }

    // Finaliza la reparación
    public boolean finalizarReparacion(Usuario usuario) {

        if (usuario == null || tecnico == null
                || !usuario.esTecnico()
                || usuario != tecnico) {
            return false;
        }

        if (detalles.isEmpty()) {
            return false;
        }

        if ("Entregado".equals(estadoReparacion)
                || "Cancelado".equals(estadoReparacion)
                || "Reparado".equals(estadoReparacion)) {
            return false;
        }

        calcularTotal();

        return actualizarEstado("Reparado", usuario);
    }

    // Getters y setters

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuarioRecibe() {
        return usuarioRecibe;
    }

    public void setUsuarioRecibe(Usuario usuarioRecibe) {
        this.usuarioRecibe = usuarioRecibe;
    }

    public Usuario getTecnico() {
        return tecnico;
    }

    public void setTecnico(Usuario tecnico) {
        asignarTecnico(tecnico);
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        actualizarDiagnostico(diagnostico);
    }

    public double getTotalReparacion() {
        return totalReparacion;
    }

    public void setTotalReparacion(double totalReparacion) {
        this.totalReparacion = totalReparacion;
    }

    public String getEstadoReparacion() {
        return estadoReparacion;
    }

    public void setEstadoReparacion(String estadoReparacion) {
        // Se requiere un usuario responsable para cambiar el estado.
        // Utilizar actualizarEstado(nuevoEstado, usuario).
    }

    public ArrayList<DetalleReparacion> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleReparacion> detalles) {
        if (detalles != null) {
            this.detalles = detalles;
            calcularTotal();
        }
    }

    public ArrayList<HistorialReparacion> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<HistorialReparacion> historial) {
        if (historial != null) {
            this.historial = historial;
        }
    }
}
