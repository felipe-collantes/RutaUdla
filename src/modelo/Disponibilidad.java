package modelo;
import java.time.LocalDateTime;

public class Disponibilidad {
    // Atributos
    private int idDisponibilidad;
    private String estado;
    private LocalDateTime fechaHora;

    // Constructor
    public Disponibilidad(int idDisponibilidad, String estado,
                          LocalDateTime fechaHora) {

        this.idDisponibilidad = idDisponibilidad;
        this.estado = estado;
        this.fechaHora = fechaHora;
    }

    // Actualizar estado del servicio
    public void actualizarEstado(String nuevoEstado) {

        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {

            this.estado = nuevoEstado;
            this.fechaHora = LocalDateTime.now();
        }
    }

    // Consultar estado actual
    public String consultarEstado() {
        return estado;
    }

    // Getters
    public int getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

}
