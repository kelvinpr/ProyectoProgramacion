package Dominio;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Objects;

public class Cliente extends Usuario {
    private String idCliente;
    private String telefono;
    private String direccion;
    private LocalDate fechaRegistro;
    // Asociación 1 -> 0..* : Cliente tiene muchas SolicitudDeSoporte
    private SolicitudDeSoporte[] solicitudDeSoportes;
    // Asociación 0..* -> 1 : Un Cliente puede aparecer en muchos MonitoreoWiFi
    private MonitoreoWifi[] monitoreoWiFi;


    public Cliente(){
        this("Sin nombre","Sin Cedula","Sin email","Sin contrasenia","Sin Id","Sin telefono","Sin direccion",null);
    }

    public Cliente(String nombre,String cedula,String email,String contrasenia,String idCliente,String telefono,String direccion,LocalDate fechaRegistro){
        super(nombre,cedula,email,contrasenia, Rol.CLIENTE);
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.solicitudDeSoportes = new SolicitudDeSoporte[0];
        this.monitoreoWiFi = new MonitoreoWifi[0];
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public SolicitudDeSoporte[] getSolicitudDeSoportes() {
        return solicitudDeSoportes;
    }

    public MonitoreoWifi[] getMonitoreoWiFi() {
        return monitoreoWiFi;
    }

    public void setIdCliente(String idCliente){
        if(idCliente != null)
            this.idCliente = idCliente;
    }

    public void setTelefono(String telefono){
        if(telefono != null)
            this.telefono = telefono;
    }

    public void setDireccion(String direccion){
        if(direccion != null)
            this.direccion = direccion;
    }

    public void setFechaRegistro(LocalDate fechaRegistro){
        if(fechaRegistro != null)
            this.fechaRegistro = fechaRegistro;
    }

    public void setSolicitudDeSoportes(SolicitudDeSoporte[] solicitudDeSoportes){
        if(solicitudDeSoportes != null)
            this.solicitudDeSoportes = solicitudDeSoportes;
    }

    public void setMonitoreoWiFi(MonitoreoWifi[] monitoreoWiFi) {
        if(monitoreoWiFi != null)
            this.monitoreoWiFi = monitoreoWiFi;
    }

    public void agregarMonitoreo(MonitoreoWifi m) {
        if (m == null) return;

        MonitoreoWifi[] aux = new MonitoreoWifi[monitoreoWiFi.length + 1];
        System.arraycopy(monitoreoWiFi, 0, aux, 0, monitoreoWiFi.length);
        aux[monitoreoWiFi.length] = m;
        monitoreoWiFi = aux;
    }

    public MonitoreoWifi[] getMonitoreos() {
        return monitoreoWiFi;
    }

    public void agregarSolicitud(SolicitudDeSoporte s) {
        if (s == null) return;

        SolicitudDeSoporte[] aux =
                new SolicitudDeSoporte[solicitudDeSoportes.length + 1];

        System.arraycopy(
                solicitudDeSoportes, 0,
                aux, 0,
                solicitudDeSoportes.length
        );

        aux[solicitudDeSoportes.length] = s;
        solicitudDeSoportes = aux;
    }   

    public SolicitudDeSoporte[] getSolicitudes() {
        return solicitudDeSoportes;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Cliente)) return false;
        Cliente aux = (Cliente)obj;
        return this.getCedula().equals(aux.getCedula());
    }

    @Override
    public String toString() {
        return super.toString() + "\nID Cliente: " + idCliente + "\nTelefono: " + telefono
                + "\nDireccion: " + direccion + "\nFecha Registro: " + fechaRegistro;
    }
}
