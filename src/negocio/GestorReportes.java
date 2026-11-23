package negocio;

import modelo.ReporteMovimiento;
import modelo.Disponibilidad;

import java.util.ArrayList;
import java.util.List;

public class GestorReportes {

    // Listas para almacenar los reportes
    private List<ReporteMovimiento> reportes;
    private List<Disponibilidad> disponibilidades;

    // Constructor
    public GestorReportes() {
        reportes = new ArrayList<>();
        disponibilidades = new ArrayList<>();
    }

    // Registrar un reporte de movimiento
    public boolean registrarReporte(ReporteMovimiento reporte) {

        if (reporte != null && reporte.validarReporte()) {
            reportes.add(reporte);
            return true;
        }

        return false;
    }

    // Registrar disponibilidad
    public void registrarDisponibilidad(
            Disponibilidad disponibilidad) {

        if (disponibilidad != null) {
            disponibilidades.add(disponibilidad);
        }
    }

    // Corroborar un reporte
    public boolean corroborarReporte(int idReporte) {

        for (ReporteMovimiento reporte : reportes) {

            if (reporte.getIdReporte() == idReporte) {

                reporte.corroborarReporte();

                return reporte.getEstadoCorroboracion()
                        .equalsIgnoreCase("Corroborado");
            }
        }

        return false;
    }

    // Consultar todos los reportes
    public List<ReporteMovimiento> consultarReportes() {
        return new ArrayList<>(reportes);
    }

    // Consultar todas las disponibilidades
    public List<Disponibilidad> consultarDisponibilidades() {
        return new ArrayList<>(disponibilidades);
    }

    // Buscar un reporte por su identificador
    public ReporteMovimiento buscarReporte(int idReporte) {

        for (ReporteMovimiento reporte : reportes) {

            if (reporte.getIdReporte() == idReporte) {
                return reporte;
            }
        }

        return null;
    }

}
