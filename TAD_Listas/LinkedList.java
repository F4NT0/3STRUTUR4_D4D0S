/**
 * Implementação de uma classe de Listas Encadeadas com Nodos
 * utiliza os métodos da interface TAD
 * possui uma classe interna de Nodos
 */
public class LinkedList implements ListTAD{
    //Variáveis
    private Nodo primeiro,ultimo;
    private int totalElementos;

    //Classe Interna Nodo
    public class Nodo{
        private E elemento;
        private Nodo proximo;
        //Método construtor
        public Nodo(E e){
            elemento = e;
            proximo = null;
        }
        //Métodos da Classe Nodo
        public void definirElemento(E e){elemento = e;}
        public void definirProximo(Nodo n){proximo = n;}
        public E pegarElemento(){return elemento;}
        public Nodo pegarProximo(){return proximo;}
    }

    //Método construtor da LinkedList
    public LinkedList(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    //Métodos da LinkedList implementados da interface TAD
    public void adicionar(E e){
        Nodo novo = new Nodo(e);
        if(ultimo != null){
            ultimo.definirProximo(novo);
        }
        else{
            primeiro = novo;
        }
        ultimo = novo;
        totalElementos++;
    }
    //public void adicionar(int index,E elemento){}

    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }

    public boolean contem(E e){
        Nodo<E> auxiliar;
        auxiliar = primeiro;
        while(auxiliar != null){
            if(auxiliar.pegarElemento().equals(e)){
                return true;
            }
            auxiliar = auxiliar.pegarProximo();
        }
        return false;
    }

    //public E pegar(int index){}

    //public int indexDe(E e){}

    public boolean estaVazio(){
        if(primeiro == null){
            return true;
        }
        else{return false;}
    }

    public boolean remover(E e){
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
    //public E remover(int index){}
    public int tamanho(){
        return totalElementos;
    }
    //public E definir(int index, E elemento){}
    //public void addInicio(E e){}
    //public E pegarInicio(){}
    //public E pegarFim(){}
    //public boolean removerInicio(){}
    //public boolean removerFim(){}



}