package negocio;

import modelo.Ruta;
import modelo.Parada;
import modelo.ServicioTransporte;

import java.util.ArrayList;
import java.util.List;

public class GestorRutasServicios {
    // Listas para almacenar rutas y servicios
    private List<Ruta> rutas;
    private List<ServicioTransporte> servicios;

    // Constructor
    public GestorRutasServicios() {
        rutas = new ArrayList<>();
        servicios = new ArrayList<>();
    }

    // Registrar una ruta
    public void registrarRuta(Ruta ruta) {

        if (ruta != null) {
            rutas.add(ruta);
        }
    }

    // Registrar un servicio de transporte
    public void registrarServicio(ServicioTransporte servicio) {

        if (servicio != null) {
            servicios.add(servicio);
        }
    }

    // Buscar una ruta por su identificador
    public Ruta buscarRuta(int idRuta) {

        for (Ruta ruta : rutas) {

            if (ruta.getIdRuta() == idRuta) {
                return ruta;
            }
        }

        return null;
    }

    // Consultar las paradas de una ruta
    public List<Parada> consultarParadas(int idRuta) {

        Ruta ruta = buscarRuta(idRuta);

        if (ruta != null) {
            return ruta.consultarRecorrido();
        }

        return new ArrayList<>();
    }

    // Consultar todos los servicios registrados
    public List<ServicioTransporte> consultarServicios() {
        return new ArrayList<>(servicios);
    }

    // Calcular el costo de un servicio
    public double calcularTarifa(int idServicio, int viajes) {

        for (ServicioTransporte servicio : servicios) {

            if (servicio.getIdServicio() == idServicio) {
                return servicio.calcularCosto(viajes);
            }
        }

        return -1;
    }

    // Consultar todas las rutas
    public List<Ruta> consultarRutas() {
        return new ArrayList<>(rutas);
    }


}
