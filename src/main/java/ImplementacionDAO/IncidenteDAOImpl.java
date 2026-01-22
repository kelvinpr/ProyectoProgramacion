package ImplementacionDAO;

import DAO.ExceptionDAO;
import DAO.IncidenteDAO;
import Dominio.Incidente;
import Dominio.SolicitudDeSoporte;

import java.util.Set;
import java.util.TreeSet;

public class IncidenteDAOImpl implements IncidenteDAO {

    private static IncidenteDAOImpl instancia;
    private Set<Incidente> incidentes;

    private IncidenteDAOImpl() {
        this.incidentes =  new TreeSet<>();
    }

    public  static IncidenteDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new IncidenteDAOImpl();
        }
        return instancia;
    }

    @Override
    public boolean crear(Incidente incidente) throws ExceptionDAO {
        if (incidente == null) throw new ExceptionDAO("Incidente nulo");
        if(!incidentes.add(incidente)) throw new ExceptionDAO("Incidente duplicado");
        return true;
    }

    @Override
    public Incidente buscarPorId(int idIncidente) throws ExceptionDAO {
        for (Incidente i : incidentes) {
            if (i.getIdIncidente() == idIncidente) return i;
        }
        throw new ExceptionDAO("Incidente no encontrado");
    }

    @Override
    public boolean actualizar(Incidente incidente) throws ExceptionDAO {
        if (incidente == null) return false;
        Incidente aux = buscarPorId(incidente.getIdIncidente());
        if (aux == null) return false;
        incidentes.remove(aux);
        incidentes.add(incidente);
        return true;
    }

    @Override
    public boolean eliminarPorId(int idIncidente) throws ExceptionDAO {
        Incidente aux = buscarPorId(idIncidente);
        if (aux == null) return false;
        incidentes.remove(aux);
        return true;
    }

    @Override
    public TreeSet<Incidente> listar() {
        return new TreeSet<>(incidentes);
    }
}
