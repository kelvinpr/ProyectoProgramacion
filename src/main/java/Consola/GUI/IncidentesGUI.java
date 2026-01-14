package Consola.GUI;

import Dominio.*;
import Extras.Funcionalidades;
import ImplementacionDAO.EmpleadoDAOImpl;
import ImplementacionDAO.IncidenteDAOImpl;
import ImplementacionDAO.SolicitudDeSoporteDAOImpl;
import DAO.EmpleadoDAO;
import DAO.IncidenteDAO;
import DAO.SolicitudDeSoporteDAO;

import java.time.LocalDate;
import java.util.Scanner;

public class IncidentesGUI {

    private Funcionalidades func = new Funcionalidades();
    private IncidenteDAO incidenteDAO = IncidenteDAOImpl.getInstancia();
    private SolicitudDeSoporteDAO solicitudDAO = SolicitudDeSoporteDAOImpl.getInstancia();
    private EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstancia();

    public void crearDesdeSolicitud() {

        System.out.print("ID solicitud: ");
        int id = func.validarEntradaOpcion();

        SolicitudDeSoporte s = solicitudDAO.buscarPorId(id);
        if (s == null) {
            System.out.println("Solicitud no encontrada");
            return;
        }

        if (s.getIncidente() != null) {
            System.out.println("La solicitud ya tiene un incidente");
            return;
        }

        Incidente i = new Incidente(
                (int) (System.currentTimeMillis() % 100000),
                LocalDate.now(),
                s.getDescripcion(),
                s                      
        );

        incidenteDAO.crear(i);
        s.setIncidente(i);

        System.out.println("Incidente creado a partir de la solicitud");
    }

    public void listarTodos() {
        for (Incidente i : incidenteDAO.listar()) {
            if (i != null)
                System.out.println(i);
        }
    }

    public void eliminarIncidente() {
        System.out.print("ID incidente: ");
        int id = func.validarEntradaOpcion();

        if (incidenteDAO.eliminarPorId(id))
            System.out.println("Incidente eliminado");
        else
            System.out.println("Incidente no encontrado");
    }

    public void asignarEmpleado() {

        System.out.print("ID incidente: ");
        int idIncidente = func.validarEntradaOpcion();

        Incidente incidente = incidenteDAO.buscarPorId(idIncidente);
        if (incidente == null) {
            System.out.println("Incidente no encontrado");
            return;
        }

        System.out.print("ID empleado: ");
        String idEmpleado = func.validarUsuario();

        Empleado emp = empleadoDAO.buscarPorId(idEmpleado);
        if (emp == null) {
            System.out.println("Empleado no encontrado");
            return;
        }

        incidente.asignarEmpleado(emp);
        System.out.println("Empleado asignado correctamente");
    }

    public void cambiarEstado() {

        System.out.print("ID incidente: ");
        int idIncidente = func.validarEntradaOpcion();

        Incidente incidente = incidenteDAO.buscarPorId(idIncidente);
        if (incidente == null) {
            System.out.println("Incidente no encontrado");
            return;
        }

        System.out.println("Estado actual: " + incidente.getEstado());
        System.out.println("1. PENDIENTE");
        System.out.println("2. EN PROCESO");
        System.out.println("3. ATENDIDO");

        int op = func.validarEntradaOpcion();

        EstadoIncidente nuevoEstado = switch (op) {
            case 1 -> EstadoIncidente.PENDIENTE;
            case 2 -> EstadoIncidente.EN_PROCESO;
            case 3 -> EstadoIncidente.ATENDIDO;
            default -> incidente.getEstado();
        };

        incidente.cambiarEstado(nuevoEstado);

        if (nuevoEstado == EstadoIncidente.ATENDIDO) {
            incidente.getSolicitudOrigen().setEstado(EstadoSolicitud.RESUELTA);
        }

        System.out.println("Estado actualizado correctamente");
    }

    public void agregarComentario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID incidente: ");
        int idIncidente = func.validarEntradaOpcion();

        Incidente incidente = incidenteDAO.buscarPorId(idIncidente);
        if (incidente == null) {
            System.out.println("Incidente no encontrado");
            return;
        }

        System.out.print("Ingrese el comentario: ");
        String comentario = sc.nextLine();

        incidente.agregarComentario(comentario);

        System.out.println("Comentario agregado correctamente");
    }

}
