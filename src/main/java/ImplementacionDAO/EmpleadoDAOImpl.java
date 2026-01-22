package ImplementacionDAO;

import DAO.EmpleadoDAO;
import DAO.ExceptionDAO;
import Dominio.Cliente;
import Dominio.Empleado;
import com.sun.source.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    private static EmpleadoDAOImpl instancia;
    private Set<Empleado> empleados;

     private EmpleadoDAOImpl() {
        this.empleados = new  TreeSet<>();
    }

    public static EmpleadoDAOImpl getInstancia() {
         if (instancia == null) {
             instancia = new EmpleadoDAOImpl();
         }
         return instancia;
    }

    @Override
    public boolean crear(Empleado empleado) throws ExceptionDAO {
        if (empleado == null) throw new ExceptionDAO("Empleado nulo");
        if(!empleados.add(empleado)) throw new ExceptionDAO("Empleado duplicado");
        return true;
    }

    @Override
    public Empleado buscarPorId(String idEmpleado) throws ExceptionDAO {
        for(Empleado empleado : empleados) {
            if(empleado.getIdEmpleado().equals(idEmpleado)) return empleado;
        }
        throw new ExceptionDAO("Empleado no encontrado");
    }

    @Override
    public boolean actualizar(Empleado empleado) throws  ExceptionDAO {
        if (empleado == null) return false;
        Empleado aux = buscarPorId(empleado.getIdEmpleado());
        if (aux == null) return false;
        empleados.remove(aux);
        empleados.add(empleado);
        return true;
    }

    @Override
    public TreeSet<Empleado> listar() {
        return new TreeSet<>(empleados);
    }

    @Override
    public boolean eliminar(String idEmpleado) throws ExceptionDAO {
        Empleado aux = buscarPorId(idEmpleado);
        if (aux == null) return false;
        empleados.remove(aux);
        return true;
    }
}
