package g16_holstein;

	public class Camarero extends Usuario {

	    private int idCamarero;

	    private int salario;

	    private String turno;

	    private String horarioTrabajo;



	    public Camarero(int idUsuario, String nombre, String rol, int telefono, String correo, int idCamarero, int salario, String turno, String horarioTrabajo) {

	        super(idUsuario, nombre, rol, telefono, correo);

	        this.idCamarero = idCamarero;

	        this.salario = salario;

	        this.turno = turno;

	        this.horarioTrabajo = horarioTrabajo;

	    }



	    // Getters y setters específicos de Camarero

	    public int getIdCamarero() {

	        return idCamarero;

	    }



	    public void setIdCamarero(int idCamarero) {

	        this.idCamarero = idCamarero;

	    }



	    public int getSalario() {

	        return salario;

	    }



	    public void setSalario(int salario) {

	        this.salario = salario;

	    }



	    public String getTurno() {

	        return turno;

	    }



	    public void setTurno(String turno) {

	        this.turno = turno;

	    }



	    public String getHorarioTrabajo() {

	        return horarioTrabajo;

	    }



	    public void setHorarioTrabajo(String horarioTrabajo) {

	        this.horarioTrabajo = horarioTrabajo;

	    }

	}