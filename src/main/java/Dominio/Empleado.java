package Dominio;

public class Empleado extends Usuario {
    private String idEmpleado;
    //// Un administrador puede estar asociado a muchos incidentes
    private Incidente[] incidentes;

    public Empleado(){
        this("Sin nombre","Sin Cedula","Sin email","Sin contrasenia","Admin","SinId");
    }

    public Empleado(String nombre, String cedula, String email, String contrasenia, String rol, String idEmpleado){
        super(nombre, cedula, email, contrasenia, rol);
        this.idEmpleado = idEmpleado;
        this.incidentes = new Incidente[0];
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado){
        if(idEmpleado != null)
            this.idEmpleado = idEmpleado;
    }

    public Incidente[] getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(Incidente[] incidentes) {
        if(incidentes != null)
            this.incidentes = incidentes;
    }

    @Override
    public String toString() {
        return super.toString() + "\nIdEmpleado: " + idEmpleado;
    }
}
