package Consola.GUI;

import Extras.Funcionalidades;

import java.util.Scanner;

public class ClienteGUI {
    private Scanner sc = new Scanner(System.in);
    private Funcionalidades func = new Funcionalidades();

    public void actualizarDatosPersonales(){
        System.out.println("Ingrese su nuevo correo: ");
        String correo = func.validarCorreo();

        System.out.println("Ingrese su nuevo telefono: ");
        String telefono = func.validarTelefono();

        System.out.println("\nDatos actualizados con exito:");
        System.out.println("Correo: " + correo);
        System.out.println("Teléfono: " + telefono);
    }

    public void actualizarContrasenia(){
        System.out.println("Ingrese su nueva contraseña: ");
        String contrasenia = func.validarContrasenia();

        System.out.println("\nContraseña actualizada con exito.");
    }
}
