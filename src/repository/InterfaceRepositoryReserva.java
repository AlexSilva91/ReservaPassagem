package repository;

import Exception.NaoHaReservas;
import Exception.ReservaNaoEncontrada;
import dados.ReservaAbstrata;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alex Da Silva Alves
 */
public interface InterfaceRepositoryReserva {

    public void SolicitarReserva(ReservaAbstrata reserva) throws SQLException;

    public ReservaAbstrata ConsultarReserva(int cod) throws SQLException, ReservaNaoEncontrada;

    public void DeleteReserva(int cod) throws SQLException, ReservaNaoEncontrada;

    public ArrayList<ReservaAbstrata> ListaReserva() throws SQLException, NaoHaReservas;

    public void ConfirmReserva(ReservaAbstrata reserva) throws SQLException, ReservaNaoEncontrada;

}
