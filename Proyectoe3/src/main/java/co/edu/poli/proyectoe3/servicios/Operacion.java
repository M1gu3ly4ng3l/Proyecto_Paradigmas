package co.edu.poli.proyectoe3.servicios;

import co.edu.poli.proyectoe3.modelo.Fruta;

public interface Operacion {

    public String create(Fruta ft);

    public Fruta read(int id);

    public Fruta[] readAll();

    public Fruta update(int id, Fruta ft);

    public Fruta delete(int id);

}
