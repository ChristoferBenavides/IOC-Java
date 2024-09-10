package cat.xtec.ioc.domain;

public class Lloguer extends Xollo {
    private String matricula;
    private boolean hibrid;
    private String marca;

    public Lloguer(String codi, String titol, String descripcio, int numeroUnitats, int numeroReserves, String matricula, boolean hibrid, String marca) {
        super(codi, titol, descripcio, numeroUnitats, numeroReserves);
        this.matricula = matricula;
        this.hibrid = hibrid;
        this.marca = marca;
    }
    public Lloguer(){
        
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isHibrid() {
        return hibrid;
    }

    public void setHibrid(boolean hibrid) {
        this.hibrid = hibrid;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}

