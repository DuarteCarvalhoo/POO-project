package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Parque representa um local, do tipo parque, para as pessoas 
 * visitarem durante o convívio.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public abstract class Parque extends Local implements Serializable{

    /**
     * Cria um objecto da classe Parque.
     * @param nome String com o nome do parque.
     * @param longitude Double com a longitude das coordenadas do parque.
     * @param latitude Double com a latitude das coordenadas do parque.
     */
    public Parque(String nome, double longitude, double latitude) {
        super(nome, longitude, latitude);
    }    
    
    /**
     * 
     * @return Double com o custo da visita do parque.
     */
    @Override
    public double getCusto() {
        return 0;
    }

    /**
     *
     * @return String com o nome e quantidade de pessoas inscritas do parque.
     */
    @Override
    public String toString() {
        return "Parque: " + getNome() + " -> Número de Inscritos: " + getPessoasInscritas() +'.';
    }
}
