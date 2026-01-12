package DAO;

import Dominio.SolicitudDeSoporte;

public interface SolicitudDeSoporteDAO {
    boolean crear(SolicitudDeSoporte solicitud);

    SolicitudDeSoporte buscarPorId(int idSolicitud);

    SolicitudDeSoporte[] listar();

    SolicitudDeSoporte[] listarPorCliente(String idCliente);

    boolean actualizar(SolicitudDeSoporte solicitud);

    boolean eliminarPorId(int idSolicitud);
}
    