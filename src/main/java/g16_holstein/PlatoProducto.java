package g16_holstein;



public class PlatoProducto {

    private Plato plato;

    private Producto producto;

    private int cantidad;



    public PlatoProducto(Plato plato, Producto producto, int cantidad) {

        this.plato = plato;

        this.producto = producto;

        this.cantidad = cantidad;

    }



    // Getters y setters

    public Plato getPlato() {

        return plato;

    }



    public void setPlato(Plato plato) {

        this.plato = plato;

    }



    public Producto getProducto() {

        return producto;

    }



    public void setProducto(Producto producto) {

        this.producto = producto;

    }



    public int getCantidad() {

        return cantidad;

    }



    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;

    }

}

   