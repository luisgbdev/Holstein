package g16_holstein;

public class Usuario {

	private int idUsuario;

    private String nombre;

    private String rol;

    private int telefono;

    private String correo;



    public Usuario(int idUsuario, String nombre, String rol, int telefono, String correo) {

        this.idUsuario = idUsuario;

        this.nombre = nombre;

        this.rol = rol;

        this.telefono = telefono;

        this.correo = correo;

    }



    // Getters y setters

    public int getIdUsuario() {

        return idUsuario;

    }



    public void setIdUsuario(int idUsuario) {

        this.idUsuario = idUsuario;

    }



    public String getNombre() {

        return nombre;

    }



    public void setNombre(String nombre) {

        this.nombre = nombre;

    }



    public String getRol() {

        return rol;

    }



    public void setRol(String rol) {

        this.rol = rol;

    }



    public int getTelefono() {

        return telefono;

    }



    public void setTelefono(int telefono) {

        this.telefono = telefono;

    }



    public String getCorreo() {

        return correo;

    }



    public void setCorreo(String correo) {

        this.correo = correo;

    }

}

