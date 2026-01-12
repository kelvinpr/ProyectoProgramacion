package Consola.GUI;

import Dominio.Cliente;
import Dominio.MonitoreoWifi;
import Dominio.PruebaWifi;

import java.time.LocalDate;

public class MonitoreoRedWiFiGUI {

    private Cliente cliente;
    private MonitoreoWifi monitoreo;

    public MonitoreoRedWiFiGUI(Cliente cliente) {
        this.cliente = cliente;

        if (cliente.getMonitoreos().length == 0) {
            monitoreo = new MonitoreoWifi(
                    "MW-" + cliente.getIdCliente(),
                    "Red-" + cliente.getNombre()
            );
            cliente.agregarMonitoreo(monitoreo);
        } else {
            monitoreo = cliente.getMonitoreos()[0];
        }

        monitoreo.iniciarMonitoreo();
    }

    public void pruebaVelocidad() {
        PruebaWifi p = new PruebaWifi(
                "PV-" + System.currentTimeMillis(),
                LocalDate.now(),
                "VELOCIDAD",
                Math.random() * 100,
                Math.random() * 50,
                0,
                monitoreo
        );
        monitoreo.realizarPruebaVelocidad(p);
        System.out.println(p.generarReporte());
    }

    public void pruebaLatencia() {
        PruebaWifi p = new PruebaWifi(
                "PL-" + System.currentTimeMillis(),
                LocalDate.now(),
                "LATENCIA",
                0,
                0,
                Math.random() * 50,
                monitoreo
        );
        monitoreo.realizarPruebaLatencia(p);
        System.out.println(p.generarReporte());
    }

    public void mostrarHistorial() {
        for (PruebaWifi p : monitoreo.getHistorialPruebas()) {
            System.out.println(p.generarReporte());
        }
    }
}
