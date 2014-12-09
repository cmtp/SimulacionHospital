/*clase de las opciones a la derecha*/
package simulacionhospital;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import javax.swing.*;

public class PanelOpciones extends JPanel implements ActionListener, MouseListener {
    
    JButton inicio, musica, ayuda, info, salir;
    Vista vista;
    
    public PanelOpciones(Vista v) {
        vista = v;
        this.setup();
    }
     public PanelOpciones() {

    }
    /*MÃ©todo que inserta los botones al panel*/
    private void setup() {
        Dimension dimension = new Dimension(130,4);
        this.setLayout(new GridLayout(5,1));
        //this.setBackground(Color.BLACK);
        
        //boton de inicio
        URL url=this.getClass().getResource("/imagenesINT/ingresar1.jpg");
        URL url1=this.getClass().getResource("/imagenesINT/volver1.gif");
        URL url2=this.getClass().getResource("/imagenesINT/ayuda1.gif");
        URL url3=this.getClass().getResource("/imagenesINT/info1.gif");
        URL url4=this.getClass().getResource("/imagenesINT/salir1.gif");
        URL url5=this.getClass().getResource("/imagenesINT/fondoEntradaa.jpg");
        URL url6=this.getClass().getResource("/imagenesINT/fondoEntradaa.jpg");
        URL url7=this.getClass().getResource("/imagenesINT/fondoEntradaa.jpg");
        URL url8=this.getClass().getResource("/imagenesINT/fondoEntradaa.jpg");
        inicio = new JButton(new ImageIcon(url));
        //inicio=new JButton("Inicio");
        inicio.setToolTipText("Inicio de aplicacion");
        inicio.setPreferredSize(dimension);
        inicio.addActionListener(this);
        inicio.addMouseListener(this);
        inicio.setBorderPainted(false);
        inicio.setFocusPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //boton musica
        musica = new JButton(new ImageIcon(url1));
        //musica=new JButton("Volver");
        musica.setToolTipText("Volver");
        musica.setPreferredSize(dimension);
        musica.addActionListener(this);
        musica.addMouseListener(this);
        musica.setBorderPainted(false);
        musica.setFocusPainted(false);
        musica.setContentAreaFilled(false);
        musica.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //boton ayuda
        ayuda = new JButton(new ImageIcon(url2));
        //ayuda =new JButton("Ayuda");
        ayuda.setToolTipText("Ayuda");
        ayuda.setPreferredSize(dimension);
        ayuda.addActionListener(this);
        ayuda.addMouseListener(this);
        ayuda.setBorderPainted(false);
        ayuda.setFocusPainted(false);
        ayuda.setContentAreaFilled(false);
        ayuda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //boton informacion
        info = new JButton(new ImageIcon(url3));
        //info = new JButton("Info");
        info.addActionListener(this);
        info.addMouseListener(this);
        info.setToolTipText("Información de desarrolladores");
        info.setPreferredSize(dimension);
        info.setBorderPainted(false);
        info.setFocusPainted(false);
        info.setContentAreaFilled(false);
        info.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        
        //boton salir
        salir = new JButton(new ImageIcon(url4));
        //salir=new JButton("Salir");
        salir.addActionListener(this);
        salir.addMouseListener(this);
        salir.setToolTipText("Salir");
        salir.setPreferredSize(dimension);
        salir.setBorderPainted(false);
        salir.setFocusPainted(false);
        salir.setContentAreaFilled(false);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.add(inicio);
        this.add(musica);
        this.add(ayuda);
        this.add(info);
        this.add(salir);
    
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(salir)){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex){}
            System.exit(0);
        }
        if(o.equals(info)) {
            vista.mostrarPanelInfo();
            
        }
        else if(o.equals(inicio)) {
            vista.mostrarPanelInicio();
        }   
        
        else if(o.equals(ayuda)){
            vista.mostrarPanelHelp();
        }
        
        else if(o.equals(musica)){
            vista.mostrarPanelEntrada();
        }
        
    }

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {
        Object o = e.getSource();
        URL url=this.getClass().getResource("/imagenesINT/salir2.gif");
        URL url1=this.getClass().getResource("/imagenesINT/volver2.gif");
        URL url2=this.getClass().getResource("/imagenesINT/ayuda2.gif");
        URL url3=this.getClass().getResource("/imagenesINT/info2.gif");
        URL url4=this.getClass().getResource("/imagenesINT/ingresar2.jpg");
        if( o == salir)
            salir.setIcon(new ImageIcon(url));

        else if( o == musica)
            musica.setIcon(new ImageIcon(url1));
            
        else if( o == ayuda )
            ayuda.setIcon(new ImageIcon(url2));
            
        else if( o == info) 
            info.setIcon(new ImageIcon(url3));
            
        else if( o == inicio) 
            inicio.setIcon(new ImageIcon(url4));
    }

    public void mouseExited(MouseEvent e) {
        Object o = e.getSource();
        URL url=this.getClass().getResource("/imagenesINT/salir1.gif");
        URL url1=this.getClass().getResource("/imagenesINT/volver1.gif");
        URL url2=this.getClass().getResource("/imagenesINT/ayuda1.gif");
        URL url3=this.getClass().getResource("/imagenesINT/info1.gif");
        URL url4=this.getClass().getResource("/imagenesINT/ingresar1.jpg");
        if( o == salir){
            salir.setIcon(new ImageIcon(url));    
        }else if( o == musica){
            musica.setIcon(new ImageIcon(url1));          
        }else if( o == ayuda)
            ayuda.setIcon(new ImageIcon(url2));    
        else if( o == info) 
            info.setIcon(new ImageIcon(url3));
        else if( o == inicio) 
            inicio.setIcon(new ImageIcon(url4));
        
        
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
    
     public static void main(String[] args) {
		PanelOpciones p = new PanelOpciones();
	}
    
    
}

