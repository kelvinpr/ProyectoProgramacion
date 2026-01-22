package Consola.SubMenu;

import Consola.GUI.ClienteGUI;
import Dominio.Cliente;
import Extras.Funcionalidades;

public class SubMenuCliente {

    private ClienteGUI gui;
    private Funcionalidades func = new Funcionalidades();

    public SubMenuCliente(Cliente cliente) {
        gui = new ClienteGUI(cliente);
    }

    public void mostrar() {
        int op;
        do {
            System.out.println("=== CLIENTE ===");
            System.out.println("1. Actualizar datos");
            System.out.println("2. Salir");
            op = func.validarEntradaOpcion();

            if (op == 1) gui.actualizarDatos();
        } while (op != 2);
    }
}
