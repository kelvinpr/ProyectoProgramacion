package Consola.GUI;

import java.util.Scanner;

public class ClienteGUI {
    private Scanner sc = new Scanner(System.in);

    public void actualizarDatosPersonales(){
        System.out.println("Ingrese su nuevo correo: ");
        String correo = sc.nextLine();
        System.out.println("Ingrese su nuevo telefono: ");
        String telefono = sc.nextLine();
    }

    public void actualizarContrasenia(){
        System.out.println("Ingrese su nueva contrasenia: ");
        String contrasenia = sc.nextLine();
    }
}
