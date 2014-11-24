/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

/*Clase que muestra el fondo oficial*/

import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;

public class PanelEntrada extends JPanel{
    private JLabel imagenFondo;
    private JLabel imagenFondo1;
	
	public PanelEntrada(){
		this.setup();
		this.fondo();
	}

	private void setup(){
		this.setLayout(null);
		this.setBackground(new Color(58,58,58));
    }
    
    /*Metodo que introduce las imagenes al panel*/
	public void fondo(){
            URL url=this.getClass().getResource("/imagenesINT/fondoEntradaa.jpg");
	    ImageIcon ima = new ImageIcon(url);
	    imagenFondo = new JLabel(new ImageIcon(ima.getImage().getScaledInstance(1250,700, 1)));
		imagenFondo.setVisible(true);
		imagenFondo.setLayout(null);
		imagenFondo.setBounds(0,0,1250,700);
		imagenFondo.setBackground(new Color(3,58,5));
		
		/*ImageIcon ima1 = new ImageIcon("imagenesINT/inicio1.gif");
	    imagenFondo1 = new JLabel(new ImageIcon(ima1.getImage().getScaledInstance(300,400, 1)));
		imagenFondo1.setVisible(true);
		imagenFondo1.setLayout(null);
		imagenFondo1.setBounds(-450,-150,1250,700);
		imagenFondo1.setBackground(new Color(3,58,5));
		
		add(imagenFondo1);*/
		add(imagenFondo);
	}
}

