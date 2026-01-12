package ImplementacionDAO;

import DAO.ClienteDAO;
import Dominio.Cliente;

public class ClienteDAOImpl implements ClienteDAO {

    private static ClienteDAOImpl instancia;

    private Cliente[] clientes;
    private int contador;

    private ClienteDAOImpl(){
        this.clientes = new Cliente[3];
        this.contador = 0;
    }

    public static ClienteDAOImpl getInstancia() {
        if (instancia == null) {
            instancia = new ClienteDAOImpl();
        }
        return instancia;
    }
    
    @Override
    public boolean crear(Cliente cliente) {
        if (cliente == null) return false;

        if (contador >= clientes.length) {
            Cliente[] aux = new Cliente[contador + 1];
            System.arraycopy(clientes, 0, aux, 0, contador);
            clientes = aux;
        }

        clientes[contador] = cliente;
        contador++;
        return true;
    }

    @Override
    public Cliente buscarPorId(String idCliente) {
        if(idCliente == null) return null;
        for(Cliente cli: clientes) {
            if(cli != null && cli.getIdCliente().equals(idCliente)) {
                return cli;
            }
        }
        return null;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        if (cliente == null) return false;

        for (int i = 0; i < contador; i++) {
            if (clientes[i].getIdCliente().equals(cliente.getIdCliente())) {
                clientes[i] = cliente;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarPorId(String idCliente) {
         for (int i = 0; i < contador; i++) {
            if (clientes[i].getIdCliente().equals(idCliente)) {

                System.arraycopy(clientes,i + 1,clientes,i,contador - i - 1);
                clientes[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Cliente[] listar() {
        Cliente[] aux = new Cliente[contador];
        System.arraycopy(clientes, 0, aux, 0, contador);
        return aux;
    }

}
