package Consola.GUI;

import Consola.SubMenu.*;
import Dominio.Cliente;
import Dominio.Empleado;
import Extras.Funcionalidades;
import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import ImplementacionDAO.ClienteDAOImpl;
import ImplementacionDAO.EmpleadoDAOImpl;

public class LoginGUI {

    private Funcionalidades func = new Funcionalidades();

    private ClienteDAO clienteDAO = ClienteDAOImpl.getInstancia();
    private EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstancia();

    // ================= INICIO =================
    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n===== LOGIN =====");
            System.out.println("1. Ingresar como cliente");
            System.out.println("2. Ingresar como administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1 -> loginCliente();
                case 2 -> loginAdmin();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 3);
    }

    // ================= LOGIN CLIENTE =================
    private void loginCliente() {
        System.out.print("Correo: ");
        String correo = func.validarCorreo();

        System.out.print("Contraseña: ");
        String contrasenia = func.validarContrasenia();

        for (Cliente cliente : clienteDAO.listar()) {
            if (cliente.getEmail().equals(correo)
                    && cliente.getContrasenia().equals(contrasenia)) {

                System.out.println("Bienvenido, " + cliente.getNombre());
                menuCliente(cliente);
                return;
            }
        }
        System.out.println("Credenciales incorrectas");
    }

    // ================= MENÚ CLIENTE =================
    private void menuCliente(Cliente cliente) {
        int opcion;

        SubMenuCliente smCliente = new SubMenuCliente(cliente);
        SubMenuSolicitudCliente smSolicitudes =
                new SubMenuSolicitudCliente(cliente);
        SubMenuMonitoreoWiFi smWifi =
                new SubMenuMonitoreoWiFi(cliente);

        do {
            System.out.println("\n===== MENÚ CLIENTE =====");
            System.out.println("1. Gestionar perfil");
            System.out.println("2. Solicitudes de soporte");
            System.out.println("3. Monitoreo WiFi");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1 -> smCliente.mostrar();
                case 2 -> smSolicitudes.mostrar();
                case 3 -> smWifi.mostrarSubmenuWifi();
                case 4 -> System.out.println("Cerrando sesión...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 4);
    }

    // ================= LOGIN ADMIN =================
    private void loginAdmin() {
        System.out.print("Correo: ");
        String correo = func.validarCorreo();

        System.out.print("Contraseña: ");
        String contrasenia = func.validarContrasenia();

        for (Empleado emp : empleadoDAO.listar()) {
            if (emp.getEmail().equals(correo)
                    && emp.getContrasenia().equals(contrasenia)) {

                System.out.println("Bienvenido administrador " + emp.getNombre());
                menuAdmin();
                return;
            }
        }
        System.out.println("Credenciales incorrectas");
    }

    // ================= MENÚ ADMIN =================
    private void menuAdmin() {
        int opcion;

        SubMenuAdmin smAdmin = new SubMenuAdmin();
        SubMenuSolicitudAdmin smSolicitudes = new SubMenuSolicitudAdmin();
        SubMenuIncidenteAdmin smIncidentes = new SubMenuIncidenteAdmin();

        do {
            System.out.println("\n===== MENÚ ADMINISTRADOR =====");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Solicitudes de soporte");
            System.out.println("3. Incidentes");
            System.out.println("4. Cerrar sesión");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1 -> smAdmin.mostrar();
                case 2 -> smSolicitudes.mostrar();
                case 3 -> smIncidentes.mostrar();
                case 4 -> System.out.println("Cerrando sesión...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 4);
    }
}
