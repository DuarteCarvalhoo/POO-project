package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Exposicao representa um local, do tipo exposição, para se visitar
 * durante os convívios.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Exposicao extends Local implements Serializable{
    /**
     * String com a forma artística da exposição.
     */
    private String formaArtistica;
    /**
     * Double com o custo da entrada da exposição.
     */
    private double custoIngresso;

    /**
     * Cria um novo objecto da classe Exposicao.
     * @param nome String com o nome da exposição.
     * @param formaArtistica String com a forma artística da exposição.
     * @param custoIngresso Double com o custo de entrada da exposição.
     * @param longitude Double com a longitude das coordenadas da exposição.
     * @param latitude Double com a latitude das coordenadas da exposição.
     */
    public Exposicao(String nome, String formaArtistica, double custoIngresso, double longitude, double latitude) {
        super(nome, longitude, latitude);
        this.formaArtistica = formaArtistica;
        this.custoIngresso = custoIngresso;
    }

    /**
     *
     * @return Double com o desconto.
     */
    @Override
    public double getDesconto(){
        return 0.10;
    }
    
    /**
     *
     * @return Double com o custo de ingresso.
     */
    @Override
    public double getCusto() {
        return custoIngresso;
    }

    /**
     *
     * @return String com o nome e número de inscritos na exposição.
     */
    @Override
    public String toString() {
        return "Exposição: " + getNome() + " -> Número de Inscritos: " + getPessoasInscritas() +'.';
    }
}
