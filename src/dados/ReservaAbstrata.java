package dados;

/**
 *
 * @author HP - 4300
 */
public abstract class ReservaAbstrata {

    private int id;
    private String dataReserva;
    private String horario;
    private String status;
    private String empresa;
    private int cod;

    public ReservaAbstrata() {
        
    }

    public ReservaAbstrata(int id, String dataReserva, String horario, String status, String empresa, int cod) {
        this.id = id;
        this.dataReserva = dataReserva;
        this.horario = horario;
        this.status = status;
        this.empresa = empresa;
        this.cod = cod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "ReservaAbstrata{" + "id=" + id +
                ", dataReserva=" + dataReserva +
                ", horario=" + horario + ", status=" +
                status + ", empresa=" + empresa +
                ", cod=" + cod + '}';
    }

}
