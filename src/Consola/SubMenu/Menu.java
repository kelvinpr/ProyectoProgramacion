package Consola.SubMenu;

import Extras.Funcionalidades;
import Consola.GUI.LoginGUI;

public class Menu {
    private final Funcionalidades func =  new Funcionalidades();
    private final SubMenuMonitoreoWiFi subMenuMonitoreoWiFi = new SubMenuMonitoreoWiFi();
    private final LoginGUI login =  new LoginGUI();
    public void mostrarMenuPrincipal() {
        int opc;
        do {
            System.out.println("\n------Menu Principal------");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Gestionar Usuario");
            System.out.println("3. Monitorear Red Wi-Fi");
            System.out.println("4. Gestionar Incidente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opc = func.validarEntradaOpcion();

            switch (opc) {
                case 1,2,3,4:
                    func.limpiarConsolaIDE();
                    login.mostrarSeleccionLogin();
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 5: System.out.println("Gracias por usar nuestro sistema!");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                default: System.out.println("Opcion No valida");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
            }
        }while (opc!=5);
    }
}
