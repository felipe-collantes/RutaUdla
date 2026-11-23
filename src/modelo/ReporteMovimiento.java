package modelo;
import java.time.LocalDateTime;

public class ReporteMovimiento {

    // Atributos
    private int idReporte;
    private String tipoMovimiento;
    private LocalDateTime fechaHora;
    private String estadoCorroboracion;

    // Constructor
    public ReporteMovimiento(int idReporte, String tipoMovimiento,
                             LocalDateTime fechaHora) {

        this.idReporte = idReporte;
        this.tipoMovimiento = tipoMovimiento;
        this.fechaHora = fechaHora;
        this.estadoCorroboracion = "Pendiente";
    }

    // Validar reporte
    public boolean validarReporte() {

        return idReporte > 0
                && tipoMovimiento != null
                && !tipoMovimiento.trim().isEmpty()
                && fechaHora != null;
    }

    // Corroborar reporte
    public void corroborarReporte() {

        if (validarReporte()) {
            estadoCorroboracion = "Corroborado";
        } else {
            estadoCorroboracion = "Rechazado";
        }
    }

    // Getters
    public int getIdReporte() {
        return idReporte;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getEstadoCorroboracion() {
        return estadoCorroboracion;
    }

    // Setter
    public void setEstadoCorroboracion(String estadoCorroboracion) {
        this.estadoCorroboracion = estadoCorroboracion;
    }
}
