package Consola.GUI;

import Dominio.Cliente;
import Dominio.SolicitudDeSoporte;
import Extras.Funcionalidades;
import DAO.SolicitudDeSoporteDAO;
import ImplementacionDAO.SolicitudDeSoporteDAOImpl;

import java.time.LocalDate;

public class SolicitudDeSoporteGUI {

    private Funcionalidades func = new Funcionalidades();
    private SolicitudDeSoporteDAO solicitudDAO =
            SolicitudDeSoporteDAOImpl.getInstancia();

    // CLIENTE
    public void crearSolicitud(Cliente cliente) {

        System.out.print("Descripción: ");
        String desc = func.validarNombre();

        SolicitudDeSoporte s = new SolicitudDeSoporte(
                (int)(System.currentTimeMillis() % 100000),
                desc,
                cliente
        );

        solicitudDAO.crear(s);      // persistencia
        cliente.agregarSolicitud(s); // relación UML

        System.out.println("Solicitud creada correctamente");
    }

    public void listarMisSolicitudes(Cliente cliente) {
    SolicitudDeSoporte[] solicitudes = cliente.getSolicitudes();

    if (solicitudes.length == 0) {
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
        System.out.print("ID solicitud: ");
        int id = func.validarEntradaOpcion();

        if (solicitudDAO.eliminarPorId(id))
            System.out.println("Solicitud eliminada");
        else
            System.out.println("Solicitud no encontrada");
    }
}

