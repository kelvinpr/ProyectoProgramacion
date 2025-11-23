package Consola.GUI;

import Consola.SubMenu.*;
import Extras.Funcionalidades;

import java.util.Scanner;

public class LoginGUI {
    private Funcionalidades func =  new Funcionalidades();
    private Scanner sc = new Scanner(System.in);
    private SubMenuAdmin sbAdmin = new SubMenuAdmin();
    private SubMenuCliente sbCliente = new SubMenuCliente();
    private SubMenuMonitoreoWiFi sbWiFi = new SubMenuMonitoreoWiFi();
    private SubMenuIncidentes sbIncidentes = new SubMenuIncidentes();
    private String usuarioActual;

    public void mostrarSeleccionLogin(){
        int opcion;

        System.out.println("=========== LOGIN ===========");
        System.out.println("1.Ingresar como cliente");
        System.out.println("2.Ingresar como administrador");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

        opcion = func.validarEntradaOpcion();

        do {
            switch (opcion){
                case 1:
                    if(loginCliente())
                        menuCliente();
                    break;
                case 2:
                    if(loginAdmin())
                        menuAdmin();
                    break;
                case 3: System.out.println("Gracias por usar nuestro sistema!");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida!!!");
                    break;
            }
        }while(opcion != 3);
    }

    private boolean loginCliente() {
        System.out.println("===== LOGIN CLIENTE =====");
        System.out.print("Ingrese su usuario: ");
        usuarioActual = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasenia = sc.nextLine();

        if (usuarioActual.equals("cliente") && contrasenia.equals("1234")) {
            System.out.println("Bienvenido cliente!");
            return true;
        } else {
            System.out.println("Credenciales de cliente incorrectas.");
            return false;
        }
    }

    private boolean loginAdmin() {
        System.out.println("===== LOGIN ADMINISTRADOR =====");
        System.out.print("Ingrese su usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasenia = sc.nextLine();

        if (usuario.equals("admin") && contrasenia.equals("admin123")) {
            System.out.println("Bienvenido administrador!");
            return true;
        } else {
            System.out.println("Credenciales de administrador incorrectas.");
            return false;
        }
    }

    private void mostrarMenuOpciones(){
        System.out.println("===== MENU CLIENTE =====");
        System.out.println("1. Gestionar cliente");
        System.out.println("2. Monitorear Red WiFi");
        System.out.println("3. Gestionar Incidentes");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private void menuCliente() {
        int opcion;
        do {
            mostrarMenuOpciones();
            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1: sbCliente.mostrarMenuCliente(); break;
                case 2: sbWiFi.mostrarSubmenuWifi(); break;
                case 3: sbIncidentes.menuCliente(usuarioActual); break;
                case 4: System.out.println("Saliendo del menú cliente..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 4);
    }

    private void menuAdmin() {
        int opcion;
        do {
            mostrarMenuOpciones();
            opcion = func.validarEntradaOpcion();

            switch (opcion) {
                case 1: sbAdmin.mostrarMenuAdmin(); break;
                case 2: sbWiFi.mostrarSubmenuWifi(); break;
                case 3: sbIncidentes.menuAdmin(); break;
                case 4: System.out.println("Saliendo del menú administrador..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 4);
    }

}
