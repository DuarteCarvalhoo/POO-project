package convivio.Convivio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe AreaDesportiva representa um local, do tipo área desportiva, para se visitar durante o 
 * convívio.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class AreaDesportiva extends Parque implements Serializable{
    /**
     * ArrayList de String com os nomes dos desportos praticáveis no local.
     */
    private ArrayList<String> desportosPraticaveis;

    /**
     * Cria um objecto da classe AreaDesportiva.
     * @param nome String com o nome da área desportiva.
     * @param longitude Double com a longitude do local.
     * @param latitude Double com a latitude do local.
     * @param desportos ArrayList de Strings com os nomes dos desportos praticáveis no local.
     */
    public AreaDesportiva(String nome, double longitude, double latitude, ArrayList<String> desportos) {
        super(nome, longitude, latitude);
        this.desportosPraticaveis = desportos;
    }  
}
