package Consola.GUI;

import Dominio.Cliente;
import Extras.Funcionalidades;

public class ClienteGUI {

    private Cliente cliente;
    private Funcionalidades func = new Funcionalidades();

    public ClienteGUI(Cliente cliente) {
        this.cliente = cliente;
    }

    public void actualizarDatos() {
        System.out.print("Nuevo correo: ");
        cliente.setEmail(func.validarCorreo());

        System.out.print("Nuevo teléfono: ");
        cliente.setTelefono(func.validarTelefono());

        System.out.print("Nueva Direccion: ");
        cliente.setDireccion(func.validarNombre());

        System.out.println("Datos actualizados");
    }
}
