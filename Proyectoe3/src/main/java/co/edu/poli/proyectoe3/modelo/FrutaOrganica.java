package co.edu.poli.proyectoe3.modelo;

import java.io.*;

public class FrutaOrganica extends Fruta implements Serializable {
    private static final long serialVersionUID = 1L;

    public FrutaOrganica(String paisOrigen, int id, String nombre, String variedad, String descripcion, double pesoPromedio, double cantidadCosechada, Cuidado[] cuidados, RegistroCosecha[] registros, int anioCreacion) {
        super(id, nombre, variedad, descripcion, pesoPromedio, cantidadCosechada, cuidados, registros, anioCreacion);
        this.paisOrigen = paisOrigen;
    }

    private String paisOrigen;

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return super.toString() + ", FrutaOrganica{" + "paisOrigen=" + paisOrigen + '}';
    }
}
