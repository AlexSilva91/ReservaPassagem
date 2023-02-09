package fachada;

import Exception.NaoHaReservas;
import Exception.ReservaNaoEncontrada;
import dados.ReservaAbstrata;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.NegocioReserva;

/**
 *
 * @author HP - 4300
 */
public class FachadaReserva implements InterfaceFachadaReserva{
    private final NegocioReserva reserva;

    public FachadaReserva(int MAX) {
        this.reserva = new NegocioReserva(MAX);
    }
    
    @Override
    public void SolicitarReserva(ReservaAbstrata reserva) throws SQLException {
        this.reserva.SolicitarReserva(reserva);
    }

    @Override
    public ReservaAbstrata ConsultarReserva(int id) throws SQLException, ReservaNaoEncontrada {
        return this.reserva.ConsultarReserva(id);
    }

    @Override
    public void DeleteReserva(int id) throws SQLException, ReservaNaoEncontrada {
        this.reserva.DeleteReserva(id);
    }

    @Override
    public ArrayList<ReservaAbstrata> ListaReserva() throws SQLException, NaoHaReservas {
        return this.reserva.ListaReserva();
    }

    @Override
    public void ConfirmReserva(ReservaAbstrata reserva) throws SQLException, ReservaNaoEncontrada {
        this.reserva.ConfirmReserva(reserva);
    }
    
}
