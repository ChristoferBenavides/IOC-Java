package cat.xtec.ioc.domain;

public class Xollo {
  private String codi;
  private String titol;
  private String descripcio;
  private Integer numeroUnitats;
  private Integer numeroReserves;

  // constructor
  public  Xollo(String codi, String titol, String descripcio, Integer numeroUnitats, Integer numeroReserves) {
    this.codi = codi;
    this.titol = titol;
    this.descripcio = descripcio;
    this.numeroUnitats = numeroUnitats;
    this.numeroReserves = numeroReserves;
  }
  public  Xollo(){
      
  }

  // getters and setters
  public String getCodi() {
    return codi;
  }

  public void setCodi(String codi) {
    this.codi = codi;
  }

  public String getTitol() {
    return titol;
  }

  public void setTitol(String titol) {
    this.titol = titol;
  }

  public String getDescripcio() {
    return descripcio;
  }

  public void setDescripcio(String descripcio) {
    this.descripcio = descripcio;
  }

  public Integer getNumeroUnitats() {
    return numeroUnitats;
  }

  public void setNumeroUnitats(Integer numeroUnitats) {
    this.numeroUnitats = numeroUnitats;
  }

  public Integer getNumeroReserves() {
    return numeroReserves;
  }

  public void setNumeroReserves(Integer numeroReserves) {
    this.numeroReserves = numeroReserves;
  }
  
  
}

