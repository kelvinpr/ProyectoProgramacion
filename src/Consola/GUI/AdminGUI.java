package Consola.GUI;

import java.util.Scanner;

public class AdminGUI {
    Scanner sc = new Scanner(System.in);
    public void registrarNuevoCliente(){
        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCLiente = sc.nextLine();
        System.out.println("Ingrese el apellido del cliente: ");
        String apellidoCliente = sc.nextLine();
        System.out.println("Ingrese el correo del cliente: ");
        String correoCliente = sc.nextLine();
        System.out.println("Ingrese su telefono del cliente: ");
        String telefonoCliente = sc.nextLine();
    }

    public void consultarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int idCliente = sc.nextInt();
    }

    public void eliminarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int idCliente = sc.nextInt();
    }
}
