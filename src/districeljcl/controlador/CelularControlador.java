/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.controlador;

import districeljcl.modelo.Celular;
import districeljcl.modelo.Marca;
import districeljcl.repositorio.CelularRepositorio;
import districeljcl.repositorio.MarcaRepositorio;
import java.util.ArrayList;

public class CelularControlador {
    
    private CelularRepositorio celulares;
    private MarcaRepositorio marcas;

    // Constructor: recibe los repositorios compartidos
    public CelularControlador(
            CelularRepositorio celulares,
            MarcaRepositorio marcas) {

        this.celulares = celulares;
        this.marcas = marcas;
    }

    // Obtener las marcas para el JComboBox
    public ArrayList<Marca> listarMarcas() {
        return marcas.listar();
    }

    // Registrar un celular
    public String guardarCelular(
            int idMarca,
            String modelo,
            String imei,
            String condicion,
            String precioTexto) {

        if (modelo == null || modelo.isBlank()
                || imei == null || imei.isBlank()
                || condicion == null || condicion.isBlank()
                || precioTexto == null || precioTexto.isBlank()) {

            return "Complete todos los campos obligatorios";
        }

        Marca marca = marcas.buscarPorId(idMarca);

        if (marca == null) {
            return "Seleccione una marca válida";
        }

        double precio;

        try {
            precio = Double.parseDouble(precioTexto.trim());
        } catch (NumberFormatException e) {
            return "El precio debe ser numérico";
        }

        if (!Double.isFinite(precio) || precio <= 0) {
            return "El precio debe ser mayor que cero";
        }

        // Evitar registrar dos veces el mismo IMEI
        for (Celular c : celulares.listar()) {
            if (c.getImei() != null
                    && c.getImei().equalsIgnoreCase(imei.trim())) {
                return "Ya existe un celular con ese IMEI";
            }
        }

        Celular celular = new Celular(
                marca,
                modelo.trim(),
                imei.trim(),
                condicion.trim());

        celular.actualizarPrecio(precio);
        
        celulares.guardar(celular);

        return "Celular guardado correctamente";
    }

    // Listar todos los celulares
    public ArrayList<Celular> listarCelulares() {
        return celulares.listar();
    }

    // Buscar celulares por modelo
    public ArrayList<Celular> buscarCelulares(String texto) {

        if (texto == null || texto.isBlank()) {
            return celulares.listar();
        }

        return celulares.buscarPorModelo(texto.trim());
    }

    // Buscar por ID
    public Celular buscarPorId(int id) {
        return celulares.buscarPorId(id);
    }

    // Actualizar el precio de un celular
    public String actualizarPrecio(int id, String precioTexto) {

        Celular celular = celulares.buscarPorId(id);

        if (celular == null) {
            return "Seleccione un celular válido";
        }

        if (precioTexto == null || precioTexto.isBlank()) {
            return "Ingrese un precio";
        }

        double precio;

        try {
            precio = Double.parseDouble(precioTexto.trim());
        } catch (NumberFormatException e) {
            return "El precio debe ser numérico";
        }

        if (!Double.isFinite(precio) || precio <= 0) {
            return "El precio debe ser mayor que cero";
        }

        celular.actualizarPrecio(precio);

        celulares.actualizar(celular);

        return "Celular actualizado correctamente";
    }

    // Cambiar el estado del celular a Vendido
    public String marcarVendido(int id) {

        if (celulares.marcarVendido(id)) {
            return "Celular vendido correctamente";
        }

        return "No se pudo vender el celular";
    }
    
    
    
    
    // Eliminar un celular del inventario
    public String eliminarCelular(int id) {

        Celular celular = celulares.buscarPorId(id);

        if (celular == null) {
            return "Seleccione un celular válido";
        }

        if (celular.getEstadoEquipo().equalsIgnoreCase("Vendido")) {
            return "No se puede eliminar un celular vendido";
        }

        if (celulares.eliminar(id)) {
            return "Celular eliminado correctamente";
        }

        return "No se pudo eliminar el celular";
    }

    
    // Actualizar los datos principales de un celular
    public String actualizarCelular(
            int id,
            int idMarca,
            String modelo,
            String imei,
            String condicion,
            String precioTexto) {

        Celular celular = celulares.buscarPorId(id);

        if (celular == null) {
            return "Seleccione un celular válido";
        }

        if (modelo == null || modelo.isBlank()
                || imei == null || imei.isBlank()
                || condicion == null || condicion.isBlank()
                || precioTexto == null || precioTexto.isBlank()) {

            return "Complete todos los campos obligatorios";
        }

        Marca marca = marcas.buscarPorId(idMarca);

        if (marca == null) {
            return "Seleccione una marca válida";
        }

        double precio;

        try {
            precio = Double.parseDouble(precioTexto.trim());
        } catch (NumberFormatException e) {
            return "El precio debe ser numérico";
        }

        if (!Double.isFinite(precio) || precio <= 0) {
            return "El precio debe ser mayor que cero";
        }

        // Comprobar que el IMEI no pertenezca a otro celular
        for (Celular c : celulares.listar()) {
            if (c.getIdCelular() != id
                    && c.getImei() != null
                    && c.getImei().equalsIgnoreCase(imei.trim())) {

                return "Ya existe otro celular con ese IMEI";
            }
        }

        // Actualizar los atributos del celular
        celular.setMarca(marca);
        celular.setModelo(modelo.trim());
        celular.setImei(imei.trim());
        celular.setCondicion(condicion.trim());
        celular.actualizarPrecio(precio);

        celulares.actualizar(celular);

        return "Celular actualizado correctamente";
    }
 
}
