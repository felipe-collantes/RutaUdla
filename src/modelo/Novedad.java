package modelo;
import java.time.LocalDateTime;

public class Novedad {
    // Atributos
    private int idNovedad;
    private String tipo;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String estado;

    // Constructor
    public Novedad(int idNovedad, String tipo,
                   String descripcion, LocalDateTime fechaHora,
                   String estado) {

        this.idNovedad = idNovedad;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    // Registrar novedad
    public boolean registrarNovedad() {

        return idNovedad > 0
                && tipo != null && !tipo.trim().isEmpty()
                && descripcion != null && !descripcion.trim().isEmpty()
                && fechaHora != null;
    }

    // Actualizar estado
    public void actualizarEstado(String nuevoEstado) {

        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            this.estado = nuevoEstado;
        }
    }

    // Getters
    public int getIdNovedad() {
        return idNovedad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
