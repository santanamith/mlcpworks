/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Paneles;

import Clases.Datos;
import Clases.GuardarFotos;
import ConexionBD.ConexionBD;
import ConexionBD.ConexionBDMelanio;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marisol
 */
public class AddProduct extends javax.swing.JPanel {

    ConexionBD cn=new ConexionBD();
    Datos dato=new Datos();
    GuardarFotos fotos=new GuardarFotos();
    
    public AddProduct() {
        initComponents();
        cn.setTipo(cmbTipo);
    }

    @Override
    public void paintComponent(Graphics g) {
        Dimension dimen = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/Images/merhy.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, dimen.width, dimen.height, this);
    }

    private void insertar_prodcuto() {

        int tipo = Integer.parseInt(cmbTipo.getSelectedItem().toString().substring(0,2).trim());
        System.out.println(tipo);
        int cantidad = Integer.parseInt(txtCantidad.getText());
        Double precio = Double.parseDouble(txtPrecio.getText());
        String caducidad=txtCaducidad.getText();
        String nomPro = txtProducto.getText();
        String desc = txtADescripcion.getText();
        String espec = txtAEspecificaciones.getText();
        try {
            String sql = "INSERT INTO producto(nombre_producto,idtipo,"
                    + " precio, caducidad, existencia, descripcion,"
                    + " especificaciones) VALUES ('" + nomPro + "','"
                    + tipo + "','" + precio + "','" + caducidad + "','" 
                    + cantidad + "','" + desc + "','"
                    + espec + "')";
            //  String sql ="insert into producto(nombre_producto,idtipo,precio,caducidad,existencia,descripcion,especificaciones) producto values ()" ;   
            cn.ejecutar(sql);
            JOptionPane.showMessageDialog(null, "Producto: " + nomPro + " agregado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, " error insertar_dato" + e.getMessage());
        }

    }

    private int validacion() {
        int f= 0;
        if (txtCantidad.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la cantidad no debe estar vacia");
            return -1;
        }
        if (txtPrecio.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo del precio no debe estar vacia");
            return -1;
        }
        if (txtCaducidad.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la cantidad/existencia no debe estar vacia");
            return -1;
        }
        if (txtProducto.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo del nombre producto no debe estar vacia");
            return -1;
        }
        if (txtADescripcion.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de la descripcion no debe estar vacia");
            return -1;
        }
        if (txtAEspecificaciones.getText() == null) {
            JOptionPane.showMessageDialog(this, "el campo de las especificaciones no debe estar vacia");
            return -1;
        }
            return f;
    }   
    private void clean(){
        txtProducto.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtCaducidad.setText("");
        txtADescripcion.setText("");
        txtAEspecificaciones.setText("");
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
        btnLimpiar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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

        btnLimpiar.setBackground(new java.awt.Color(255, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(204, 204, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 51, 51));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(204, 204, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lblfoto.setBackground(new java.awt.Color(255, 0, 0));
        lblfoto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblfoto.setForeground(new java.awt.Color(204, 204, 255));
        lblfoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfoto.setText("Foto");
        lblfoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setForeground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Agregar foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setForeground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Quitar foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7))
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtCaducidad)
                                            .addComponent(txtProducto)
                                            .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(76, 76, 76)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        clean();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(validacion()==-1){
            return;
        }else {
            insertar_prodcuto();
            DefaultTableModel df=(DefaultTableModel) EditProduct.jTable1.getModel();
            dato.buscarProduct("select * from producto", df);
            EditProduct.jTable1.setModel(df);
            DefaultTableModel dfm=(DefaultTableModel) DeleteProduct.jTable1.getModel();
            dato.buscarProduct("select * from producto", dfm);
            DeleteProduct.jTable1.setModel(dfm);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(txtProducto.getText()==null || txtProducto.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe colocar el nombre del producto");
        }else{
            String  arch1="" ,  idpro = "" ;
            JFileChooser    fc  =  new  JFileChooser () ;
            lblfoto.setText("");
            fc.setFileFilter ( new FileNameExtensionFilter( "Fotos", 
                                                   "jpg","jpeg","png","bmp" )  ) ;
            fc.setDialogTitle ( "Seleccionar Fotografías" );
            int  r  =  fc.showOpenDialog( this) ;  // r: 0=Aceptar; 1=Cancelar
            if ( r == 0 )   {
                   arch1  =  fc.getSelectedFile().toString() ;
            } // r == 0
            if ( ! arch1.isEmpty() )  {
    // seleccionar el producto
                    idpro = txtProducto.getText().trim();
    // copia foto de arch1 a arch2
                    fotos.CopiarFoto( arch1 , idpro ) ;
    // verfoto
                    fotos.VerFoto( lblfoto , idpro  );
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fotos.EliminarFoto(txtProducto.getText().trim(), lblfoto);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JTextArea txtADescripcion;
    private javax.swing.JTextArea txtAEspecificaciones;
    private javax.swing.JFormattedTextField txtCaducidad;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
