package cat.xtec.ioc.domain;

import java.util.Objects;

public class Renda {

    private int any;
    private int homes;
    private int dones;
    private int total;
    private String origen;

    public Renda(int any, int homes, int dones, int total, String origen) {
        this.any = any;
        this.homes = homes;
        this.dones = dones;
        this.total = total;
        this.origen = origen;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Renda)) {
            return false;
        }

        final Renda other = (Renda) o;
        return other.getAny() == this.any;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.any);
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

