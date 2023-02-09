package repository;

import Exception.NaoHaReservas;
import Exception.ReservaNaoEncontrada;
import connection.ConnectionFactory;
import dados.Reserva;
import dados.ReservaAbstrata;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alex Da Silva Alves
 */
public class RepositoryReserva implements InterfaceRepositoryReserva {

    private Connection conn;
    private String sql;
    private final ArrayList<ReservaAbstrata> reserva;

    public RepositoryReserva() {
        this.reserva = new ArrayList<>();
    }

    @Override
    public void SolicitarReserva(ReservaAbstrata reserva) throws SQLException {
        this.conn = ConnectionFactory.getConnection();
        sql = "INSERT INTO reserva(id_reserva,dataReserva, horario, status, empresa, cod)VALUES(?,?,?,?,?,?)";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getId());
            stmt.setString(2, reserva.getDataReserva());
            stmt.setString(3, reserva.getHorario());
            stmt.setString(4, "Solicitado");
            stmt.setString(5, reserva.getEmpresa());
            stmt.setInt(6, reserva.getCod());
            stmt.execute();
        }
        this.conn.close();
    }

    @Override
    public ReservaAbstrata ConsultarReserva(int cod) throws SQLException, ReservaNaoEncontrada {
        this.conn = ConnectionFactory.getConnection();
        sql = "SELECT * FROM reserva where cod=?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, cod);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            stmt.close();
            this.conn.close();
            throw new ReservaNaoEncontrada();
        } else {
            ReservaAbstrata reservaAbstrata = null;
            switch (resultSet.getString("status")) {
                case "Solicitado":
                    reservaAbstrata = new Reserva(resultSet.getInt("id_reserva"), resultSet.getString("dataReserva"),
                            resultSet.getString("horario"), resultSet.getString("status"), resultSet.getString("empresa"), resultSet.getInt("cod"));
                    break;
                case "Aprovado":
                    reservaAbstrata = new Reserva(resultSet.getInt("id_reserva"), resultSet.getString("dataReserva"),
                            resultSet.getString("horario"), resultSet.getString("status"), resultSet.getString("empresa"), resultSet.getInt("cod"));
                    break;
                case "Rejeitado":
                    reservaAbstrata = new Reserva(resultSet.getInt("id_reserva"), resultSet.getString("dataReserva"),
                            resultSet.getString("horario"), resultSet.getString("status"), resultSet.getString("empresa"), resultSet.getInt("cod"));
                    break;
            }
            stmt.close();
            this.conn.close();
            return reservaAbstrata;
        }
    }

    @Override
    public void DeleteReserva(int cod) throws SQLException, ReservaNaoEncontrada {
        this.conn = ConnectionFactory.getConnection();
        sql = "delete from reserva where cod=?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setInt(1, cod);
        if (stmt.executeUpdate() == 0) {
            stmt.close();
            this.conn.close();
            throw new ReservaNaoEncontrada();
        } else {
            stmt.close();
            this.conn.close();
        }
    }

    @Override
    public ArrayList<ReservaAbstrata> ListaReserva() throws SQLException, NaoHaReservas {
        ArrayList<ReservaAbstrata> reser = new ArrayList<>();
        this.conn = ConnectionFactory.getConnection();
        this.sql = "SELECT * FROM reserva";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            ReservaAbstrata res = null;
            switch (resultSet.getString("status")) {
                case "Solicitado":
                    res = new Reserva(resultSet.getInt("id_reserva"), resultSet.getString("dataReserva"),
                            resultSet.getString("horario"), resultSet.getString("status"),
                            resultSet.getString("empresa"), resultSet.getInt("cod"));
                    break;
                case "Aprovado":
                    res = new Reserva(resultSet.getInt("id_reserva"), resultSet.getString("dataReserva"),
                            resultSet.getString("horario"), resultSet.getString("status"),
                            resultSet.getString("empresa"), resultSet.getInt("cod"));
                    break;
                case "Rejeitado":
                    res = new Reserva(resultSet.getInt("id_reserva"), resultSet.getString("dataReserva"),
                            resultSet.getString("horario"), resultSet.getString("status"),
                            resultSet.getString("empresa"), resultSet.getInt("cod"));
                    break;
            }
            reserva.add(res);
        }
        if (reserva.isEmpty()) {
            stmt.close();
            this.conn.close();
            throw new NaoHaReservas();
        } else {
            stmt.close();
            this.conn.close();
            return reser;
        }
    }

    @Override
    public void ConfirmReserva(ReservaAbstrata reserva) throws SQLException, ReservaNaoEncontrada {
        this.conn = ConnectionFactory.getConnection();
        this.sql = "UPDATE reserva set status = ? where cod = ?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, reserva.getStatus());
        stmt.setInt(2, reserva.getCod());
        if (stmt.executeUpdate() == 0) {
            stmt.close();
            this.conn.close();
            throw new ReservaNaoEncontrada();
        } else {
            stmt.close();
            this.conn.close();
        }
    }

}
