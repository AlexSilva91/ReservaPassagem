package dados;

/**
 *
 * @author Alex Da Silva Alves
 */
public abstract class UsuarioAbstrato {

    private int id;
    private String nome;
    private String cpf;
    private String senha;

    public UsuarioAbstrato() {

    }

    public UsuarioAbstrato(int id, String nome, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "UsuarioAbstrato{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + '}';
    }

    
}
