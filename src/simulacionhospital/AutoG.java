/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import Matematicas.PruebaMatematica;
import Matematicas.VariableAleatoria;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
//Pruebas
public class AutoG extends Thread implements Runnable
{  

    private VariableAleatoria va;
    private boolean play;
    private boolean pausa;
    private int velocidad;
    private JLabel imagen;
    private int control_a;
    private int cajero;
    private int lavadero;
    private int encerado;
    private Accion accion;
    private Estacionamiento_I estacionamiento1;
    private Estacion_Lavado estacion_lavado;
    private Estacionamiento_II estacionamiento2;
    private Estacion_Control estacion_control;
    
    
    //variabless
    public double tiempo_llegadas;
    public double tiempo_estacion_lavado;
    public double tiempo_de_labado;
    public double tiempo_encerado;
    public double tiempo_estacion_control;
    public double tiempo_control;
    public int tiempo_verificacion_Llegadas;
    public int tiempo_verificacion_encerado;
    //public int j;
    // IMAGENES
    public ImageIcon derecha;
    public ImageIcon izquierda;
    public ImageIcon arriba;
    public ImageIcon abajo;
    public  int etiquetaCliente;
   // public int h;
    
    public AutoG(ThreadGroup gru, String nam,Accion ac,JLabel ima,int lab,int enc,int caj,int c_aceite, Estacionamiento_I estacio1,Estacion_Lavado lava, Estacionamiento_II estacio2,Estacion_Control contro)
    {
      super(gru,nam);
      velocidad=9;
      imagen=ima;
      lavadero=lab;
      encerado=enc;
      control_a=c_aceite;
      cajero=caj;
      pausa=false;
      play=true;
      
      accion=ac;
      estacionamiento1=estacio1;
      estacion_lavado=lava;
      estacionamiento2=estacio2;
      estacion_control=contro;
      va=new VariableAleatoria();
      tiempo_verificacion_Llegadas=10;
      //etiquetaCliente=0;
     // tiempo_estacion_lavado=100.0;
      tiempo_de_labado=500.0;
      tiempo_encerado=800.0;
      //tiempo_estacion_control=20;
      tiempo_control=1000.0;
      distribuciones();
    }
    public void run()
    {
       VentanaSimulacion.actualizarInformacion();
        //thread.setPriority(Thread.MIN_PRIORITY+1);
        imagen.setIcon(derecha);
        // monitor.incrementarPersonasSistema();      
       VariableAleatoria etiqueta= new VariableAleatoria();
       double eti= etiqueta.exponencial(15);//media
        if(eti<10)
        {
            
         Auto_no_socio auto = new Auto_no_socio(); 
         accion.auto_tabla.add(auto.tipo);
         derecha=auto.getDerecha();
         izquierda=auto.getIzquierda();
         arriba=auto.getArriba();
         abajo=auto.getAbajo();
         etiquetaCliente=auto.getTipo();
         arrivo_autos(derecha,izquierda,arriba,abajo);
         velocidad= accion.velo;   
        }
        else if (eti<20)
       {
         Auto_socio auto = new Auto_socio(); 
         accion.auto_tabla.add(auto.tipo);
         derecha=auto.getDerecha();
         izquierda=auto.getIzquierda();
         arriba=auto.getArriba();
         abajo=auto.getAbajo();
         etiquetaCliente=auto.getTipo();
         arrivo_autos(derecha,izquierda,arriba,abajo);
         velocidad= accion.velo; 
       }
       else if(eti<30)
       {
         Camioneta_socio camioneta = new Camioneta_socio(); 
         accion.auto_tabla.add(camioneta.tipo);
         derecha=camioneta.getDerecha();
         izquierda=camioneta.getIzquierda();
         arriba=camioneta.getArriba();
         abajo=camioneta.getAbajo();
         etiquetaCliente=camioneta.getTipo();
         arrivo_autos(derecha,izquierda,arriba,abajo);
         velocidad= accion.velo;
       }
       else
       {
         Camioneta_no_socio  camioneta= new Camioneta_no_socio(); 
         accion.auto_tabla.add(camioneta.tipo);
         derecha=camioneta.getDerecha();
         izquierda=camioneta.getIzquierda();
         arriba=camioneta.getArriba();
         abajo=camioneta.getAbajo();
         etiquetaCliente=camioneta.getTipo();
         arrivo_autos(derecha,izquierda,arriba,abajo);
         velocidad= accion.velo;
        }
    }
    private void distribuciones(){
    
        tiempo_llegadas=AtencionLlegadas()*accion.velo/100;
        tiempo_de_labado=atencion_lavado()*accion.velo/100;
        tiempo_encerado=atencion_encerado()*accion.velo/100;
        tiempo_control=atencion_control_a()*accion.velo/100;
       
    
    }
    private int AtencionLlegadas(){
    
        
            return (int)(va.exponencial(3.4))*100;
          }
    // ARRIBO DE AUTOS SOCIOS    
    private synchronized void arrivo_autos(ImageIcon der,ImageIcon iz,ImageIcon ar,ImageIcon ab)
    {
        distribuciones();
        int i=accion.getCantidadAutos();
        int j= estacionamiento1.getVacio();
        int x= estacion_lavado.getVacio();
        
        dormir((tiempo_verificacion_Llegadas));
       // accion.insertarTiempodeLlegadas((double)tiempo_llegadas);
       /* if(i>9){
              imagen.setLocation(-10,320);
                       imagen.setIcon(der);
                       accion.incrementar_llegadas();
                       accion.incrementar_autos_no_Atendidos();
                       moverD(1000);
                       imagen.setIcon(ar);
                       moverN(260);
                       imagen.setIcon(iz);
                       moverI(-10);
                       imagen.setIcon(new ImageIcon("Imagenes/"));
                       
        }*/
       //VERIFICA SI EL ESTACIONAMIENTO DE LAVADO  Y  LA ESTACION DE LAVADO ESTA VACIO
       //SI ES ASI PASA DIRECTO A LA ESTACION DE LAVADO
       if(j==0 && x==0)
        {
            imagen.setLocation(-10,300);
            imagen.setIcon(der);
            accion.incrementar_llegadas();
            moverD(240);
            imagen.setIcon(ab);
            moverS(570);
            imagen.setIcon(der);
            lavado(der,iz,ar,ab); 
            accion.insertar_tiempo_espera_e1(0.0);
        }
       // Y  
       else
        {
         int aux=estacionamiento1.getEspacioDesocupado();
         System.out.println(aux);
         i=aux;
         System.out.println(i);
        switch (i)
        {
            case 0: 
            {
                        estacionamiento1.ocupadoEspacio1();
                        accion.incrementar_llegadas();
                        accion.incrementar_estacionamiento_lavado();
                        categoriaCliente_Parqueo1();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                      
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(370);
                        imagen.setIcon(iz);
                        moverI(155);
                        dormir((int)tiempo_de_labado+4000); 
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio1();
                        lavado(der,iz,ar,ab);
                        
                             
            }
                         break;
            case 1: 
              {
                        estacionamiento1.ocupadoEspacio2();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(420);
                        imagen.setIcon(iz);
                        moverI(155);
                        dormir((int)tiempo_de_labado+4000);
                         accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio2();
                        lavado(der,iz,ar,ab);   
            }
                         break;
             case 2: 
            {
                        estacionamiento1.ocupadoEspacio3();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(470);
                        imagen.setIcon(iz);
                        moverI(155);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio3();
                        lavado(der,iz,ar,ab);         
             }
                         break;
             case 3: 
             {
                        estacionamiento1.ocupadoEspacio4();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(520);
                        imagen.setIcon(iz);
                        moverI(155);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio4();
                        lavado(der,iz,ar,ab);          
             }
                         break;
            case 4: 
            {
                        estacionamiento1.ocupadoEspacio5();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(iz);
                        moverI(155);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio5();
                        lavado(der,iz,ar,ab);          
             }
                         break;
          case 5:
          {
                        estacionamiento1.ocupadoEspacio6();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(370);
                        imagen.setIcon(ar);
                        moverN(520);
                        imagen.setIcon(der);
                        moverD(420);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        moverI(370);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio6();
                        lavado(der,iz,ar,ab);           
                        }
                         break;     
          case 6: {
                        estacionamiento1.ocupadoEspacio7();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(370);
                        imagen.setIcon(ar);
                        moverN(472);
                        imagen.setIcon(der);
                        moverD(420);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        moverI(370);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio7();
                        lavado(der,iz,ar,ab);    
                        }
                         break;  
                         
          case 7: {
                        
                        estacionamiento1.ocupadoEspacio8();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(370);
                        imagen.setIcon(ar);
                        moverN(420);
                        imagen.setIcon(der);
                        moverD(420);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        moverI(370);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio8();
                        lavado(der,iz,ar,ab);  
                        }
                         break;  
          case 8: {
                        
                        estacionamiento1.ocupadoEspacio9();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(370);
                        imagen.setIcon(ar);
                        moverN(370);
                        imagen.setIcon(der);
                        moverD(420);
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        moverI(370);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio9();
                        lavado(der,iz,ar,ab);     
                        }
                         break;    
          case 9: {
                        estacionamiento1.ocupadoEspacio10();
                        imagen.setLocation(-10,300);
                        imagen.setIcon(der);
                        accion.incrementar_llegadas();
                        categoriaCliente_Parqueo1();
                        accion.incrementar_estacionamiento_lavado();
                        moverD(240);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(315);
                        imagen.setIcon(ar);
                        moverN(380); 
                        dormir((int)tiempo_de_labado+4000);
                        accion.insertar_tiempo_espera_e1(tiempo_de_labado);
                        imagen.setIcon(ab);
                        moverS(570);
                        imagen.setIcon(der);
                        moverD(400);
                        estacionamiento1.desocupadoEspacio10();
                        lavado(der,iz,ar,ab);        
                        }
                         break;        
         //ESTE CASO SUCEDE CUANDO EL ESTACIONAMIENTO ESTA TOTALMENTE LLENO Y LOS VEHICULOS SE VAN
         case 10:
         {
               imagen.setLocation(-10,320);
                       imagen.setIcon(der);
                       accion.incrementar_llegadas();
                       accion.incrementar_autos_no_Atendidos();
                       categoriaCliente_NA();
                       moverD(1000);
                       imagen.setIcon(ar);
                       moverN(260);
                       imagen.setIcon(iz);
                       moverI(-10);
                       imagen.setIcon(new ImageIcon("Imagenes/"));
                       accion.insertar_tiempo_espera_e1(0.0);
                      accion.insertar_tiempo_lavado(0.0);
                      accion.insertar_tiempo_encerado(0.0);
                      accion.inserta_tiempo_espera_e2(0.0);
                      accion.insertar_tiempo_control_a(0.0);
                       
        } 
        break;
       }                         
    }
}
 private synchronized void lavado(ImageIcon der,ImageIcon iz,ImageIcon ar,ImageIcon ab)
    {
        
        
   
        System.out.println("Lavando");
        double si=va.exponencial(10);
        int i=va.uniforme(1, (lavadero-1)); 
        estacion_lavado.ocupadoEstacion();
        switch (i){
            case 1: {  
                       moverD(510);
                       imagen.setIcon(ar);
                       moverN(480);
                       accion.incrementar_autos_lavado();
                       //accion.incrementar_basico();
                       dormir((int)tiempo_de_labado+100);  ////////////////////////////////////////TIEMPO DE LAVADO
                       categoriaCliente_Lavadero();
                       accion.incrementar_servicio_solo_estacion();
                       moverN(265);
                       imagen.setIcon(iz); 
                       /*if(etiquetaCliente==1 ||etiquetaCliente==3)
                       { caja(der,iz,ar,ab);}
                       else 
                       { 
                         accion.incrementar_servicio_plus();
                         moverN(310);
                         imagen.setIcon(der);
                         moverD(1050);
                         imagen.setIcon(ar);
                         moverN(150);
                         encerado(der,iz,ar,ab); 
                       }*/
                       if(si<5)
                    {
                         
                         accion.incrementar_basico();
                        
                         moverN(265);
                         imagen.setIcon(iz);
                         accion.insertar_tiempo_lavado(tiempo_de_labado+tiempo_encerado+tiempo_control);
                         accion.insertar_tiempo_encerado(0.0);
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                         caja(der,iz,ar,ab);
                       
                        }
                        else
                        {
                         accion.insertar_tiempo_lavado(tiempo_de_labado);
                         moverN(310);
                         imagen.setIcon(der);
                         moverD(1050);
                         imagen.setIcon(ar);
                         moverN(150);
                         encerado(der,iz,ar,ab);
                    }
                     
                       
            }
            break;
            
            case 2: {   //imagen.setLocation(100,70);
                        moverD(600);
                        imagen.setIcon(ar);
                        moverN(480);
                        accion.incrementar_autos_lavado();
                     
                        dormir((int)tiempo_de_labado+100);
                        categoriaCliente_Lavadero();
                        
                    if(si<5)
                    {
                         accion.incrementar_basico();
                         
                         moverN(265);
                         imagen.setIcon(iz);
                         accion.insertar_tiempo_lavado(tiempo_de_labado+tiempo_encerado+tiempo_control);
                         accion.insertar_tiempo_encerado(0.0);
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                         caja(der,iz,ar,ab);
                         
                        }
                        else
                        {
                         accion.insertar_tiempo_lavado(tiempo_de_labado);
                         moverN(310);
                         imagen.setIcon(der);
                         moverD(1050);
                         imagen.setIcon(ar);
                         moverN(150);
                         encerado(der,iz,ar,ab);
                    }
            }
            break;
              case 3: {   //imagen.setLocation(100,70);
                        moverD(690);
                        imagen.setIcon(ar);
                        moverN(480);
                        accion.incrementar_autos_lavado();
                        dormir((int)tiempo_de_labado+100);
                       categoriaCliente_Lavadero();
                        
                        if(si<5)
                        {
                          accion.incrementar_basico();
                          
                          moverN(265);
                          imagen.setIcon(iz);
                          accion.insertar_tiempo_lavado(tiempo_de_labado+tiempo_encerado+tiempo_control);
                          accion.insertar_tiempo_encerado(0.0);
                          accion.inserta_tiempo_espera_e2(0.0);
                          accion.insertar_tiempo_control_a(0.0);
                          caja(der,iz,ar,ab);
                        }
                        else
                        {
                          moverN(310);
                          imagen.setIcon(der);
                          moverD(1050);
                          imagen.setIcon(ar);
                          moverN(150);
                          accion.insertar_tiempo_lavado(tiempo_de_labado);
                          encerado(der,iz,ar,ab);
                        }
            }
            break;
              case 4: {   //imagen.setLocation(100,70);
                        moverD(780);
                        imagen.setIcon(ar);
                        moverN(480);
                        accion.incrementar_autos_lavado();
                        dormir((int)tiempo_de_labado+100);
                       categoriaCliente_Lavadero();
                         
                        if(si<5)
                        {
                          accion.incrementar_basico();
                          
                          moverN(265);
                          imagen.setIcon(iz);
                         accion.insertar_tiempo_lavado(tiempo_de_labado+tiempo_encerado+tiempo_control);
                         accion.insertar_tiempo_encerado(0.0);
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                          caja(der,iz,ar,ab);
                        }
                        else
                        {
                          moverN(310);
                          imagen.setIcon(der);
                          moverD(1050);
                          imagen.setIcon(ar);
                          moverN(150);
                          accion.insertar_tiempo_lavado(tiempo_de_labado);
                          encerado(der,iz,ar,ab);
                        }
            }
            break;
              case 5: {   //imagen.setLocation(100,70);
                        moverD(870);
                        imagen.setIcon(ar);
                        moverN(480);
                        accion.incrementar_autos_lavado();
                        dormir((int)tiempo_de_labado+100);
                        categoriaCliente_Lavadero();
                       
                       if(si<8)
                       {
                         accion.incrementar_basico();
                         
                         moverN(265);
                         imagen.setIcon(iz);
                         accion.insertar_tiempo_lavado(tiempo_de_labado+tiempo_encerado+tiempo_control);
                         accion.insertar_tiempo_encerado(0.0);
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                           caja(der,iz,ar,ab);
                        }else
                        {
                         moverN(310);
                         imagen.setIcon(der);
                         moverD(1050);
                         imagen.setIcon(ar);
                         moverN(150);
                         accion.insertar_tiempo_lavado(tiempo_de_labado);
                         encerado(der,iz,ar,ab); 
                        }
            }
            break;
              case 6: {   //imagen.setLocation(100,70);
                       moverD(960);
                       imagen.setIcon(ar);
                       moverN(480);
                       accion.incrementar_autos_lavado();
                       dormir((int)tiempo_de_labado+100);
                       categoriaCliente_Lavadero();
                      
                       if(si<10)
                       {
                         accion.incrementar_basico();
                        
                         moverN(265);
                         imagen.setIcon(iz);
                         caja(der,iz,ar,ab);
                          accion.insertar_tiempo_lavado(tiempo_de_labado+tiempo_encerado+tiempo_control);
                         accion.insertar_tiempo_encerado(0.0);
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                       }else
                       {
                        moverN(310);
                        imagen.setIcon(der);
                        moverD(1050);
                        imagen.setIcon(ar);
                        moverN(150);
                        accion.insertar_tiempo_lavado(tiempo_de_labado);
                        encerado(der,iz,ar,ab);
                       }
            }
            break;
    
        }
   
   
    }
    
    
    private synchronized void encerado(ImageIcon der,ImageIcon iz,ImageIcon ar,ImageIcon ab){
       
        System.out.println("encerando"+ (encerado-1));
        System.out.println(va.uniforme(1, (encerado-1)));
        
        int i=va.uniforme(1, (encerado-1)); ////////////////////////////////////////////PROB UNIFORME
        double si=va.exponencial(12);
        switch (i){
            case 1: {  
                        imagen.setIcon(iz);
                        moverI(800);
                        imagen.setIcon(ab);
                        moverS(200);
                        imagen.setIcon(iz);
                        moverI(700);     
                        dormir((int)tiempo_encerado+100);
                        accion.incrementar_autos_encerado();//////////////////////////////////////
                                               
                        moverI(630);
                        if(si>20)
                       {
                        
                         imagen.setIcon(ab);
                         moverS(260);
                         imagen.setIcon(iz);
                         accion.incrementar_servicio_plus();
                         categoriaCliente_Encerado();
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                         caja(der,iz,ar,ab);
                       }else
                       {
                        accion.insertar_tiempo_encerado(tiempo_encerado);
                        estacion_control_aceite(der,iz,ar,ab);
                       }
                          
                  
                        
            }
            break;
            case 2: {   imagen.setIcon(iz);
                        moverI(1000);
                        imagen.setIcon(ab);
                        moverS(205);
                        imagen.setIcon(iz);
                        moverI(920);
                        accion.incrementar_autos_encerado();
                        dormir((int)tiempo_encerado+100);           //////////////////////////////////////
                        accion.insertar_tiempo_encerado(tiempo_encerado);                        
                        moverI(630);
                        if(si>20)
                       {
                        
                         imagen.setIcon(ab);
                         moverS(260);
                         imagen.setIcon(iz);
                         accion.incrementar_servicio_plus();
                         categoriaCliente_Encerado();
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                         caja(der,iz,ar,ab);
                       }else
                       {
                        accion.insertar_tiempo_encerado(tiempo_encerado);   
                        estacion_control_aceite(der,iz,ar,ab);
                       }
                        
                     
            }
            break;
            case 3: {  moverN(105);
                       imagen.setIcon(iz);
                       moverI(760);
                       accion.incrementar_autos_encerado();
                       dormir((int)tiempo_encerado+100);           //////////////////////////////////////
                        
                       imagen.setIcon(ab);
                       moverS(200);
                       imagen.setIcon(iz);
                       moverI(630);
                       if(si>20)
                       {
                        
                         imagen.setIcon(ab);
                         moverS(260);
                         imagen.setIcon(iz);
                         accion.incrementar_servicio_plus();
                         categoriaCliente_Encerado();
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                         caja(der,iz,ar,ab);
                       }else
                       {
                         accion.insertar_tiempo_encerado(tiempo_encerado); 
                        estacion_control_aceite(der,iz,ar,ab);
                       }
                       
            }
            break;
            case 4: {   moverN(105);
                        imagen.setIcon(iz);
                        moverI(960);
                        accion.incrementar_autos_encerado();
                        dormir((int)tiempo_encerado+100);           //////////////////////////////////////
                                              
                      
                        imagen.setIcon(ab);
                        moverS(200);
                        imagen.setIcon(iz);
                        moverI(630);
                       if(si>20)
                       {
                        
                         imagen.setIcon(ab);
                         moverS(260);
                         imagen.setIcon(iz);
                         accion.incrementar_servicio_plus();
                         categoriaCliente_Encerado();
                         accion.inserta_tiempo_espera_e2(0.0);
                         accion.insertar_tiempo_control_a(0.0);
                         caja(der,iz,ar,ab);
                       }else
                       {
                         accion.insertar_tiempo_encerado(tiempo_encerado); 
                        estacion_control_aceite(der,iz,ar,ab);
                       }
            }
            break;
          
        }
        dormir(50);
        //cambio_aceite();
    }
    //EL AUTO SABE IR A LA ESTACION  DE CONTROL DE ACEITE
private synchronized void estacion_control_aceite(ImageIcon der,ImageIcon iz,ImageIcon ar,ImageIcon ab)
 {
          
          int i= accion.getCantidadAutos_estacionamiento_encerado();
          //int  h= estacionamiento2.getVacioI();
          int g= estacion_control.getVacioI();
         //VERIFICA SI EL ESTACIONAMIENTO DE LAVADO  Y  LA ESTACION DE LAVADO ESTA VACIO
       //SI ES ASI PASA DIRECTO A LA ESTACION DE LAVADO
      /* if(h==0 && g==0)
        {
             moverI(482);
             imagen.setIcon(ab);
             moverS(150);
             imagen.setIcon(iz);
             cambio_aceite(der,iz,ar,ab); 
        }
       // Y  
       else
        {
         int aux=estacionamiento2.getEspacioDesocupadoI();
         System.out.println(aux);
         i=aux;
         System.out.println(i);*/
       
        switch (i){
            case 0: {   //imagen.setIcon(new ImageIcon("Imagenes/caminaD.gif"));
                    imagen.setIcon(ar);
                    moverN(60);  
                    imagen.setIcon(iz);
                    moverI(540);
                    categoriaCliente_Parqueo2();
                    dormir((int)tiempo_control+100);
                    accion.incrementar_servicio_completo();
                    accion.inserta_tiempo_espera_e2(tiempo_control); 
                    moverI(482);
                    imagen.setIcon(ab);
                    moverS(150);
                    imagen.setIcon(iz);
                    cambio_aceite(der,iz,ar,ab);
            }
            break;
            case 1: {   //imagen.setIcon(new ImageIcon("Imagenes/caminaD.gif"));
                    imagen.setIcon(ar);
                    moverN(100);  
                    imagen.setIcon(iz);
                    moverI(540);
                    categoriaCliente_Parqueo2();
                    accion.incrementar_autos_estacionamiento_control();
                    dormir((int)tiempo_control+100); 
                    accion.incrementar_servicio_completo();
                    accion.inserta_tiempo_espera_e2(tiempo_control); 
                    moverI(482);
                    imagen.setIcon(ab);
                    moverS(150);
                    imagen.setIcon(iz);
                    cambio_aceite(der,iz,ar,ab);
            
            }
            break;
            case 2: {   //imagen.setIcon(new ImageIcon("Imagenes/caminaD.gif"));
                    imagen.setIcon(ar);
                    moverN(150);  
                    imagen.setIcon(iz);
                    moverI(540);
                    categoriaCliente_Parqueo2();
                    accion.incrementar_autos_estacionamiento_control();
                    dormir((int)tiempo_control+100); 
                    accion.incrementar_servicio_completo();
                    accion.inserta_tiempo_espera_e2(tiempo_control); 
                    moverI(482);
                    imagen.setIcon(iz);
                    cambio_aceite(der,iz,ar,ab);
            }
            break;
            case 3: {   //imagen.setIcon(new ImageIcon("Imagenes/caminaD.gif"));
                    imagen.setIcon(ar); //ar
                    moverN(180);  
                    imagen.setIcon(iz);
                    moverI(540);
                    categoriaCliente_Parqueo2();
                    accion.incrementar_autos_estacionamiento_control();
                    dormir((int)tiempo_control+100); 
                    accion.incrementar_servicio_completo();
                    accion.inserta_tiempo_espera_e2(tiempo_control); 
                    moverI(482);
                    imagen.setIcon(ar);
                    moverN(150);
                    imagen.setIcon(iz);
                    cambio_aceite(der,iz,ar,ab);
            }
            break;
            case 4: {   //imagen.setIcon(new ImageIcon("Imagenes/caminaD.gif"));
            
                    imagen.setIcon(ab);
                    moverS(220);  
                    imagen.setIcon(iz);
                    moverI(540);
                    categoriaCliente_Parqueo2();
                    accion.incrementar_autos_estacionamiento_control();
                    dormir((int)tiempo_control+100);
                    accion.incrementar_servicio_completo();
                    accion.inserta_tiempo_espera_e2(tiempo_control); 
                    moverI(482);
                    imagen.setIcon(ar);
                    moverN(150);
                    imagen.setIcon(iz);
                    cambio_aceite(der,iz,ar,ab);
            }
            break;
        }
    //}
   }
     private synchronized void cambio_aceite(ImageIcon der,ImageIcon iz,ImageIcon ar,ImageIcon ab){
        int i=va.uniforme(1, (control_a-1)); 
        switch (i){
            case 1: {   //imagen.setIcon(new ImageIcon("Imagenes/caminaD.gif"));
                        moverI(400);
                        imagen.setIcon(ab);
                        moverS(195);
                        imagen.setIcon(ar);
                        accion.incrementar_autos_estacionamiento_control();
                        categoriaCliente_Control();
                        dormir((int)tiempo_control+500); 
                        accion.insertar_tiempo_control_a(tiempo_control);
                        moverN(150);
                        imagen.setIcon(iz);
                        moverI(160);
                        imagen.setIcon(ab);
                        moverS(260);
                        imagen.setIcon(iz);
                        caja(der,iz,ar,ab);
                        
                          
            
            }
            break;
             case 2: { // imagen.setIcon(ab);
                        moverI(240);
                        imagen.setIcon(ab);
                        moverS(195);
                        imagen.setIcon(ar);
                        accion.incrementar_autos_estacionamiento_control();
                        categoriaCliente_Control();
                        dormir((int)tiempo_control+500); 
                        //accion.incrementar_autos_estacionamiento_control();
                        moverN(150);
                        imagen.setIcon(iz);
                        moverI(160);
                        imagen.setIcon(ab);
                        moverS(260);
                        imagen.setIcon(iz);
                        caja(der,iz,ar,ab);
            }
            break;
            case 3: {   //imagen.setIcon(ab);
                        moverI(400);
                        imagen.setIcon(ab);
                        moverN(60);                       
                        imagen.setIcon(ar);
                        accion.incrementar_autos_estacionamiento_control();
                        categoriaCliente_Control();
                        dormir((int)tiempo_control+500); 
                       // accion.incrementar_autos_estacionamiento_control();
                        moverN(60);
                        imagen.setIcon(iz);
                        moverI(160);
                        imagen.setIcon(ab);
                        moverS(260);
                        imagen.setIcon(iz);
            }
            break;
            case 4: {  //  imagen.setIcon(ab);
                        moverI(240);
                        imagen.setIcon(ab);
                        moverN(60);                       
                        imagen.setIcon(ar);
                        accion.incrementar_autos_estacionamiento_control();
                        categoriaCliente_Control();
                        dormir((int)tiempo_control+500);
                       // accion.incrementar_autos_estacionamiento_control();
                        moverN(60);
                        imagen.setIcon(iz);
                        moverI(160);
                        imagen.setIcon(ab);
                        moverS(260);
                        imagen.setIcon(iz);
                        caja(der,iz,ar,ab);
            }
          
        }
        
    }
    
     private synchronized void caja(ImageIcon der,ImageIcon iz,ImageIcon ar,ImageIcon ab)
     {       
          moverI(50);
          dormir(1000); 
          moverI(-10);
              imagen.setIcon(new ImageIcon("Imagenes/vacio"));
     }
    
     //.....METODO PARA CONTAR SOCIOS........
      private void categoriaCliente_NA()
     {       
         if(etiquetaCliente==1)
          {
              accion.incrementar_NA_AS();
          }
          else if(etiquetaCliente==2)
          {
              accion.incrementar_NA_AS();
              //accion.incrementar_NA_ANS();
          }
          else if (etiquetaCliente==3)
          {
              accion.incrementar_NA_AS();
              //accion.incrementar_NA_CS();
          }
          else 
          {
              accion.incrementar_NA_AS();
              //accion.incrementar_NA_CNS();
          }
     }
     
      private void categoriaCliente_Parqueo1()
     {       
         if(etiquetaCliente==1)
          {
              accion.incrementar_parqueo1_AS();
              accion.incrementar_Array_parqueo1__AS( (Double)tiempo_de_labado);
          }
          else if(etiquetaCliente==2)
          {
              accion.incrementar_parqueo1_AS();
              accion.incrementar_Array_parqueo1__AS( (Double)tiempo_de_labado);
              /*
              accion.incrementar_parqueo1_ANS();
              accion.incrementar_Array_parqueo1_ANS((Double)tiempo_de_labado);
          */}
          else if (etiquetaCliente==3)
          {
              accion.incrementar_parqueo1_AS();
              accion.incrementar_Array_parqueo1__AS( (Double)tiempo_de_labado);
              /*
              accion.incrementar_parqueo1_CS();
              accion.incrementar_Array_parqueo1_CS(tiempo_de_labado);
          */}
          else 
          {
              accion.incrementar_parqueo1_AS();
              accion.incrementar_Array_parqueo1__AS( (Double)tiempo_de_labado);
              /*
              accion.incrementar_parqueo1_CNS();
              accion.incrementar_Array_parqueo1_CNS(tiempo_de_labado);
          */}
     }
       private void categoriaCliente_Parqueo2()
     {       
         if(etiquetaCliente==1)
          {
              accion.incrementar_parqueo2_AS();
              accion.incrementar_Array_parqueo2_AS(tiempo_control);
          }
          else if(etiquetaCliente==2)
          {
              accion.incrementar_parqueo2_AS();
              accion.incrementar_Array_parqueo2_AS(tiempo_control);
              /*
              accion.incrementar_parqueo2_ANS();
              accion.incrementar_Array_parqueo2_ANS(tiempo_control);
          */}
          else if (etiquetaCliente==3)
          {
              accion.incrementar_parqueo2_AS();
              accion.incrementar_Array_parqueo2_AS(tiempo_control);
              /*
              accion.incrementar_parqueo2_CS();
              accion.incrementar_Array_parqueo2_CS(tiempo_control);
          */}
          else 
          {
              accion.incrementar_parqueo2_AS();
              accion.incrementar_Array_parqueo2_AS(tiempo_control);
              /*
              accion.incrementar_parqueo2_CNS();
              accion.incrementar_Array_parqueo2_CNS(tiempo_control);
          */}
     }
     
     
     private void categoriaCliente_Lavadero()
     {       
         if(etiquetaCliente==1)
          {
              accion.incrementar_lava_AS();
              accion.incrementar_Array_lava_AS(tiempo_de_labado);
          }
          else if(etiquetaCliente==2)
          {
              accion.incrementar_lava_AS();
              accion.incrementar_Array_lava_AS(tiempo_de_labado);
              /*
              accion.incrementar_lava_ANS();
              accion.incrementar_Array_lava_ANS(tiempo_de_labado);
          */}
          else if (etiquetaCliente==3)
          {
              accion.incrementar_lava_AS();
              accion.incrementar_Array_lava_AS(tiempo_de_labado);
              /*
              accion.incrementar_lava_CS();
              accion.incrementar_Array_lava_CS(tiempo_de_labado);
          */}
          else 
          {
              accion.incrementar_lava_AS();
              accion.incrementar_Array_lava_AS(tiempo_de_labado);
              /*
              accion.incrementar_lava_CNS();
              accion.incrementar_Array_lava_CNS(tiempo_de_labado);
          */}
     }
     private void categoriaCliente_Encerado()
     {       
         if(etiquetaCliente==1)
          {
              accion.incrementar_ence_AS();
              accion.incrementar_Array_encerado_AS(tiempo_encerado);
          }
          else if(etiquetaCliente==2)
          {
              accion.incrementar_ence_AS();
              accion.incrementar_Array_encerado_AS(tiempo_encerado);
              /*
              accion.incrementar_ence_ANS();
              accion.incrementar_Array_encerado_ANS(tiempo_encerado);
          */}
          else if (etiquetaCliente==3)
          {
              accion.incrementar_ence_AS();
              accion.incrementar_Array_encerado_AS(tiempo_encerado);
              /*
              accion.incrementar_ence_CS();
              accion.incrementar_Array_encerado_CS(tiempo_encerado);
          */}
          else 
          {
              accion.incrementar_ence_AS();
              accion.incrementar_Array_encerado_AS(tiempo_encerado);
              /*
              accion.incrementar_ence_CNS();
              accion.incrementar_Array_encerado_CNS(tiempo_encerado);
          */}
     }
       private void categoriaCliente_Control()
     {       
         if(etiquetaCliente==1)
          {
              accion.incrementar_control_AS();
              accion.incrementar_Array_control_AS(tiempo_control);
          }
          else if(etiquetaCliente==2)
          {
              accion.incrementar_control_AS();
              accion.incrementar_Array_control_AS(tiempo_control);
              /*
              accion.incrementar_control_ANS();
              accion.incrementar_Array_control_ANS(tiempo_control);
          */}
          else if (etiquetaCliente==3)
          {
              accion.incrementar_control_AS();
              accion.incrementar_Array_control_AS(tiempo_control);
              /*
              accion.incrementar_control_CS();
              accion.incrementar_Array_control_CS(tiempo_control);
          */}
          else 
          {
              accion.incrementar_control_AS();
              accion.incrementar_Array_control_AS(tiempo_control);
              /*
              accion.incrementar_control_CNS();
              accion.incrementar_Array_control_CNS(tiempo_control);
          */}
     }
     
     
     // .....METODOS DEL VEHICULO EN GENERAL....      
     private void moverD(int pos){
        while(play && imagen.getX()<pos){
            try {
                sleep(velocidad*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imagen.setLocation(imagen.getX()+10, imagen.getY());
        }
    }
    private void moverI(int pos){
        while(play && imagen.getX()>pos){
            try {
                
                sleep(velocidad*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imagen.setLocation(imagen.getX()-10, imagen.getY());
        }
    }
    private void moverS(int pos){
        while(play && imagen.getY()<pos){
            try {
                sleep(velocidad*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imagen.setLocation(imagen.getX(), imagen.getY()+10);
        }
    }
    private void moverN(int pos){
        while(play && imagen.getY()>pos){
            try {
                sleep(velocidad*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imagen.setLocation(imagen.getX(), imagen.getY()-10);
        }
    }
    private void dormir(int x){
        try {
            velocidad= accion.velo;
            sleep(velocidad*x);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
    public void parar() {
        play=false;
        
    }
    public void continuar(){
        play=true;
    }
    public void actualizarvelo(){
        
        velocidad= accion.velo;
    }
        
   private int atencion_lavado(){
        int res=accion.m_atencion_lavado;
        if (res==0){res=(int)(va.exponencial(15))*100;}
        else if (res==1){res=(int)(va.uniforme(8, 10)*100);}  //uniforme
        else if (res==2){res=(int)(va.normal(0.5, 15, 10))*100;}  //normal
        else if (res==3){res=(va.transformadaInversa())*10;}  //trns inversa
        else if (res==4){res=(int)(va.exponencial(3.4))*100;}  //bermolli
        return res;
    }
    private int atencion_encerado(){
        int res=accion.m_atencion_encerado;
        if (res==0){res=(va.transformadaInversa())*10;}  //Trans. Inversa
        else if (res==1){res=(int)(va.normal(2.2, 1.33, 100))*100;}  //normal
        else if (res==2){res=(int)(va.exponencial(10))*100;}  //esponencial
        else if (res==3){res=(int)(va.uniforme(8, 10)*100);}  //uniforme
        return res;
    }
    private int atencion_control_a(){
        int res=accion.m_atencion_control_a;
        if (res==0){res=(va.transformadaInversa())*10;}  //Trans. Inversa
        else if (res==1){res=(int)(va.normal(2.2, 1.33, 100))*100;}  //normal
        else if (res==2){res=(int)(va.exponencial(10))*100;}  //esponencial
        else if (res==3){res=(int)(va.uniforme(8, 10)*100);}  //uniforme
        return res;
    }
}