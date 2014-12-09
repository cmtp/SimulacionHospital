/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

/**
 *
 * @author marcelo
 */
import Matematicas.PruebaMatematica;
import Matematicas.VariableAleatoria;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.tools.JavaCompiler;

// buscar label de investigacion para poder remplazar  al cajero jiji
public class Panel123 extends JPanel {
    ///
    private JComboBox cb_meses;
   private JComboBox dias;
    
    
    private JComboBox cb_distribucion_labadero;
    private JComboBox cb_distribucion_encerado;
    private JComboBox cb_distribucion_aceite;
    private JComboBox cb_d_investigacion;
    private JComboBox cb_d_negociacion;
    ///
    private JLabel fondo;
    private ArrayList<JLabel> operadores_labadero;
    private ArrayList<JLabel> listaSiniestros;
    private ArrayList<JLabel> listaGastos;
    private JLabel label_cajero;
    private int cotrol_a;
    private int cajero;
    private int labadero;
    private int encerado;
    private int numhil=20;
    double porciontiempo=10;
    Timer timer = new Timer();
    Accion accion;
    Estacionamiento_I estacionamiento1;
    Estacion_Lavado lavadero;
    Estacionamiento_II estacionamiento2;
    Estacion_Control control;
    private VariableAleatoria va;
    JSlider jSlider1;
    
    /////////////////////////////////////////////////////////////variablesssssssssssss
    private int tiempoEntreLlegadas;
 
    private int cantidadC;
    //////////////////////////////////////////////////////////////////////////////////
    
    private ArrayList<AutoG> lista_autos=new ArrayList<AutoG>();
    
    private ArrayList<JLabel> lisLabel =new ArrayList<JLabel>();
    ThreadGroup grupoHilo;
   
    
    public Panel123(Accion accion,int cotrol_a,int cajero,int labadero,int encerado, Estacionamiento_I estacionamiento1,Estacion_Lavado lavadero, Estacionamiento_II estacionamiento2,Estacion_Control control)
    {     
        setLayout(null);
        this.cotrol_a = cotrol_a;
        this.cajero = cajero;
        this.labadero = labadero;
        this.encerado = encerado;
        this.accion = accion;
        this.estacionamiento1=estacionamiento1;
        this.lavadero=lavadero;
        this.estacionamiento2=estacionamiento2;
        this.control=control;
        
        //setUndecorated(true);
        va = new VariableAleatoria();
        tiempoEntreLlegadas=10;
        cantidadC=0;
        
        operadores_labadero=new ArrayList<JLabel>();
        listaSiniestros=new ArrayList<JLabel>();
        listaGastos = new ArrayList<JLabel>();
        
        
        //creamos labelss
       for (int i = 0; i < 100; i++)
       {
            
            JLabel lab=new JLabel();
             URL url=this.getClass().getResource("/Imagenes/CaminaD.gif");
            lab.setIcon(new ImageIcon(url));
            lab.setBounds(-50, 315, lab.getIcon().getIconWidth(),lab.getIcon().getIconHeight());
            this.add(lab);
            lisLabel.add(lab );
          
        }
        
        crearBotones();
        agregarLabadero();
        agregar_encerador();
        control_aceite();
        fijos();
        crearFondo();
        
        setVisible(true);
    }//Fin Constructor;
    
    public void crearFondo()
    {
       // fondo.setIcon(new ImageIcon(escala));
        fondo=new JLabel();
        //fondo.setLayout(null);
        URL url1=this.getClass().getResource("/Imagenes/fondo_plano_Descripcion3.png");
        fondo.setIcon(new ImageIcon(url1));
        fondo.setBounds(0,-28,1280,750);
        fondo.setVisible(true);
        add(fondo);
    }
    
    public void crearBotones(){
        
        jSlider1 =new JSlider(SwingConstants.HORIZONTAL,0,200,10);
        cb_meses = new JComboBox();
        cb_meses.addItem("Enero");
    
        dias = new JComboBox();
        dias.addItem("Lunes");

        
        cb_distribucion_labadero = new JComboBox();
        cb_distribucion_labadero.addItem("Exponencial");
        cb_distribucion_labadero.addItem("Uniforme");
        cb_distribucion_labadero.addItem("Normal");
        cb_distribucion_labadero.addItem("Trans. Inversa");
        cb_distribucion_labadero.setBounds(650, 400, 100, 20); //deistribucion con los que atienden los labaderos elite
        add(cb_distribucion_labadero);

        cb_distribucion_encerado = new JComboBox();// seleccion de distribucion de la seccion de encerado:
        cb_distribucion_encerado.addItem("Normal");
        cb_distribucion_encerado.addItem("Trans. Inversa");
        cb_distribucion_encerado.addItem("Exponencial");
        cb_distribucion_encerado.addItem("Uniforme");
        cb_distribucion_encerado.setBounds(800, 55, 100, 20); //cngiuramos el lugar y tamanio de combo box de encerado de atencion
        add(cb_distribucion_encerado);

        cb_d_negociacion = new JComboBox();
        cb_d_negociacion.addItem("Trans. Inversa");
        cb_d_negociacion.addItem("Normal");
        cb_d_negociacion.addItem("Exponencial");
        cb_d_negociacion.addItem("Uniforme");
        cb_d_negociacion.setBounds(780, 100, 80, 20);
        //add(cb_d_negociacion);

        cb_d_investigacion = new JComboBox();
        cb_d_investigacion.addItem("Normal");
        cb_d_investigacion.addItem("Exponencial");
        cb_d_investigacion.addItem("Uniforme");
        cb_d_investigacion.addItem("Trans. Inversa");
        cb_d_investigacion.setBounds(30, 540, 80, 20);
        //add(cb_d_investigacion);
        
        cb_distribucion_aceite = new JComboBox();
       
        cb_distribucion_aceite.addItem("Normal");
        cb_distribucion_aceite.addItem("Exponencial");
        cb_distribucion_aceite.addItem("Uniforme");
        cb_distribucion_aceite.addItem("Trans. Inversa");
        cb_distribucion_aceite.setBounds(300, 55, 100, 20);
        add(cb_distribucion_aceite);
        
    
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void agregarLabadero(){
        int x=480;
        int y=435;
        for(int i=0;i<labadero;i++){
            //URL url2=this.getClass().getResource("/Imagenes/lavado2G.gif");
            JLabel labadero1=new JLabel(new ImageIcon(/*url2*/));
            labadero1.setLayout(null);
            labadero1.setBounds(x,y,100,120);
            this.add(labadero1);
            x=x+70+20;  
            operadores_labadero.add(labadero1);
         
        }   
    }
    
    public void agregar_encerador(){
        int x=660;
        int y=100;
        for(int i=0;i<encerado;i++){    
            //URL url3=this.getClass().getResource("/Imagenes/encerado.png");
            JLabel encerados=new JLabel(new ImageIcon(/*url3*/));
            encerados.setLayout(null);
            
             encerados.setBounds(x,y,200,230);
             this.add(encerados);
             x=x+200;  
             operadores_labadero.add(encerados);
             if(i==1){
                    y=10;
                    x=690;
                }
             if(i==2){
                 y=10;
                 x=900;
                }
             
        }   
    }
    
    public void control_aceite(){
        int x=372;
          int y=154;
        for(int i=1;i<=cotrol_a;i++){   
            //URL url4=this.getClass().getResource("/Imagenes/EngraseAceiteado2.gif");
            JLabel estimaciones=new JLabel(new ImageIcon(/*url4*/));
            estimaciones.setLayout(null);
            
             estimaciones.setBounds(x,y,100,125);//(x,y,100,120)
             this.add(estimaciones);
             x=x-160;  
             operadores_labadero.add(estimaciones);
             if(i%2==0){
                 y=y-132;
                 x=372;
             }
        }   
    }
    
    public void fijos(){
        //URL url5=this.getClass().getResource("/Imagenes/almacen.gif");
        label_cajero=new JLabel(new ImageIcon(/*url5*/));//sospechas1
        label_cajero.setLayout(null);
        label_cajero.setBounds(5,78,150,200);
        add(label_cajero);
        
      
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void setIndiceCBD(int n){
        cb_meses.setSelectedIndex(n);
        
    }
    
    public void pararClientes(){
        
       // for(int i=0; i<mono.personasSistema; i++)
       // {
           // if(Clientes[i].isAlive())
              //  Clientes[i].stop();
        //}
    }
    //
    public void suspenderClientes()
    {
        for(int i=0; i<lista_autos.size(); i++)
        {
            if(lista_autos.get(i).isAlive())
            {
              lista_autos.get(i).suspend();
              lista_autos.get(i).parar();
            }
        }
        timer.cancel();   
    }
    //
    public void actualizarvelocidad()
    {
        for(int i=0; i<lista_autos.size(); i++)
        {
            if(lista_autos.get(i).isAlive())
            {
                 lista_autos.get(i).actualizarvelo();
                }
        }
    }
    public void resumeClientes()
    {
        for(int i=0; i<lista_autos.size(); i++)
        {
            if(lista_autos.get(i).isAlive())
            {
                lista_autos.get(i).resume();
                lista_autos.get(i).continuar();
            }
        }
            timerTask.run();    
    }
    //VentanaSimulacion simu= new VentanaSimulacion();
    public int getMesSeleccionado()
    {
        return cb_meses.getSelectedIndex();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void empezarSimulacion(){
        int messelecionado = cb_meses.getSelectedIndex();
        // abilitar si o si
        Accion.atencion_labado(cb_distribucion_labadero.getSelectedIndex());
        Accion.atencion_encerado(cb_distribucion_encerado.getSelectedIndex());
        //Monitor.atencionInvestigacion(cb_d_investigacion.getSelectedIndex());
        Accion.atencion_control_a(cb_distribucion_aceite.getSelectedIndex());
        //Monitor.atencionNegociacion(cb_d_negociacion.getSelectedIndex());
        

        cb_distribucion_labadero.setEnabled(false);
        cb_distribucion_encerado.setEnabled(false);
        cb_d_investigacion.setEnabled(false);
        cb_d_negociacion.setEnabled(false);
        cb_distribucion_aceite.setEnabled(false);
        
        cb_meses.setEnabled(false);
        dias.setEnabled(false);
        
        grupoHilo=new ThreadGroup("hilopadre");

        int t=0;
        while (t<=90)
        {
            String nom="auto  "+t;
            AutoG auto=new AutoG(grupoHilo,nom,accion,lisLabel.get(t),labadero,encerado,cajero,cotrol_a,estacionamiento1,lavadero,estacionamiento2,control);
            for(int i=0;i<=100;i++)
            {
                System.out.println ("Esperando la creacion del siguiente auto "+i);
            }
            lista_autos.add(auto );
            
        
            t++;
        }
             int p=(int)va.exponencial(14)*40+50;
        if(p>500){
        tiempoEntreLlegadas=p;
         
    }
     tiempoEntreLlegadas=1000;
     cantidadC=va.uniforme(20,30);
        timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);
        
        
        
        
        
      
        /*switch(messelecionado)
        {
        case 0:     
            System.out.println("va.uniforme(4, 7)");
            cantidadC = va.uniforme(4, 7);
            tiempoEntreLlegadas= va.uniforme(1000, 1030);
            
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 1: 
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 2: 
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 3:     
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 4:     
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 5:     
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
            
        case 6:     
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
            
        case 7:         
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 8:     
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 9:     
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 10:    
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
        case 11:    
            cantidadC = va.uniforme(10, 12);
            tiempoEntreLlegadas = va.uniforme(1000, 1030);
            timer.scheduleAtFixedRate(timerTask, 0, tiempoEntreLlegadas);   
            break;
            
                
        }*/
        
            
    }
    private TimerTask timerTask = new TimerTask(){
        int u=0;
        public void run() {
            //codigo a correr
            if(cantidadC>u)
            {
                System.out.println(""+u);
                lista_autos.get(u).start();
                System.out.println("hiloss");
                int r= grupoHilo.activeCount();
                System.out.println("hilossss"+r);
                u=u%149+1;
                accion.setHora((int)(tiempoEntreLlegadas*porciontiempo));
                porciontiempo=porciontiempo+1;
            }else
            {
                cancel();
                
            }
        }    
    };
    public double  getTiempo()
    {
        System.out.println("reee"+tiempoEntreLlegadas*porciontiempo);
        return tiempoEntreLlegadas*porciontiempo;               
    }
        
    public Accion getAccion()
    {
        return accion;
    }
    
}