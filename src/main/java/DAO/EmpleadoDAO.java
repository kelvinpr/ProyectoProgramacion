package DAO;

import Dominio.Empleado;

public interface EmpleadoDAO {
    
    boolean crear(Empleado empleado);

    Empleado buscarPorId(String idEmpleado);

    boolean actualizar(Empleado empleado);

    Empleado[] listar();

    boolean eliminar(String idEmpleado);
}
