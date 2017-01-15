/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Paneles;

import ConexionBD.ConexionBDMelanio;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Date;
import java.util.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Marisol
 */
public class AddProduct extends javax.swing.JPanel {

    ConexionBDMelanio con;
    Calendar calendario = GregorianCalendar.getInstance();
    SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form AddProduct
     */
    public AddProduct() {
        initComponents();
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension dimen = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/Images/merhy.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, dimen.width, dimen.height, this);
    }

    private void insertar_prodcuto() {

        int tipo = Integer.parseInt(cmbTipo.getName());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        Double precio = Double.parseDouble(txtPrecio.getText());
        java.util.Date caducidad = calendario.getTime();
        String nomPro = txtProducto.getText();
        String desc = txtADescripcion.getText();
        String espec = txtAEspecificaciones.getText();
        try {
            String sql = "INSERT INTO productos(nombre_producto, precio, caducidad, existencia, descripcion, especificaciones) VALUES ('" + nomPro + "','" + tipo + "','" + precio + "','" + caducidad + "','" + cantidad + "','" + desc + "','" + espec + "')";
            //  String sql ="insert into producto(nombre_producto,idtipo,precio,caducidad,existencia,descripcion,especificaciones) producto values ()" ;   
            con.ejecutar(sql);
            JOptionPane.showMessageDialog(null, "Producto: " + nomPro + " agregado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, " error insertar_dato" + e.getMessage());
        }

    }

    private void validacion() {
        if (cmbTipo.getName() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la tipo deve se selecionar un elemento");
        }
        if (txtCantidad.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la cantidad no deve de estar vacia");
        }
        if (txtPrecio.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la precio no deve de estar vacia");
        }
        if (txtCaducidad.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la cantidad/existencia no deve de estar vacia");
        }
        if (txtProducto.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la nombre producto no deve de estar vacia");
        }
        if (txtADescripcion.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la descripcion no deve de estar vacia");
        }
        if (txtAEspecificaciones.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la especificaciones no deve de estar vacia");
        }
    }

    private void actualizar_prodcuto() {
        int tipo = Integer.parseInt(cmbTipo.getName());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        Double precio = Double.parseDouble(txtPrecio.getText());
        java.util.Date caducidad = calendario.getTime();
        String nomPro = txtProducto.getText();
        String desc = txtADescripcion.getText();
        String espec = txtAEspecificaciones.getText();

        try {
            
        String sql = "update producto set nombre_producto='" + nomPro + "',idtipo='" + tipo + "',precio='" + precio + "',"
                + "caducidad='" + caducidad + "',existencia='" + cantidad + "',descripcion='" + desc + "',especificaciones='" + espec + "' where id_producto='" + txtId + "'";
        con.ejecutar(sql);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,"error actualizar_prodcuto"+ e.getMessage());
        }
    }

    private void eliminar_usuario() {
        try {
            String sql = "delete from producto where id_producto='" + txtId.getText() + "'";
            con.ejecutar(sql);
            JOptionPane.showMessageDialog(this, "correctamete se borro");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtADescripcion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAEspecificaciones = new javax.swing.JTextArea();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCaducidad = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        txtId = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Nombre de producto");

        txtADescripcion.setColumns(20);
        txtADescripcion.setRows(5);
        jScrollPane3.setViewportView(txtADescripcion);

        txtAEspecificaciones.setColumns(20);
        txtAEspecificaciones.setRows(5);
        jScrollPane1.setViewportView(txtAEspecificaciones);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Precio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Especificaciones");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText("Descripción");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Cantidad/Existencia");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("Caducidad");

        try {
            txtCaducidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCaducidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("Tipo");

        cmbTipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbTipo.setForeground(new java.awt.Color(204, 204, 255));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCaducidad)
                                    .addComponent(txtProducto)
                                    .addComponent(cmbTipo, 0, 142, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel4)
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(174, 174, 174))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextArea txtAEspecificaciones;
    private javax.swing.JFormattedTextField txtCaducidad;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
