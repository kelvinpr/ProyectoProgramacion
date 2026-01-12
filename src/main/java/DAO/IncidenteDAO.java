package DAO;

import Dominio.Incidente;

public interface IncidenteDAO {
    boolean crear(Incidente incidente);

    Incidente buscarPorId(int idIncidente);

    boolean actualizar(Incidente incidente);

    boolean eliminarPorId(int idIncidente);

    Incidente[] listar();
}
