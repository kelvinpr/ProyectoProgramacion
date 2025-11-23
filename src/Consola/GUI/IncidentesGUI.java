package Consola.GUI;

import java.util.ArrayList;
import java.util.Scanner;

public class IncidentesGUI {
    private Scanner sc = new Scanner(System.in);

    private ArrayList<Incidente> incidentes = new ArrayList<>();

    // FUNCIONES DEL CLIENTE

    public void registrarIncidente(String usuario) {
        System.out.print("Descripción del incidente: ");
        String desc = sc.nextLine();

        incidentes.add(new Incidente(usuario, desc));

        System.out.println("Incidente registrado correctamente.");
    }

    public void consultarMisIncidentes(String usuario) {
        System.out.println("===== MIS INCIDENTES =====");
        boolean tiene = false;

        for (int i = 0; i < incidentes.size(); i++) {
            Incidente inc = incidentes.get(i);

            if (inc.getUsuario().equals(usuario)) {
                tiene = true;
                System.out.println((i + 1) + ". [" + inc.getEstado() + "] " + inc.getDescripcion());
            }
        }

        if (!tiene) System.out.println("No tienes incidentes registrados.");
    }

    public void eliminarIncidenteCliente(String usuario) {
        consultarMisIncidentes(usuario);

        System.out.print("Número del incidente a eliminar: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num < 1 || num > incidentes.size()) {
            System.out.println("Número inválido.");
            return;
        }

        Incidente inc = incidentes.get(num - 1);

        if (!inc.getUsuario().equals(usuario)) {
            System.out.println("No puedes eliminar incidentes de otro usuario.");
            return;
        }

        incidentes.remove(num - 1);
        System.out.println("Incidente eliminado correctamente.");
    }

    // FUNCIONES DEL ADMIN
    public void consultarTodos() {
        System.out.println("===== TODOS LOS INCIDENTES =====");

        if (incidentes.isEmpty()) {
            System.out.println("No hay incidentes registrados.");
            return;
        }

        for (int i = 0; i < incidentes.size(); i++) {
            Incidente inc = incidentes.get(i);

            System.out.println((i + 1) + ". Usuario: " + inc.getUsuario() +
                    " | Estado: " + inc.getEstado() +
                    " | Descripción: " + inc.getDescripcion());
        }
    }

    public void actualizarIncidente() {
        consultarTodos();

        if (incidentes.isEmpty()) return;

        System.out.print("Número del incidente a actualizar: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num < 1 || num > incidentes.size()) {
            System.out.println("Número inválido.");
            return;
        }

        System.out.print("Nuevo estado (Pendiente / En proceso / Resuelto): ");
        String nuevo = sc.nextLine();

        incidentes.get(num - 1).setEstado(nuevo);

        System.out.println("Estado actualizado correctamente.");
    }

    public void eliminarIncidenteAdmin() {
        consultarTodos();

        if (incidentes.isEmpty()) return;

        System.out.print("Número del incidente a eliminar: ");
        int num = Integer.parseInt(sc.nextLine());

        if (num < 1 || num > incidentes.size()) {
            System.out.println("Número inválido.");
            return;
        }

        incidentes.remove(num - 1);

        System.out.println("Incidente eliminado correctamente.");
    }
}
