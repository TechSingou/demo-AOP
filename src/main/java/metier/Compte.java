package metier;

public class Compte {
    private Long code;
    private double sole;

    public Compte() {
    }

    public Compte(Long code, double sole) {
        this.code = code;
        this.sole = sole;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public double getSole() {
        return sole;
    }

    public void setSole(double sole) {
        this.sole = sole;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "code=" + code +
                ", sole=" + sole +
                '}';
    }
}
