package g16_holstein;



public class Mesa {

    private int idMesa;

    private int numero;

    private int capacidad;

    private String disponibilidad;

    private Camarero camareroAsignado; // Relación con Camarero



    public Mesa(int idMesa, int numero, int capacidad, String disponibilidad, Camarero camareroAsignado) {

        this.idMesa = idMesa;

        this.numero = numero;

        this.capacidad = capacidad;

        this.disponibilidad = disponibilidad;

        this.camareroAsignado = camareroAsignado;

    }



    // Getters y setters

    public int getIdMesa() {

        return idMesa;

    }



    public void setIdMesa(int idMesa) {

        this.idMesa = idMesa;

    }



    public int getNumero() {

        return numero;

    }



    public void setNumero(int numero) {

        this.numero = numero;

    }



    public int getCapacidad() {

        return capacidad;

    }



    public void setCapacidad(int capacidad) {

        this.capacidad = capacidad;

    }



    public String getDisponibilidad() {

        return disponibilidad;

    }



    public void setDisponibilidad(String disponibilidad) {

        this.disponibilidad = disponibilidad;

    }



    public Camarero getCamareroAsignado() {

        return camareroAsignado;

    }



    public void setCamareroAsignado(Camarero camareroAsignado) {

        this.camareroAsignado = camareroAsignado;

    }

}