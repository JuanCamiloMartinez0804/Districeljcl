/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package districeljcl.vista;

import districeljcl.controlador.CelularControlador;
import districeljcl.modelo.Celular;
import districeljcl.modelo.Marca;
import districeljcl.repositorio.CelularRepositorio;
import districeljcl.repositorio.MarcaRepositorio;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaCelulares extends javax.swing.JFrame {
    
    private CelularControlador controlador;
    private DefaultTableModel modeloTabla;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaCelulares.class.getName());

    /**
     * Creates new form VentanaCelulares
     */
    public VentanaCelulares(CelularControlador controlador) {
        
        
        
        
        
        initComponents();

        this.controlador = controlador;

        setTitle("Districeljcl - Gestión de Celulares");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        modeloTabla = new DefaultTableModel(
                new Object[]{
                    "ID", "Marca", "Modelo", "IMEI",
                    "Condición", "Precio", "Estado"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tblCelulares.setModel(modeloTabla);

        cargarMarcas();
        cargarCelulares();

        btnGuardar.addActionListener(e -> guardarCelular());
        btnActualizar.addActionListener(e -> actualizarCelular());
        btnEliminar.addActionListener(e -> eliminarCelular());
        btnLimpiar.addActionListener(e -> limpiarCampos());

        tblCelulares.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                seleccionarCelular();
            }
        });
    }
    
   
    
    private void cargarMarcas() {
        cmbMarca.removeAllItems();

        for (Marca marca : controlador.listarMarcas()) {
            cmbMarca.addItem(marca.getNombreMarca());
        }
    }

    private int obtenerIdMarca() {
        int indice = cmbMarca.getSelectedIndex();

        if (indice < 0) {
            throw new IllegalArgumentException("Seleccione una marca.");
        }

        return controlador.listarMarcas()
                .get(indice).getIdMarca();
    }

    private void cargarCelulares() {
        modeloTabla.setRowCount(0);

        for (Celular celular : controlador.listarCelulares()) {
            agregarFila(celular);
        }
    }

    private void agregarFila(Celular celular) {
        modeloTabla.addRow(new Object[]{
            celular.getIdCelular(),
            celular.getMarca().getNombreMarca(),
            celular.getModelo(),
            celular.getImei(),
            celular.getCondicion(),
            celular.getPrecioVenta(),
            celular.getEstadoEquipo()
        });
    }

    private void limpiarCampos() {
        if (cmbMarca.getItemCount() > 0) {
            cmbMarca.setSelectedIndex(0);
        }

        txtModelo.setText("");
        txtImei.setText("");
        cmbCondicion.setSelectedIndex(0);
        txtPrecio.setText("");
        txtBuscar.setText("");

        tblCelulares.clearSelection();
    }

    private int obtenerIdSeleccionado() {
        int fila = tblCelulares.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(
                    this, "Seleccione un celular de la tabla."
            );
            return -1;
        }

        int filaModelo = tblCelulares.convertRowIndexToModel(fila);

        return Integer.parseInt(
                modeloTabla.getValueAt(filaModelo, 0).toString()
        );
    }

    private void seleccionarCelular() {
        int fila = tblCelulares.getSelectedRow();

        if (fila == -1) {
            return;
        }

        int id = obtenerIdSeleccionado();
        Celular celular = controlador.buscarPorId(id);

        if (celular == null) {
            return;
        }

        for (int i = 0; i < controlador.listarMarcas().size(); i++) {
            Marca marca = controlador.listarMarcas().get(i);

            if (marca.getIdMarca()
                    == celular.getMarca().getIdMarca()) {
                cmbMarca.setSelectedIndex(i);
                break;
            }
        }

        txtModelo.setText(celular.getModelo());
        txtImei.setText(celular.getImei());
        cmbCondicion.setSelectedItem(celular.getCondicion());
        txtPrecio.setText(String.valueOf(celular.getPrecioVenta()));
    }

    private void guardarCelular() {
        try {
            String resultado = controlador.guardarCelular(
                    obtenerIdMarca(),
                    txtModelo.getText(),
                    txtImei.getText(),
                    cmbCondicion.getSelectedItem().toString(),
                    txtPrecio.getText()
            );

            JOptionPane.showMessageDialog(this, resultado);

            cargarCelulares();
            limpiarCampos();

        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void actualizarCelular() {
        int id = obtenerIdSeleccionado();

        if (id == -1) {
            return;
        }

        try {
            String resultado = controlador.actualizarCelular(
                    id,
                    obtenerIdMarca(),
                    txtModelo.getText(),
                    txtImei.getText(),
                    cmbCondicion.getSelectedItem().toString(),
                    txtPrecio.getText()
            );

            JOptionPane.showMessageDialog(this, resultado);

            cargarCelulares();

        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void eliminarCelular() {
        int id = obtenerIdSeleccionado();

        if (id == -1) {
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Desea eliminar el celular seleccionado?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String resultado = controlador.eliminarCelular(id);

            JOptionPane.showMessageDialog(this, resultado);

            cargarCelulares();
            limpiarCampos();

        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void buscarCelulares() {
        try {
            String busqueda = txtBuscar.getText().trim().toLowerCase();

            modeloTabla.setRowCount(0);

            for (Celular celular : controlador.listarCelulares()) {

                String marca = celular.getMarca()
                        .getNombreMarca().toLowerCase();

                String modelo = celular.getModelo().toLowerCase();

                String imei = celular.getImei().toLowerCase();

                if (busqueda.isEmpty()
                        || marca.contains(busqueda)
                        || modelo.contains(busqueda)
                        || imei.contains(busqueda)) {

                    agregarFila(celular);
                }
            }

            if (modeloTabla.getRowCount() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "No se encontraron celulares."
                );
            }

        } catch (Exception e) {
            mostrarError(e);
        }
    }

    private void mostrarError(Exception e) {
        JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbMarca = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        txtImei = new javax.swing.JTextField();
        cmbCondicion = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCelulares = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado" }));

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);

        txtBuscar.addActionListener(this::txtBuscarActionPerformed);

        btnGuardar.setText("Guardar");

        btnActualizar.setText("Actualizar");

        btnEliminar.setText("Eliminar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnLimpiar.setText("Limpiar");

        tblCelulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblCelulares);

        jLabel1.setText("Marca:");

        jLabel2.setText("Modelo:");

        jLabel3.setText("IMEI");

        jLabel4.setText("Condición:");

        jLabel5.setText("Precio de venta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtModelo)
                    .addComponent(txtImei)
                    .addComponent(cmbMarca, 0, 149, Short.MAX_VALUE)
                    .addComponent(cmbCondicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecio))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addGap(51, 51, 51)
                            .addComponent(btnActualizar)
                            .addGap(49, 49, 49)
                            .addComponent(btnEliminar)
                            .addGap(52, 52, 52)
                            .addComponent(btnLimpiar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
        buscarCelulares();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarCelulares();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            CelularRepositorio celulares = new CelularRepositorio();
            MarcaRepositorio marcas = new MarcaRepositorio();

            CelularControlador controlador
                    = new CelularControlador(celulares, marcas);

            new VentanaCelulares(controlador).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCondicion;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCelulares;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtImei;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
