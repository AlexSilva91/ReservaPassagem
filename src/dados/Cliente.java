package dados;

/**
 *
 * @author Alex Da Silva Alves
 */
public class Cliente extends UsuarioAbstrato {

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha);
    }

}
