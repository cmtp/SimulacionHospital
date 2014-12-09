/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simulacionhospital;

import java.util.ArrayList;
public class Estacion_Lavado
{   public String tipo ="estacion lavado";
    public int estacion;
    public  int vacio;
    public  ArrayList<Integer> listaEstado; 
    public Estacion_Lavado()
    {
       estacion=0; 
       vacio=0;
       listaEstado= new ArrayList <Integer>();   
    }
    public  void ocupadoEstacion()
    {
       estacion=1;
    }
    public   void desocupadoEstacion()
    {
       estacion=0;
    }
    // Ocupado ----> 1
    // No ocupado --->0
    public  int getVacio()
      {
         if(estacion==0)
            {vacio=0;}
         else
             {vacio=1;}
         return vacio;
      }  
  }
