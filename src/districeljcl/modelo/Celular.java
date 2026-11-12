/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import java.time.LocalDateTime;

public class Celular {

    // Atributos
    private int idCelular;
    private Marca marca;
    private String imei;
    private String modelo;
    private int almacenamiento;
    private String color;
    private String condicion;
    private String origenEquipo;
    private String estadoEquipo;
    private double costoCompra;
    private double precioVenta;
    private String rutaImagen;
    private LocalDateTime fechaRegistro;
    private String observaciones;

    // Constructor vacío
    public Celular() {
        this.estadoEquipo = "Disponible";
        this.fechaRegistro = LocalDateTime.now();
    }

    // Constructor principal
    public Celular(Marca marca, String modelo,
                   String imei, String condicion) {
        this();
        this.marca = marca;
        this.modelo = modelo;
        this.imei = imei;
        this.condicion = condicion;
    }

    // Actualiza el estado del equipo
    public boolean actualizarEstado(String estado) {
        if (estado == null || estado.isBlank()) {
            return false;
        }

        switch (estado) {
            case "Disponible":
            case "Vendido":
            case "En reparación":
            case "Reparado":
            case "Entregado":
                this.estadoEquipo = estado;
                return true;
            default:
                return false;
        }
    }

    // Actualiza el precio de venta
    public void actualizarPrecio(double precio) {
        if (Double.isFinite(precio) && precio >= 0) {
            this.precioVenta = precio;
        }
    }

    // Calcula la utilidad del equipo
    public double calcularUtilidad() {
        return precioVenta - costoCompra;
    }

    // Verifica si está disponible
    public boolean estaDisponible() {
        return "Disponible".equals(estadoEquipo);
    }

    // Obtiene la información del celular
    public String obtenerInformacion() {
        String nombreMarca = marca != null
                ? marca.getNombreMarca() : "Sin marca";

        return "ID: " + idCelular
                + "\nMarca: " + nombreMarca
                + "\nModelo: " + modelo
                + "\nIMEI: " + imei
                + "\nAlmacenamiento: " + almacenamiento + " GB"
                + "\nColor: " + color
                + "\nCondicion: " + condicion
                + "\nOrigen del equipo: " + origenEquipo
                + "\nEstado: " + estadoEquipo
                + "\nCosto de compra: " + costoCompra
                + "\nPrecio de venta: " + precioVenta
                + "\nUtilidad: " + calcularUtilidad()
                + "\nFecha de registro: " + fechaRegistro
                + "\nObservaciones: " + observaciones;
    }

    // Getters y setters
    public int getIdCelular() {
        return idCelular;
    }

    public void setIdCelular(int idCelular) {
        this.idCelular = idCelular;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getOrigenEquipo() {
        return origenEquipo;
    }

    public void setOrigenEquipo(String origenEquipo) {
        this.origenEquipo = origenEquipo;
    }

    public String getEstadoEquipo() {
        return estadoEquipo;
    }

    public void setEstadoEquipo(String estadoEquipo) {
        actualizarEstado(estadoEquipo);
    }

    public double getCostoCompra() {
        return costoCompra;
    }

    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        actualizarPrecio(precioVenta);
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
