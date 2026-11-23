package modelo;
import java.time.LocalDateTime;
public class Estimacion {
    // Atributos
    private int idEstimacion;
    private double intervaloMinutos;
    private double esperaMinutos;
    private LocalDateTime horaEstimada;

    // Constructor
    public Estimacion(int idEstimacion, double intervaloMinutos,
                      double esperaMinutos, LocalDateTime horaEstimada) {

        this.idEstimacion = idEstimacion;
        this.intervaloMinutos = intervaloMinutos;
        this.esperaMinutos = esperaMinutos;
        this.horaEstimada = horaEstimada;
    }

    // Calcular intervalo
    public double calcularIntervalo() {
        return intervaloMinutos;
    }

    // Estimar hora de salida
    public LocalDateTime estimarSalida() {

        long segundos = Math.round(esperaMinutos * 60);

        return horaEstimada.plusSeconds(segundos);
    }

    // Estimar hora de llegada
    public LocalDateTime estimarLlegada() {

        long segundos = Math.round(
                (esperaMinutos + intervaloMinutos) * 60
        );

        return horaEstimada.plusSeconds(segundos);
    }

    // Getters
    public int getIdEstimacion() {
        return idEstimacion;
    }

    public double getIntervaloMinutos() {
        return intervaloMinutos;
    }

    public double getEsperaMinutos() {
        return esperaMinutos;
    }

    public LocalDateTime getHoraEstimada() {
        return horaEstimada;
    }

    // Setters
    public void setIntervaloMinutos(double intervaloMinutos) {
        if (intervaloMinutos >= 0) {
            this.intervaloMinutos = intervaloMinutos;
        }
    }

    public void setEsperaMinutos(double esperaMinutos) {
        if (esperaMinutos >= 0) {
            this.esperaMinutos = esperaMinutos;
        }
    }

    public void setHoraEstimada(LocalDateTime horaEstimada) {
        if (horaEstimada != null) {
            this.horaEstimada = horaEstimada;
        }
    }
}
