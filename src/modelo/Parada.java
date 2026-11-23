package modelo;

public class Parada {
    // Atributos
    private int idParada;
    private String nombre;
    private String ubicacion;
    private int orden;

    // Constructor
    public Parada(int idParada, String nombre,
                  String ubicacion, int orden) {

        this.idParada = idParada;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.orden = orden;
    }

    // Mostrar informacion de la parada
    public void mostrarInformacion() {

        System.out.println("ID de parada: " + idParada);
        System.out.println("Nombre: " + nombre);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Orden: " + orden);
    }

    // Getters
    public int getIdParada() {
        return idParada;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getOrden() {
        return orden;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }
}
