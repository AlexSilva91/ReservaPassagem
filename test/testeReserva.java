
import Exception.ClienteNaoEncontrado;
import dados.Reserva;
import java.sql.SQLException;
import repository.RepositoryReserva;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP - 4300
 */
public class testeReserva {
    public static void main(String[] args) throws SQLException, ClienteNaoEncontrado {
        RepositoryReserva reserva = new RepositoryReserva();
        Reserva reserv = new Reserva();
        
        reserv.setDataReserva("01/02/2000");
        reserv.setHorario("05:40");
        reserv.setEmpresa("Azul");
        reserv.setCod(14);
        try {
            reserva.SolicitarReserva(reserv);
            System.out.println("Reserva Solicitada!");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Erro ao solicitar reserva!");
        }
    }

}
