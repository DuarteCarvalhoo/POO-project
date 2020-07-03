package convivio.Convivio;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Classe ConvivioDei que serve para criar convívios disponíveis para as pessoas.
 * @author Pedro Ribeiro e Duarte Carvalho
 */
public class ConvivioDei implements Serializable{
    /**
     * String com o nome do convívio.
     */
    private String nome;
    /**
     * ArrayList de objectos da classe Pessoa. Armazena as pessoas inscritas no convívio.
     */
    private ArrayList<Pessoa> listaPessoasInscritas;
    /**
     * ArrayList de objectos da classe Local. Armazena os locais possíveis de visitar no convívio.
     */
    private ArrayList<Local> listaLocais;
    /**
     * ArrayList de objectos da classe Inscricao. Armazena as inscrições das pessoas nos locais.
     */
    private ArrayList<Inscricao> inscricoes;

    /**
     * Cria um objecto da classe ConvivioDei.
     * @param nome String com o nome do convívio.
     */
    public ConvivioDei(String nome) {
        this.nome = nome;
        this.listaPessoasInscritas = new ArrayList<>();
        this.listaLocais = new ArrayList<>();
        this.inscricoes = new ArrayList<>();
    }
    
    /**
     * Cria um objecto da classe ConvivioDei com um ArrayList de pessoas e locais já criados.
     * @param nome String com o nome do convívio.
     * @param listaPessoasInscritas ArrayList com objectos da classe Pessoa. Guarda as pessoas inscritas no convívio.
     * @param listaLocais ArrayList com objectos da classe Local. Guarda os locais possiveis de visitar no convívio.
     */
    public ConvivioDei(String nome, ArrayList<Pessoa> listaPessoasInscritas, ArrayList<Local> listaLocais){
        this.nome = nome;
        this.listaPessoasInscritas = listaPessoasInscritas;
        this.listaLocais = listaLocais;
        this.inscricoes = new ArrayList<>();
    }

    /**
     * Devolve a lista de pessoas inscritas no Convivio.
     * @return ArrayList de objectos Pessoa
     */
    public ArrayList<Pessoa> getListaPessoasInscritas() {
        return listaPessoasInscritas;
    }
    
    /**
     *
     * @return ArrayList de inscrições.
     */
    public ArrayList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    /**
     *
     * @return ArrayList de locais do convívio.
     */
    public ArrayList<Local> getListaLocais() {
        return listaLocais;
    }

    /**
     *
     * @return String com o nome do convívio.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Adiciona um local à lista de locais possíveis de visitar do convívio.
     * @param local Objecto da classe Local.
     */
    public void adicionarLocal(Local local){
        this.listaLocais.add(local);
    }
    
    /**
     * Adiciona uma pessoa à lista de pessoas inscritas no convívivo.
     * @param pessoa Objecto da classe Pessoa.
     */
    public void inscreverPessoa(Pessoa pessoa){
        this.listaPessoasInscritas.add(pessoa);
    }
    
    /**
     * Verifica se uma pessoa já está registada ou não no convívio.
     * Devolve "true" se a pessoa já estiver registada, devolve "false" caso 
     * contrário.
     * @param p Objecto da classe Pessoa.
     * @return Boolean.
     */
    public boolean isPersonRegistered(String p){
        for(Pessoa pessoa : listaPessoasInscritas){
            if(pessoa.getNome().equals(p)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Percorre a lista de locais e devolve uma String com a informação de todos
     * os locais possíveis de visitar no convívio.
     * @return String com a informação dos locais.
     */
    public String getInfoLocais(){
        String infoLocal = "";
        for(Local local : listaLocais){
            infoLocal += local + "\n";
        }
        return infoLocal;
    }
    
    /**
     * Percorre a lista de locais e devolve uma String com a informação de todos os
     * locais possíveis de visitar no convívio, a diferença está no facto de a 
     * apresentação dos locais ser feita por ordem (decrescente pelo número de pessoas inscritas).
     * @return Strign com a informação dos locais.
     */
    public String getInfoLocaisOrdered(){
        String infoLocal = "";
        ArrayList<Local> listaTmp = listaLocais;
        Local temp;
        for (int x=0; x<listaTmp.size(); x++){
            for (int i=0; i < listaTmp.size()-x-1; i++) {
                if (listaTmp.get(i).getPessoasInscritas() < listaTmp.get(i+1).getPessoasInscritas()){
                    temp = listaTmp.get(i);
                    listaTmp.set(i,listaTmp.get(i+1) );
                    listaTmp.set(i+1, temp);
                }
            }
        }
        for(Local local : listaTmp){
            infoLocal += local + "\n";
        }
        return infoLocal;
    }
    
    /**
     * Cria um objecto da classe Inscricao com uma pessoa e um local.
     * Serve para inscrever uma pessoa num local do convívio.
     * Devolve 1 em caso de sucesso e -1 caso a local tenha lotação máxima e este
     * já tenha sido atingido.
     * @param p Objecto da classe Pessoa.
     * @param l Objecto da classe Local.
     * @return Inteiro, 1 em caso de sucesso, -1 em case de insucesso.
     */
    public int inscreverEmLocal(Pessoa p, Local l){
       if(l.isBar()){
           if(((Bar)l).canRegister()){               
                inscricoes.add(new Inscricao(p, l));
                int index = listaLocais.indexOf(l);
                listaLocais.get(index).incrementarPessoasIns();
                return 1;
           }else{
               return -1;
           }
       }else{
            inscricoes.add(new Inscricao(p, l));
            int index = listaLocais.indexOf(l);
            listaLocais.get(index).incrementarPessoasIns();
            return 1;
       }
    }
    
    /**
     * Vai desinscrever uma pessoa de um local. Encontra o objecto que contém a
     * pessoa e o local passado como argumentos e retira esse objecto da lista de 
     * inscrições.
     * @param p Objecto da classe Pessoa.
     * @param local Objecto da classe Local.
     */
    public void desinscreverDeLocal(String p, Local local){
        String l = local.getNome();
        Inscricao remover = null;
        for(Inscricao ins : inscricoes){
            if(ins.getNomePessoa().equals(p) && ins.getNomeLocal().equals(l)){
                remover = ins;
                break;
            }
        }
        int index = inscricoes.indexOf(remover);
        inscricoes.remove(index);
        local.decrementarPessoasIns();
    }
}
