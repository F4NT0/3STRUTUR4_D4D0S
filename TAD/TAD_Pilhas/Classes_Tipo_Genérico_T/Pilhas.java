public class Pilhas<T> implements PilhaTAD<T>{
    Nodo primeiro,ultimo;
    int totalElementos;

    public class Nodo{
        private T elemento;
        private Nodo proximo;

        public Nodo(T e){
            elemento = e;
            proximo = null;
        }

        public void definirElemento(T e){elemento = e;}
        public void definirProximo(Nodo n){proximo = n;}
        public T pegarElemento(){return elemento;}
        public Nodo pegarProximo(){return proximo;}
    }

     public Pilhas(){
         primeiro = null;
         ultimo = null;
         totalElementos = 0;
     }


      public int tamanho(){
          return totalElementos;
      }

      public boolean estaVazio(){
          if(primeiro == null && ultimo == null){
              return true;
          }
          return false;
      }

      public T topo(){
        return primeiro.pegarElemento();
      }


      public void push(T elemento){
          Nodo novo = new Nodo(elemento);
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

      public T pop(){
          T elemento;
        if(ultimo == primeiro){
            ultimo = null;
        }
        elemento = primeiro.pegarElemento();
        primeiro = primeiro.pegarProximo();
        totalElementos--;
        return elemento;
      }

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