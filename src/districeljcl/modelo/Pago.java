/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import java.time.LocalDateTime;

public class Pago {
  
    // Atributos
    private int idPago;
    private Venta venta;
    private Reparacion reparacion;
    private Usuario usuarioRecibePago;
    private LocalDateTime fechaPago;
    private double valorPago;
    private String metodoPago;
    private String estadoPago;
    private String referenciaPago;

    // Constructor vacío
    public Pago() {

        this.fechaPago = LocalDateTime.now();
        this.estadoPago = "Registrado";
    }

    // Constructor principal
    public Pago(Usuario usuarioRecibePago,
            double valorPago, String metodoPago) {

        this();

        this.usuarioRecibePago = usuarioRecibePago;
        setValorPago(valorPago);
        setMetodoPago(metodoPago);
    }

    // Registrar pago de una venta
    public boolean registrarPagoVenta(Venta venta) {

        if (venta == null
                || usuarioRecibePago == null
                || !Double.isFinite(valorPago)
                || valorPago <= 0
                || metodoPago == null
                || metodoPago.isBlank()) {
            return false;
        }

        // No permitir asociar nuevamente un pago
        if (this.venta != null || this.reparacion != null) {
            return false;
        }

        // Verificar que la venta esté confirmada
        if (!"Confirmada".equalsIgnoreCase(
                venta.getEstadoVenta())) {
            return false;
        }

        this.venta = venta;
        this.reparacion = null;

        return true;
    }

    // Registrar pago de una reparación
    public boolean registrarPagoReparacion(Reparacion reparacion) {

        if (reparacion == null
                || usuarioRecibePago == null
                || !Double.isFinite(valorPago)
                || valorPago <= 0
                || metodoPago == null
                || metodoPago.isBlank()) {
            return false;
        }

        // No permitir asociar nuevamente un pago
        if (this.venta != null || this.reparacion != null) {
            return false;
        }

        // Verificar que la reparación esté finalizada
        if (!"Reparado".equalsIgnoreCase(
                reparacion.getEstadoReparacion())
                && !"Entregado".equalsIgnoreCase(
                        reparacion.getEstadoReparacion())) {
            return false;
        }

        this.reparacion = reparacion;
        this.venta = null;

        return true;
    }

    // Cambiar estado del pago
    public boolean cambiarEstado(String nuevoEstado) {

        if (nuevoEstado == null || nuevoEstado.isBlank()) {
            return false;
        }

        // Estados permitidos
        switch (nuevoEstado) {

            case "Registrado":
            case "Confirmado":
            case "Rechazado":
            case "Anulado":
                break;

            default:
                return false;
        }

        // No repetir el mismo estado
        if (nuevoEstado.equals(estadoPago)) {
            return false;
        }

        // No modificar pagos anulados o rechazados
        if ("Anulado".equals(estadoPago)
                || "Rechazado".equals(estadoPago)) {
            return false;
        }

        this.estadoPago = nuevoEstado;

        return true;
    }

    // Obtener información del pago
    public String obtenerInformacion() {

        String destino;

        if (venta != null) {

            destino = "Venta: " + venta.getIdVenta();

        } else if (reparacion != null) {

            destino = "Reparacion: "
                    + reparacion.getIdReparacion();

        } else {

            destino = "Sin venta ni reparacion asociada";
        }

        return "Pago: " + idPago
                + "\n" + destino
                + "\nUsuario: "
                + (usuarioRecibePago != null
                        ? usuarioRecibePago.obtenerNombreCompleto()
                        : "No asignado")
                + "\nFecha: " + fechaPago
                + "\nValor: $" + valorPago
                + "\nMetodo: " + metodoPago
                + "\nEstado: " + estadoPago
                + "\nReferencia: " + referenciaPago;
    }

    // Getters y setters

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
        if (venta != null) {
            this.reparacion = null;
        }
    }

    public Reparacion getReparacion() {
        return reparacion;
    }

    public void setReparacion(Reparacion reparacion) {
        this.reparacion = reparacion;
        if (reparacion != null) {
            this.venta = null;
        }
    }

    public Usuario getUsuarioRecibePago() {
        return usuarioRecibePago;
    }

    public void setUsuarioRecibePago(Usuario usuarioRecibePago) {
        this.usuarioRecibePago = usuarioRecibePago;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {

        if (Double.isFinite(valorPago) && valorPago > 0) {
            this.valorPago = valorPago;
        }
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {

        if (metodoPago != null && !metodoPago.isBlank()) {
            this.metodoPago = metodoPago;
        }
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        cambiarEstado(estadoPago);
    }

    public String getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(String referenciaPago) {
        this.referenciaPago = referenciaPago;
    }
    
}
