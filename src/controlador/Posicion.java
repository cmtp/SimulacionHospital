package controlador;

import java.io.*;

class Posicion
{
		
	private int[] ficha_motos=new int [15];
	private int[] ficha_livianos=new int [30];	
	private int[] coordenadas_livianos=new int [30];
	private int s=110;

	public Posicion()
	{
		
	}
	
	public boolean Buscar_espacio(int tipo,int pos)
    {
		if(tipo==1)
		{
			if(ficha_motos[pos]==0)
				return true;
			else
				return false;
		}
		if(tipo==2)
		{
			if(ficha_livianos[pos]==0)
				return true;
			else
				return false;
		}else
		{
			return false;
		}

	}
	
	
	public void Cambiar_espacio(int tipo,int pos)
	{
		
		if(tipo==1)
		{
			if(ficha_motos[pos]==0)
				ficha_motos[pos]=1;
			else
				ficha_motos[pos]=0;	
		}
		if(tipo==2)
		{
			if(ficha_livianos[pos]==0)
				ficha_livianos[pos]=1;
			else
				ficha_livianos[pos]=0;			
		}
	}
	
	public int Iniciox(int p)
	{
		return coordenadas_livianos[p-1];
	}
	
	public void Iniciarx()
	{
		for(int x=0;x<30;x++)
			{	coordenadas_livianos[x]=s;
				s=s+50;}//Constante para que los autos no ingresen al mismo lugar
	}
	
	public int Estado_motos(int posicio)
	{
			
			return ficha_motos[posicio];

	}
	
  public int Estado_livianos(int posicio)
	{
	
			return ficha_livianos[posicio];
				
		}
		
	
	
}//fin clase Posicion
	