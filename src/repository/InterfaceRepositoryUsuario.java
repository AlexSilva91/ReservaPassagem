
package repository;

import Exception.ClienteNaoEncontrado;
import Exception.LoginOuSenhaInvalido;
import dados.Adm;
import dados.Cliente;
import dados.UsuarioAbstrato;
import java.sql.SQLException;

/**
 *
 * @author Alex Da Silva Alves
 */
public interface InterfaceRepositoryUsuario {
    public void CadastrarCliente(Cliente cliente)throws SQLException;
    public void CadastrarAdm(Adm adm)throws SQLException;
    public UsuarioAbstrato ConsultarCliente(String cpf)throws ClienteNaoEncontrado, SQLException;
    public boolean Login(String cpf, String senha)throws LoginOuSenhaInvalido, ClienteNaoEncontrado, SQLException;   
}

