package g16_holstein;



import java.util.Date;



public class Comanda {

    private int idComanda;

    private Mesa mesa;

    private Menu menu;

    private Date fecha;



    public Comanda(int idComanda, Mesa mesa, Menu menu, Date fecha) {

        this.idComanda = idComanda;

        this.mesa = mesa;

        this.menu = menu;

        this.fecha = fecha;

    }



    // Getters y setters

    public int getIdComanda() {

        return idComanda;

    }



    public void setIdComanda(int idComanda) {

        this.idComanda = idComanda;

    }



    public Mesa getMesa() {

        return mesa;

    }



    public void setMesa(Mesa mesa) {

        this.mesa = mesa;

    }



    public Menu getMenu() {

        return menu;

    }



    public void setMenu(Menu menu) {

        this.menu = menu;

    }



    public Date getFecha() {

        return fecha;

    }



    public void setFecha(Date fecha) {

        this.fecha = fecha;

    }

}

