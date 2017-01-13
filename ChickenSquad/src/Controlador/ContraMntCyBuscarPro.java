/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Formularios.BuscarCliente;
import Formularios.BuscarProducto;
import Formularios.MntComprobante;
import Transacciones.MantenimientoCliente;
import Transacciones.MantenimientoProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PSantana
 */
public class ContraMntCyBuscarPro implements ActionListener,KeyListener{
    MntComprobante comprobante =new MntComprobante();
    BuscarProducto producto=new BuscarProducto(comprobante, true);
    MantenimientoProductos mntp=new MantenimientoProductos();
    
    BuscarCliente cliente=new BuscarCliente(comprobante, true);
    MantenimientoCliente mntc=new MantenimientoCliente();
    public ContraMntCyBuscarPro(MntComprobante comprobante,BuscarProducto producto,BuscarCliente cliente){
        this.comprobante=comprobante;
        this.producto=producto;
        this.cliente=cliente;
        comprobante.btnBcliente.addActionListener(this);
        comprobante.btnBproducto.addActionListener(this);
        producto.btnSeleccionar.addActionListener(this);
        cliente.btnSeleccionar.addActionListener(this);
    }

     public void setDataP(JTextField id,JTextField p,JTextField s){
        id.setText(producto.tblBuscarP.getModel().getValueAt(producto.tblBuscarP.getSelectedRow(), 0).toString());
        p.setText(producto.tblBuscarP.getModel().getValueAt(producto.tblBuscarP.getSelectedRow(), 3).toString());
        s.setText(producto.tblBuscarP.getModel().getValueAt(producto.tblBuscarP.getSelectedRow(), 4).toString());
     }
     public void setDataC(JTextField doc) {
        doc.setText(cliente.tblCliente.getModel().getValueAt(cliente.tblCliente.getSelectedRow(), 3).toString());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int filaE=producto.tblBuscarP.getSelectedRow();// dato para condicion btnEditar
        int nfilas=producto.tblBuscarP.getSelectedRowCount();// dato para condicion btnEditar
        int filaC=cliente.tblCliente.getSelectedRow();
        int nfilasC=cliente.tblCliente.getSelectedRowCount();
        if(e.getSource()==comprobante.btnBproducto){
            producto.setVisible(true);
        }
        if(e.getSource()==comprobante.btnBcliente){
            cliente.setVisible(true);
        }
        if(producto.isShowing()){
        if(e.getSource()==producto.btnSeleccionar){//Acciòn boton Editar
            if(filaE<0){
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else if(nfilas>1){
                JOptionPane.showMessageDialog(null, "Seleccione solo una fila");
            }else{
                producto.dispose();
                setDataP(comprobante.txtCodigo,comprobante.txtPrecio,comprobante.txtStock);
                comprobante.txtCodigo.setEditable(false);
                comprobante.txtPrecio.setEditable(false);
                comprobante.txtStock.setEditable(false);
            }
        }
        }
        if(cliente.isShowing()){
        if(e.getSource()==cliente.btnSeleccionar){
            if(filaC<0){
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }else if(nfilasC>1){
                JOptionPane.showMessageDialog(null, "Seleccione solo una fila");
            }else{
                cliente.dispose();
                setDataC( comprobante.txtDocumento);
                comprobante.txtDocumento.setEditable(false);
            }
        }    
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
