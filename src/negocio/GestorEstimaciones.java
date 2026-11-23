package negocio;

import modelo.Estimacion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorEstimaciones {
    private List<Estimacion> estimaciones;

    public GestorEstimaciones() {
        estimaciones = new ArrayList<>();
    }

    // Registrar una nueva estimación
    public boolean registrarEstimacion(Estimacion estimacion) {
        if (estimacion != null) {
            estimaciones.add(estimacion);
            return true;
        }
        return false;
    }

    // Buscar una estimación por su identificador
    public Estimacion buscarEstimacion(int idEstimacion) {
        for (Estimacion estimacion : estimaciones) {
            if (estimacion.getIdEstimacion() == idEstimacion) {
                return estimacion;
            }
        }
        return null;
    }

    // Consultar el intervalo entre unidades de transporte
    public double consultarIntervalo(int idEstimacion) {
        Estimacion estimacion = buscarEstimacion(idEstimacion);

        if (estimacion != null) {
            return estimacion.calcularIntervalo();
        }

        return -1;
    }

    // Calcular la hora estimada de salida
    public LocalDateTime consultarSalida(int idEstimacion) {
        Estimacion estimacion = buscarEstimacion(idEstimacion);

        if (estimacion != null) {
            return estimacion.estimarSalida();
        }

        return null;
    }

    // Calcular la hora estimada de llegada
    public LocalDateTime consultarLlegada(int idEstimacion) {
        Estimacion estimacion = buscarEstimacion(idEstimacion);

        if (estimacion != null) {
            return estimacion.estimarLlegada();
        }

        return null;
    }

    // Consultar todas las estimaciones
    public List<Estimacion> consultarEstimaciones() {
        return new ArrayList<>(estimaciones);
    }


}
