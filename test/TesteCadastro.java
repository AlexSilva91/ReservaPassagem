
import dados.Adm;
import dados.Cliente;
import java.sql.SQLException;
import repository.RepositoryUsuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP - 4300
 */
public class TesteCadastro {
    public static void main(String[] args) throws SQLException {
        Cliente cliente = new Cliente();
        Adm adm = new Adm();
        RepositoryUsuario usuario = new RepositoryUsuario();
        
        adm.setCpf("123");
        adm.setNome("Alex");
        adm.setSenha("123");
        usuario.CadastrarAdm(adm);
        
    }
}
