package utilitarios;

import Exception.ReservaNaoEncontrada;
import dados.Reserva;
import dados.ReservaAbstrata;
import fachada.FachadaReserva;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP - 4300
 */
public class GerarCodigo extends Random {

    private final int MAX = 1000;
    private final Random cod = new Random();
    private int codigo = 0;

    public int gerarCodigo() {
        this.codigo = this.cod.nextInt(MAX);
        return codigo;
    }

    public boolean ValidaCod(int cod) {
        boolean valido = false;
        FachadaReserva reserva = new FachadaReserva(MAX);
        ReservaAbstrata reservaAbstrata;
        try {
            reservaAbstrata = reserva.ConsultarReserva(cod);
            if (cod != reservaAbstrata.getCod()) {
                valido = true;
            }
        } catch (SQLException | ReservaNaoEncontrada ex) {
            System.out.println(ex);
        }
        return valido;
    }
}
