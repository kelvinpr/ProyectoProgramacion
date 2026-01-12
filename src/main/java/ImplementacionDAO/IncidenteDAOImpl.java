package ImplementacionDAO;

import DAO.IncidenteDAO;
import Dominio.Incidente;

public class IncidenteDAOImpl implements IncidenteDAO {

    private static IncidenteDAOImpl instancia;
    private Incidente[] incidentes;
    private int contador;

    private IncidenteDAOImpl() {
        incidentes = new Incidente[3];
        contador = 0;
    }

    public  static IncidenteDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new IncidenteDAOImpl();
        }
        return instancia;
    }

    @Override
    public boolean crear(Incidente incidente) {
        if (incidente == null) return false;

        if (contador >= incidentes.length) {
            Incidente[] aux =
                    new Incidente[incidentes.length + 1];
            System.arraycopy(incidentes, 0, aux, 0, incidentes.length);
            incidentes = aux;
        }

        incidentes[contador] = incidente;
        contador++;
        return true;
    }

    @Override
    public Incidente buscarPorId(int idIncidente) {
        for (int i = 0; i < contador; i++) {
            if (incidentes[i].getIdIncidente() == idIncidente) {
                return incidentes[i];
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Incidente incidente) {
        if (incidente == null) return false;

        for (int i = 0; i < contador; i++) {
            if (incidentes[i].getIdIncidente()
                    == incidente.getIdIncidente()) {
                incidentes[i] = incidente;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarPorId(int idIncidente) {
        for (int i = 0; i < contador; i++) {
            if (incidentes[i].getIdIncidente() == idIncidente) {

                System.arraycopy(incidentes, i + 1, incidentes, i, contador - i - 1);
                incidentes[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Incidente[] listar() {
        Incidente[] aux = new Incidente[contador];
        System.arraycopy(incidentes, 0, aux, 0, contador);
        return aux;
    }
}
