package modelo;

public class ServicioTransporte {
    // Atributos
    private int idServicio;
    private String tipo;
    private double tarifa;
    private boolean tarifaVerificada;

    // Constructor
    public ServicioTransporte(int idServicio, String tipo,
                              double tarifa, boolean tarifaVerificada) {

        this.idServicio = idServicio;
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.tarifaVerificada = tarifaVerificada;
    }

    // Calcular el costo de varios viajes
    public double calcularCosto(int viajes) {

        if (viajes < 0) {
            throw new IllegalArgumentException(
                    "La cantidad de viajes no puede ser negativa."
            );
        }

        return tarifa * viajes;
    }

    // Consultar la tarifa
    public double consultarTarifa() {
        return tarifa;
    }

    // Getters
    public int getIdServicio() {
        return idServicio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTarifa() {
        return tarifa;
    }

    public boolean isTarifaVerificada() {
        return tarifaVerificada;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTarifa(double tarifa) {
        if (tarifa >= 0) {
            this.tarifa = tarifa;
        }
    }

    public void setTarifaVerificada(boolean tarifaVerificada) {
        this.tarifaVerificada = tarifaVerificada;
    }

}
