package Test;

import java.time.LocalDate;

import Consola.GUI.LoginGUI;
import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import Dominio.Cliente;
import Dominio.Empleado;
import ImplementacionDAO.ClienteDAOImpl;
import ImplementacionDAO.EmpleadoDAOImpl;

public class Proyecto {
    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
        inicializarDatos();
        login.iniciar();
    }
    private static void inicializarDatos() {

        ClienteDAO clienteDAO = ClienteDAOImpl.getInstancia();
        EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstancia();

        Cliente cliente = new Cliente(
                "Juan",
                "123456789",
                "juan@mail.com",
                "Cliente123",
                "CLIENTE",
                "CL-001",
                "099999999",
                "Quito",
                LocalDate.now()
        );

        clienteDAO.crear(cliente);

        Empleado admin = new Empleado(
                "Admin",
                "987654321",
                "admin@mail.com",
                "Admin123",
                "ADMIN",
                "EMP-001"
                );
        empleadoDAO.crear(admin);
    }
}
