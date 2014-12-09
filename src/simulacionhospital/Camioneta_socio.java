/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;
/**
 * Write a description of class Camioneta here.
 * 
 * @author karen 
 * @version (a version number or a date)
 */
import java.net.URL;
import javax.swing.ImageIcon;
import static simulacionhospital.Paciente_gravedad.tipo1;
public class Camioneta_socio 
  


{
    public String tipo="Camioneta socio";
    public ImageIcon derecha;
    public ImageIcon izquierda;
    public ImageIcon arriba;
    public ImageIcon abajo;
    public static int tipo3;
    public Camioneta_socio()
    {
      URL url=this.getClass().getResource("/Imagenes/CaminaD.gif");
        URL url1=this.getClass().getResource("/Imagenes/CaminaE.gif");
        URL url2=this.getClass().getResource("/Imagenes/CaminaAr.gif");
        URL url3=this.getClass().getResource("/Imagenes/CaminaS.gif");
        derecha= new ImageIcon(url);
        izquierda= new ImageIcon(url1);
        arriba= new ImageIcon(url2);
        abajo= new ImageIcon(url3);
      tipo3=3;
    }
    //Metodos Get
    public int getTipo()
    {
        return tipo3;
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