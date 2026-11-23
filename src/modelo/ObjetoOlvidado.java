package modelo;

public class ObjetoOlvidado {

    // Atributos
    private int idObjeto;
    private String tipoReporte;
    private String descripcion;
    private String caracteristicas;
    private String estado;

    // Constructor
    public ObjetoOlvidado(int idObjeto, String tipoReporte,
                          String descripcion, String caracteristicas,
                          String estado) {

        this.idObjeto = idObjeto;
        this.tipoReporte = tipoReporte;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.estado = estado;
    }

    // Registrar objeto
    public boolean registrarObjeto() {

        return idObjeto > 0
                && tipoReporte != null
                && !tipoReporte.trim().isEmpty()
                && descripcion != null
                && !descripcion.trim().isEmpty()
                && caracteristicas != null
                && !caracteristicas.trim().isEmpty();
    }

    // Actualizar estado
    public void actualizarEstado(String nuevoEstado) {

        if (nuevoEstado != null && !nuevoEstado.trim().isEmpty()) {
            this.estado = nuevoEstado;
        }
    }

    // Getters
    public int getIdObjeto() {
        return idObjeto;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getEstado() {
        return estado;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}
