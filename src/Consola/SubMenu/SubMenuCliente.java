package Consola.SubMenu;

import Extras.Funcionalidades;
import Consola.GUI.ClienteGUI;

import java.util.Scanner;

public class SubMenuCliente {
    private Funcionalidades func =  new Funcionalidades();
    private ClienteGUI cliente = new ClienteGUI();
    public void mostrarMenuCliente() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("===== SUBMENÚ: GESTIONAR USUARIO -> CLIENTE =====");
            System.out.println("1. Actualizar datos peronales");
            System.out.println("2. Actualizar contrasenia");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch(opcion){
                case 1: cliente.actualizarDatosPersonales();
                    System.out.println("Datos actualizados exitosamente!");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 2: cliente.actualizarContrasenia();
                    System.out.println("Contrasenia actualizada exitosamente!");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 3 : System.out.println("Volviendo al menú principal...");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                default : System.out.println("Opción no válida.");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
            }
        }while (opcion != 3);
    }
}
