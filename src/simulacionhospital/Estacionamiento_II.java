/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

/**
 * Write a description of class Estacionamiento_II here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Estacionamiento_II
{
    public String tipo="estacion control";
    public int espacio1;
    public int espacio2;
    public int espacio3;
    public int espacio4;
    public int espacio5;
    public int vacioI;
    public ArrayList<Integer> listaEstadoI; 
    public Estacionamiento_II()
    {
       espacio1=0; 
       espacio2=0;
       espacio3=0;
       espacio4=0;
       espacio5=0;
       vacioI=0;
       listaEstadoI= new ArrayList <Integer>();   
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
    // Ocupado ----> 1
    // No ocupado --->0
    public  int getVacioI()
      {
           int i=0;
           listaEstadoI.add(i,espacio1);
           listaEstadoI.add(i+1,espacio2);
           listaEstadoI.add(i+2,espacio3);
           listaEstadoI.add(i+3,espacio4);
           listaEstadoI.add(i+4,espacio5);
           for (int j=0;j<=5;j++)
           {
               if(listaEstadoI.get(j)==0)
               {vacioI=0;}
               else
               {vacioI=1;}
            }
           return vacioI;
      }  
      public int getEspacioDesocupadoI()
      {
           int i=0;
           int espacioVacioI=10;
           listaEstadoI.add(i,espacio1);
           listaEstadoI.add(i+1,espacio2);
           listaEstadoI.add(i+2,espacio3);
           listaEstadoI.add(i+3,espacio4);
           listaEstadoI.add(i+4,espacio5);
           for (int j=0;j<=5;j++)
           {
               if(listaEstadoI.get(j)==0)
               {
                   espacioVacioI=j;
               }
            }
           return espacioVacioI ;
      }

}
