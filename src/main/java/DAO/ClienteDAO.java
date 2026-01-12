package DAO;

import Dominio.Cliente;

public interface ClienteDAO {
    boolean crear(Cliente cliente);

    Cliente buscarPorId(String idCliente);

    boolean actualizar(Cliente cliente);

    boolean eliminarPorId(String idCliente);

    Cliente[] listar();

}
