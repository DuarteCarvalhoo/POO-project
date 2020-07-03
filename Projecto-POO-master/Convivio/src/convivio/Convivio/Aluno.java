package convivio.Convivio;

import java.io.Serializable;

/**
 * A classe Aluno representa um aluno do DEI.
 * Contém nome, perfil, password e nome de curso do aluno.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Aluno extends Pessoa implements Serializable{
    /**
     * String com o nome do curso do Aluno.
     */
    private String nomeCurso;

    /**
     * Cria um objecto da classe Aluno.
     * @param nome String com o nome do Aluno.
     * @param perfil String com o perfil do Aluno, "Desportivo", "Cultural", "Boémio" ou "Poupadinho".
     * @param password  String correspondente à palavra-passe do Aluno.
     * @param nomeCurso String correspondente ao nome do curso, "LEI" ou "LDM".
     */
    public Aluno(String nome, String perfil, String password, String nomeCurso) {
        super(nome, perfil, password);
        this.nomeCurso = nomeCurso;
    }
    
    /**
     * Calcula o custo do aluno para frequentar determinado local tendo em 
     * atenção a promoção do local, caso este a tenha (seja diferente de zero).
     * @param preco Preco para frequentar o local.
     * @param promocao Promocao do local a descontar do preco.
     * @return Valor da despesa do aluno/lucro do local.
     */
    @Override
    public double calcularDespesa(double preco, double promocao){
        return preco - (preco * promocao);
    }

    /**
     *
     * @return String com o nome da pessoa, perfil e nome do curso
     */
    @Override
    public String toString() {
        return getNome() + ", " + getPerfil() + ", " + nomeCurso + ".";
    }
    
    
}
