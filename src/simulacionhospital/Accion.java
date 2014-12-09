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

/**
 * Write a description of class Accion here.
 * 
 * @author (remy sejas encinas)
 * @version ( version 1.01)
 */

import java.util.*;    
public class Accion
{
   public static int m_atencion_llegadas;
   public static int m_atencion_lavado;
   public static int m_atencion_encerado;
   public static int m_atencion_control_a;
   public static int autos;
   public static int total_parqueo;
   public static int autos_no_atendidos;//por estar lleno el servicio
   public static int autos_lavado;
   public static int autos_en_encerado;
   public static int autos_control_aceite;
   public static int velo;
   public static int tiempo;
   public static int autos_estacionamiento_control;
   public static int servicio_plus;
   public static int servicio_basico;
   public static int servicio_completo;
   public static int completo_en_labado;
   public static int camioneta_socio;
   public static int camioneta_no_socio;
   public static int auto_socio;
   public static int auto_no_socio;
   public static int vehiculo_sola_estacion;
    //array de autos
    public ArrayList<Object> auto_tabla;
    public static ArrayList<Double> tiempo_llegada_auto;
    public static ArrayList<Double> tiempo_en_parqueo_llegada;//ya
    public static ArrayList<Double> tiempo_antencion_encerado;//ya
    public static ArrayList<Double> tiempo_atencion_labado;//ya
    public static ArrayList<Double> tiempo_en_parqueo_control_aceite;//ya
    public static ArrayList<Double> tiempo_atencion_control_aceite;
    
    // Para Reynaldo
    //Lavado
    public static int lava_AS;
    public static int lava_ANS;
    public static int lava_CS;
    public static int lava_CNS;
    public static ArrayList<Double> lavadero_AS;
    public static ArrayList<Double> lavadero_ANS;
    public static ArrayList<Double> lavadero_CNS;
    public static ArrayList<Double> lavadero_CS;
    
    public static int ence_AS;
    public static int ence_ANS;
    public static int ence_CS;
    public static int ence_CNS;
    public static ArrayList<Double> encerado_AS;
    public static ArrayList<Double> encerado_ANS;
    public static ArrayList<Double> encerado_CNS;
    public static ArrayList<Double> encerado_CS;
    
    public static int contro_AS;
    public static int contro_ANS;
    public static int contro_CS;
    public static int contro_CNS;
    public static ArrayList<Double> control_AS;
    public static ArrayList<Double> control_ANS;
    public static ArrayList<Double> control_CNS;
    public static ArrayList<Double> control_CS;
    
    public static int parqueo1_AS;
    public static int parqueo1_ANS;
    public static int parqueo1_CS;
    public static int parqueo1_CNS;
    public static ArrayList<Double> Aparqueo1_AS;
    public static ArrayList<Double> Aparqueo1_ANS;
    public static ArrayList<Double> Aparqueo1_CNS;
    public static ArrayList<Double> Aparqueo1_CS;
    
    public static int parqueo2_AS;
    public static int parqueo2_ANS;
    public static int parqueo2_CS;
    public static int parqueo2_CNS;
    public static ArrayList<Double> Aparqueo2_AS;
    public static ArrayList<Double> Aparqueo2_ANS;
    public static ArrayList<Double> Aparqueo2_CNS;
    public static ArrayList<Double> Aparqueo2_CS;
    
    public static int NA_AS;
    public static int NA_ANS;
    public static int NA_CS;
    public static int NA_CNS;

    public Accion()
    {
       
         autos=0;
         tiempo=0;
         autos_no_atendidos=0;
         autos_estacionamiento_control=0;
         servicio_plus=0;
         servicio_basico=0;
         servicio_completo=0;
         completo_en_labado=0;
         camioneta_socio=0;
         camioneta_no_socio=0;
         auto_socio=0;
         auto_no_socio=0;
         vehiculo_sola_estacion=0;
         
       auto_tabla= new ArrayList<Object>();
       tiempo_llegada_auto   = new ArrayList<Double>();
       tiempo_en_parqueo_llegada= new  ArrayList<Double>();
       tiempo_atencion_labado= new  ArrayList<Double>();
        tiempo_antencion_encerado= new  ArrayList<Double>();
       tiempo_en_parqueo_control_aceite= new  ArrayList<Double>();
       tiempo_atencion_control_aceite= new  ArrayList<Double>();
       ////
     lava_AS=0;
     lava_ANS=0;
     lava_CS=0;
     lava_CNS=0;
     lavadero_AS=new ArrayList<Double> (); 
     lavadero_ANS= new ArrayList<Double> ();
     lavadero_CNS=new ArrayList<Double> ();
     lavadero_CS= new ArrayList<Double> ();
     
     ence_AS=0;
     ence_ANS=0;
     ence_CS=0;
     ence_CNS=0;
     encerado_AS= new ArrayList<Double> (); 
     encerado_ANS= new ArrayList<Double> ();
     encerado_CNS= new ArrayList<Double>(); 
     encerado_CS= new ArrayList<Double> ();
    
     contro_AS=0;
     contro_ANS=0;
     contro_CS=0;
     contro_CNS=0;
     control_AS= new ArrayList<Double> ();
     control_ANS= new ArrayList<Double> ();
     control_CNS= new ArrayList<Double> ();
     control_CS= new ArrayList<Double> ();
     
     parqueo1_AS=0;
     parqueo1_ANS=0;
     parqueo1_CS=0;
     parqueo1_CNS=0;
     Aparqueo1_AS= new ArrayList<Double> ();
     Aparqueo1_ANS= new ArrayList<Double> ();
     Aparqueo1_CNS= new ArrayList<Double> ();
     Aparqueo1_CS= new ArrayList<Double> ();
     
     parqueo2_AS=0;
     parqueo2_ANS=0;
     parqueo2_CS=0;
     parqueo2_CNS=0;
     Aparqueo2_AS= new ArrayList<Double> ();
     Aparqueo2_ANS= new ArrayList<Double> ();
     Aparqueo2_CNS= new ArrayList<Double> ();
     Aparqueo2_CS= new ArrayList<Double> ();
        NA_AS=0;
        NA_ANS=0;
        NA_CS=0;
        NA_CNS=0;
    
    }

    // METODOS DE CAMIONETAS-AUTOS PROMEDIO SOCIO -NO SOCIO
    // ARRAYLIST
     public  static synchronized void incrementar_Array_lava_AS( double d)
     {
         lavadero_AS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_lava_ANS(double d)
      {
         lavadero_ANS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_lava_CS(double d)
      {
         lavadero_CS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_lava_CNS(double d )
      {
         lavadero_CNS.add((Double)d); 
      }
      
       public static synchronized void incrementar_lava_AS()
      {
         lava_AS ++; 
      }
      public static synchronized void incrementar_lava_ANS()
      {
         lava_ANS ++; 
      }
      public static synchronized void incrementar_lava_CS()
      {
         lava_CS ++; 
      }
      public static synchronized void incrementar_lava_CNS()
      {
         lava_CNS ++; 
      }
      
      public int  getLava_AS()
      {
          return lava_AS ; 
      }
      public int  getLava_ANS()
      {
          return lava_ANS ; 
      }
       public int  getLava_CS()
      {
          return lava_CS ; 
      }
      public int  getLava_CNS()
      {
          return lava_CNS ; 
      }
      //no atendidos
       public static synchronized void incrementar_NA_AS()
      {
         NA_AS ++; 
      }
      public static synchronized void incrementar_NA_ANS()
      {
         NA_ANS ++; 
      }
      public static synchronized void incrementar_NA_CS()
      {
         NA_CS ++; 
      }
      public static synchronized void incrementar_NA_CNS()
      {
         NA_CNS ++; 
      }
      
      public int  getNA_AS()
      {
          return NA_AS ; 
      }
      public int  getNA_ANS()
      {
          return NA_ANS ; 
      }
       public int  getNA_CS()
      {
          return NA_CS ; 
      }
      public int  getNA_CNS()
      {
          return NA_CNS ; 
      }
      
      
      
     
      //***ENCERADO
      public static synchronized void incrementar_Array_encerado_AS( double d )
      {
         encerado_AS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_encerado_ANS(double d)
      {
         encerado_ANS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_encerado_CS(double d)
      {
         encerado_CS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_encerado_CNS(double d )
      {
         encerado_CNS.add((Double)d); 
      }
      
       public static synchronized void incrementar_ence_AS()
      {
         ence_AS ++; 
      }
      public static synchronized void incrementar_ence_ANS()
      {
         ence_ANS ++; 
      }
      public static synchronized void incrementar_ence_CS()
      {
         ence_CS ++; 
      }
      public static synchronized void incrementar_ence_CNS()
      {
         ence_CNS ++; 
      }
      public int  getEnce_AS()
      {
          return ence_AS ; 
      }
      public int  getEnce_ANS()
      {
          return ence_ANS ; 
      }
       public int  getEnce_CS()
      {
        return  ence_CS ; 
      }
      public int  getEnce_CNS()
      {
          return ence_CNS ; 
      }
    //***ACEITE
    
      public static synchronized void incrementar_Array_control_AS( double d )
      {  
         control_AS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_control_ANS(double d)
      {
         control_ANS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_control_CS(double d)
      {
         control_CS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_control_CNS(double d )
      {
         control_CNS.add((Double)d); 
      }
      
       public static synchronized void incrementar_control_AS()
      {
         contro_AS ++; 
      }
      public static synchronized void incrementar_control_ANS()
      {
         contro_ANS ++; 
      }
      public static synchronized void incrementar_control_CS()
      {
         contro_CS ++; 
      }
      public static synchronized void incrementar_control_CNS()
      {
         contro_CNS ++; 
      }
      
      public int  getControl_AS()
      {
          return contro_AS ; 
      }
      public int  getControl_ANS()
      {
          return contro_ANS ; 
      }
       public int  getControl_CS()
      {
        return  contro_CS ; 
      }
      public int  getControl_CNS()
      {
          return contro_CNS ; 
      }
      
      // Parqueo1 Lavado
      public static synchronized void incrementar_Array_parqueo1__AS( double d )
      {  
         Aparqueo1_AS.add(d); 
      }
      public static synchronized void incrementar_Array_parqueo1_ANS(double d)
      {
         Aparqueo1_ANS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_parqueo1_CS(double d)
      {
         Aparqueo1_CS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_parqueo1_CNS(double d )
      {
         Aparqueo1_CNS.add((Double)d); 
      }
      
       public static synchronized void incrementar_parqueo1_AS()
      {
         parqueo1_AS ++; 
      }
      public static synchronized void incrementar_parqueo1_ANS()
      {
         parqueo1_ANS ++; 
      }
      public static synchronized void incrementar_parqueo1_CS()
      {
         parqueo1_CS ++; 
      }
      public static synchronized void incrementar_parqueo1_CNS()
      {
         parqueo1_CNS ++; 
      }
      
      public int  getParqueo1_AS()
      {
          return parqueo1_AS ; 
      }
      public int  getParqueo1_ANS()
      {
          return parqueo1_ANS ; 
      }
       public int  getParqueo1_CS()
      {
        return  parqueo1_CS ; 
      }
      public int  getParqueo1_CNS()
      {
          return parqueo1_CNS ; 
      }
      
      public ArrayList <Double>  getAParqueo1_AS()
      {
          return Aparqueo1_AS ; 
      }
      public ArrayList <Double>  getAParqueo1_ANS()
      {
          return Aparqueo1_ANS ; 
      }
      public ArrayList <Double>  getAParqueo1_CS()
      {
          return Aparqueo1_CS ; 
      }
            public ArrayList <Double>  getAParqueo1_CNS()
      {
          return Aparqueo1_CNS ; 
      }
      
      
      //Parqueo2 Aceite
      public static synchronized void incrementar_Array_parqueo2_AS( double d )
      {  
         Aparqueo2_AS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_parqueo2_ANS(double d)
      {
         Aparqueo2_ANS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_parqueo2_CS(double d)
      {
         Aparqueo2_CS.add((Double)d); 
      }
      public static synchronized void incrementar_Array_parqueo2_CNS(double d )
      {
         Aparqueo2_CNS.add((Double)d); 
      }
      
       public static synchronized void incrementar_parqueo2_AS()
      {
         parqueo2_AS ++; 
      }
      public static synchronized void incrementar_parqueo2_ANS()
      {
         parqueo2_ANS ++; 
      }
      public static synchronized void incrementar_parqueo2_CS()
      {
         parqueo2_CS ++; 
      }
      public static synchronized void incrementar_parqueo2_CNS()
      {
         parqueo2_CNS ++; 
      }
      
      public int  getParqueo2_AS()
      {
          return parqueo2_AS ; 
      }
      public int  getParqueo2_ANS()
      {
          return parqueo2_ANS ; 
      }
       public int  getParqueo2_CS()
      {
        return  parqueo2_CS ; 
      }
      public int  getParqueo2_CNS()
      {
          return parqueo2_CNS ; 
      }
      
      
      
    public static synchronized void incrementar_llegadas()
      {
          //total_parqueo ++;
          autos ++; 
      }
    public static synchronized void incrementar_estacionamiento_lavado()
      {
          total_parqueo ++;
      }
    public int getEstacionamiento_lavado()
      {
          return total_parqueo;
      }
    public static synchronized void incrementar_autos_lavado()
     {
        autos_lavado ++;
     }
    public static synchronized void incrementar_autos_encerado()
    {
        autos_en_encerado ++;
    }
    public static synchronized void incrementar_autos_en_control_aceite()
     {
         autos_estacionamiento_control++;
     }
    public static synchronized void incrementar_autos_estacionamiento_control()
    {
        autos_estacionamiento_control ++;
        if(autos_estacionamiento_control >4 )
         {autos_estacionamiento_control=0;}
    }
     public static synchronized void incrementar_servicio_solo_estacion()
      {
          vehiculo_sola_estacion ++;
      }
    public static synchronized void incrementar_servicio_completo()
    {
         servicio_completo++;
    }
    public static synchronized void incrementar_servicio_plus()
    {
         servicio_plus++;
    }
    public static synchronized void incrementar_basico()
    {
         servicio_basico++;
         completo_en_labado++;
    }
    public static synchronized void incrementar_completo_en_labado()
    {
         completo_en_labado++;
    }
    public static synchronized void velocidad(double ve)
    {
        velo=(int)ve;
    }
    public static synchronized void setHora( int r)
    {   
        tiempo =r;
    }
    public static synchronized void atencion_llegada(int x)
    {
        m_atencion_llegadas = x;
    }
     public static synchronized void atencion_labado(int x){
        m_atencion_lavado = x;
    }
    public static  synchronized void atencion_encerado(int x){
        m_atencion_encerado = x;
    }
      public static  synchronized void atencion_control_a(int x){
        m_atencion_control_a = x;
    }
        // metodos set de tiempos
      //insertando tiempos de estaciones de llegada y esperas en cada seccion 
     public void insertarTiempode_llegadas(Double t)
    {
       tiempo_llegada_auto.add(t);
    }
      public void insertar_tiempo_espera_e1(Double t)
    {
       tiempo_en_parqueo_llegada.add(t);
    }
    
     public void insertar_tiempo_lavado(Double t)
    {
        tiempo_atencion_labado.add(t);
    }
    public void insertar_tiempo_encerado(Double t)
    {
        tiempo_antencion_encerado.add(t);
    }
     public void insertar_tiempo_control_a(Double t)
    {
        tiempo_atencion_control_aceite.add(t);
    }
    
      public void inserta_tiempo_espera_e2(Double t)
    {
        tiempo_en_parqueo_control_aceite.add(t);
    }
    
                  
    public  static synchronized void reiniciar()
    {
       
    }
    
    
    
    public static synchronized void incrementar_autos_no_Atendidos()
    {
        autos_no_atendidos ++;
    }
   //metogos get
    public static synchronized int getServicioSoloEstacion()
    {
        return vehiculo_sola_estacion;
    }
    public static synchronized int getAutosNoAtendidos()
    {
        return autos_no_atendidos;
    }
    public static synchronized int Hora()
    {
        return tiempo;
    }
    public ArrayList<Double> obtenerTiempoLlegada()
    {
        return tiempo_llegada_auto;
    }
    public int getCantidadAutos()
    {
        return autos;
    }
    public int getTotal_vehiculos_atendidos()
    {
        return  servicio_basico;
    }
    public int getServicioBasico()
    {
        return  servicio_basico;
    }
    public int getServicioPlus()
    {
        return  servicio_plus;
    }
    public int getServicioCompleto()
    {
        return  servicio_completo;
    }
    public int getCantidadAutos_estacionamiento_encerado()
    {
        return autos_estacionamiento_control;
    }
    
  
   
}
