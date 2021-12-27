import java.sql.Timestamp;
import java.time.Instant;

public class Comanda {
    private int id;
    private Timestamp data;
    private int cantitate;
    private StatusPlata status;
    private int idMasina;
    private int idClient;

    public Comanda(int cantitate, StatusPlata status, Masina masina, Client client) {
        this(-1, cantitate, status, masina, client);
    }

    public Comanda(int cantitate, StatusPlata status, int idMasina, int idClient) {
        this(-1, cantitate, status, idMasina, idClient);
    }

    public Comanda(int id, int cantitate, StatusPlata status, Masina masina, Client client) {
        this(id, cantitate, status, masina.getId(), client.getId());
    }

    public Comanda(int id, int cantitate, StatusPlata status, int idMasina, int idClient) {
        this.id = id;
        this.data = new Timestamp(Instant.now().getEpochSecond() * 1000);
        this.cantitate = cantitate;
        this.status = status;
        this.idMasina = idMasina;
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public StatusPlata getStatus() {
        return status;
    }

    public void setStatus(StatusPlata status) {
        this.status = status;
    }

    public int getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", data=" + data +
                ", cantitate=" + cantitate +
                ", status=" + status +
                ", idMasina=" + idMasina +
                ", idClient=" + idClient +
                '}';
    }
}
