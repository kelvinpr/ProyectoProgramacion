package Extras;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcionalidades {
    private Scanner sc = new Scanner(System.in);

    public int validarEntradaOpcion() {
        Pattern pattern = Pattern.compile("\\d+");

        while (true) {
            String entrada = sc.nextLine();
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) {
                return Integer.parseInt(entrada);
            } else {
                System.out.print("Error: Ingrese un número válido: ");
            }
        }
    }

    public String validarUsuario() {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._-]{3,}$");

        while (true) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) return input;

            System.out.print("Error: Ingrese un usuario válido (mín. 3 caracteres, solo letras, números y . _ -): ");
        }
    }

    public String validarNombre() {
        Pattern pattern = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,}$");

        while (true) {
            String entrada = sc.nextLine();
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) {
                return entrada;
            } else {
                System.out.print("Error: Ingrese un nombre válido: ");
            }
        }
    }

    public String validarCorreo() {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

        while (true) {
            String entrada = sc.nextLine();
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) {
                return entrada;
            } else {
                System.out.print("Error: Ingrese un correo válido: ");
            }
        }
    }

    public String validarTelefono() {
        Pattern pattern = Pattern.compile("^\\d{7,15}$");

        while (true) {
            String entrada = sc.nextLine();
            Matcher matcher = pattern.matcher(entrada);

            if (matcher.matches()) {
                return entrada;
            } else {
                System.out.print("Error: Ingrese un teléfono válido (solo números): ");
            }
        }
    }

    public String validarContrasenia() {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$");

        while (true) {
            String entrada = sc.nextLine();
            Matcher matcher = pattern.matcher(entrada);
            if (matcher.matches()) return entrada;

            System.out.print("Error: La contraseña debe tener al menos 8 caracteres, " +
                    "incluyendo mayúscula, minúscula y número: ");
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
