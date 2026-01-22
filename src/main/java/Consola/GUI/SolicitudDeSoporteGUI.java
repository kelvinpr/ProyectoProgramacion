package Consola.GUI;

import DAO.ExceptionDAO;
import Dominio.Cliente;
import Dominio.Incidente;
import Dominio.SolicitudDeSoporte;
import Extras.Funcionalidades;
import DAO.SolicitudDeSoporteDAO;
import ImplementacionDAO.IncidenteDAOImpl;
import ImplementacionDAO.SolicitudDeSoporteDAOImpl;

import java.time.LocalDate;
import java.util.TreeSet;

public class SolicitudDeSoporteGUI {

    private Funcionalidades func = new Funcionalidades();
    private SolicitudDeSoporteDAO solicitudDAO =
            SolicitudDeSoporteDAOImpl.getInstancia();
    private IncidenteDAOImpl incidenteDAO =
            IncidenteDAOImpl.getInstancia();

    // CLIENTE
    public void crearSolicitud(Cliente cliente) {
        try {
            System.out.print("Descripción: ");
            String desc = func.validarNombre();

            SolicitudDeSoporte s = new SolicitudDeSoporte(
                    (int) (System.currentTimeMillis() % 100000),
                    desc,
                    cliente
            );

            solicitudDAO.crear(s);      // persistencia
            cliente.agregarSolicitud(s); // relación UML

            System.out.println("Solicitud creada correctamente");
        }catch (ExceptionDAO e){
            System.out.println("Error -> " +  e.getMessage());
        }
    }

    public void listarMisSolicitudes(Cliente cliente) {
    TreeSet<SolicitudDeSoporte> solicitudes = cliente.getSolicitudes();

    if (solicitudes.isEmpty()) {
        System.out.println("No tienes solicitudes");
        return;
    }

    for (SolicitudDeSoporte s : solicitudes) {
        System.out.println(s);
    }
}

    //Admin
    public void listarTodas() {
        for (SolicitudDeSoporte s : solicitudDAO.listar()) {
            System.out.println(s);
        }
    }

    public void eliminarSolicitud() {
        try {
            System.out.print("ID solicitud: ");
            int id = func.validarEntradaOpcion();
            SolicitudDeSoporte solicitud = solicitudDAO.buscarPorId(id);
            Incidente incidente = solicitud.getIncidente();
            Cliente cliente = solicitud.getCliente();
            if (incidente != null) {
                 incidenteDAO.eliminarPorId(incidente.getIdIncidente());
            }
            solicitudDAO.eliminarPorId(id);
            System.out.println("Solicitud eliminada correctamente");
        }catch (ExceptionDAO e){
            System.out.println("Error -> " +  e.getMessage());
        }
    }
}

