package DAO;

import Dominio.Cliente;

import java.util.TreeSet;

public interface ClienteDAO {
    boolean crear(Cliente cliente) throws ExceptionDAO;

    Cliente buscarPorId(String idCliente) throws ExceptionDAO;

    boolean actualizar(Cliente cliente) throws ExceptionDAO;

    boolean eliminarPorId(String idCliente) throws ExceptionDAO;

    TreeSet<Cliente> listar();

}
