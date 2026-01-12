package ImplementacionDAO;

import DAO.EmpleadoDAO;
import Dominio.Empleado;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    private static EmpleadoDAOImpl instancia;
    private Empleado[] empleados;
    private int contador;

     private EmpleadoDAOImpl() {
        empleados = new Empleado[3]; 
        contador = 0;
    }

    public static EmpleadoDAOImpl getInstancia() {
         if (instancia == null) {
             instancia = new EmpleadoDAOImpl();
         }
         return instancia;
    }

    @Override
    public boolean crear(Empleado empleado) {
        if (empleado == null) return false;

        if (contador >= empleados.length) {
            Empleado[] aux = new Empleado[empleados.length + 1];
            System.arraycopy(empleados, 0, aux, 0, empleados.length);
            empleados = aux;
        }
        empleados[contador] = empleado;
        contador++;
        return true;
    }

    @Override
    public Empleado buscarPorId(String idEmpleado) {
        for(Empleado empleado : empleados) {
            if(empleado.getIdEmpleado().equals(idEmpleado)) return empleado;
        }
        return null;
    }

    @Override
    public boolean actualizar(Empleado empleado) {
        if (empleado == null) return false;

        for (int i = 0; i < contador; i++) {
            if (empleados[i].getIdEmpleado()
                    .equals(empleado.getIdEmpleado())) {
                empleados[i] = empleado;
                return true;
            }
        }
        return false;
    }

    @Override
    public Empleado[] listar() {
        Empleado[] aux = new Empleado[contador];
        System.arraycopy(empleados, 0, aux, 0, contador);
        return aux;
    }
}
