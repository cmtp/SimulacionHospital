/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

/*Clase que maneja la mayoria de las clases en excepcion de PanelOpciones, PanelRotator*/


import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class MultiPanel extends JPanel {
        PanelEntrada pe;
        PanelInfo pi;
        //Inicio panelInicio;
        PanelSimulacion simulacion;
        PanelHelp ayuda;
        
    
    public MultiPanel() {
        this.setBackground(new Color(58,58,58));
        this.setLayout(new BorderLayout());
        inicializarPaneles();
    }
    
    public void inicializarPaneles(){
        pe = new PanelEntrada();
        pi = new PanelInfo();
 //               panelInicio = new Inicio();
        simulacion = new PanelSimulacion();
        ayuda = new PanelHelp();
        this.mostrarPanelEntrada();
    }   
    
    public void mostrarPanelEntrada() {
        pi.setVisible(false);
        pe.setVisible(true);
        ayuda.setVisible(false);
        add(pe,"Center");
    }
    

    public void mostrarPanelInfo(){
        pe.setVisible(false);
        pi.setVisible(true);
  //      panelInicio.setVisible(false);
        simulacion.setVisible(false);
        pi.mostrarInfo();
        ayuda.setVisible(false);
        add(pi,"Center");
    }
        public void mostrarPanelInicio()
        {
          pe.setVisible(false);
          pi.setVisible(false);
       // panelInicio.mostrar();
        simulacion= new PanelSimulacion();
        ayuda.setVisible(false);
        add(simulacion,"Center");
        }
        
        public void mostrarPanelHelp()
        {
            pe.setVisible(false);
            pi.setVisible(false);
           // panelInicio.setVisible(false);
            simulacion.setVisible(false);
            ayuda.setVisible(true);
            add(ayuda,"Center");
        }
        
/*        public void mostrarVentanaHelp()
        {
            pe.setVisible(false);
            pi.setVisible(false);
            panelInicio.setVisible(false);
            ayuda.setVisible(false);
            
            add(ayuda,"Center");

        }*/
}

