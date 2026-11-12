/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;

/**
 *
 * @author juanc
 */
public class Marca {
    
    // Atributos
    private int idMarca;
    private String nombreMarca;

    // Constructor vacío
    public Marca() {
    }

    // Constructor parametrizado
    public Marca(int idMarca, String nombreMarca) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
    }

    // Getters y setters
    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    // Método del UML
    public String obtenerInformacion() {
        return idMarca + " - " + nombreMarca;
    }
}
