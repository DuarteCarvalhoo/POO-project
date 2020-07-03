package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Inscricao serve para representar uma inscrição de uma pessoa 
 * num local.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Inscricao implements Serializable{
    /**
     * Objecto da classe Pessoa.
     */
    private Pessoa pessoa;
    /**
     * Objecto da classe Local.
     */
    private Local local;

    /**
     * Cria um objecto da classe Inscricao.
     * @param pessoa Objecto da classe Pessoa.
     * @param local Objecto da classe Local.
     */
    public Inscricao(Pessoa pessoa, Local local) {
        this.pessoa = pessoa;
        this.local = local;
    }
    
    /**
     *
     * @return Double com a despesa da pessoa no local.
     */
    public double getReceita(){
        return pessoa.calcularDespesa(local.getCusto(), local.getDesconto());
    }
    
    /**
     *
     * @return String com o nome da pessoa.
     */
    public String getNomePessoa(){
        return pessoa.getNome();
    }
    
    /**
     *
     * @return String com o nome do local.
     */
    public String getNomeLocal(){
        return local.getNome();
    }
    
    /**
     *
     * @return Objecto da classe Pessoa.
     */
    public Pessoa getPessoa(){
        return pessoa;
    }
}
