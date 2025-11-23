package Extras;

import java.util.Scanner;

public class Funcionalidades {
    private Scanner sc = new Scanner(System.in);

    public int validarEntradaOpcion() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Error: Ingrese un número válido: ");
            }
        }
    }

    public void limpiarConsolaIDE() {
        for (int i = 0; i < 41; i++) {
            System.out.println();
        }
    }

    public void esperarLimpieza() {
        try {
            Thread.sleep(3 * 1000); //
        } catch (InterruptedException e) {
            System.out.println("Error en el tiempo de espera.");
        }
    }
}
