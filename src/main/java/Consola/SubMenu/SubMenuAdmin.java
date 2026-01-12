package Consola.SubMenu;

import Consola.GUI.AdminGUI;
import Extras.Funcionalidades;

public class SubMenuAdmin {

    private AdminGUI admin = new AdminGUI();
    private Funcionalidades func = new Funcionalidades();

    public void mostrar() {
        int op;
        do {
            System.out.println("=== ADMIN ===");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Actualizar cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Salir");
            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> admin.registrarCliente();
                case 2 -> admin.actualizarCliente();
                case 3 -> admin.buscarCliente();
                case 4 -> admin.listarClientes();
                case 5 -> admin.eliminarCliente();
                case 6 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 6);
    }
}
