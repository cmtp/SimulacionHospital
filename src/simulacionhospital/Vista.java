/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author marcelo
 */
public class Vista  extends JFrame{
    
	public static Vista vista;
	PanelOpciones po;
	MultiPanel mp;
//******************************
//**************************
//	PanelRotator pr;
     //   Inicio PanelInicio;
	
	public Vista () {	
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.BLACK);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setup();
		this.setTitle("SImulacion Hospital");
		//vista=this;
	}

	private void setup() {
	    this.setLayout(new BorderLayout(20,0));
	    po = new PanelOpciones(this);
	    mp = new MultiPanel();
	    po.setVisible(true);
	 //   pr = new PanelRotator(this);
	    this.getContentPane().add(mp,"Center");
	    //this.add(mp,"Center");
		add(po,"West");//East
//		mp.add(pr,"South");
	}
	
	public void mostrarPanelEntrada() {
        mp.mostrarPanelEntrada();
        po.setVisible(true);
      //  pr.setVisible(true);
        
    }
	
	public void mostrarPanelInfo() {
		mp.mostrarPanelInfo();
	}
        public void mostrarPanelInicio()
        {
            mp.mostrarPanelInicio();
     //       pr.setVisible(false);
       //    po.setVisible(true);
        }
        
        public void mostrarPanelHelp(){
            mp.mostrarPanelHelp();
        }
}
