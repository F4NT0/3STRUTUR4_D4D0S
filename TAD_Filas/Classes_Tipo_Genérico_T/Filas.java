public class Filas<T> implements FilaTAD<T>{
    private int totalElementos;
    private Nodo primeiro,ultimo;
     
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


     public Filas(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
     }

     public void inserir(T elemento){
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

      public T retirar(){
        Nodo auxiliar = primeiro;
        T elemento;
        if(ultimo == primeiro){
            elemento = ultimo.pegarElemento();
            ultimo = null; 
            return elemento;
        }
        for(int i = 0 ; i < totalElementos-1 ; i++){
            auxiliar = auxiliar.pegarProximo();
        }
        if(ultimo == auxiliar.pegarProximo()){
            ultimo = auxiliar;
        }
        elemento = ultimo.pegarElemento();
        totalElementos--;
        return elemento;
    }


      public int tamanho(){return totalElementos;}

      public T pegarPrimeiro(){return primeiro.pegarElemento();}

      public T pegarUltimo(){return ultimo.pegarElemento();}

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

    public boolean estaVazio(){
        if(primeiro == null && ultimo == null){
            return true;
        } 
        return false;
    }

    public void limpar(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
    }
 }