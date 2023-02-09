package negocio;

import Exception.ClienteNaoEncontrado;
import Exception.NaoHaReservas;
import Exception.ReservaNaoEncontrada;
import dados.ReservaAbstrata;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.RepositoryReserva;

/**
 *
 * @author HP - 4300
 */
public class NegocioReserva implements interfaceNegocioReserva {

    private final RepositoryReserva repReserva;

    public NegocioReserva(int MAX) {
        this.repReserva = new RepositoryReserva();
    }

    @Override
    public void SolicitarReserva(ReservaAbstrata reserva) throws SQLException {
        this.repReserva.SolicitarReserva(reserva);
    }

    @Override
    public ReservaAbstrata ConsultarReserva(int id) throws SQLException, ReservaNaoEncontrada {
      return this.repReserva.ConsultarReserva(id);
    }

    @Override
    public void DeleteReserva(int id) throws SQLException, ReservaNaoEncontrada {
       this.repReserva.DeleteReserva(id);
    }

    @Override
    public ArrayList<ReservaAbstrata> ListaReserva() throws SQLException, NaoHaReservas {
        return this.repReserva.ListaReserva();
    }

    @Override
    public void ConfirmReserva(ReservaAbstrata reserva) throws SQLException, ReservaNaoEncontrada {
       this.repReserva.ConfirmReserva(reserva);
    }
 
}
