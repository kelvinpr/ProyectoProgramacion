package Test;

import java.time.LocalDate;

import Consola.GUI.LoginGUI;
import DAO.ClienteDAO;
import DAO.EmpleadoDAO;
import DAO.ExceptionDAO;
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
        try {
            ClienteDAO clienteDAO = ClienteDAOImpl.getInstancia();
            EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstancia();

            Cliente cliente = new Cliente(
                    "Juan",
                    "123456789",
                    "juan@gmail.com",
                    "Cliente123",
                    "CL-001",
                    "099999999",
                    "Quito",
                    LocalDate.now()
            );

            clienteDAO.crear(cliente);

            Empleado admin = new Empleado(
                    "Jorge",
                    "987654321",
                    "admin@gmail.com",
                    "Admin123",
                    "EMP-001"
            );
            empleadoDAO.crear(admin);
        }catch (ExceptionDAO e){
            System.out.println("Error -> " +  e.getMessage());
        }
    }
}
