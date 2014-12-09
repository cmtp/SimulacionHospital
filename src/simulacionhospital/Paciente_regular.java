/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author marcelo
 */
public class Paciente_regular {
    public String tipo="Paciente de gravedad";
    public ImageIcon derecha;
    public ImageIcon izquierda;
    public ImageIcon arriba;
    public ImageIcon abajo;
    public static int tipo2;
    
    public Paciente_regular()
    {
        URL url=this.getClass().getResource("/Imagenes/A2_derecha.gif");
        URL url1=this.getClass().getResource("/Imagenes/A2_izquierda.gif");
        URL url2=this.getClass().getResource("/Imagenes/A2_arriba.gif");
        URL url3=this.getClass().getResource("/Imagenes/A2_abajo.gif");
        derecha= new ImageIcon(url);
        izquierda= new ImageIcon(url1);
        arriba= new ImageIcon(url2);
        abajo= new ImageIcon(url3);
        tipo2=2;
    }
    //Metodos Get
    public int getTipo()
    {
        return tipo2;
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
