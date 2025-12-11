package Consola.GUI;

public class Incidente {
    private String usuario;
    private String descripcion;
    private String estado;

    public Incidente(String usuario, String descripcion) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.estado = "Pendiente";
    }

    public String getUsuario() { return usuario; }
    public String getDescripcion() { return descripcion; }
    public String getEstado() { return estado; }

    public void setUsuario(String usuario) {
        if(usuario != null)
            this.usuario = usuario;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion != null)
            this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        if(estado != null)
            this.estado = estado;
    }
}
