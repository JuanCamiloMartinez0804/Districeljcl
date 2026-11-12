/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;


public class DetalleReparacion {

    // Atributos
    private int idDetalleReparacion;
    private Repuesto repuesto;
    private String descripcionTrabajo;
    private int cantidad;
    private double costoUnitario;
    private double precioUnitario;
    private double costoManoObra;
    private double subtotal;

    // Constructor vacío
    public DetalleReparacion() {
    }

    // Constructor principal
    public DetalleReparacion(String descripcionTrabajo,
            int cantidad, double precioUnitario,
            double costoManoObra) {

        this.descripcionTrabajo = descripcionTrabajo;

        setCantidad(cantidad);
        setPrecioUnitario(precioUnitario);
        setCostoManoObra(costoManoObra);

        this.costoUnitario = 0.0;

        calcularSubtotal();
    }

    // Calcula el subtotal del detalle
    public double calcularSubtotal() {

        subtotal = (cantidad * precioUnitario)
                + costoManoObra;

        return subtotal;
    }

    // Calcula el costo total del detalle
    public double calcularCostoTotal() {

        return (cantidad * costoUnitario)
                + costoManoObra;
    }

    // Obtiene la información del detalle
    public String obtenerInformacion() {

        String nombreRepuesto;

        if (repuesto != null) {
            nombreRepuesto = repuesto.getNombre();
        } else {
            nombreRepuesto = "Sin repuesto";
        }

        return "Trabajo: " + descripcionTrabajo
                + "\nRepuesto: " + nombreRepuesto
                + "\nCantidad: " + cantidad
                + "\nCosto unitario: " + costoUnitario
                + "\nPrecio unitario: " + precioUnitario
                + "\nMano de obra: " + costoManoObra
                + "\nSubtotal: " + calcularSubtotal();
    }

    // Getters y setters

    public int getIdDetalleReparacion() {
        return idDetalleReparacion;
    }

    public void setIdDetalleReparacion(int idDetalleReparacion) {
        this.idDetalleReparacion = idDetalleReparacion;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {

        if (cantidad >= 0) {
            this.cantidad = cantidad;
            calcularSubtotal();
        }
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {

        if (Double.isFinite(costoUnitario)
                && costoUnitario >= 0) {

            this.costoUnitario = costoUnitario;
        }
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {

        if (Double.isFinite(precioUnitario)
                && precioUnitario >= 0) {

            this.precioUnitario = precioUnitario;
            calcularSubtotal();
        }
    }

    public double getCostoManoObra() {
        return costoManoObra;
    }

    public void setCostoManoObra(double costoManoObra) {

        if (Double.isFinite(costoManoObra)
                && costoManoObra >= 0) {

            this.costoManoObra = costoManoObra;
            calcularSubtotal();
        }
    }

    public double getSubtotal() {
        return calcularSubtotal();
    }

    public void setSubtotal(double subtotal) {

        // El subtotal es calculado automáticamente.
        // No se modifica manualmente.
        calcularSubtotal();
    }
    
}
