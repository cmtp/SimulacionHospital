/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.net.URL;
import javafx.scene.input.DataFormat;
import javax.swing.ImageIcon;
/**
 *
 * @author marcelo
 */
public class Paciente_gravedad {
    
    public String tipo="Paciente de gravedad";
    public ImageIcon derecha;
    public ImageIcon izquierda;
    public ImageIcon arriba;
    public ImageIcon abajo;
    public static int tipo1;
    
    public Paciente_gravedad()
    {
        URL url=this.getClass().getResource("/Imagenes/A1_derecha.jpg");
        URL url1=this.getClass().getResource("/Imagenes/A1_izquierda.jpg");
        URL url2=this.getClass().getResource("/Imagenes/A1_arriba.jpg");
        URL url3=this.getClass().getResource("/Imagenes/A1_abajo.jpg");
        derecha= new ImageIcon(url);
        izquierda= new ImageIcon(url1);
        arriba= new ImageIcon(url2);
        abajo= new ImageIcon(url3);
        tipo1=1;
    }
    //Metodos Get
    public int getTipo()
    {
        return tipo1;
    }
    public ImageIcon getDerecha()
    {
        return derecha;
    }
        public ImageIcon getIzquierda()
    {
        return izquierda;
    }
      public ImageIcon getArriba()
    {
        return arriba;
    }
   public ImageIcon getAbajo()
    {
        return abajo;
    }
    // Metodos Set
    public void SetDerecha(ImageIcon de)
    {
        derecha=de;
    }
        public void SetIzquierda(ImageIcon iz)
    {
        izquierda=iz;
    }
        public void SetArriba(ImageIcon ar)
    {
        arriba=ar;
    }
        public void SetAbajo(ImageIcon ab)
    {
        abajo=ab;
    }

}
