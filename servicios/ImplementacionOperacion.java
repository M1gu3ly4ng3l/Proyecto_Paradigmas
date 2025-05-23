package co.edu.poli.proyectoe3.servicios;

import co.edu.poli.proyectoe3.modelo.Fruta;

import java.io.*;

public class ImplementacionOperacion implements Operacion, OperacionSerializacion{

    private Fruta[] frutas = new Fruta[100];
    private int contador = 0;

    @Override
    public String create(Fruta ft) {
        if (contador < frutas.length) {
            frutas[contador++] = ft;
            return "Fruta agregada con éxito.";
        } else {
            return "No hay espacio para más frutas.";
        }
    }

    @Override
    public Fruta read(int id) {
        for (int i = 0; i < contador; i++) {
            if (frutas[i].getId() == id) {
                return frutas[i];
            }
        }
        return null;
    }

     public Fruta[] readAll() {
        Fruta[] copia = new Fruta[contador];
        for (int i = 0; i < contador; i++) {
            copia[i] = frutas[i];
        }
        return copia;

     }
    public Fruta update(int codigo, Fruta nuevaFruta) {
        for (int i = 0; i < contador; i++) {
            if (frutas[i] != null && frutas[i].getId() == codigo) {
                frutas[i] = nuevaFruta;
                return nuevaFruta;
            }
        }
        return null;
    }

    public Fruta delete(int codigo) {
        for (int i = 0; i < contador; i++) {
            if (frutas[i] != null && frutas[i].getId() == codigo) {
                Fruta eliminada = frutas[i];
                // correr todo hacia atrás para no dejar huecos
                for (int j = i; j < contador - 1; j++) {
                    frutas[j] = frutas[j + 1];
                }
                frutas[contador - 1] = null;
                contador--;
                return eliminada;
            }
        }
        return null;
    }

    public String serializar(Fruta[] ft, String path, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Frutas.dat"))) {
            oos.writeObject(ft);  // Aquí serializas un único objeto Fruta
            return "Serialización exitosa.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al serializar.";
        }
    }

    public Fruta[] deserializar(String path, String name) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Frutas.dat"))) {
            return (Fruta[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
