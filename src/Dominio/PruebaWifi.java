package Dominio;

import java.time.LocalDate;

public class PruebaWifi {

    private String idPrueba;
    private LocalDate fecha;
    private String tipoPrueba;

    private double velocidadDescarga;
    private double velocidadSubida;
    private double latenciaPromedio;

    private MonitoreoWifi monitoreoPadre;

    public PruebaWifi() {
        this.idPrueba = "";
        this.fecha = LocalDate.now();
        this.tipoPrueba = "";
        this.velocidadDescarga = 0.0;
        this.velocidadSubida = 0.0;
        this.latenciaPromedio = 0.0;
        this.monitoreoPadre = null;
    }

    public PruebaWifi(String idPrueba, LocalDate fecha, String tipoPrueba,
                      double velocidadDescarga, double velocidadSubida,
                      double latenciaPromedio, MonitoreoWifi monitoreoPadre) {

        this.idPrueba = idPrueba;
        this.fecha = fecha;
        this.tipoPrueba = tipoPrueba;
        this.velocidadDescarga = velocidadDescarga;
        this.velocidadSubida = velocidadSubida;
        this.latenciaPromedio = latenciaPromedio;
        this.monitoreoPadre = monitoreoPadre;
    }

    public String getIdPrueba() { return idPrueba; }
    public void setIdPrueba(String idPrueba) { this.idPrueba = idPrueba; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getTipoPrueba() { return tipoPrueba; }
    public void setTipoPrueba(String tipoPrueba) { this.tipoPrueba = tipoPrueba; }

    public double getVelocidadDescarga() { return velocidadDescarga; }
    public void setVelocidadDescarga(double velocidadDescarga) { this.velocidadDescarga = velocidadDescarga; }

    public double getVelocidadSubida() { return velocidadSubida; }
    public void setVelocidadSubida(double velocidadSubida) { this.velocidadSubida = velocidadSubida; }

    public double getLatenciaPromedio() { return latenciaPromedio; }
    public void setLatenciaPromedio(double latenciaPromedio) { this.latenciaPromedio = latenciaPromedio; }

    public MonitoreoWifi getMonitoreoPadre() { return monitoreoPadre; }
    public void setMonitoreoPadre(MonitoreoWifi monitoreoPadre) { this.monitoreoPadre = monitoreoPadre; }

    public void hacerPruebaVelocidad() {
        System.out.println("Realizando prueba de velocidad...");
    }

    public void hacerPruebaLatencia() {
        System.out.println("Realizando prueba de latencia...");
    }

    public double calcularPromedioVelocidad() {
        return (velocidadDescarga + velocidadSubida) / 2;
    }

    public double calcularIndiceLatencia() {
        return latenciaPromedio;
    }

    public String generarReporte() {
        return "Reporte de Prueba WiFi: " + idPrueba +
                " - Tipo: " + tipoPrueba +
                " - Descarga: " + velocidadDescarga +
                " - Subida: " + velocidadSubida +
                " - Latencia: " + latenciaPromedio;
    }

    @Override
    public String toString() {
        return "PruebaWifi{" +
                "idPrueba='" + idPrueba + '\'' +
                ", fecha=" + fecha +
                ", tipoPrueba='" + tipoPrueba + '\'' +
                ", velocidadDescarga=" + velocidadDescarga +
                ", velocidadSubida=" + velocidadSubida +
                ", latenciaPromedio=" + latenciaPromedio +
                ", monitoreoPadre=" + monitoreoPadre +
                '}';
    }
}
