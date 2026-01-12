package Dominio;
import java.time.LocalDate;

public class Incidente {
    private int idIncidente;
    private LocalDate fechaReporte;
    private String descripcion;
    private String[] comentarios;
    private int contadorComentarios;
    private Empleado empleadoAsignado;
    private String estado;
    private SolicitudDeSoporte solicitudOrigen;

    public Incidente(){
        this(0,null,"Sin descripcion",null);
    }
    public Incidente(int idIncidente,
                 LocalDate fechaReporte,
                 String descripcion,
                 SolicitudDeSoporte solicitudOrigen) {

        this.idIncidente = idIncidente;
        this.fechaReporte = fechaReporte;
        this.descripcion = descripcion;
        this.solicitudOrigen = solicitudOrigen;

        this.estado = "PENDIENTE";
        this.empleadoAsignado = null;

        this.comentarios = new String[3];
        this.contadorComentarios = 0;
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

    public String[] getComentarios() {
        return comentarios;
    }


    public Empleado getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public SolicitudDeSoporte getSolicitudOrigen() {
        return solicitudOrigen;
    }

    public String getEstado(){
        return estado;  
    }

    public void asignarEmpleado(Empleado e) {
        if (e != null) {
            this.empleadoAsignado = e;
            this.estado = "EN PROCESO";
        }
    }

    public void cambiarEstado(String estado) {
        if (estado != null) {
            this.estado = estado;
        }
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
    public void setComentarios(String[] comentarios){
        if (comentarios != null){
            this.comentarios = comentarios;
        }
    }
    public void setDescripcion(String descripcion){
        if(descripcion != null){
            this.descripcion = descripcion;
        }
    }
    
    
    public void setEmpleadoAsignado(Empleado empleadoAsignado){
        if(empleadoAsignado != null) {
            this.empleadoAsignado = empleadoAsignado;
        }
    }

    public void agregarComentario(String comentario) {
        if (comentario == null) return;

        if (contadorComentarios >= comentarios.length) {
            String[] aux = new String[comentarios.length + 1];
            System.arraycopy(comentarios, 0, aux, 0, comentarios.length);
            comentarios = aux;
        }

        comentarios[contadorComentarios] = comentario;
        contadorComentarios++;
    }

    @Override
    public String toString() {

    StringBuilder sb = new StringBuilder();
        sb.append("Incidente{")
        .append("idIncidente=").append(idIncidente)
        .append(", fechaReporte=").append(fechaReporte)
        .append(", descripcion='").append(descripcion).append('\'')
        .append(", estado=").append(estado);

        if (empleadoAsignado != null) {
            sb.append(", empleado=").append(empleadoAsignado.getNombre());
        } else {
            sb.append(", empleado=No asignado");
        }

        sb.append(", comentarios=[");

        for (int i = 0; i < contadorComentarios; i++) {
            sb.append(comentarios[i]);
            if (i < contadorComentarios - 1) sb.append(", ");
        }

        sb.append("]}");

        return sb.toString();
    }

}
