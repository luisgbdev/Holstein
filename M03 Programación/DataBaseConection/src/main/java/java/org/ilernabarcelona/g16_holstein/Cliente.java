package g16_holstein;



public class Cliente {

    private int idCliente;

    private String nombre;

    private String apellido;

    private String correo;

    private int idUsuario; // Clave foránea



    // Constructor

    public Cliente(int idCliente, String nombre, String apellido, String correo, int idUsuario) {

        this.idCliente = idCliente;

        this.nombre = nombre;

        this.apellido = apellido;

        this.correo = correo;

        this.idUsuario = idUsuario;

    }



    // Getters y setters

    public int getIdCliente() {

        return idCliente;

    }



    public void setIdCliente(int idCliente) {

        this.idCliente = idCliente;

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



    public int getIdUsuario() {

        return idUsuario;

    }



    public void setIdUsuario(int idUsuario) {

        this.idUsuario = idUsuario;

    }

}

