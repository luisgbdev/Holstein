package g16_holstein;



public class Menu {

    private int idMenu;

    private String nombre;

    private int precio;

    private String tipo;

    private String descripcion;



    public Menu(int idMenu, String nombre, int precio, String tipo, String descripcion) {

        this.idMenu = idMenu;

        this.nombre = nombre;

        this.precio = precio;

        this.tipo = tipo;

        this.descripcion = descripcion;

    }



    // Getters y setters

    public int getIdMenu() {

        return idMenu;

    }



    public void setIdMenu(int idMenu) {

        this.idMenu = idMenu;

    }



    public String getNombre() {

        return nombre;

    }



    public void setNombre(String nombre) {

        this.nombre = nombre;

    }



    public int getPrecio() {

        return precio;

    }



    public void setPrecio(int precio) {

        this.precio = precio;

    }



    public String getTipo() {

        return tipo;

    }



    public void setTipo(String tipo) {

        this.tipo = tipo;

    }



    public String getDescripcion() {

        return descripcion;

    }



    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }

}