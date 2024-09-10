package cat.xtec.ioc.domain;

public class Hotel extends  Xollo {
    private String nom;
    private String habitacio;
    private String direccio;


    public Hotel(String codi, String titol, String descripcio, Integer numeroUnitats, Integer numeroReserves,
                 String nom, String habitacio, String direccio) {
        super(codi, titol, descripcio, numeroUnitats, numeroReserves);
        this.nom = nom;
        this.habitacio = habitacio;
        this.direccio = direccio;
    }
    public Hotel(){
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(String habitacio) {
        this.habitacio = habitacio;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }
}