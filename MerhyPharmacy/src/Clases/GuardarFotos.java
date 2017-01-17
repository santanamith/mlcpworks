/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marisol y su gente
 */
public class GuardarFotos {
    private String RutaExe = System.getProperty("user.dir");
    private String RutaFoto = RutaExe + "/fotos/";   

    public GuardarFotos() {
    }
    
    public  void  VerFoto ( JLabel  pLbl , String  idpro )  {
// Ruta de la foto 
            String  sArch = this.RutaFoto + "producto" + idpro + ".jpg";
// capturar  foto a memoria
            ImageIcon  img  =  new  ImageIcon ( sArch  ) ;
// cambia el tamaño de foto
            Icon  foto = new  ImageIcon ( 
                      img.getImage().getScaledInstance (  
                      pLbl.getWidth() , pLbl.getHeight ( ) , 
                      Image.SCALE_DEFAULT )  ) ;  
// mostrar imagen en el marco      
            pLbl.setIcon ( foto ) ;          
    }
    public void CopiarFoto ( String a1 , String idpro  )   {
        String a2 = this.RutaFoto + "producto" + idpro + ".jpg";
        
        File  f1 = new File( a1 ) ;   // archivo origen para leer
        File  f2 = new File( a2 ) ;   // archivo destino para guardar
        if ( f2.exists ( ) )  {  return ;  }
        
        try {   InputStream  in =  new  FileInputStream( f1 );
                  OutputStream  out =  new  FileOutputStream( f2 );
                  byte[ ]  buf = new  byte [ 2048 ] ;
                  int  tam;
                  while (  ( tam = in.read( buf ) ) > 0 ) {
                               out.write( buf , 0, tam);
                  } // while   
                 in.close();
                 out.close();         
        }  catch ( IOException  e)  {
                    JOptionPane.showMessageDialog ( null , 
                           "Error al CopiarFoto\n" +  e.getMessage()  );
        } // try        
    }
    public  void  EliminarFoto ( String  idpro , JLabel  pLbl)   {
            String  arch = this.RutaFoto + "producto" + idpro + ".jpg";
              
            File  ff = new File( arch ) ;
            if (  ff.exists ( )  )  {
// borrando del disco                
                   ff.delete ( ) ; 
// quitando del marco
                   pLbl.setIcon( null );
            } // if exists
    }
}
