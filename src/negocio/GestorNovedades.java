package negocio;

import modelo.Novedad;
import modelo.ObjetoOlvidado;
import java.util.ArrayList;
import java.util.List;

public class GestorNovedades {
    private List<Novedad> novedades;
    private List<ObjetoOlvidado> objetosOlvidados;

    public GestorNovedades() {
        this.novedades = new ArrayList<>();
        this.objetosOlvidados = new ArrayList<>();
    }

    // --- Novedades ---

    public boolean registrarNovedad(Novedad novedad) {
        if (novedad != null) {
            novedad.registrarNovedad();
            novedades.add(novedad);
            return true;
        }
        return false;
    }

    public Novedad buscarNovedad(int idNovedad) {
        for (Novedad novedad : novedades) {
            if (novedad.getIdNovedad() == idNovedad) {
                return novedad;
            }
        }
        return null;
    }

    public boolean actualizarEstadoNovedad(int idNovedad, String nuevoEstado) {
        Novedad novedad = buscarNovedad(idNovedad);
        if (novedad != null && nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            novedad.actualizarEstado(nuevoEstado.trim());
            return true;
        }
        return false;
    }

    public List<Novedad> consultarNovedades() {
        return new ArrayList<>(novedades);
    }

    public List<Novedad> consultarNovedadesActivas() {
        List<Novedad> activas = new ArrayList<>();
        for (Novedad novedad : novedades) {
            if (novedad.getEstado() != null && !novedad.getEstado().equalsIgnoreCase("RESUELTA")) {
                activas.add(novedad);
            }
        }
        return activas;
    }

    // --- Objetos olvidados ---

    public boolean registrarObjetoOlvidado(ObjetoOlvidado objeto) {
        if (objeto != null) {
            objeto.registrarObjeto();
            objetosOlvidados.add(objeto);
            return true;
        }
        return false;
    }

    public ObjetoOlvidado buscarObjetoOlvidado(int idObjeto) {
        for (ObjetoOlvidado objeto : objetosOlvidados) {
            if (objeto.getIdObjeto() == idObjeto) {
                return objeto;
            }
        }
        return null;
    }

    public boolean actualizarEstadoObjeto(int idObjeto, String nuevoEstado) {
        ObjetoOlvidado objeto = buscarObjetoOlvidado(idObjeto);
        if (objeto != null && nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            objeto.actualizarEstado(nuevoEstado.trim());
            return true;
        }
        return false;
    }

    public List<ObjetoOlvidado> consultarObjetosOlvidados() {
        return new ArrayList<>(objetosOlvidados);
    }
}
