package Consola.GUI;

import DAO.EmpleadoDAO;
import DAO.ExceptionDAO;
import Dominio.Empleado;
import Dominio.Rol;
import Extras.Funcionalidades;
import Dominio.Cliente;
import DAO.ClienteDAO;
import ImplementacionDAO.ClienteDAOImpl;
import ImplementacionDAO.EmpleadoDAOImpl;

import java.time.LocalDate;
import java.util.TreeSet;

public class AdminGUI {

    private Funcionalidades func = new Funcionalidades();
    private ClienteDAO clienteDAO = ClienteDAOImpl.getInstancia();
    private EmpleadoDAO empleadoDAO = EmpleadoDAOImpl.getInstancia();

    public void registrarCliente() {
        try {
            System.out.print("Nombre: ");
            String nombre = func.validarNombre();

            System.out.print("Cedula: ");
            String cedula = func.validarTelefono();

            System.out.print("Correo: ");
            String correo = func.validarCorreo();

            System.out.print("Teléfono: ");
            String telefono = func.validarTelefono();

            System.out.print("Direccion: ");
            String direccion = func.validarNombre();

            Cliente c = new Cliente(
                    nombre,
                    cedula,
                    correo,
                    "Cliente123",
                    "CL-" + System.currentTimeMillis() % 1000,
                    telefono,
                    direccion,
                    LocalDate.now()
            );
            clienteDAO.crear(c);
            System.out.println("Cliente creado correctamente");

        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public void listarClientes() {
        for (Cliente c : clienteDAO.listar()) {
            System.out.println(c);
        }
    }
    public void buscarCliente() {
        try {
            System.out.print("Ingrese el ID del cliente: ");
            String id = func.validarUsuario();

            Cliente cliente = clienteDAO.buscarPorId(id);
            System.out.println("\n=== CLIENTE ENCONTRADO ===");
            System.out.println(cliente);

        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public void actualizarCliente() {
        try {
            System.out.print("Ingrese el ID del cliente a actualizar: ");
            String id = func.validarUsuario();

            Cliente cliente = clienteDAO.buscarPorId(id);

            System.out.println("\n=== CLIENTE ACTUAL ===");
            System.out.println(cliente);


            System.out.print("Nuevo correo: ");
            String correo = func.validarCorreo();
            cliente.setEmail(correo);

            System.out.print("Nuevo teléfono: ");
            String telefono = func.validarTelefono();
            cliente.setTelefono(telefono);

            System.out.print("Nueva dirección: ");
            String direccion = func.validarNombre();
            cliente.setDireccion(direccion);

            System.out.println("Cliente actualizado correctamente");
        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public void eliminarCliente() {
        try {
            System.out.print("ID cliente: ");
            String id = func.validarUsuario();

            clienteDAO.eliminarPorId(id);
            System.out.println("Cliente eliminado");
        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public void registrarEmpleado() {
        try {
            System.out.print("Nombre: ");
            String nombre = func.validarNombre();

            System.out.print("Cédula: ");
            String cedula = func.validarUsuario();

            System.out.print("Correo: ");
            String email = func.validarCorreo();


            String id = String.format("EMP-%03d", System.currentTimeMillis() % 1000);

            Empleado e = new Empleado(
                    nombre,
                    cedula,
                    email,
                    "Admin123",
                    id
            );
            empleadoDAO.crear(e);
            System.out.println("Empleado creado correctamente");
        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public void buscarEmpleado() {
        try {
            System.out.print("ID empleado: ");
            String id = func.validarUsuario();

            Empleado e = empleadoDAO.buscarPorId(id);
            System.out.println("\n=== EMPLEADO ENCONTRADO ===");
            System.out.println(e);

        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public void listarEmpleados() {
        for (Empleado aux : empleadoDAO.listar()) {
            System.out.println(aux);
        }
    }

    public void eliminarEmpleado() {
        try {
            System.out.print("ID empleado: ");
            String id = func.validarUsuario();
            empleadoDAO.eliminar(id);
            System.out.println("Empleado eliminado" );
        }catch (ExceptionDAO e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }
}
