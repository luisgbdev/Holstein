package g16_holstein;



public class MenuPlato {

    private Menu menu;

    private Plato plato;



    public MenuPlato(Menu menu, Plato plato) {

        this.menu = menu;

        this.plato = plato;

    }



    // Getters y setters

    public Menu getMenu() {

        return menu;

    }



    public void setMenu(Menu menu) {

        this.menu = menu;

    }



    public Plato getPlato() {

        return plato;

    }



    public void setPlato(Plato plato) {

        this.plato = plato;

    }

}