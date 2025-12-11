package Dominio;


import java.time.LocalDate;

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
        super();
        this.idCliente = "Sin ID";
        this.telefono = "Sin telefono";
        this.direccion = "Sin direccion";
        this.fechaRegistro = null;
        this.solicitudDeSoportes = new SolicitudDeSoporte[0];
        this.monitoreoWiFi = new MonitoreoWifi[0];
    }

    public Cliente(String nombre,String cedula,String email,String contrasenia,String rol,String idCliente,String telefono,String direccion,LocalDate fechaRegistro, MonitoreoWifi[] monitoreoWiFi,SolicitudDeSoporte[] solicitudDeSoportes){
        super(nombre,cedula,email,contrasenia,rol);
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.solicitudDeSoportes = solicitudDeSoportes ;
        this.monitoreoWiFi = monitoreoWiFi;
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

    @Override
    public String toString() {
        return super.toString() + "\nID Cliente: " + idCliente + "\nTelefono: " + telefono
                + "\nDireccion: " + direccion + "\nFecha Registro: " + fechaRegistro;
    }
}
