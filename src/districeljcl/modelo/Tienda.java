/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;


public class Tienda {
 
    // Atributos
    private int id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;

    // Constructor vacío
    public Tienda() {
    }

    // Constructor principal
    public Tienda(String nombre, String nit,
            String direccion, String telefono) {

        this();

        setNombre(nombre);
        setNit(nit);
        setDireccion(direccion);
        setTelefono(telefono);
    }

    // Obtiene el encabezado de la tienda
    public String obtenerEncabezado() {

        return nombre
                + "\nNIT: " + nit
                + "\nDireccion: " + direccion
                + "\nTelefono: " + telefono
                + "\n----------------------------\n";
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if (id >= 0) {
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre.trim();
        }
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {

        if (nit != null && !nit.isBlank()) {
            this.nit = nit.trim();
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {

        if (direccion != null && !direccion.isBlank()) {
            this.direccion = direccion.trim();
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (telefono != null && !telefono.isBlank()) {
            this.telefono = telefono.trim();
        }
    }
}
