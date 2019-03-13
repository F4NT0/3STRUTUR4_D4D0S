/**
 * Classe de Implementação de Filas
 * Filas são um caso particular de lista no qual
 * a movimentação acontece somente no inicio e no fim
 * 
 * Fila é chamada de Queue
 * 
 * POLITICA DE ACESSO AOS DADOS: FIFO
 * First-In,First-Out: primeiro a entrar será o primeiro a sair
 * Os elementos são retirados na ordem que entram
 */
 public class Filas<T> implements FilaTAD<T>{
    private int totalElementos;
    private Nodo primeiro,ultimo;
     

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



     //Método construtor
     public Filas(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
     }

     /**
      * Método para inserir valores na Fila
      * na fila é sempre inserido no inicio da fila
      * se chama enqueue
      */
     public void inserir(T elemento){
         //cria um novo nodo para colocar o elemento
         Nodo novo = new Nodo(elemento);
         //verificação para que a Fila está vazia ou não
         if(primeiro == null){ 
             primeiro = novo;
             ultimo = novo;
         }else{
             //se a lista não for vazia
             //o proximo nodo depois do primeiro se torna o novo
             novo.definirProximo(primeiro);
            primeiro = novo;
            if(ultimo == null){
                ultimo = novo;
            }
         }
         totalElementos++;
     }

     /**
      * Método para remover valores da Fila
      * é retirado o ultimo elemento da fila sempre
      * se chama dequeue
      */
      public T retirar(){
          //criado um nodo auxiliar para andar pela Fila
        Nodo auxiliar = primeiro;
        //variavel para armazenar o elemento do ultimo Nodo
        T elemento;
        //esta verificação serve para verificar se o ultimo nodo
        //for o primeiro Nodo
        if(ultimo == primeiro){
            //salvamos o elemento do ultimo na variavel
            elemento = ultimo.pegarElemento();
            //tornamos o ultimo em nulo
            ultimo = null;
            //retorna o elemento 
            return elemento;
        }
        //anda pela fila até o penultimo elemento
        for(int i = 0 ; i < totalElementos-1 ; i++){
            //vai alterando o nodo do auxiliar
            auxiliar = auxiliar.pegarProximo();
        }
       
        //se o ultimo for o proximo do auxiliar
        if(ultimo == auxiliar.pegarProximo()){
            //tornamos o ultimo o Nodo auxiliar
            ultimo = auxiliar;
        }
        //salva o elemento do ultimo na variavel
        elemento = ultimo.pegarElemento();
        //diminuimos o tamanho dos elementos da Fila
        totalElementos--;
        //retornamos o elemento do Nodo que foi deletado
        return elemento;
    }


      /**
       * Método para retornar o tamanho da Fila
       */
      public int tamanho(){
          //retorna o numero total de elementos
          return totalElementos;
      }

      /**
       * Método para pegar o primeiro Nodo
       * Retorna o elemento do primeiro Nodo
       */
      public T pegarPrimeiro(){
          //retorna o primeiro elemento do Nodo
          return primeiro.pegarElemento();
      }

      /**
       * Método para pegar os ultimos elementos da Fila
       * Retorna o elemento do ultimo Nodo
       */
      public T pegarUltimo(){
         return ultimo.pegarElemento();
      }

      /**
       * Método para ver todos os elementos da lista
       */
    public T pegar(int index){
        if((index < 0 || index >= totalElementos)){
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

    /**
     * Método para verificar se a fila está vazia
     */
    public boolean estaVazio(){
        if(primeiro == null && ultimo == null){
            return true;
        } 
        return false;
    }

    /**
     * Método para limpar a Fila
     */
    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }
 }