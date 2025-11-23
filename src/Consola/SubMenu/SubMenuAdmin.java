package Consola.SubMenu;

import Extras.Funcionalidades;
import Consola.GUI.AdminGUI;

import java.util.Scanner;

public class SubMenuAdmin {
    Funcionalidades func = new Funcionalidades();
    AdminGUI admin  = new AdminGUI();
    public void mostrarMenuAdmin(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("===== SUBMENÚ: GESTIONAR USUARIO -> ADMIN =====");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Consultar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = func.validarEntradaOpcion();

            switch(opcion){
                case 1: admin.registrarNuevoCliente();
                    System.out.println("Cliente registrado exitosamente!");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 2: admin.consultarCliente();
                    System.out.println("Cliente encontrado exitosamente!");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 3: admin.eliminarCliente();
                    System.out.println("Cliente eliminado exitosamente!");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                case 4 : System.out.println("Volviendo al menú principal...");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
                default : System.out.println("Opción no válida.");
                    func.esperarLimpieza();
                    func.limpiarConsolaIDE();
                    break;
            }
        }while (opcion != 4);
    }
}
