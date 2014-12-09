/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;
/*Clase del boton de informacion, todo lo que hay en ese panel*/


import java.awt.Color;
import java.awt.Font;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;

public class PanelInfo extends JPanel{
    private JLabel imagenFondo1;
	
	public PanelInfo() {
		
		this.setup();
	}

	private void setup() {
		this.setLayout(null);
		this.setBackground(new Color(58,58,58));
		mostrarInfo();
	}
	
	/*Metodo que introduce la imagen de fondo, los nombres*/
	public void mostrarInfo() {
		Color color=Color.white;

		Font font=new Font("Vivaldi", Font.ITALIC, 40);
                //URL url=this.getClass().getResource("/imagenesINT/fondoInform.jpg");
		//ImageIcon ima1 =new ImageIcon(url);
	    imagenFondo1 = new JLabel(/*new ImageIcon(ima1.getImage().getScaledInstance(1250,700, 1))*/);
		imagenFondo1.setBounds(0,0,1250,700);
		imagenFondo1.setBackground(new Color(3,58,5));
		imagenFondo1.setVisible(true);
		imagenFondo1.setLayout(null);
		
		add(imagenFondo1);
		    
        JLabel titulo = new JLabel();
		titulo.setFont(font); 
		titulo.setForeground(color);
	    titulo.setText("Integrantes:");
	    titulo.setBounds(130, 100, 770, 40);
	        
	    JLabel d1 = new JLabel();
		d1.setFont(font); 
		d1.setForeground(color);
	    d1.setText("Flores Garcia Silvia Eugenia");
	    d1.setBounds(130, 200, 770, 40);
	        
	    JLabel d2 = new JLabel();
		d2.setFont(font); 
		d2.setForeground(color);
        d2.setText("Ramirez Sejas Paola Andrea");	        
        d2.setBounds(130, 260, 770, 40);
        ImageIcon icon=new ImageIcon("/Imageness/hechobolivia.png");
	    JLabel h= new JLabel(icon);
        h.setBounds(220, 480, icon.getIconWidth(), icon.getIconHeight());
	        
        icon=new ImageIcon("/Imageness/umss.png");
	    JLabel f= new JLabel(icon);
        f.setBounds(420, 480, icon.getIconWidth(), icon.getIconHeight());
        
        icon=new ImageIcon("/Imagenes/fcyt.png");
	    JLabel g= new JLabel(icon);
        g.setBounds(620, 480, icon.getIconWidth(), icon.getIconHeight());
        
        this.add(titulo);
        this.add(d2);
        this.add(d1);
	    this.add(h);
	    this.add(f);
	    this.add(g);
        this.add(imagenFondo1);
        }
}
