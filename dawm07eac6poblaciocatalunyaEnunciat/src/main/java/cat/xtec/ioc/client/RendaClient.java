// RendaClient.java
package cat.xtec.ioc.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class RendaClient {
    private int any;
    private int total;
    private int homes;
    private int dones;
    private String origen;


    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getHomes() {
        return homes;
    }

    public void setHomes(int homes) {
        this.homes = homes;
    }

    public int getDones() {
        return dones;
    }

    public void setDones(int dones) {
        this.dones = dones;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    @Override
    public String toString() {
        return "Renda {"
                + "any=" + any
                + ", homes=" + homes
                + ", dones=" + dones
                + ", total=" + total
                + ", origen='" + origen + '\''
                + '}';
    }   
}

