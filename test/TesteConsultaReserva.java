
import Exception.ReservaNaoEncontrada;
import dados.Reserva;
import java.sql.SQLException;
import repository.RepositoryReserva;

/**
 *
 * @author HP - 4300
 */
public class TesteConsultaReserva {

    public static void main(String[] args) {
        RepositoryReserva reserva = new RepositoryReserva();
        Reserva res = new Reserva();
        try {
            res = (Reserva) reserva.ConsultarReserva(7);
            System.out.println(res.toString());
        } catch (SQLException | ReservaNaoEncontrada ex) {
            System.out.println(ex.getMessage());
            System.out.println("Falha na consulta!");
        }
    }
}
