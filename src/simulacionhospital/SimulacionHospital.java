/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import vista.VentanaPrincipal;

/**
 *
 * @author marcelo
 */
public class SimulacionHospital {

   int screenx, screeny;
 public static void main(String[] args) {
            Prueba carg=new Prueba();
            carg.start();
            Vista vista=new Vista();
            try {
                carg.join();
            }catch (Exception e) {}
            vista.setVisible(true);
    }

      //Carga la aplicacion en backGround usando una interfaz visual de carga
     
    public void run(){
        JWindow w= new JWindow();
        //URL url=this.getClass().getResource("/imagenesINT/inicioAuto.gif");
        //JLabel imagen=new JLabel(new ImageIcon(url));// poner una imagen para el cuadro pequeño
        //imagen.repaint(); 
        //JLabel imagen=new JLabel("Hola Mundo");
        //w.add(imagen,BorderLayout.CENTER);
        JProgressBar bar=new JProgressBar(0,800);
        bar.setString("cargando Simulacion Hospital .....");
        bar.setStringPainted(true);
        w.add(bar,BorderLayout.SOUTH);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
        int i=0;
        while(i<800) {
           i++;
           bar.setValue(i);
           try {
                Thread.sleep(5);
            }catch(InterruptedException e){}
        }
        w.dispose();
    }
    
}
