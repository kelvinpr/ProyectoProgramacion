package Consola.SubMenu;

import Consola.GUI.AdminGUI;
import Extras.Funcionalidades;

public class SubMenuAdmin {

    private AdminGUI adminGUI = new AdminGUI();
    private Funcionalidades func = new Funcionalidades();

    /*public void mostrar() {
        int op;
        do {
            System.out.println("\n=== ADMIN ===");
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar empleados");
            System.out.println("3. Volver");

            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> menuClientes();
                case 2 -> menuEmpleados();
                case 3 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (op != 3);
    }*/

    public void menuClientes() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE CLIENTES ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Volver");

            System.out.print("Seleccione una opción: ");


            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> adminGUI.registrarCliente();
                case 2 -> adminGUI.buscarCliente();
                case 3 -> adminGUI.actualizarCliente();
                case 4 -> adminGUI.listarClientes();
                case 5 -> adminGUI.eliminarCliente();
                case 6 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (op != 6);
    }

    public void menuEmpleados() {
        int op;
        do {
            System.out.println("\n--- GESTIÓN DE EMPLEADOS ---");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Buscar empleado");
            System.out.println("3. Listar empleados");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Volver");

            System.out.print("Seleccione una opción: ");


            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> adminGUI.registrarEmpleado();
                case 2 -> adminGUI.buscarEmpleado();
                case 3 -> adminGUI.listarEmpleados();
                case 4 -> adminGUI.eliminarEmpleado();
                case 5 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (op != 5);
    }
}
