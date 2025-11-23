package Consola.SubMenu;

import Extras.Funcionalidades;
import Consola.GUI.MonitoreoRedWiFiGUI;

import java.util.Scanner;

public class SubMenuMonitoreoWiFi {
    Funcionalidades func = new Funcionalidades();
    MonitoreoRedWiFiGUI mrw = new MonitoreoRedWiFiGUI();
    public void mostrarSubmenuWifi() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("===== SUBMENÚ: MONITOREAR RED WI-FI =====");
            System.out.println("1. Realizar prueba de velocidad");
            System.out.println("2. Realizar prueba de latencia");
            System.out.println("3. Mostrar resultados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1 : mrw.realizarPruebaVelocidad();
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 2 : mrw.realizarPruebaLatencia();
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 3 : mrw.mostrarResultados();
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 4 : System.out.println("Gracias por usar nuestro sistema! ");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                default : System.out.println("Opción no válida.");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
            }
        } while (opcion != 4);
    }
}
