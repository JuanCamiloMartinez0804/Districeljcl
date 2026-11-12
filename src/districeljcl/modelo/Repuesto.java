/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;


public class Repuesto {
 
    // Atributos
    private int idRepuesto;
    private String nombre;
    private String descripcion;
    private String marca;
    private String modeloCompatible;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    private int stockMinimo;
    private String estado;

    // Constructor vacío
    public Repuesto() {

        this.stock = 0;
        this.stockMinimo = 0;
        this.estado = "Activo";
    }

    // Constructor principal
    public Repuesto(String nombre, String marca,
            double precioCompra, double precioVenta, int stock) {

        this();

        this.nombre = nombre;
        this.marca = marca;

        setPrecioCompra(precioCompra);
        setPrecioVenta(precioVenta);
        setStock(stock);
    }

    // Descuenta unidades del inventario
    public boolean descontarStock(int cantidad) {

        if (!"Activo".equalsIgnoreCase(estado)) {
            return false;
        }

        if (!hayExistencias(cantidad)) {
            return false;
        }

        stock -= cantidad;

        return true;
    }

    // Aumenta unidades del inventario
    public boolean aumentarStock(int cantidad) {

        if (cantidad <= 0) {
            return false;
        }

        if (cantidad > Integer.MAX_VALUE - stock) {
            return false;
        }

        stock += cantidad;

        return true;
    }

    // Comprueba si existe al menos una unidad
    public boolean hayExistencias() {

        return stock > 0;
    }

    // Comprueba si hay suficientes unidades
    public boolean hayExistencias(int cantidad) {

        return cantidad > 0 && stock >= cantidad;
    }

    // Comprueba si necesita reposición
    public boolean necesitaReposicion() {

        return stock <= stockMinimo;
    }

    // Calcula la utilidad por unidad
    public double calcularUtilidad() {

        return precioVenta - precioCompra;
    }

    // Getters y setters

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModeloCompatible() {
        return modeloCompatible;
    }

    public void setModeloCompatible(String modeloCompatible) {
        this.modeloCompatible = modeloCompatible;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {

        if (Double.isFinite(precioCompra) && precioCompra >= 0) {
            this.precioCompra = precioCompra;
        }
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {

        if (Double.isFinite(precioVenta) && precioVenta >= 0) {
            this.precioVenta = precioVenta;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {

        if (stock >= 0) {
            this.stock = stock;
        }
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {

        if (stockMinimo >= 0) {
            this.stockMinimo = stockMinimo;
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {

        if (estado != null
                && (estado.equalsIgnoreCase("Activo")
                || estado.equalsIgnoreCase("Inactivo"))) {

            this.estado = estado.equalsIgnoreCase("Activo")
                    ? "Activo" : "Inactivo";
        }
    }
}
