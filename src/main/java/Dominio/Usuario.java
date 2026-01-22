package Dominio;

public class Usuario {
    private String nombre;
    private String cedula;
    private String email;
    private String contrasenia;
    private Rol rol;

    public Usuario(){
        this("Sin Nombre","Sin Cedula","Sin email","Sin contrasenia", Rol.CLIENTE);
    }

    public Usuario(String nombre, String cedula, String email, String contrasenia, Rol rol){
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public String getNombre(){
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setNombre(String nombre) {
        if(nombre != null)
            this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        if(cedula != null)
            this.cedula = cedula;
    }

    public void setEmail(String email){
        if(email != null)
            this.email = email;
    }

    public void setContrasenia(String contrasenia){
        if(contrasenia != null)
            this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "------------Usuario------------" + "\nNombre: " + nombre + "\nCedula: " + cedula
                + "\nEmail: " + email + "\nContrasenia: " + contrasenia + "\nRol: " + rol;
    }
}
