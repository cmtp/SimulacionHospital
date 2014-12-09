/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Autor extends JDialog
{
	JLabel programa = new JLabel("	ESTUDIANTES DE LA UMSS", JLabel.CENTER);
	JLabel autor1 = new JLabel("Silvia Eugenia Flores Garcia", JLabel.CENTER);
	JLabel autor2 = new JLabel("La chiby", JLabel.CENTER);
	JLabel autor3 = new JLabel("Paola Andrea Ramirez Sejas", JLabel.CENTER);
	JLabel autor4 = new JLabel("Payito", JLabel.CENTER);
	JLabel doc1 = new JLabel("", JLabel.CENTER);
	JLabel derechos1 = new JLabel("", JLabel.CENTER);
	JLabel derechos2 = new JLabel("2014", JLabel.CENTER);

	JButton aceptar = new JButton("Aceptar");

	JPanel principal = new JPanel(new BorderLayout());
	JPanel info = new JPanel(new GridLayout(8, 1));
	JPanel boton = new JPanel(new FlowLayout());

 public  Autor() {
	
		super(new Frame(), "Desarrolladores", true);

		info.add(programa);
		info.add(autor1);
		info.add(autor2);
		info.add(autor3);
		info.add(autor4);
		info.add(doc1);
		info.add(derechos1);
		info.add(derechos2);
		boton.add(aceptar);
		principal.add("Center", info);
		principal.add("South", boton);
		getContentPane().add(principal);
		pack();
		setResizable(false);
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);
		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		this.setVisible(true);

	}
 

}

