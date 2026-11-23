package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    // Atributos
    private int idRuta;
    private String nombre;
    private String origen;
    private String destino;
    private String sentido;

    // Relacion con la clase Parada
    private List<Parada> paradas;

    // Constructor
    public Ruta(int idRuta, String nombre, String origen,
                String destino, String sentido) {

        this.idRuta = idRuta;
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.sentido = sentido;
        this.paradas = new ArrayList<>();
    }

    // Buscar una parada por su nombre
    public Parada buscarParada(String nombreParada) {

        for (Parada parada : paradas) {

            if (parada.getNombre().equalsIgnoreCase(nombreParada)) {
                return parada;
            }
        }

        return null;
    }

    // Consultar el recorrido de la ruta
    public List<Parada> consultarRecorrido() {
        return new ArrayList<>(paradas);
    }

    // Agregar una parada a la ruta
    public void agregarParada(Parada parada) {
        if (parada != null) {
            paradas.add(parada);
        }
    }

    // Getters y setters
    public int getIdRuta() {
        return idRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public String getSentido() {
        return sentido;
    }

    public List<Parada> getParadas() {
        return new ArrayList<>(paradas);
    }
}

