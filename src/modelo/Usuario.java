package modelo;

public class Usuario {
    // Atributos
    private int idUsuario;
    private String alias;
    private String estado;
    private double confiabilidad;

    // Constructor
    public Usuario(int idUsuario, String alias, String estado) {

        this.idUsuario = idUsuario;
        this.alias = alias;
        this.estado = estado;
        this.confiabilidad = 0.0;
    }

    // Registrar usuario
    public boolean registrarUsuario() {

        return alias != null && !alias.trim().isEmpty()
                && estado != null && !estado.trim().isEmpty();
    }

    // Calcular confiabilidad
    public double calcularConfiabilidad(
            int reportesValidos, int reportesTotales) {

        if (reportesTotales <= 0 || reportesValidos < 0
                || reportesValidos > reportesTotales) {

            confiabilidad = 0.0;
            return confiabilidad;
        }

        confiabilidad = (double) reportesValidos
                / reportesTotales * 100;

        return confiabilidad;
    }

    // Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public String getAlias() {
        return alias;
    }

    public String getEstado() {
        return estado;
    }

    public double getConfiabilidad() {
        return confiabilidad;
    }

    // Setters
    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
