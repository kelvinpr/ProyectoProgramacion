package DAO;

import Dominio.Empleado;

import java.util.TreeSet;

public interface EmpleadoDAO {
    
    boolean crear(Empleado empleado) throws ExceptionDAO;

    Empleado buscarPorId(String idEmpleado) throws ExceptionDAO;

    boolean actualizar(Empleado empleado) throws ExceptionDAO;

    TreeSet<Empleado> listar();

    boolean eliminar(String idEmpleado) throws ExceptionDAO;
}
