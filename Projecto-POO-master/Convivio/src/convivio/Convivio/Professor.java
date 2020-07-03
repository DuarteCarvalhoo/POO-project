package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Professor que representa uma pessoa do tipo professor.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Professor extends Pessoa implements Serializable{
    private String tipoProfessor;

    /**
     * Cria um objecto da classe Professor.
     * @param nome String com o nome do professor.
     * @param perfil String com o perfil do professor.
     * @param password String com a password do professor.
     * @param tipoProfessor String com o tipo de professor.
     */
    public Professor(String nome, String perfil, String password, String tipoProfessor) {
        super(nome, perfil, password);
        this.tipoProfessor = tipoProfessor;
    }

    /**
     *
     * @return String com o nome e perfil do professor.
     */
    @Override
    public String toString() {
        return getNome() + ", " + getPerfil() + ".";
    }  
    
}
