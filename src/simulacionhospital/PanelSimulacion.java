/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author marcelo
 */
public class PanelSimulacion extends JPanel implements ActionListener{
    
 // declaramos variables  
    private JButton b_aceptar;
    private JButton b_cancelrar;
    private JLabel label_labadero;
    private JLabel label_encerado;
    private JLabel label_c_aceite;
    private JLabel label_cajero;
    private JLabel label_negro;
    

    
    private JLabel label_fondo_der;
    
    private JLabel label_fcyt;
    private JComboBox cb_labadero;
    private JComboBox cb_encerado;
    private JComboBox cb_cajero;
    private JComboBox cb_c_aceite;
    private JPanel panelDatos;
  
    private VentanaSimulacion simu;
   
    
    public PanelSimulacion(){
        setLayout(null);
        setBounds(0,0,1145,640  ); //tamanio y lugar de frame 
       /* setDefaultCloseOperation(3);
        setTitle("Ventana Principal de Simulación");//colocamos un nombre a nuestro frame
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null); */
        crearBotones();//llamamos al metodo  crear botones para poder crear nuestros botones de aceptar y cancelar
        crearComboBox(); // llamamos al metodo de combo box 
        crearFondos(); //llamamos al metodo crar fondos para que se creen los fundos en el interfaz      
        setVisible(true);
    }
    
    
    // este metodo crea los bones de nuestro interfaz y coloca un tamanio de nuestros botones 
    public void crearBotones(){
        
        b_aceptar=new JButton("Aceptar");
        b_aceptar.setBounds(920,400,150,45);
        b_aceptar.addActionListener(this);
        add(b_aceptar);
        
        b_cancelrar=new JButton("Cancelar");
        b_cancelrar.setBounds(920,550,150,45);
        b_cancelrar.addActionListener(this);
        add(b_cancelrar);
    }
    // este metodo crea los fondos 
    public void crearFondos(){
        
        setLayout(null);
        setBackground(Color.BLACK);
        URL url=this.getClass().getResource("/Imagenes/fcyt.PNG");
        URL url1=this.getClass().getResource("/Imagenes/fondo_negro1.jpg");
        URL url2=this.getClass().getResource("/Imagenes/fondo_datos.jpg");
        label_fcyt=new JLabel(new ImageIcon(url));
        label_fcyt.setLayout(null);
        label_fcyt.setBounds(960,20,120,100);//(960,20,120,100)
        add(label_fcyt);
        
        label_negro=new JLabel();
        label_negro.setLayout(null);
        label_negro.setIcon(new ImageIcon(url1));
        label_negro.setBounds(2,5,900,740);//(5,5,900,630)
        label_negro.setVisible(true);
        add(label_negro);

        label_fondo_der=new JLabel();
        label_fondo_der.setLayout(null);
        label_fondo_der.setIcon(new ImageIcon(url2));
        label_fondo_der.setBounds(865,5,350,740);//(865,5,300,630)
        label_fondo_der.setVisible(true);
        add(label_fondo_der);
        

    }
    //metodo q crea nuestros combo box para poder seleccionar cantodad de labaderos, enceradores .etc. 
     public void crearComboBox(){
        panelDatos = new JPanel();
        panelDatos.setLayout(null);
        panelDatos.setBounds(865,5,350,740);//(865,5,300,630)
        panelDatos.setBackground(new Color(0,10,0,4));
        label_labadero=new JLabel("Selecione N° de Labaderos");
        cb_labadero = new JComboBox();
        cb_labadero.addItem("1");
        cb_labadero.addItem("2");
        cb_labadero.addItem("3");
        cb_labadero.addItem("4");
        cb_labadero.addItem("5");
        cb_labadero.addItem("6");
        cb_labadero.setBounds(40, 183, 50, 20);//(20, 183, 50, 20)
        label_labadero.setBounds(100,183,200,20);
        label_labadero.setVisible(true);
        panelDatos.add(cb_labadero);
        panelDatos.add(label_labadero);
        
        cb_encerado = new JComboBox();
        cb_encerado.addActionListener(this);
        cb_encerado.setBounds(40, 228, 50, 20);
        label_encerado=new JLabel("seleccione N° de enceradores");
        label_encerado.setBounds(100,228,200,20);
        cb_encerado.addItem("1");
        cb_encerado.addItem("2");
        cb_encerado.addItem("3");
        cb_encerado.addItem("4");
        cb_encerado.setVisible(true);
        panelDatos.add(cb_encerado);
         panelDatos.add(label_encerado);
        
        setLayout(null);
        setBackground(Color.black);
        cb_cajero = new JComboBox();
        label_cajero=new JLabel("Recepcionista");
        cb_cajero.addActionListener(this);
        cb_cajero.setBounds(40, 320, 50, 20);
        label_cajero.setBounds(100, 320, 200, 20);
        cb_cajero.setBackground(Color.white);
        cb_cajero.setBorder(BorderFactory.createEmptyBorder());
        cb_cajero.setFont(new Font("Helvetica", Font.BOLD, 10));
        cb_cajero.setFont(null);
        cb_cajero.addItem("1");
        cb_cajero.setVisible(true);
        cb_cajero.enable(true);
        label_cajero.setVisible(true);
        panelDatos.add(cb_cajero);
        panelDatos.add(label_cajero);
        
        cb_c_aceite = new JComboBox();
        
        label_c_aceite=new JLabel("seleccione N° de controles");
        cb_c_aceite.setBounds(40, 273, 50, 20);
        label_c_aceite.setBounds(100,273,200,20);
        cb_c_aceite.addItem("1");
        cb_c_aceite.addItem("2");
        cb_c_aceite.addItem("3");
        cb_c_aceite.addItem("4");
        cb_c_aceite.setVisible(true);
        panelDatos.add(cb_c_aceite);
         panelDatos.add(label_c_aceite);
        this.add(panelDatos);
    }
   
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b_aceptar)){
                int n_control_a = Integer.parseInt(cb_c_aceite.getSelectedItem().toString());
                int n_cajero =Integer.parseInt(cb_cajero.getSelectedItem().toString());
                  int n_labaderos = Integer.parseInt(cb_labadero.getSelectedItem().toString());
                  int n_enceradores = Integer.parseInt(cb_encerado.getSelectedItem().toString());
                simu=new VentanaSimulacion(n_control_a,n_cajero,n_labaderos,n_enceradores);         
                simu.setVisible(true);
                
        }else if(e.getSource().equals(b_cancelrar)){
            int o=JOptionPane.showConfirmDialog(this, "Esta seguro que desea salir del sistema de Simulacion Elite Car Wash?");
            if(o==JOptionPane.OK_OPTION){
                System.exit(3);
            }
        }
    }
    

    
    public static void main(String[] args)
    {
        PanelSimulacion inicio =new PanelSimulacion();
        
    }
}
