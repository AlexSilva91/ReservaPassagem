
import Exception.NaoHaReservas;
import dados.ReservaAbstrata;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.RepositoryReserva;

/**
 *
 * @author HP - 4300
 */
public class TesteListReserva {

    public static void main(String[] args) {
        RepositoryReserva res = new RepositoryReserva();
        try {
            ArrayList<ReservaAbstrata> reserva = res.ListaReserva();
            for (ReservaAbstrata reserv : reserva) {
                System.out.println(reserv.toString());
            }
        } catch (SQLException | NaoHaReservas e) {
            System.out.println(e.getMessage());
        }
    }
}
