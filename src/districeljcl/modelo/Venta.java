/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta {
 
    // Atributos
    private int idVenta;
    private Cliente cliente;
    private Usuario vendedor;
    private LocalDateTime fechaVenta;
    private ArrayList<DetalleVenta> detalles;
    private double totalVenta;
    private String estadoVenta;

    // Constructor vacío
    public Venta() {

        this.detalles = new ArrayList<>();
        this.fechaVenta = LocalDateTime.now();
        this.totalVenta = 0.0;
        this.estadoVenta = "Pendiente";
    }

    // Constructor principal
    public Venta(Cliente cliente, Usuario vendedor) {

        this();

        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    // Agrega un celular a la venta
    public boolean agregarCelular(Celular celular, double descuento) {

        if (celular == null
                || !Double.isFinite(descuento)
                || descuento < 0
                || !Double.isFinite(celular.getPrecioVenta())
                || celular.getPrecioVenta() <= 0
                || descuento >= celular.getPrecioVenta()) {
            return false;
        }

        // Solo permite agregar celulares disponibles
        if (!celular.estaDisponible()) {
            return false;
        }

        // No permite modificar una venta confirmada
        if (!"Pendiente".equalsIgnoreCase(estadoVenta)) {
            return false;
        }

        // Evita agregar el mismo celular dos veces
        for (DetalleVenta detalle : detalles) {

            if (detalle.getCelular() == celular
                    || detalle.getCelular().getIdCelular() > 0
                    && detalle.getCelular().getIdCelular()
                    == celular.getIdCelular()) {
                return false;
            }
        }

        // Crear el detalle de la venta
        DetalleVenta detalle = new DetalleVenta(
                celular,
                celular.getPrecioVenta(),
                celular.getCostoCompra(),
                descuento
        );

        detalles.add(detalle);

        calcularTotal();

        return true;
    }

    // Elimina un detalle de la venta
    public boolean quitarDetalle(int indice) {

        // Solo se pueden modificar ventas pendientes
        if (!"Pendiente".equalsIgnoreCase(estadoVenta)) {
            return false;
        }

        // Validar que el índice exista
        if (indice < 0 || indice >= detalles.size()) {
            return false;
        }

        detalles.remove(indice);

        calcularTotal();

        return true;
    }

    // Calcula el total de la venta
    public double calcularTotal() {

        totalVenta = 0.0;

        for (DetalleVenta detalle : detalles) {

            totalVenta += detalle.calcularSubtotal();
        }

        return totalVenta;
    }

    // Calcula la utilidad total de la venta
    public double calcularUtilidad() {

        double utilidad = 0.0;

        for (DetalleVenta detalle : detalles) {

            utilidad += detalle.calcularUtilidad();
        }

        return utilidad;
    }

    // Genera el comprobante de la venta
    public String generarComprobante(Tienda tienda) {

        StringBuilder comprobante = new StringBuilder();

        comprobante.append(tienda.obtenerEncabezado());
        comprobante.append("\n");
        comprobante.append(
                "============================================================\n"
        );
        comprobante.append(
                "                    COMPROBANTE DE VENTA\n"
        );
        comprobante.append(
                "============================================================\n"
        );

        comprobante.append("Venta: ")
                .append(idVenta).append("\n");

        comprobante.append("Fecha: ")
                .append(fechaVenta).append("\n");

        comprobante.append("Cliente: ")
                .append(cliente.obtenerNombreCompleto()).append("\n");

        comprobante.append("Vendedor: ")
                .append(vendedor.obtenerNombreCompleto()).append("\n");

        comprobante.append(
                "------------------------------------------------------------\n"
        );

        comprobante.append(String.format(
                "%-22s %5s %13s %11s %13s%n",
                "PRODUCTO", "CANT.", "PRECIO", "DESCUENTO", "SUBTOTAL"
        ));

        comprobante.append(
                "------------------------------------------------------------\n"
        );

        // Configuración de formato monetario colombiano
        java.text.DecimalFormatSymbols simbolos =
                new java.text.DecimalFormatSymbols(
                        new java.util.Locale("es", "CO")
                );

        java.text.DecimalFormat formato =
                new java.text.DecimalFormat("#,##0.00", simbolos);

        // Recorrer los detalles de la venta
        for (DetalleVenta detalle : detalles) {

            Celular celular = detalle.getCelular();

            String nombreMarca = celular.getMarca() != null
                    ? celular.getMarca().getNombreMarca()
                    : "Sin marca";

            String producto = nombreMarca + " "
                    + celular.getModelo();

            comprobante.append(String.format(
                    "%-22s %5d %13s %11s %13s%n",
                    producto,
                    1,
                    "$" + formato.format(detalle.getPrecioVenta()),
                    "$" + formato.format(detalle.getDescuento()),
                    "$" + formato.format(detalle.calcularSubtotal())
            ));
        }

        comprobante.append(
                "------------------------------------------------------------\n"
        );

        comprobante.append(String.format(
                "%-52s %13s%n",
                "TOTAL:",
                "$" + formato.format(calcularTotal())
        ));

        comprobante.append(
                "============================================================\n"
        );
        comprobante.append(
                "           GRACIAS POR CONFIAR EN DISTRICELJCL\n"
        );
        comprobante.append(
                "============================================================\n"
        );

        comprobante.append("Estado: ").append(estadoVenta);

        return comprobante.toString();
    }

    // Confirma la venta
    public boolean confirmar() {

        // Validar cliente, vendedor y detalles
        if (cliente == null || vendedor == null || detalles.isEmpty()) {
            return false;
        }

        // La venta debe estar pendiente
        if (!"Pendiente".equalsIgnoreCase(estadoVenta)) {
            return false;
        }

        // Calcular el total
        calcularTotal();

        if (!Double.isFinite(totalVenta) || totalVenta <= 0) {
            return false;
        }

        // Verificar todos los celulares antes de confirmar
        for (DetalleVenta detalle : detalles) {

            if (detalle == null || detalle.getCelular() == null) {
                return false;
            }

            if (!detalle.getCelular().estaDisponible()) {
                return false;
            }
        }

        // Actualizar los estados de los celulares
        for (DetalleVenta detalle : detalles) {

            detalle.getCelular().actualizarEstado("Vendido");
        }

        // Confirmar la venta
        estadoVenta = "Confirmada";

        return true;
    }

    // Getters y setters

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
}
