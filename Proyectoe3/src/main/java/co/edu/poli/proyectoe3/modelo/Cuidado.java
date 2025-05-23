package co.edu.poli.proyectoe3.modelo;

import java.io.*;

public class Cuidado implements Serializable {
    private static final long serialVersionUID = 1L;

    public Cuidado(int id, String tipoCuidado, String descripcion, int frecuenciaDias) {
        this.id = id;
        this.tipoCuidado = tipoCuidado;
        this.descripcion = descripcion;
        this.frecuenciaDias = frecuenciaDias;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String tipoCuidado;

    public String getTipoCuidado() {
        return tipoCuidado;
    }

    public void setTipoCuidado(String tipoCuidado) {
        this.tipoCuidado = tipoCuidado;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private int frecuenciaDias;

    public int getFrecuenciaDias() {
        return frecuenciaDias;
    }

    public void setFrecuenciaDias(int frecuenciaDias) {
        this.frecuenciaDias = frecuenciaDias;
    }

    @Override
    public String toString() {
        return "Cuidado{" + "id=" + id + ", tipoCuidado=" + tipoCuidado + ", descripcion=" + descripcion + ", frecuenciaDias=" + frecuenciaDias + '}';
    }

}
