package ImplementacionDAO;

import DAO.ExceptionDAO;
import DAO.SolicitudDeSoporteDAO;
import Dominio.SolicitudDeSoporte;
import java.util.Set;
import java.util.TreeSet;

public class SolicitudDeSoporteDAOImpl implements SolicitudDeSoporteDAO{

    private static SolicitudDeSoporteDAOImpl instancia;
    private Set<SolicitudDeSoporte> solicitudDeSoporte;

    private SolicitudDeSoporteDAOImpl() {
        this.solicitudDeSoporte = new TreeSet<>();
    }

    public static SolicitudDeSoporteDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new SolicitudDeSoporteDAOImpl();
        }
        return instancia;
    }

    @Override
    public boolean crear(SolicitudDeSoporte solicitud) throws ExceptionDAO {
        if (solicitud == null) throw new ExceptionDAO("Solicitud nula");
        if(!solicitudDeSoporte.add(solicitud)) throw new ExceptionDAO("Solicitud duplicada");
        return true;
    }

    @Override
    public SolicitudDeSoporte buscarPorId(int idSolicitud) throws ExceptionDAO {
        for (SolicitudDeSoporte s : solicitudDeSoporte) {
            if (s.getIdSolicitud() == idSolicitud) return s;
        }
        throw new ExceptionDAO("Solicitud no encontrada");
    }

    @Override
    public TreeSet<SolicitudDeSoporte> listar() {
        return new TreeSet<>(solicitudDeSoporte);
    }

    @Override
    public TreeSet<SolicitudDeSoporte> listarPorCliente(String idCliente) {

        TreeSet<SolicitudDeSoporte> resultado = new TreeSet<>();

        for (SolicitudDeSoporte s : solicitudDeSoporte) {
            if (s.getCliente() != null &&
                    s.getCliente().getIdCliente().equals(idCliente)) {

                resultado.add(s);
            }
        }

        return resultado;
    }


    @Override
    public boolean actualizar(SolicitudDeSoporte solicitud) throws ExceptionDAO {
        if (solicitud == null) return false;
        SolicitudDeSoporte aux = buscarPorId(solicitud.getIdSolicitud());
        if (aux == null) return false;
        solicitudDeSoporte.remove(aux);
        solicitudDeSoporte.add(solicitud);
        return true;
    }

    @Override
    public boolean eliminarPorId(int idSolicitud) throws  ExceptionDAO {
        SolicitudDeSoporte aux = buscarPorId(idSolicitud);
        if (aux == null) return false;
        solicitudDeSoporte.remove(aux);
        return true;
    }
}
