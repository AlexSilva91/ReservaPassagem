package dados;

/**
 *
 * @author Alex Da Silva Alves
 */
public class Reserva extends ReservaAbstrata {

    public Reserva() {
    }

    public Reserva(int id, String dataReserva, String horario, String status, String empresa, int cod) {
        super(id, dataReserva, horario, status, empresa, cod);
    }

}
