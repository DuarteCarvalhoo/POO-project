package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Pessoa representa as pessoas que vão ter acesso aos diferentes convívios.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public abstract class Pessoa implements Serializable{
    /**
     * String com o nome da pessoa.
     */
    private String nome;
    /**
     * String com o perfil da pessoa.
     */
    private String perfil;
    /**
     * String com a password da pessoa para efetuar o login.
     */
    private String password;

    /**
     * Cria um objecto da classe Pessoa.
     * @param nome String com o nome da pessoa.
     * @param perfil String com o perfil da pessoa.
     * @param password String com a password da pessoa.
     */
    public Pessoa(String nome, String perfil, String password) {
        this.nome = nome;
        this.perfil = perfil;
        this.password = password;
    }
    
    /**
     * Calcula a despesa da pessoa num determinado local.
     * @param preco Preço a pagar para visitar um local.
     * @param promocao Desconto do preço a pagar.
     * @return Double com a despesa da pessoa.
     */
    public double calcularDespesa(double preco, double promocao){
        return preco;
    }

    /**
     *
     * @return String com o nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return String com o perfil da pessoa.
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     *
     * @return String com a palavra-passe da pessoa.
     */
    public String getPassword() {
        return password;
    }
    
}
