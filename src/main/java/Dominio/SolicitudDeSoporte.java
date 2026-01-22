package Dominio;

import java.time.LocalDate;
import java.util.UUID;

public class SolicitudDeSoporte implements Comparable<SolicitudDeSoporte>{

    private final int idSolicitud;
    private final LocalDate fechaSolicitud;
    private String descripcion;
    private EstadoSolicitud estado;
    private Cliente cliente;
    private Incidente incidente;

    public SolicitudDeSoporte() {
        this(0,"Sin descripcion",null);
    }

    public SolicitudDeSoporte(int idSolicitud, String descripcion, Cliente cliente) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = LocalDate.now();
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.estado = EstadoSolicitud.PENDIENTE;
        this.incidente = null;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        if (estado != null)
            this.estado = estado;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
        this.estado = EstadoSolicitud.PENDIENTE;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SolicitudDeSoporte)) return false;
        SolicitudDeSoporte other = (SolicitudDeSoporte) obj;
        return this.idSolicitud == other.idSolicitud;
    }

    @Override
    public int compareTo(SolicitudDeSoporte o) {
        return Integer.compare(this.idSolicitud, o.idSolicitud);
    }

    @Override
    public String toString() {
        return "SolicitudDeSoporte\n" +
                "idSolicitud = " + idSolicitud +
                ", fechaSolicitud = " + fechaSolicitud +
                ", descripcion = " + descripcion +
                ", estado = " + estado;
    }
}