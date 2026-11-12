/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;



public class DetalleVenta {
 
    // Atributos
    private int idDetalleVenta;
    private Celular celular;
    private double precioVenta;
    private double costoUnitario;
    private double descuento;

    // Constructor vacío
    public DetalleVenta() {
    }

    // Constructor principal
    public DetalleVenta(Celular celular, double precioVenta,
            double costoUnitario, double descuento) {

        this();

        this.celular = celular;

        setPrecioVenta(precioVenta);
        setCostoUnitario(costoUnitario);
        setDescuento(descuento);
    }

    // Calcula el subtotal del detalle
    public double calcularSubtotal() {

        return precioVenta - descuento;
    }

    // Calcula la utilidad del detalle
    public double calcularUtilidad() {

        return calcularSubtotal() - costoUnitario;
    }

    // Obtiene la información del detalle
    public String obtenerInformacion() {

        String nombreCelular = "No asignado";

        if (celular != null) {

            String nombreMarca = celular.getMarca() != null
                    ? celular.getMarca().getNombreMarca()
                    : "Sin marca";

            nombreCelular = nombreMarca + " "
                    + celular.getModelo();
        }

        return "Celular: " + nombreCelular
                + "\nPrecio de venta: " + precioVenta
                + "\nCosto unitario: " + costoUnitario
                + "\nDescuento: " + descuento
                + "\nSubtotal: " + calcularSubtotal()
                + "\nUtilidad: " + calcularUtilidad();
    }

    // Getters y setters

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {

        if (Double.isFinite(precioVenta)
                && precioVenta >= 0
                && precioVenta >= descuento) {

            this.precioVenta = precioVenta;
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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {

        if (Double.isFinite(descuento)
                && descuento >= 0
                && descuento <= precioVenta) {

            this.descuento = descuento;
        }
    }
    
}
