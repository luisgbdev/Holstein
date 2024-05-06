package g16_holstein;



public class ComandaPlato {

    private Comanda comanda;

    private Plato plato;

    private int cantidad;



    public ComandaPlato(Comanda comanda, Plato plato, int cantidad) {

        this.comanda = comanda;

        this.plato = plato;

        this.cantidad = cantidad;

    }



    // Getters y setters

    public Comanda getComanda() {

        return comanda;

    }



    public void setComanda(Comanda comanda) {

        this.comanda = comanda;

    }



    public Plato getPlato() {

        return plato;

    }



    public void setPlato(Plato plato) {

        this.plato = plato;

    }



    public int getCantidad() {

        return cantidad;

    }



    public void setCantidad(int cantidad) {

        this.cantidad = cantidad;

    }

}

