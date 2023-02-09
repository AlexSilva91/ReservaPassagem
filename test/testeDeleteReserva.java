
import Exception.ReservaNaoEncontrada;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.RepositoryReserva;



/**
 *
 * @author HP - 4300
 */
public class testeDeleteReserva {
    public static void main(String[] args) {
        RepositoryReserva reserva = new RepositoryReserva();
        try {
            reserva.DeleteReserva(10);
            System.out.println("Deletado com sucesso!");
        } catch (SQLException | ReservaNaoEncontrada ex) {
            System.out.println(ex.getMessage());
        }
    }
}
