package Consola.GUI;

import Extras.Funcionalidades;

import java.util.Scanner;

public class AdminGUI {
    private Funcionalidades func = new Funcionalidades();
    private Scanner sc = new Scanner(System.in);

    public void registrarNuevoCliente(){
        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCLiente = func.validarNombre();

        System.out.println("Ingrese el apellido del cliente: ");
        String apellidoCliente = func.validarNombre();

        System.out.println("Ingrese el correo del cliente: ");
        String correoCliente = func.validarCorreo();

        System.out.println("Ingrese el telefono del cliente: ");
        String telefonoCliente = func.validarTelefono();

        System.out.println("\nCliente registrado con éxito:");
        System.out.println("Nombre: " + nombreCLiente);
        System.out.println("Apellido: " + apellidoCliente);
        System.out.println("Correo: " + correoCliente);
        System.out.println("Teléfono: " + telefonoCliente);
    }

    public void consultarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int idCliente = func.validarEntradaOpcion();
        System.out.println("Consultando cliente con ID: " + idCliente);
    }

    public void eliminarCliente(){
        System.out.println("Ingrese el id del cliente: ");
        int idCliente = func.validarEntradaOpcion();
        System.out.println("Eliminando cliente con ID: " + idCliente);
    }
}
