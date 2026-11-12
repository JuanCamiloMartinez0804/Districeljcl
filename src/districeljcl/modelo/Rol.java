/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;




public class Rol {
 
    // Atributos
    private int idRol;
    private String nombreRol;
    private String descripcion;

    // Constructor vacío
    public Rol() {
    }

    // Constructor con parámetros
    public Rol(int idRol, String nombreRol, String descripcion) {

        this();

        setIdRol(idRol);
        setNombreRol(nombreRol);
        setDescripcion(descripcion);
    }

    // Getters y setters

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {

        if (idRol >= 0) {
            this.idRol = idRol;
        }
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {

        if (nombreRol != null && !nombreRol.isBlank()) {
            this.nombreRol = nombreRol.trim();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        if (descripcion != null) {
            this.descripcion = descripcion.trim();
        }
    }

    // Método para obtener información
    public String obtenerInformacion() {

        return idRol + " - "
                + nombreRol + " - "
                + descripcion;
    }
}
