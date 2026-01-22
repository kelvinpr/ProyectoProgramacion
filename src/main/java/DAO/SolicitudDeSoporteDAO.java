package DAO;

import Dominio.SolicitudDeSoporte;

import java.util.TreeSet;

public interface SolicitudDeSoporteDAO {
    boolean crear(SolicitudDeSoporte solicitud) throws ExceptionDAO;

    SolicitudDeSoporte buscarPorId(int idSolicitud) throws ExceptionDAO;

    TreeSet<SolicitudDeSoporte> listar();

    TreeSet<SolicitudDeSoporte> listarPorCliente(String idCliente);

    boolean actualizar(SolicitudDeSoporte solicitud) throws ExceptionDAO;

    boolean eliminarPorId(int idSolicitud) throws ExceptionDAO;
}
    