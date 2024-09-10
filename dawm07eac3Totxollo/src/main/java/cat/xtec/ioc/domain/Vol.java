package cat.xtec.ioc.domain;

import java.util.Date;

public class Vol extends Xollo {
    private String desti;
    private Date data;
    private int persones;

    public Vol(String codi, String titol, String descripcio, int numeroUnitats, int numeroReserves, String desti, Date data, int persones) {
        super(codi, titol, descripcio, numeroUnitats, numeroReserves);
        this.desti = desti;
        this.data = data;
        this.persones = persones;
    }
    public Vol(){
        
    }

    public String getDesti() {
        return desti;
    }

    public void setDesti(String desti) {
        this.desti = desti;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getPersones() {
        return persones;
    }

    public void setPersones(int persones) {
        this.persones = persones;
    }
}

