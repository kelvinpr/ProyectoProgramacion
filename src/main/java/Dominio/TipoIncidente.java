package Dominio;

public class TipoIncidente {
    private String idTipo;
    private String nombre;
    private String descripcion;
    private String prioridad;
    //El tipo de incidente se relaciona a varios incidentes
    private Incidente[] incidentes;


    public TipoIncidente(){
        this("Sin Id","Sin nombre","Sin descripcion","Sin prioridad");
    }

    public TipoIncidente(String idTipo, String nombre, String descripcion, String prioridad){

        this.idTipo = idTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.incidentes = new Incidente[3];
    }

    public String getIdTipo() {
        return idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }
    public Incidente[] getIncidentes() {
        return incidentes;
    }

    public void setIdTipo(String idTipo) {
        if (idTipo != null){
            this.idTipo= idTipo;
        } else {
            System.out.println("idTipo inválido: no se asignó valor.");
        }
    }

    public void setNombre(String nombre) {
        if ( nombre != null){
            this.nombre = nombre;
        }else{
            System.out.println("Nombre inválido: no se asigno nombre.");
        }
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null){
            this.descripcion = descripcion;
        }else{
            System.out.println("Descripción invalida: no se asignó descripcion");
        }

    }

    public void setPrioridad(String prioridad) {
        if (prioridad!= null){
            this.prioridad = prioridad;
        }else{
            System.out.println("Pioridad invalida: no se asigno prioridad");
        }
    }
    public void setIncidentes(Incidente[] incidentes) {
        if (incidentes != null) {
            this.incidentes = incidentes;
        } else {
            System.out.println("Arreglo de incidentes nulo: se mantiene el arreglo actual.");
        }
    }

    @Override
    public String toString() {
        int totalIncidentes = (incidentes != null) ? incidentes.length : 0;
        return "tipoIncidente{"+
                "idTipo='" + idTipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", cantidadIncidentes=" + totalIncidentes +
                '}';
    }
}

