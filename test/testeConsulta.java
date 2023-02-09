
import Exception.ClienteNaoEncontrado;
import dados.UsuarioAbstrato;
import java.sql.SQLException;
import repository.RepositoryUsuario;


/**
 *
 * @author HP - 4300
 */
public class testeConsulta {
    public static void main(String[] args) {
        RepositoryUsuario usuario = new RepositoryUsuario();
        UsuarioAbstrato usu;
        try {
            usu = usuario.ConsultarCliente("1234");
            System.out.println(usu.toString());
        } catch (ClienteNaoEncontrado | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
