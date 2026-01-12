package ImplementacionDAO;

import DAO.SolicitudDeSoporteDAO;
import Dominio.SolicitudDeSoporte;

public class SolicitudDeSoporteDAOImpl implements SolicitudDeSoporteDAO{

    private static SolicitudDeSoporteDAOImpl instancia;
    private SolicitudDeSoporte[] solicitudes;
    private int contador;

    private SolicitudDeSoporteDAOImpl() {
        solicitudes = new SolicitudDeSoporte[3];
        contador = 0;
    }

    public static SolicitudDeSoporteDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new SolicitudDeSoporteDAOImpl();
        }
        return instancia;
    }

    @Override
    public boolean crear(SolicitudDeSoporte solicitud) {
        if (solicitud == null) return false;

        if (contador >= solicitudes.length) {
            SolicitudDeSoporte[] aux =
                    new SolicitudDeSoporte[solicitudes.length + 1];
            System.arraycopy(solicitudes, 0, aux, 0, solicitudes.length);
            solicitudes = aux;
        }

        solicitudes[contador] = solicitud;
        contador++;
        return true;
    }

    @Override
    public SolicitudDeSoporte buscarPorId(int idSolicitud) {
        for (int i = 0; i < contador; i++) {
            if (solicitudes[i].getIdSolicitud() == idSolicitud) {
                return solicitudes[i];
            }
        }
        return null;
    }

    @Override
    public SolicitudDeSoporte[] listar() {
        SolicitudDeSoporte[] aux = new SolicitudDeSoporte[contador];
        System.arraycopy(solicitudes, 0, aux, 0, contador);
        return aux;
    }

    @Override
    public SolicitudDeSoporte[] listarPorCliente(String idCliente) {
        int total = 0;

        for (int i = 0; i < contador; i++) {
            if (solicitudes[i].getCliente()
                    .getIdCliente().equals(idCliente)) {
                total++;
            }
        }

        SolicitudDeSoporte[] aux = new SolicitudDeSoporte[total];
        int index = 0;

        for (int i = 0; i < contador; i++) {
            if (solicitudes[i].getCliente()
                    .getIdCliente().equals(idCliente)) {
                aux[index++] = solicitudes[i];
            }
        }

        return aux;
    }

    @Override
    public boolean actualizar(SolicitudDeSoporte solicitud) {
        if (solicitud == null) return false;

        for (int i = 0; i < contador; i++) {
            if (solicitudes[i].getIdSolicitud()
                    == solicitud.getIdSolicitud()) {
                solicitudes[i] = solicitud;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarPorId(int idSolicitud) {
        for (int i = 0; i < contador; i++) {
            if (solicitudes[i].getIdSolicitud() == idSolicitud) {
                System.arraycopy(solicitudes, i + 1, solicitudes, i, contador - i - 1);
                solicitudes[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }
}
