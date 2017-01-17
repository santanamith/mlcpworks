/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Paneles;

import ConexionBD.ConexionBD;
import ConexionBD.ConexionBDMelanio;
import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marisol
 */
public class AddUser extends javax.swing.JPanel {

    ConexionBD cn = new ConexionBD();

    /**
     * Creates new form addusuario
     */
    public AddUser() {
        initComponents();
        cmbCargo.removeAllItems();
        cmbCargo.addItem("Administrador");
        cmbCargo.addItem("Almacenero");
        cmbCargo.addItem("Cajero");
    }
    @Override
    public void paintComponent(Graphics g){
        Dimension dimen = getSize();
        ImageIcon imagen=new ImageIcon(new ImageIcon(getClass().getResource("/Images/merhy.png")).getImage());
        g.drawImage(imagen.getImage(), 0, 0, dimen.width,dimen.height,this);
    }
    private void insert_usuario() {
        String nombre = txtNombre.getText();
        String apePater = txtApelPa.getText();
        String apeMater = txtApelMa.getText();
        String Dni = txtDNI.getText();
        String usuario = txtUsuario.getText();
        String contraseña = txtjPassContraseña.getText();
        String cargo = cmbCargo.getSelectedItem().toString();
        try {

            String sql = "insert into usuario(nombre,apellido_paterno,apellido_materno,dni,usuario,clave,cargo)"
                    + " values ('" + nombre + "','" + apePater + "','" + apeMater + "','" + Dni + "','" + usuario + "','" + contraseña + "','" + cargo + "')";
            JOptionPane.showMessageDialog(this, "Datos registrados");
            cn.ejecutar(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error al insert usuario" + e.getMessage());
        }
    }
    private int validar(){
        int f=0;
        if(txtNombre.getText()==null ||txtNombre.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Complete le campo del nombre");
            return -1;
        }
        if(txtApelMa.getText()==null ||txtApelMa.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Complete le campo del Apellido materno");
            return -1;
        }
        if(txtApelPa.getText()==null ||txtApelPa.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Complete le campo del Apellido paterno");
            return -1;
        }
        if(txtDNI.getText()==null ||txtDNI.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Complete le campo del Apellido paterno");
            return -1;
        }
        if(txtDNI.getText().length()!=8){
            JOptionPane.showMessageDialog(null, "El campo DNI solo debe contener 8 números");
            return -1;
        }
        if(txtUsuario.getText()==null ||txtUsuario.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Complete el campo usuario");
            return -1;
        }
        if(txtjPassContraseña.getText()==null ||txtjPassContraseña.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Complete el campo de la contraseña");
            return -1;
        }
        return f;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtjPassContraseña = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApelMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtApelPa = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cmbCargo = new javax.swing.JComboBox();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("Contraseña :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Usuario");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 255));
        jLabel4.setText("DNI :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("Cargo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("Apellido M.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Apellido P.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("Nombre");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setText("Datos de Acceso al sistema");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 255));
        jLabel9.setText("Datos Personales");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setForeground(new java.awt.Color(204, 204, 255));
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4))
                                            .addGap(81, 81, 81)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtApelMa)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(cmbCargo, javax.swing.GroupLayout.Alignment.LEADING, 0, 222, Short.MAX_VALUE)
                                                        .addComponent(txtDNI))
                                                    .addGap(100, 100, 100))))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2))
                                            .addGap(84, 84, 84)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtApelPa)
                                                .addComponent(txtNombre)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(59, 59, 59)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(70, 70, 70)
                                    .addComponent(txtjPassContraseña))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(103, 103, 103)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApelPa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApelMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjPassContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clean();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(validar()==-1){
            return;
        }else{
            insert_usuario();
            clean();
            DefaultTableModel df=(DefaultTableModel) EditUser.jTable1.getModel();
            buscarUser("select * from usuario", df);
            EditUser.jTable1.setModel(df);
            DefaultTableModel dfm=(DefaultTableModel) DeleteUser.jTable1.getModel();
            buscarUser("select * from usuario", dfm);
            DeleteUser.jTable1.setModel(dfm);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void buscarUser(String sql,DefaultTableModel tabla) {
        int f=0;
        try {
            ResultSet rs=cn.Consulta(sql);
            tabla.setRowCount(0);
            while (rs.next()){
                f=tabla.getRowCount();
                tabla.setRowCount(f+1);
                tabla.setValueAt(rs.getInt("id_usuario"), f, 0);
                tabla.setValueAt(rs.getString("nombre"), f, 1);
                tabla.setValueAt(rs.getString("apellido_paterno"), f, 2);
                tabla.setValueAt(rs.getString("apellido_materno"), f, 3);
                tabla.setValueAt(rs.getString("dni"), f, 4);
                tabla.setValueAt(rs.getString("usuario"), f, 5);
                tabla.setValueAt("**********", f, 6);
                tabla.setValueAt(rs.getString("cargo"), f, 7);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al Estableces datos de la tabla cliente "+ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JComboBox cmbCargo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField txtApelMa;
    private javax.swing.JTextField txtApelPa;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtjPassContraseña;
    // End of variables declaration//GEN-END:variables

    private void clean() {
        txtNombre.setText("");
        txtApelPa.setText("");
        txtApelMa.setText("");
        txtDNI.setText("");
        txtUsuario.setText("");
        txtjPassContraseña.setText("");
        cmbCargo.setSelectedIndex(0);
    }
    
}
