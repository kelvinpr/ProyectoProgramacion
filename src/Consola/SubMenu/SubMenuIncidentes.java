package Consola.SubMenu;

import Extras.Funcionalidades;
import Consola.GUI.IncidentesGUI;

import java.util.Scanner;

public class SubMenuIncidentes {
    Funcionalidades func = new Funcionalidades();
    Scanner sc = new Scanner(System.in);
    IncidentesGUI gui = new IncidentesGUI();

    public void menuCliente(String usuario) {
        int opcion;

        do {
            System.out.println("===== INCIDENTES (CLIENTE) =====");
            System.out.println("1. Registrar incidente");
            System.out.println("2. Consultar mis incidentes");
            System.out.println("3. Eliminar incidente");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1 : gui.registrarIncidente(usuario); break;
                case 2 : gui.consultarMisIncidentes(usuario); break;
                case 3 : gui.eliminarIncidenteCliente(usuario); break;
                case 4 : System.out.println("Volviendo..."); break;
                default : System.out.println("Opción no válida."); break;
            }

            func.esperarLimpieza();
            func.limpiarConsolaIDE();

        } while (opcion != 4);
    }

    public void menuAdmin() {
        int opcion;

        do {
            System.out.println("===== INCIDENTES (ADMINISTRADOR) =====");
            System.out.println("1. Consultar todos los incidentes");
            System.out.println("2. Actualizar estado");
            System.out.println("3. Eliminar incidente");
            System.out.println("4. Volver");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1 : gui.consultarTodos(); break;
                case 2 : gui.actualizarIncidente(); break;
                case 3 : gui.eliminarIncidenteAdmin(); break;
                case 4 : System.out.println("Volviendo...");
                break;
                default : System.out.println("Opción no válida."); break;
            }

            func.esperarLimpieza();
            func.limpiarConsolaIDE();

        } while (opcion != 4);
    }
}
