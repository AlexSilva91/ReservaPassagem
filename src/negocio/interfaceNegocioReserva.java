package negocio;

import Exception.NaoHaReservas;
import Exception.ReservaNaoEncontrada;
import dados.ReservaAbstrata;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP - 4300
 */
public interface interfaceNegocioReserva {

    public void SolicitarReserva(ReservaAbstrata reserva) throws SQLException;

    public ReservaAbstrata ConsultarReserva(int id) throws SQLException, ReservaNaoEncontrada;

    public void DeleteReserva(int id) throws SQLException, ReservaNaoEncontrada;

    public ArrayList<ReservaAbstrata> ListaReserva() throws SQLException, NaoHaReservas;

    public void ConfirmReserva(ReservaAbstrata reserva) throws SQLException, ReservaNaoEncontrada;

}
