package Consola.SubMenu;

import Consola.GUI.SolicitudDeSoporteGUI;
import Dominio.Cliente;
import Extras.Funcionalidades;

public class SubMenuSolicitudCliente {

    private SolicitudDeSoporteGUI gui = new SolicitudDeSoporteGUI();
    private Funcionalidades func = new Funcionalidades();
    private Cliente cliente;

    public SubMenuSolicitudCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void mostrar() {
        int op;
        do {
            System.out.println("=== SOPORTE (CLIENTE) ===");
            System.out.println("1. Crear solicitud");
            System.out.println("2. Ver mis solicitudes");
            System.out.println("3. Volver");
            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> gui.crearSolicitud(cliente);
                case 2 -> gui.listarMisSolicitudes(cliente);
            }
        } while (op != 3);
    }
}
