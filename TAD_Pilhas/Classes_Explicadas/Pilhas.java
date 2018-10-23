/**
 * Classe de Implementação de Pilhas
 * Pilhas funcionam da seguinte forma:
 *          -> É um caso particular de lista, onde é
 *             retirado o ultimo elemento colocado, sendo o primeiro elemento
 *           -> Segue o estilo LIFO(Left-In,First Out)
 * 
 */
 public class Pilhas<T> implements PilhaTAD<T>{
    Nodo primeiro,ultimo;
    int totalElementos;

    //Classe Interna Nodo
    public class Nodo{
        private T elemento;
        private Nodo proximo;

        //Método construtor do Nodo
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

     //Método Construtor
     public Pilhas(){
         primeiro = null;
         ultimo = null;
         totalElementos = 0;
     }


     /**
      * Método para descobrir o tamanho da Pilha
      */
      public int tamanho(){
          return totalElementos;
      }

     /**
      * Método para verificar se a Pilha está vazia
      */
      public boolean estaVazio(){
          if(primeiro == null && ultimo == null){
              return true;
          }
          return false;
      }

      /**
       * Método para verificar qual valor está no topo da pilha
       * chamamos o topo da pilha de TOP
       * returna o valor do topo da pilha
       */
      public T topo(){
        return primeiro.pegarElemento();
      }

      /**
       * Método para adicionar um valor na Pilha
       * chamamos esse método de PUSH
       */
      public void push(T elemento){
          //Criando um Nodo novo com o elemento
          Nodo novo = new Nodo(elemento);
          //verificação para ver se a fila está vazia
          if(primeiro == null){
              primeiro = novo;
              ultimo = novo;
          }else{
              novo.definirProximo(primeiro);
              primeiro = novo;
              if(ultimo == null){
                  ultimo = novo;
              }
          }
          totalElementos++;
      }

      /**
       * Método para remover um valor da pilha
       * É removido o primeiro elemento da pilha toda vez
       * chamamos esse método de POP
       */
      public T pop(){
          //variavel para armazenar o elemento do Nodo
          T elemento;
        //fazemos uma verificação para ver se o ultimo é igual ao primeiro
        if(ultimo == primeiro){
            ultimo = null;
        }
        elemento = primeiro.pegarElemento();
        primeiro = primeiro.pegarProximo();
        totalElementos--;
        return elemento;
      }

      /**
       * Método para andar e ver toda a pilha
       */
      public T pegar(int index){
          if((index < 0 ) || (index > totalElementos)){
              throw new IndexOutOfBoundsException();
          }
          Nodo auxiliar = primeiro;
          int contador = 0;
          while(contador < index){
              auxiliar = auxiliar.pegarProximo();
              contador++;
          }
          return auxiliar.pegarElemento();
      }

     
 }