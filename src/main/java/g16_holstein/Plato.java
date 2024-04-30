package g16_holstein;



public class Plato {

    private int idPlato;

    private String nombre;

    private String descripcion;



    public Plato(int idPlato, String nombre, String descripcion) {

        this.idPlato = idPlato;

        this.nombre = nombre;

        this.descripcion = descripcion;

    }



    // Getters y setters

    public int getIdPlato() {

        return idPlato;

    }



    public void setIdPlato(int idPlato) {

        this.idPlato = idPlato;

    }



    public String getNombre() {

        return nombre;

    }



    public void setNombre(String nombre) {

        this.nombre = nombre;

    }



    public String getDescripcion() {

        return descripcion;

    }



    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }

}

