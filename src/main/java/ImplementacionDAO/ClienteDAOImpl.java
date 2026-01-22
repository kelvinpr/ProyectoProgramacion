package ImplementacionDAO;

import DAO.ClienteDAO;
import DAO.ExceptionDAO;
import Dominio.Cliente;


import java.util.Set;
import java.util.TreeSet;

public class ClienteDAOImpl implements ClienteDAO {

    private static ClienteDAOImpl instancia;
    private Set<Cliente> clientes;

    private ClienteDAOImpl(){
        this.clientes = new TreeSet<Cliente>();
    }

    public static ClienteDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDAOImpl();
        }
        return instancia;
    }
    
    @Override
    public boolean crear(Cliente cliente) throws ExceptionDAO {
        if (cliente == null) throw new ExceptionDAO("Cliente nulo");
        if(!clientes.add(cliente)) throw new ExceptionDAO("Cliente duplicado (cédula ya registrada)");
        return true;
    }

    @Override
    public Cliente buscarPorId(String idCliente) throws ExceptionDAO {
        for(Cliente aux:clientes){
            if(aux.getIdCliente().equals(idCliente)) return aux;
        }
        throw new ExceptionDAO("Cliente no encontrado");
    }

    @Override
    public boolean actualizar(Cliente cliente) throws ExceptionDAO{
        if (cliente == null) return false;
        Cliente aux = buscarPorId(cliente.getIdCliente());
        if (aux == null) return false;
        clientes.remove(aux);
        clientes.add(cliente);
        return true;
    }

    @Override
    public boolean eliminarPorId(String idCliente) throws ExceptionDAO {
         Cliente aux = buscarPorId(idCliente);
         if (aux == null) return false;
         clientes.remove(aux);
        return true;
    }

    @Override
    public TreeSet<Cliente> listar() {
        return new TreeSet<>(clientes);
    }

}
