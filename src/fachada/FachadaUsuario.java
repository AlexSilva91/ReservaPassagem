/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import Exception.ClienteNaoEncontrado;
import Exception.LoginOuSenhaInvalido;
import dados.Adm;
import dados.Cliente;
import dados.UsuarioAbstrato;
import java.sql.SQLException;
import negocio.NegocioUsuario;

/**
 *
 * @author HP - 4300
 */
public class FachadaUsuario implements interfaceFachadaUsuario {

    private final NegocioUsuario usuario;

    public FachadaUsuario(int MAX) {
        this.usuario = new NegocioUsuario(MAX);
    }

    @Override
    public void CadastrarCliente(Cliente cliente) throws SQLException {
        this.usuario.CadastrarCliente(cliente);
    }

    @Override
    public void CadastrarAdm(Adm adm) throws SQLException {
        this.usuario.CadastrarAdm(adm);
    }

    @Override
    public UsuarioAbstrato ConsultarCliente(String cpf) throws ClienteNaoEncontrado, SQLException {
        return usuario.ConsultarCliente(cpf);
    }

    @Override
    public boolean Login(String cpf, String senha) throws LoginOuSenhaInvalido, ClienteNaoEncontrado, SQLException {
        return this.usuario.Login(cpf, senha);
    }

    public boolean LoginInstanciaAdm(String cpf, String senha) throws ClienteNaoEncontrado, SQLException {
        return this.usuario.LoginInstanciaAdm(cpf, senha);
    }
    public boolean LoginInstanciaCliente(String cpf, String senha) throws ClienteNaoEncontrado, SQLException {
        return this.usuario.LoginInstanciaCliente(cpf, senha);
    }
}
