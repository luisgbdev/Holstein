package g16_holstein;



public class Producto {

    private int idProducto;

    private String tipo;

    private String descripcion;

    private int stock;



    public Producto(int idProducto, String tipo, String descripcion, int stock) {

        this.idProducto = idProducto;

        this.tipo = tipo;

        this.descripcion = descripcion;

        this.stock = stock;

    }



    // Getters y setters

    public int getIdProducto() {

        return idProducto;

    }



    public void setIdProducto(int idProducto) {

        this.idProducto = idProducto;

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



    public int getStock() {

        return stock;

    }



    public void setStock(int stock) {

        this.stock = stock;

    }

}