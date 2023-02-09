package repository;

import Exception.ClienteNaoEncontrado;
import Exception.LoginOuSenhaInvalido;
import connection.ConnectionFactory;
import java.sql.Connection;
import dados.Adm;
import dados.Cliente;
import dados.UsuarioAbstrato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alex Da Silva Alves
 */
public class RepositoryUsuario implements InterfaceRepositoryUsuario {

    private Connection conn;
    private String sql;

    @Override
    public void CadastrarCliente(Cliente cliente) throws SQLException {
        this.conn = ConnectionFactory.getConnection();
        this.sql = "INSERT INTO usuarioabstrato(nome, cpf, senha, classe)VALUES(?,?,?,?)";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, "cliente");
            stmt.execute();
        }
        this.conn.close();
    }

    @Override
    public void CadastrarAdm(Adm adm) throws SQLException {
        this.conn = ConnectionFactory.getConnection();
        this.sql = "INSERT INTO usuarioabstrato(nome, cpf, senha, classe)VALUES(?,?,?,?)";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getCpf());
            stmt.setString(3, adm.getSenha());
            stmt.setString(4, "adm");
            stmt.execute();
        }
        this.conn.close();
    }

    @Override
    public UsuarioAbstrato ConsultarCliente(String cpf) throws ClienteNaoEncontrado, SQLException {
        this.conn = ConnectionFactory.getConnection();
        this.sql = "SELECT * FROM usuarioabstrato where cpf=?";
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet resultSet = stmt.executeQuery();
        if (!resultSet.next()) {
            stmt.close();
            this.conn.close();
            throw new ClienteNaoEncontrado();
        } else {
            UsuarioAbstrato usuario = null;
            switch (resultSet.getString("classe")) {
                case "adm":
                    usuario = new Adm(resultSet.getInt("id_usuario"), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("senha"));
                    break;
                case "cliente":
                    usuario = new Cliente(resultSet.getInt("id_usuario"), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("senha"));
                    break;
            }
            stmt.close();
            this.conn.close();
            return usuario;
        }

    }

    @Override
    public boolean Login(String cpf, String senha) throws LoginOuSenhaInvalido, ClienteNaoEncontrado, SQLException {
        UsuarioAbstrato usuario = this.ConsultarCliente(cpf);
        boolean instaAdm = false, instCliente = false;
        boolean login = false;
        if (cpf.equals(usuario.getCpf()) && senha.equals(usuario.getSenha())) {
             login = true;
            if(usuario instanceof Adm){
                instaAdm = true;
            }else{
                instCliente = true;
            }
        }else{
            throw new LoginOuSenhaInvalido();
        }
        return login && instaAdm | instCliente;
    }
public boolean LoginInstanciaAdm(String cpf, String senha) throws ClienteNaoEncontrado, SQLException {
        UsuarioAbstrato usuario = this.ConsultarCliente(cpf);
        boolean instaAdm = false;
        if (usuario instanceof Adm) {
           instaAdm = true;
        }
        return instaAdm;
    }
public boolean LoginInstanciaCliente(String cpf, String senha) throws ClienteNaoEncontrado, SQLException {
        UsuarioAbstrato usuario = this.ConsultarCliente(cpf);
        boolean instaCliente= false;
        if (usuario instanceof Cliente) {
           instaCliente = true;
        }
        return instaCliente;
    }
}
