package Consola.SubMenu;

import Consola.GUI.SolicitudDeSoporteGUI;
import Extras.Funcionalidades;

public class SubMenuSolicitudAdmin {

    private SolicitudDeSoporteGUI gui = new SolicitudDeSoporteGUI();
    private Funcionalidades func = new Funcionalidades();

    public void mostrar() {
        int op;
        do {
            System.out.println("=== SOPORTE (ADMIN) ===");
            System.out.println("1. Ver todas las solicitudes");
            System.out.println("2. Eliminar solicitud");
            System.out.println("3. Volver");
            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> gui.listarTodas();
                case 2 -> gui.eliminarSolicitud();
            }
        } while (op != 3);
    }
}
