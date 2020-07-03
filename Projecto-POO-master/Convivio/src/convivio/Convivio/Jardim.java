package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Jardim que representa um local, disponível para visitar num convívio.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Jardim extends Parque implements Serializable{
    /**
     * Double com o tamanho do jardim.
     */
    private double area;

    /**
     * Cria um novo objecto da classe Jardim.
     * @param nome String com o nome do jardim.
     * @param area Double com o tamanho do jardim.
     * @param longitude Double com a longitude das coordenadas do jardim.
     * @param latitude Double com a latitude das coordenadas do jardim.
     */
    public Jardim(String nome, double area, double longitude, double latitude) {
        super(nome, longitude, latitude);
        this.area = area;
    }
}
