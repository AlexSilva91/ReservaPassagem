package Exception;

/**
 *
 * @author Alex Da Silva Alves
 */
public class ClienteJaExiste extends Exception{
    public ClienteJaExiste(){
        super("Cliente já existe!");
    }
}
