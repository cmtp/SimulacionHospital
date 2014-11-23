/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author marcelo
 */
public class Paciente {
    private int ci;
    private String nombre;
    private String tipoProblema;
    private String rutaImagen;
    private double tiempoLlegada;
    private double tiempoEspera;
    private double TiempoAtencion;

    public Paciente(int ci, String nombre, String tipoProblema, String rutaImagen, double tiempoLlegada, double tiempoEspera, double TiempoAtencion) {
        this.ci = ci;
        this.nombre = nombre;
        this.tipoProblema = tipoProblema;
        this.rutaImagen = rutaImagen;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoEspera = tiempoEspera;
        this.TiempoAtencion = TiempoAtencion;
    }

    public int getCi() {
        return ci;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public double getTiempoAtencion() {
        return TiempoAtencion;
    }

    public double getTiempoEspera() {
        return tiempoEspera;
    }

    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public void setTiempoAtencion(double TiempoAtencion) {
        this.TiempoAtencion = TiempoAtencion;
    }

    public void setTiempoEspera(double tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }
    
}
