package Dominio;

import java.util.ArrayList;

public class MonitoreoWifi {

    private String idMonitoreo;
    private String nombreRed;

    private ArrayList<PruebaWifi> historialPruebas;


    public MonitoreoWifi() {
        this.idMonitoreo = "";
        this.nombreRed = "";
        this.historialPruebas = new ArrayList<>();
    }


    public MonitoreoWifi(String idMonitoreo, String nombreRed) {
        this.idMonitoreo = idMonitoreo;
        this.nombreRed = nombreRed;
        this.historialPruebas = new ArrayList<>();
    }


    public String getIdMonitoreo() {
        return idMonitoreo;
    }

    public void setIdMonitoreo(String idMonitoreo) {
        if (idMonitoreo != null)
            this.idMonitoreo = idMonitoreo;
    }

    public String getNombreRed() {
        return nombreRed;
    }

    public void setNombreRed(String nombreRed) {
        if (nombreRed != null)
            this.nombreRed = nombreRed;
    }

    public ArrayList<PruebaWifi> getHistorialPruebas() {
        return historialPruebas;
    }

    // MÉTODOS

    public boolean iniciarMonitoreo() {
        System.out.println("Iniciando monitoreo...");
        return true;
    }

    public boolean detenerMonitoreo() {
        System.out.println("Deteniendo monitoreo...");
        return true;
    }

    public void agregarPrueba(PruebaWifi p) {
        if (p != null)
            historialPruebas.add(p);
    }

    public ArrayList<PruebaWifi> obtenerHistorial() {
        return historialPruebas;
    }


    public PruebaWifi realizarPruebaVelocidad(PruebaWifi p) {
        agregarPrueba(p);
        return p;
    }

    public PruebaWifi realizarPruebaLatencia(PruebaWifi p) {
        agregarPrueba(p);
        return p;
    }

    @Override
    public String toString() {
        return "MonitoreoWifi{" +
                "idMonitoreo='" + idMonitoreo + '\'' +
                ", nombreRed='" + nombreRed + '\'' +
                ", historialPruebas=" + historialPruebas +
                '}';
    }
}