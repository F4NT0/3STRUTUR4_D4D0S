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
            ultimo.definirProximo(novo); // define o proximo nodo com o novo nodo
        }
        ultimo = novo; //ultimo nodo se torna o novo
        totalElementos++; //sobe o total de elementos do nodo
    }
    //public void adicionar(int index,T elemento){}

    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    public boolean contem(T e){
        Nodo<T> auxiliar;
        auxiliar = primeiro;
        while(auxiliar != null){
            if(auxiliar.pegarElemento().equals(e)){
                return true;
            }
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
        Nodo anterior,auxiliar;
        if(primeiro == null){return false;}
        if(primeiro.pegarElemento().equals(e)){
            if(ultimo == primeiro){ultimo = null;}
            primeiro = primeiro.pegarProximo();
            totalElementos--;
            return true;
        }
        anterior = primeiro;
        auxiliar = primeiro.pegarProximo();
        while(auxiliar != null){
            if(auxiliar.pegarElemento().equals(e)){
                if(auxiliar == ultimo){ultimo = anterior;}
                anterior.definirProximo(auxiliar.pegarProximo());
                totalElementos--;
                return true;
            }
            else{
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