package Dominio;

import Consola.GUI.Incidente;

public class Empleado extends Usuario {
    private String idEmpleado;
    //// Un administrador puede estar asociado a muchos incidentes
    private Incidente[] incidentes;

    public Empleado(){
        super();
        this.idEmpleado = "Sin ID";
        this.incidentes = new Incidente[0];
    }

    public Empleado(String nombre, String cedula, String email, String contrasenia, String rol, String idEmpleado, Incidente[] incidentes){
        super(nombre, cedula, email, contrasenia, rol);
        this.idEmpleado = idEmpleado;
        this.incidentes = incidentes;
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
