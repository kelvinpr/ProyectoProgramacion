package Dominio;
import java.time.LocalDate;
import java.util.ArrayList;

public class Incidente {
    private int idIncidente;
    private LocalDate fechaReporte;
    private String descripcion;
    private ArrayList<String> comentarios;
    private Cliente reportadopor;
    private Empleado empleadoAsignado;
    private TipoIncidente tipoIncidente;

    public Incidente(){
        this.idIncidente = 0;
        this.fechaReporte = LocalDate.now();
        this.descripcion = "Sin descripcion";
        this.comentarios = new ArrayList<>();
        this.reportadopor = null;
        this.empleadoAsignado = null;
        this.tipoIncidente = null;
    }
    public Incidente(int idIncidente, LocalDate fechaReporte, String descripcion, ArrayList<String> comentarios, Cliente reportadopor, Empleado empleadoAsignado, TipoIncidente tipoIncidente){
        this.idIncidente = idIncidente;
        this.fechaReporte = fechaReporte;
        this.descripcion = descripcion;
        this.reportadopor = reportadopor;
        this.empleadoAsignado = empleadoAsignado;
        this.tipoIncidente = tipoIncidente;
        this.comentarios = new ArrayList<>();
    }

    public int getIdIncidente() {
        return idIncidente;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    public Cliente getReportadopor() {
        return reportadopor;
    }

    public Empleado getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public TipoIncidente getTipoIncidente() {
        return tipoIncidente;
    }

    public void setIdIncidente(int idIncidente){
        if (idIncidente > 0) {
            this.idIncidente = idIncidente;
        }
    }
    public void setFechaReporte(LocalDate fechaReporte) {
        if (fechaReporte != null) {
            this.fechaReporte = fechaReporte;
        }
    }
    public void setComentarios(ArrayList<String> comentarios){
        if (comentarios != null){
            this.comentarios = comentarios;
        }
    }
    public void setDescripcion(String descripcion){
        if(descripcion != null){
            this.descripcion = descripcion;
        }
    }
    public void setReportadopor(Cliente reportadopor){
        if(reportadopor != null) {
            this.reportadopor = reportadopor;
        }
    }
    public void setEmpleadoAsignado(Empleado empleadoAsignado){
        if(empleadoAsignado != null) {
            this.empleadoAsignado = empleadoAsignado;
        }
    }
    public void setTipoIncidente(TipoIncidente tipoIncidente){
        if(tipoIncidente != null) {
            this.tipoIncidente = tipoIncidente;
        }
    }

    @Override
    public String toString() {
        return "Incidente{" +
                "idIncidente=" + idIncidente +
                ", fechaReporte=" + fechaReporte +
                ", descripcion='" + descripcion + '\'' +
                ", comentarios=" + comentarios +
                ", reportadopor=" + reportadopor +
                ", empleadoAsignado=" + empleadoAsignado +
                ", tipoIncidente=" + tipoIncidente +
                '}';
    }
}
