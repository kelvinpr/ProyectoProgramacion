package Dominio;

public class Usuario {
    private String nombre;
    private String cedula;
    private String email;
    private String contrasenia;
    private String rol;

    public Usuario(){
        this("Sin Nombre","Sin Cedula","Sin email","Sin contrasenia","Sin rol");
    }

    public Usuario(String nombre, String cedula, String email, String contrasenia, String rol){
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

    public String getRol() {
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

    public void setRol(String rol){
        if(rol != null)
            this.rol = rol;
    }

    @Override
    public String toString() {
        return "------------Usuario------------" + "\nNombre: " + nombre + "\nCedula: " + cedula
                + "\nEmail: " + email + "\nContrasenia: " + contrasenia + "\nRol: " + rol;
    }
}
