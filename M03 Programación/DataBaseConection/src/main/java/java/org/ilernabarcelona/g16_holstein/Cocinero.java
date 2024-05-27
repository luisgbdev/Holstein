package g16_holstein;



public class Cocinero {

    private int idCocinero;

    private String nombre;

    private String apellido;

    private String correo;

    private int salario;

    private int telefono;

    private int idUsuario; // Clave foránea



    // Constructor

    public Cocinero(int idCocinero, String nombre, String apellido, String correo, int salario, int telefono, int idUsuario) {

        this.idCocinero = idCocinero;

        this.nombre = nombre;

        this.apellido = apellido;

        this.correo = correo;

        this.salario = salario;

        this.telefono = telefono;

        this.idUsuario = idUsuario;

    }



    // Getters y setters

    public int getIdCocinero() {

        return idCocinero;

    }



    public void setIdCocinero(int idCocinero) {

        this.idCocinero = idCocinero;

    }



    public String getNombre() {

        return nombre;

    }



    public void setNombre(String nombre) {

        this.nombre = nombre;

    }



    public String getApellido() {

        return apellido;

    }



    public void setApellido(String apellido) {

        this.apellido = apellido;

    }



    public String getCorreo() {

        return correo;

    }



    public void setCorreo(String correo) {

        this.correo = correo;

    }



    public int getSalario() {

        return salario;

    }



    public void setSalario(int salario) {

        this.salario = salario;

    }



    public int getTelefono() {

        return telefono;

    }



    public void setTelefono(int telefono) {

        this.telefono = telefono;

    }



    public int getIdUsuario() {

        return idUsuario;

    }



    public void setIdUsuario(int idUsuario) {

        this.idUsuario = idUsuario;

    }

}

