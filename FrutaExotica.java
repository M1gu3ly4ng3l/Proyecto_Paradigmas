package co.edu.poli.proyecto.modelo;

import java.io.*;

public class FrutaExotica extends Fruta implements Serializable {
    private static final long serialVersionUID = 1L;

    public FrutaExotica(boolean certificada, int id, String nombre, String variedad, String descripcion, double pesoPromedio, double cantidadCosechada, Cuidado[] cuidados, RegistroCosecha[] registros, int anioCreacion) {
        super(id, nombre, variedad, descripcion, pesoPromedio, cantidadCosechada, cuidados, registros, anioCreacion);
        this.certificada = certificada;
    }

    private boolean certificada;

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    @Override
    public String toString() {
        return "FrutaExotica{" + "certificada=" + certificada + '}';
    }

}
