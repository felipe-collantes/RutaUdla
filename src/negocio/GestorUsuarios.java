package negocio;

import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    // Registrar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        if (usuario != null && buscarUsuario(usuario.getIdUsuario()) == null) {
            usuario.registrarUsuario();
            usuarios.add(usuario);
            return true;
        }
        return false;
    }

    // Buscar un usuario por su identificador
    public Usuario buscarUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    // Evaluar / calcular la confiabilidad pasando los 2 argumentos que pide Usuario.calcularConfiabilidad(...)
    public double consultarConfiabilidad(int idUsuario, int parametro1, int parametro2) {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario != null) {
            return usuario.calcularConfiabilidad(parametro1, parametro2);
        }
        return -1;
    }

    // Consultar todos los usuarios registrados
    public List<Usuario> consultarUsuarios() {
        return new ArrayList<>(usuarios);
    }

    // Consultar estadísticas de usuarios
    public String consultarEstadisticas() {
        int total = usuarios.size();
        if (total == 0) {
            return "Total usuarios: 0 | Usuarios activos: 0";
        }

        int activos = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getEstado() != null && usuario.getEstado().equalsIgnoreCase("ACTIVO")) {
                activos++;
            }
        }

        return String.format(
                "Total usuarios: %d | Usuarios activos: %d",
                total, activos
        );
    }
}
