package Dominio;

import java.time.LocalDate;

public class SolicitudDeSoporte {

    private int idSolicitud;
    private LocalDate fechaSolicitud;
    private String descripcion;
    private String prioridad;
    private String estado;
    // Asociación 1 -> 0..1 : SolicitudDeSoporte puede tener 0 o 1 Incidente
    private Incidente incidente;
    //Asociacion
    private Cliente cliente;

    public SolicitudDeSoporte() {
        this.idSolicitud = 0;
        this.fechaSolicitud = LocalDate.now();
        this.descripcion = "Sin descripción";
        this.prioridad = "Baja";
        this.estado = "Pendiente";
        this.cliente = new Cliente();
    }

    public SolicitudDeSoporte(int idSolicitud, LocalDate fechaSolicitud,
                              String descripcion, String prioridad, String estado,Cliente cliente) {

        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = estado;
        this.cliente = cliente;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdSolicitud(int idSolicitud) {
        if(idSolicitud > 0)
            this.idSolicitud = idSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud){
        if(fechaSolicitud != null)
            this.fechaSolicitud = fechaSolicitud;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        }
    }

    public void setPrioridad(String prioridad) {
        if (prioridad != null && !prioridad.trim().isEmpty()) {
            this.prioridad = prioridad;
        }
    }

    public void setEstado(String estado) {
        if (estado != null && !estado.trim().isEmpty()) {
            this.estado = estado;
        }
    }

    public void setIncidente(Incidente incidente) {
        if(incidente != null)
            this.incidente = incidente;
    }

    public void setCliente(Cliente cliente) {
        if(cliente != null)
            this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "SolicitudDeSoporte{" +
                "idSolicitud=" + idSolicitud +
                ", fechaSolicitud=" + fechaSolicitud +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}