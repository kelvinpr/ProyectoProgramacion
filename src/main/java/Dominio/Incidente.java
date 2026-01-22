package Dominio;
import java.time.LocalDate;

public class Incidente implements Comparable<Incidente> {
    private static final int COMENTARIOS_SIZE = 3;
    private final int idIncidente;
    private final   LocalDate fechaReporte;
    private String descripcion;
    private String[] comentarios;
    private int contadorComentarios;
    private Empleado empleadoAsignado;
    private EstadoIncidente estado;
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

        this.estado = EstadoIncidente.PENDIENTE;
        this.empleadoAsignado = null;

        this.comentarios = new String[COMENTARIOS_SIZE];
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

    public EstadoIncidente getEstado(){
        return estado;  
    }

    public void asignarEmpleado(Empleado e) {
        if (e != null) {
            this.empleadoAsignado = e;
            this.estado = EstadoIncidente.EN_PROCESO;
        }
    }

    public void cambiarEstado(EstadoIncidente estado) {
        if (estado != null) {
            this.estado = estado;
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
        if (comentario == null || comentario.isBlank()) return;

        if (contadorComentarios >= comentarios.length) {
            String[] aux = new String[comentarios.length + 1];
            System.arraycopy(comentarios, 0, aux, 0, comentarios.length);
            comentarios = aux;
        }

        comentarios[contadorComentarios++] = comentario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Incidente)) return false;

        Incidente other = (Incidente) obj;
        return this.idIncidente == other.idIncidente;
    }

    @Override
    public int compareTo(Incidente o) {
        return Integer.compare(this.idIncidente, o.idIncidente);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Incidente{")
                .append("id=").append(idIncidente)
                .append(", fecha=").append(fechaReporte)
                .append(", descripcion='").append(descripcion).append('\'')
                .append(", estado=").append(estado)
                .append(", empleado=")
                .append(empleadoAsignado != null ? empleadoAsignado.getNombre() : "No asignado")
                .append(", comentarios=[");

        for (int i = 0; i < contadorComentarios; i++) {
            sb.append(comentarios[i]);
            if (i < contadorComentarios - 1) sb.append(", ");
        }

        sb.append("]}");
        return sb.toString();
    }

}
