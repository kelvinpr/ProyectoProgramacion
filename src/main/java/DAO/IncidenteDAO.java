package DAO;

import Dominio.Incidente;

import java.util.TreeSet;

public interface IncidenteDAO {
    boolean crear(Incidente incidente) throws ExceptionDAO;

    Incidente buscarPorId(int idIncidente) throws ExceptionDAO;

    boolean actualizar(Incidente incidente) throws ExceptionDAO;

    boolean eliminarPorId(int idIncidente) throws ExceptionDAO;

    TreeSet<Incidente> listar();
}
