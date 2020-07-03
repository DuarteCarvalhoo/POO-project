package convivio.Convivio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe Bar representa um local, do tipo bar, para se visitar durante o convívio.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class Bar extends Local implements Serializable{
    /**
     * Inteiro para a lotação máxima do bar.
     */
    private int lotacao;
    /**
     * Double com o consumo mínimo obrigatório do bar.
     */
    private double consumoMinimo;
    /**
     * Arraylist de objectos da classe Pessoa. É a guestlist do bar.
     */
    private ArrayList<Pessoa> guestlist;
    /**
     * Double com a percentagem da lotação do bar que serve para o cálculo do tamanho da guestlist.
     */
    static private double tamanhoGuestlist = 0.30;

    /**
     * Cria um objecto da classe Bar.
     * @param nome String com o nome do bar.
     * @param lotacao Inteiro com a lotação máxima do bar.
     * @param consumoMinimo Double com o consumo mínimo obrigatório do bar.
     * @param longitude Double com a longitude das coordenadas do bar.
     * @param latitude Double com a latitude das coordenadas do bar.
     */
    public Bar(String nome, int lotacao, double consumoMinimo, double longitude, double latitude) {
        super(nome, longitude, latitude);
        this.lotacao = lotacao;
        this.consumoMinimo = consumoMinimo;
        this.guestlist = new ArrayList<>();
    }

    /**
     * Devolve valor do consumo mínimo obrigatório.
     * @return Valor do consumo mínimo obrigatório.
     */
    @Override
    public double getCusto() {
        return consumoMinimo;
    }

    /**
     *
     * @return String com o nome, quantidade de pessoas inscritas e a lotação do bar.
     */
    @Override
    public String toString() {
        return "Bar: " + getNome() + " -> Número de Inscritos: " + getPessoasInscritas() + " || Lotação: " + lotacao + '.';
    }
    
    /**
     * Tem como objectivo a construção da guestlist do bar. O tamanho da guestlist
     * é uma percentagem da lotação máxima do bar. As pessoas com o perfil "Boémio" têm
     * prioridade em relação às outras pessoas. Apenas se não houver mais pessoas com o perfil 
     * "Boémio", o restos dos lugares da guestlist, se houverem, são ocupados pela ordem
     * de inscrição do resto das pessoas.
     * @param inscricoes ArrayList de objectos da classe Inscricao, cujo contém todas as inscrições em locais de um determinado convívio.
     * @return String com a informação das pessoas que estão na guestlist do bar.
     */
    public String getGuestListInfo(ArrayList<Inscricao> inscricoes){
        guestlist.clear();
        boolean flag = true;
        boolean flag2 = true;
        for(Inscricao ins : inscricoes){
            if(ins.getNomeLocal().equals(getNome())){
                if(ins.getPessoa().getPerfil().equals("Boémio")){
                    guestlist.add(ins.getPessoa());
                }
            }
            if(guestlist.size() >= (tamanhoGuestlist*lotacao)){
               break;
            }
        }
        if(guestlist.size() < (tamanhoGuestlist*lotacao)){
            for(Inscricao ins : inscricoes){
                if(ins.getNomeLocal().equals(getNome())){
                    if(!guestlist.contains(ins.getPessoa())){
                        guestlist.add(ins.getPessoa());
                    }
                }
                if(guestlist.size() >= (tamanhoGuestlist*lotacao)){
                   break;
                }
            }
        }
        String rt = "";
        for(Pessoa p : guestlist){
            rt += p + "\n";
        }
        return rt;
    }
    
    /**
     *
     * @return true caso se trate de um bar.
     */
    @Override
    public boolean isBar(){
        return true;
    }
    
    /**
     *
     * @return Boolean, true caso a quantidade de pessoas inscritas seja menor que a lotação do bar, false caso contrário.
     */
    public boolean canRegister(){
        if(getPessoasInscritas() < lotacao){
            return true;
        }else
            return false;
    }
}
