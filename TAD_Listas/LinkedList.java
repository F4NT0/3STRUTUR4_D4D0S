/**
 * Implementação de uma classe de Listas Encadeadas com Nodos
 * utiliza os métodos da interface TAD
 * possui uma classe interna de Nodos
 */
public class LinkedList<T> {//implements ListTAD{
    //Variáveis
    private Nodo primeiro,ultimo;
    //primeiro é o HEAD
    //ultimo é o TAIL
    private int totalElementos;

    //Classe Interna Nodo
    public class Nodo{
        private T elemento;
        private Nodo proximo;
        //Método construtor
        public Nodo(T e){
            elemento = e;
            proximo = null;
        }
        //Métodos da Classe Nodo
        public void definirElemento(T e){elemento = e;}
        public void definirProximo(Nodo n){proximo = n;}
        public T pegarElemento(){return elemento;}
        public Nodo pegarProximo(){return proximo;}    
    }

    //Método construtor da LinkedList
    public LinkedList(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    //Métodos da LinkedList implementados da interface TAD

    /**
     * Método de inserção de um elemento na lista
     * elemento sempre inserido no fim
     * @param e
     */
    public void adicionar(T e){
        Nodo novo = new Nodo(e); //criado um novo nodo com o elemento
        if(primeiro == null){  //se a referencia do primeiro nodo for null
            primeiro = novo; //define o primeiro como o novo
        }else{ // se o primeiro for diferente de null
            //O proximo nodo depois do ultimo será o novo Nodo
            ultimo.definirProximo(novo); 
        }
        ultimo = novo; //ultimo nodo se torna o novo
        totalElementos++; //sobe o total de elementos do nodo
    }
    //public void adicionar(int index,T elemento){}

    /**
     * Método para zerar a Lista 
     */
    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }


    /**
     * Método para verificar se o elemento existe na Lista Encadeada
     * @param e
     * @return
     */
    public boolean contem(T e){
        Nodo auxiliar; //criado um nodo auxiliar
        auxiliar = primeiro; //definimos o auxiliar como o primeiro
        while(auxiliar != null){//enquanto o auxiliar não for nulo
            //verifica se o elemento é igual ao elemento de entrada
            if(auxiliar.pegarElemento().equals(e)){
                return true;
            }
            //pega o proximo Nodo depois de verificado
            auxiliar = auxiliar.pegarProximo();
        }
        return false;
    }

    /**
     * Para pegar um Nodo especifico, devemos 
     * criar um contador que irá passar por todos os nodos
     * até chegar no nodo que fica na posição do index
     * @param index
     */
    public T pegar(int index){
        //verificação se o index está dentro do tamanho total
        if((index < 0) || (index >= totalElementos)){
            throw new IndexOutOfBoundsException();
        }
        Nodo auxiliar = primeiro; //colocamos o primeiro nodo no auxiliar
        int contador = 0; //criamos um contador zerado
        while(contador < index){ //enquanto o contador for menor que o index
            //o auxiliar vai passando pelos nodos até chegar no nodo do index
            auxiliar = auxiliar.pegarProximo();
            contador++;
        }
        //quando chegar no index, retorna o elemento do Nodo
        return auxiliar.pegarElemento();

    }

    //public int indexDe(T e){}

    public boolean estaVazio(){
        if(primeiro == null){
            return true;
        }
        else{return false;}
    }

    public boolean remover(T e){
        //criado um nodo auxiliar e um anterior
        Nodo anterior,auxiliar;
        //se o primeiro for nulo, retorna false
        if(primeiro == null){return false;}
        //faz uma verificação para ver se o primeiro Nodo
        //possui o mesmo elemento do parâmetro
        if(primeiro.pegarElemento().equals(e)){
            //se o ultimo Nodo for igual ao primeiro
            //O ultimo será definido null
            if(ultimo == primeiro){ultimo = null;}
            //se não forem iguais
            //primeiro irá se tornar o proximo
            primeiro = primeiro.pegarProximo();
            totalElementos--; //diminui o total de elementos
            return true;
        }
        //se não for o mesmo elemento, devemos andar pelos Nodos
        anterior = primeiro; //anterior se torna o primeiro
        //auxiliar se torna o proximo
        auxiliar = primeiro.pegarProximo();

        while(auxiliar != null){//enquanto o auxiliar for diferente de null
           //Verifica se o elemento do auxiliar é igual ao elemento do parametro
            if(auxiliar.pegarElemento().equals(e)){
                //se o auxiliar for igual ao ultimo, o ultimo se torna anterior
                if(auxiliar == ultimo){ultimo = anterior;}
                //sera definido o proximo do anterior, pegando o proximo do auxiliar
                anterior.definirProximo(auxiliar.pegarProximo());
                //diminui o tamanho
                totalElementos--;
                return true;
            }
            else{
                //se não for igual, ele pega o proximo Nodo
                anterior = auxiliar;
                auxiliar = auxiliar.pegarProximo();
            }
        }
        return false;
    }
    //public T remover(int index){}
    public int tamanho(){
        return totalElementos;
    }
    //public T definir(int index, T elemento){}
    //public void addInicio(T e){}
    //public T pegarInicio(){}
    //public T pegarFim(){}
    //public boolean removerInicio(){}
    //public boolean removerFim(){}

}