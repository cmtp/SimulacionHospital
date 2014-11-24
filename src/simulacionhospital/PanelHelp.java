/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;
/**
 * Esta clase tambien es un panel pero tiene la funcion de abrir paginas web para la orientacion en el juego
 * proporcionando ayuda de como manejar el programa
 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.border.*;
import javax.swing.colorchooser.*;
import javax.swing.filechooser.*;
import javax.accessibility.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.*;
import java.io.*;
import java.applet.*;
import java.net.*;
/**
 * PanelHelp.java
 * 
 */
public class PanelHelp extends JPanel
{
	// sonido
	//Sonido s;
	
	// la barra deslizante
	JScrollPane barraDeslizante;
	
	// el panel editor
	JEditorPane html;
	/**
	*Es el constructor del PanelHelp(Inicializa el PanelHelp)recibiendo un Sonido como parametro
	*/
	public PanelHelp()
	{
	    //this.s = s;
	    setBackground(new Color(58,58,58));
		this.setLayout(new BorderLayout(20,20));
		cargarLaAyuda();
		
		// añadimos la barra deslizante al panel
		this.add(barraDeslizante, BorderLayout.CENTER);
		
		//etiquetas de relleno
		/*this.add("South",new JLabel());
		this.add("East",new JLabel());
		this.add("West",new JLabel());
		this.add("North",new JLabel());*/
    }
    /**
     * Tiene la tarea de cargar las paginas para la ayuda
     */
    public void cargarLaAyuda()
    {
        try {
	        URL url = null;
	        String direccion = null;
	        try {
		           direccion = "/help/MANUAL_DE_USUARIO_Elite.html";
		           url = getClass().getResource(direccion);
                } catch (Exception e) {
		           System.err.println("Failed to open " + direccion);
		           url = null;
                }
                if(url != null)
                {
                    html = new JEditorPane(url);
                    html.setEditable(false);
                    html.addHyperlinkListener(crearHiperlinkListener());
                    barraDeslizante = new JScrollPane();
		            JViewport vp = barraDeslizante.getViewport();
		            vp.add(html);
		        }
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }
    /**
     * Se encarga de adicionar los eventos dentro la pagina de la ayuda
     */
	public HyperlinkListener crearHiperlinkListener(){
	return new HyperlinkListener() {
	    public void hyperlinkUpdate(HyperlinkEvent e) {
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
		    if (e instanceof HTMLFrameHyperlinkEvent) {
			((HTMLDocument)html.getDocument()).processHTMLFrameHyperlinkEvent(
			    (HTMLFrameHyperlinkEvent)e);
		    } else {
			try {
			    html.setPage(e.getURL());
			} catch (IOException ioe) {
			    System.out.println("IOE: " + ioe);
			}
		    }
		}
	    }
	};
    }
}