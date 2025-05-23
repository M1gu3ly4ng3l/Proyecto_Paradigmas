package co.edu.poli.proyectoe3.modelo;

import java.io.Serializable;

public class RegistroCosecha implements Serializable {

    private static final long serialVersionUID = 1L;

    public RegistroCosecha(int id, String fecha, double cantidadRecolectada, String observaciones) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadRecolectada = cantidadRecolectada;
        this.observaciones = observaciones;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String fecha;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    private double cantidadRecolectada;

    public double getCantidadRecolectada() {
        return cantidadRecolectada;
    }

    public void setCantidadRecolectada(double cantidadRecolectada) {
        this.cantidadRecolectada = cantidadRecolectada;
    }

    private String observaciones;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return super.toString() + ", RegistroCosecha{" + "id=" + id + ", fecha=" + fecha + ", cantidadRecolectada=" + cantidadRecolectada + ", observaciones=" + observaciones + '}';
    }

}
