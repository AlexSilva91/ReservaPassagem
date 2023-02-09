
import Exception.ReservaNaoEncontrada;
import dados.Reserva;
import java.sql.SQLException;
import repository.RepositoryReserva;


/**
 *
 * @author HP - 4300
 */
public class TesteConfirmReserva {
    public static void main(String[] args) {
        RepositoryReserva reserva = new RepositoryReserva();
        Reserva res = new Reserva();
        res.setStatus("Rejeitado");
        res.setCod(14);
        try{
            reserva.ConfirmReserva(res);
            System.out.println("Operação Realizada!");
        }catch(SQLException | ReservaNaoEncontrada msg){
            System.out.println(msg);
        }
    }
}
