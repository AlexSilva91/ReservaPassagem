package dados;

/**
 *
 * @author Alex Da Silva Alves
 */
public class Adm extends UsuarioAbstrato {

    public Adm() {
    
    }

    public Adm(int id, String nome, String cpf, String senha) {
        super(id, nome, cpf, senha);
    }

}
