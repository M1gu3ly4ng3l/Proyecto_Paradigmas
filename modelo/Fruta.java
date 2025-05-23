package co.edu.poli.proyectoe3.modelo;

import java.io.*;

public abstract class Fruta implements Serializable {

    private static final long serialVersionUID = 1L;

    public Fruta(int id, String nombre, String variedad, String descripcion, double pesoPromedio, double cantidadCosechada, Cuidado[] cuidados, RegistroCosecha[] registros, int anioCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.variedad = variedad;
        this.descripcion = descripcion;
        this.pesoPromedio = pesoPromedio;
        this.cantidadCosechada = cantidadCosechada;
        this.cuidados = cuidados;
        this.registros = registros;
        this.anioCreacion = anioCreacion;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String variedad;

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private double pesoPromedio;

    public double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    private double cantidadCosechada;

    public double getCantidadCosechada() {
        return cantidadCosechada;
    }

    public void setCantidadCosechada(double cantidadCosechada) {
        this.cantidadCosechada = cantidadCosechada;
    }

    private Cuidado[] cuidados;

    public Cuidado[] getCuidados() {
        return cuidados;
    }

    public void setCuidados(Cuidado[] cuidados) {
        this.cuidados = cuidados;
    }

    private RegistroCosecha[] registros;

    public RegistroCosecha[] getRegistros() {
        return registros;
    }

    public void setRegistros(RegistroCosecha[] registros) {
        this.registros = registros;
    }

    private int anioCreacion;

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    /**
     * @param anioActual
     * @return
     */
    public int calcularEdad(int anioActual) {
        // TODO implement here
        return 0;
    }

    @Override
    public String toString() {
        return "Fruta{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", variedad='" + variedad + '\''
                + ", descripcion='" + descripcion + '\''
                + ", pesoPromedio=" + pesoPromedio
                + ", cantidadCosechada=" + cantidadCosechada
                + ", anioCreacion=" + anioCreacion
                + ", cuidados=" + java.util.Arrays.toString(cuidados)
                + ", registros=" + java.util.Arrays.toString(registros)
                + '}';
    }

}
