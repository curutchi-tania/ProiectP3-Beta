public class Masina {
    private int id;
    private String marca;
    private int an;
    private float kilometraj;
    private float pret;
    private String culoare;
    private String descriere;

    public Masina(String marca, int an, float kilometraj, float pret, String culoare, String descriere) {
        this(-1, marca, an, kilometraj, pret, culoare, descriere);
    }

    public Masina(int id, String marca, int an, float kilometraj, float pret, String culoare, String descriere) {
        this.id = id;
        this.marca = marca;
        this.an = an;
        this.kilometraj = kilometraj;
        this.pret = pret;
        this.culoare = culoare;
        this.descriere = descriere;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public float getKilometraj() {
        return kilometraj;
    }

    public void setKilometraj(float kilometraj) {
        this.kilometraj = kilometraj;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", an=" + an +
                ", kilometraj=" + kilometraj +
                ", pret=" + pret +
                ", culoare='" + culoare + '\'' +
                ", descriere='" + descriere + '\'' +
                '}';
    }
}
