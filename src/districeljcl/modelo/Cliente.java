/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.modelo;



public class Cliente {
 
    // Atributos
    private int idCliente;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String documento;
    private String telefono;
    private String correo;
    private String direccion;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor principal
    public Cliente(String nombre, String apellido,
            String tipoDocumento, String documento) {

        this();

        setNombre(nombre);
        setApellido(apellido);
        setTipoDocumento(tipoDocumento);
        setDocumento(documento);
    }

    // Obtiene el nombre completo del cliente
    public String obtenerNombreCompleto() {

        String nombreCliente = nombre != null
                ? nombre.trim() : "";

        String apellidoCliente = apellido != null
                ? apellido.trim() : "";

        return (nombreCliente + " " + apellidoCliente).trim();
    }

    // Obtiene la información del cliente
    public String obtenerInformacion() {

        return "ID: " + idCliente
                + "\nNombre completo: " + obtenerNombreCompleto()
                + "\nTipo de documento: " + tipoDocumento
                + "\nDocumento: " + documento
                + "\nTelefono: " + telefono
                + "\nCorreo: " + correo
                + "\nDireccion: " + direccion;
    }

    // Actualiza la información de contacto
    public void actualizarContacto(
            String telefono,
            String correo,
            String direccion) {

        setTelefono(telefono);
        setCorreo(correo);
        setDireccion(direccion);
    }

    // Getters y setters

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {

        if (idCliente >= 0) {
            this.idCliente = idCliente;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {

        if (apellido != null && !apellido.isBlank()) {
            this.apellido = apellido.trim();
        }
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {

        if (tipoDocumento != null
                && !tipoDocumento.isBlank()) {

            this.tipoDocumento = tipoDocumento.trim();
        }
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {

        if (documento != null
                && !documento.isBlank()) {

            this.documento = documento.trim();
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        if (correo != null && !correo.isBlank()) {
            this.correo = correo.trim();
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
}
