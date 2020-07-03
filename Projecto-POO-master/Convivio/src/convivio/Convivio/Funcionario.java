package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Funcionario, representa uma pessoa, do tipo funcionário.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Funcionario extends Pessoa implements Serializable{
    /**
     * String com o tempo de trabalho do funcionário, pode ser "Integral" ou "Parcial".
     */
    private String tempoTrabalho;

    /**
     * Cria um novo objecto da classe Funcionario.
     * @param nome String com o nome do funcionário.
     * @param perfil String com o perfil do funcionário.
     * @param password String com a palavra-passe do funcionário.
     * @param tempoTrabalho String com o tempo de trabalho do funcionário. "Integral" ou "Parcial".
     */
    public Funcionario(String nome, String perfil, String password, String tempoTrabalho) {
        super(nome, perfil, password);
        this.tempoTrabalho = tempoTrabalho;
    }

    /**
     *
     * @return String com o nome do funcionário e o seu perfil.
     */
    @Override
    public String toString() {
        return getNome() + ", " + getPerfil() + ".";
    }
    
    
}
