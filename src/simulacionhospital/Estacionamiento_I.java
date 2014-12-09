/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

/**
 * Write a description of class Esatacionamiento_I here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Estacionamiento_I
{
    public String tipo="estacion control";
    public int espacio1;
    public  int espacio2;
    public  int espacio3;
    public  int espacio4;
    public  int espacio5;
    public  int espacio6;
    public  int espacio7;
    public  int espacio8;
    public  int espacio9;
    public  int espacio10;
    public  int vacio;
    public  ArrayList<Integer> listaEstado; 
    public Estacionamiento_I()
    {
       espacio1=0; 
       espacio2=0;
       espacio3=0;
       espacio4=0;
       espacio5=0;
       espacio6=0;
       espacio7=0;
       espacio8=0;
       espacio9=0;
       espacio10=0;
       vacio=0;
       listaEstado= new ArrayList <Integer>();   
    }
    public  void ocupadoEspacio1()
      {
       espacio1 =1;
      }
    public  void ocupadoEspacio2()
      {
       espacio2=1;
      }
    public void ocupadoEspacio3()
      {
       espacio3=1;
      }
    public  void ocupadoEspacio4()
      {
       espacio4=1;
      }
    public  void ocupadoEspacio5()
      {
       espacio5=1;
      }
    public  void ocupadoEspacio6()
      {
       espacio6=1;
      }
    public  void ocupadoEspacio7()
      {
       espacio7=1;
      }
    public  void ocupadoEspacio8()
      {
       espacio8=1;
      }
    public  void ocupadoEspacio9()
      {
       espacio9=1;
      }
    public  void ocupadoEspacio10()
      {
       espacio10=1;
      }
    public   void desocupadoEspacio1()
      {
       espacio1=0;
      }
    public  void desocupadoEspacio2()
      {
       espacio2=0;
      }
    public  void desocupadoEspacio3()
      {
       espacio3=0;
      }
    public void desocupadoEspacio4()
      {
       espacio4=0;
      }
    public void desocupadoEspacio5()
      {
       espacio5=0;
      }
    public void desocupadoEspacio6()
      {
       espacio6=0;
      }
    public  void desocupadoEspacio7()
      {
       espacio7=0;
      }
    public  void desocupadoEspacio8()
      {
       espacio8=0;
      }
    public  void desocupadoEspacio9()
      {
       espacio9=0;
      }
    public  void desocupadoEspacio10()
      {
       espacio10=0;
      }  
    // Metodos get del estado delos espacios
     public int getOcupado1()
      {
       return espacio1;
      } 
      public int getOcupado2()
      {
       return espacio2;
      } 
      public int getOcupado3()
      {
       return espacio3;
      } 
      public int getOcupado4()
      {
       return espacio4;
      } 
      public int getOcupado5()
      {
       return espacio5;
      } 
      public int getOcupado6()
      {
       return espacio6;
      } 
      public int getOcupado7()
      {
       return espacio7;
      } 
      public int getOcupado8()
      {
       return espacio8;
      } 
      public int getOcupado9()
      {
       return espacio9;
      } 
      public int getOcupado10()
      {
       return espacio10;
      } 
    // Ocupado ----> 1
    // No ocupado --->0
    public  int getVacio()
      {
           int i=0;
           listaEstado.add(i,espacio1);
           listaEstado.add(i+1,espacio2);
           listaEstado.add(i+2,espacio3);
           listaEstado.add(i+3,espacio4);
           listaEstado.add(i+4,espacio5);
           listaEstado.add(i+5,espacio6);
           listaEstado.add(i+6,espacio7);
           listaEstado.add(i+7,espacio8);
           listaEstado.add(i+8,espacio9);
           listaEstado.add(i+9,espacio10);
           for (int j=0;j<=9;j++)
           {
               if(listaEstado.get(j)==0)
               {vacio=0;}
               else
               {vacio=1;}
            }
           return vacio;
      }  
      public int getEspacioDesocupado()
      {
           int i=0;
           int espacioVacio=10;
           listaEstado.add(i,espacio1);
           listaEstado.add(i+1,espacio2);
           listaEstado.add(i+2,espacio3);
           listaEstado.add(i+3,espacio4);
           listaEstado.add(i+4,espacio5);
           listaEstado.add(i+5,espacio6);
           listaEstado.add(i+6,espacio7);
           listaEstado.add(i+7,espacio8);
           listaEstado.add(i+8,espacio9);
           listaEstado.add(i+9,espacio10);
           for (int j=0;j<=9;j++)
           {
               if(listaEstado.get(j)==0)
               {
                   espacioVacio=j;
               }
            }
           return espacioVacio ;
      }

  
}
