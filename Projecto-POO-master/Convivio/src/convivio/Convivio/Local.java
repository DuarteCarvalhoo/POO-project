package convivio.Convivio;

import java.io.Serializable;

/**
 * Classe Local, representa locais que o utilizador vai poder visitar
 * nos convívios.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public abstract class Local implements Serializable{
    /**
     * String com o nome do local.
     */
    private String nome;
    /**
     * Double com a longitude do local.
     */
    private double longitude;
    /**
     * Double com a latitude do local.
     */
    private double latitude;
    /**
     * Inteiro com o número de pessoas inscritas.
     */
    private int pessoasInscritas = 0;

    /**
     *
     * @return Inteiro com o número de pessoas inscritas neste local.
     */
    public int getPessoasInscritas() {
        return pessoasInscritas;
    }
    
    /**
     *
     * @return String com o nome do convívio.
     */
    protected String getNome() {
        return nome;
    }

    /**
     * Cria um objecto da classe Local.
     * @param nome String com o nome do local.
     * @param longitude Double com a longitude das coordenadas do local.
     * @param latitude Double com a latitude das coordenadas do local.
     */
    public Local(String nome, double longitude, double latitude) {
        this.nome = nome;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    
    /**
     * Incrementa o número de pessoas inscritas.
     */
    public void incrementarPessoasIns(){
        pessoasInscritas++;
    }
    
    /**
     * Decrementa o número de pessoas inscritas.
     */
    public void decrementarPessoasIns(){
        pessoasInscritas--;
    }
    
    /**
     *
     * @return Double com o desconto do local.
     */
    public double getDesconto(){
        return 0;
    }
    
    /**
     *
     * @return Boolean que é "true" se o local for um bar, caso contrário é "false".
     */
    public boolean isBar(){
        return false;
    }
    
    /**
     * Método abstrato.
     * @return Double
     */
    public abstract double getCusto();
}
