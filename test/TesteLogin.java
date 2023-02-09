
import Exception.ClienteNaoEncontrado;
import Exception.LoginOuSenhaInvalido;
import java.sql.SQLException;
import repository.RepositoryUsuario;


/**
 *
 * @author HP - 4300
 */
public class TesteLogin {
    public static void main(String[] args) {
        RepositoryUsuario usuario = new RepositoryUsuario();
        try {
            boolean Login = usuario.Login("1234", "12333");
            if(Login==true){
                System.out.println("Bem-Vindo!");
            }else{
                System.out.println("Acesso negado!");
                throw new LoginOuSenhaInvalido();
            }
        } catch (LoginOuSenhaInvalido | ClienteNaoEncontrado | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
