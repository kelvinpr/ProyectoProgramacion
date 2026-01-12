package Consola.GUI;

import Extras.Funcionalidades;
import Dominio.Cliente;
import DAO.ClienteDAO;
import ImplementacionDAO.ClienteDAOImpl;

import java.time.LocalDate;

public class AdminGUI {

    private Funcionalidades func = new Funcionalidades();
    private ClienteDAO clienteDAO = ClienteDAOImpl.getInstancia();

    public void registrarCliente() {
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
                "CLIENTE",
                "CL-" + System.currentTimeMillis(),
                telefono,
                direccion,
                LocalDate.now()
        );

        clienteDAO.crear(c);
        System.out.println("Cliente registrado");
    }

    public void listarClientes() {
        for (Cliente c : clienteDAO.listar()) {
            System.out.println(c);
        }
    }
    public void buscarCliente() {
        System.out.print("Ingrese el ID del cliente: ");
        String id = func.validarUsuario();

        Cliente cliente = clienteDAO.buscarPorId(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
        } else {
            System.out.println("\n=== CLIENTE ENCONTRADO ===");
            System.out.println(cliente);
        }
    }

    public void actualizarCliente() {
    System.out.print("Ingrese el ID del cliente a actualizar: ");
    String id = func.validarUsuario();

    Cliente cliente = clienteDAO.buscarPorId(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        System.out.println("\n=== CLIENTE ACTUAL ===");
        System.out.println(cliente);

        System.out.println("\nIngrese los nuevos datos (deje vacío para no cambiar)");

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
    }

    public void eliminarCliente() {
        System.out.print("ID cliente: ");
        String id = func.validarUsuario();

        if (clienteDAO.eliminarPorId(id))
            System.out.println("Cliente eliminado");
        else
            System.out.println("Cliente no encontrado");
    }
}
