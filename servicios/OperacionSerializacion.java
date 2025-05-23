package co.edu.poli.proyectoe3.servicios;

import co.edu.poli.proyectoe3.modelo.*;

public interface OperacionSerializacion {

    public String serializar(Fruta[] ft, String path, String name);

    public Fruta[] deserializar(String path, String name);
}
