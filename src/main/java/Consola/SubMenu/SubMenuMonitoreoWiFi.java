package Consola.SubMenu;

import Consola.GUI.MonitoreoRedWiFiGUI;
import Dominio.Cliente;
import Extras.Funcionalidades;

public class SubMenuMonitoreoWiFi {

    private MonitoreoRedWiFiGUI gui;
    private Funcionalidades func = new Funcionalidades();

    public SubMenuMonitoreoWiFi(Cliente cliente) {
        gui = new MonitoreoRedWiFiGUI(cliente);
    }

    public void mostrarSubmenuWifi() {
        int op;
        do {
            System.out.println("=== MONITOREO WIFI ===");
            System.out.println("1. Velocidad");
            System.out.println("2. Latencia");
            System.out.println("3. Historial");
            System.out.println("4. Volver");

            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> gui.pruebaVelocidad();
                case 2 -> gui.pruebaLatencia();
                case 3 -> gui.mostrarHistorial();
            }

        } while (op != 4);
    }
}

