package Consola.SubMenu;

import Consola.GUI.IncidentesGUI;
import Extras.Funcionalidades;

public class SubMenuIncidenteAdmin {

    private IncidentesGUI gui = new IncidentesGUI();
    private Funcionalidades func = new Funcionalidades();

    public void mostrar() {
        int op;
        do {
            System.out.println("\n=== INCIDENTES (ADMIN) ===");
            System.out.println("1. Crear incidente desde solicitud");
            System.out.println("2. Asignar empleado");
            System.out.println("3. Cambiar estado del incidente");
            System.out.println("4. Agregar comentario"); // 👈 NUEVO
            System.out.println("5. Listar incidentes");
            System.out.println("6. Eliminar incidente");
            System.out.println("7. Volver");

            op = func.validarEntradaOpcion();

            switch (op) {
                case 1 -> gui.crearDesdeSolicitud();
                case 2 -> gui.asignarEmpleado();
                case 3 -> gui.cambiarEstado();
                case 4 -> gui.agregarComentario(); // 👈 NUEVO
                case 5 -> gui.listarTodos();
                case 6 -> gui.eliminarIncidente();
                case 7 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (op != 7);
    }


}
