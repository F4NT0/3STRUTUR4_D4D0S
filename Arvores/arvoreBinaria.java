/**
 * Classe de uma Árvore Binária
 */
 public class arvoreBinaria<T>{
     //Variáveis
     private Nodo<T> referenciaRaiz; //Nodo onde vai ficar armazenado qual é a Raiz
    
     /**
      * Posições Possiveis de um Nodo em uma árvore binária
      */
     public enum NodoPosicao{
        Esquerda,Direita;
     }

     //Classe Interna do Nodo
     public class Nodo<T>{
         //Referencia ao Nodo Pai do Nodo atual
         private Nodo pai;
         //Referencia ao Nodo da Esquerda
         private Nodo nodoEsquerda;
         //Referencia ao Nodo da Direita
         private Nodo nodoDireita;
         //elemento
         private T elemento;

         //Método Construtor do Nodo
         public Nodo(T e){
            elemento = e;
            pai = null;
            nodoEsquerda = null;
            nodoDireita = null;
         }
         
         //Métodos do Nodo

         //Getters
         public T getElemento(){return elemento;}
         public Nodo getEsquerda(){return nodoEsquerda;}
         public Nodo getDireita(){return nodoDireita;}
         public Nodo getPai(){return pai;}

        //Setters
        public void setElemento(T e){elemento = e;}
        public void setEsquerda(Nodo esq){nodoEsquerda = esq;}
        public void setDireita(Nodo dir){nodoDireita = dir;}
        public void setPai(Nodo pai){this.pai = pai;}

     }

     /**
      * Método Construtor da Árvore, onde temos um vetor como Parâmetro
      * @param vetor
      */
     public arvoreBinaria(T[] vetor){
         //é criado uma Fila que vai indo armazenando os elementos em Nodos da Árvore
         Filas<T> fila = new Fila<T>();
         //criando um novo Nodo para armazenar o elemento da Fila
         Nodo<T> novo = null; //Inicializado em null, porque devemos retirar os elementos do vetor
         //criando um Nodo onde vai ficar armazenado quem é o primeiro Nodo
         Nodo<T> primeiroNodo = null; //inicializado como null porque devemos definir quem ele é depois
         //Criado uma variavel para definir de qual lado o Nodo irá ficar na árvore binária
         NodoPosicao posicao = null;

         //se o vetor não for zero
         if(vetor.length > 0){
             //pegamos o elemento do vetor e colocamos no novo Nodo
             novo = new Nodo<T>(vetor[0]);
             //colocamos o novo Nodo como referencia a  raiz, por ser o Nodo onde esta a raiz
             referenciaRaiz = novo;
             //adicionamos o valor do Nodo raiz na Fila
             fila.inserir(referenciaRaiz.getElemento());
             //agora definimos a posição do posição como esquerda
             posicao = NodoPosicao.Esquerda;

             //É criado um For para se criar todos os outros Nodos da Árvore
             for(int i = 1 ; i < vetor.length ; i++){
                 //atualizamos o novo Nodo toda vez que pegamos um valor do vetor
                 novo = new Nodo<T>(vetor[i]);
                 fila.inserir(novo.getElemento());//adicionamos os elementos na Fila
                 primeiroNodo = new Nodo<T>(fila.pegar(0));//criamos o Nodo primeiro, onde fica armazenado o primeiro elemento da árvore
                 novo.setPai(primeiro);//definimos o primeiro elemento da árvore como o pai do novo Nodo

                 //utilizamos agora a posição que definimos antes(esquerda) para dizer para onde vai o novo Nodo
                 if(posicao.equals(NodoPosicao.Esquerda)){
                    primeiroNodo.setEsquerda(novo);//definimos o novo Nodo como o Nodo a esquerda do primeiro Nodo
                    posicao = NodoPosicao.Direita; //definimos a posição como a direita, para onde vai o proximo Nodo
                 }else{
                     //se a posicao estiver como Direita, ele irá add o novo Nodo na direita do Primeiro Nodo
                     primeiroNodo.setDireita(novo); 
                     fila.retirar(); // é retirado da Fila o elemento que iniciou a construção da arvore
                     posicao = NodoPosicao.Esquerda; //definimos a posicao como esquerda, para quando iniciar, o Nodo irá ser adicionado a esquerda e depois direita
                 }

             }

         }


     }

     //Métodos para se usar em Árvores

     //MÉTODOS DE CAMINHAMENTO PELA ÁRVORE(Entregando uma LinkedList)

     /**
      * Método de Caminhamento Pré-Fixado
      * No Pré-fixado, o Nodo é visitado antes de seus Descendentes
      * Ordem: 
      *       1) Visita a Raiz
      *       2) Percorre sub-árvores da Esquerda
      *       3) Percorre sub-árvores da Direita 
      */
      public LinkedList<T> prefixado(){
          //criando uma lista para armazenar
          LinkedList<T> lista = new LinkedList<T>();
          Nodo<T> raiz = referenciaRaiz;
          preFixado(raiz,lista);
          return lista;
      }
      public void preFixado(Nodo<T> raiz,LinkedList<T> lista){
        
            if(raiz != null){
                //adicionamos primeiro a raiz na lista
                lista.adicionar(raiz.getElemento());
                //andamos pelas sub-arvores da esquerda de forma recursiva
                preFixado(raiz.getEsquerda(), lista);
                //andamos depois pelas sub-arvores da direita de forma recursiva
                preFixado(raiz.getDireita(), lista);
            }
        }

      /**
       * Método de Caminhamento Pós-Fixado
       * No Pós-Fixado, o Nodo é visitado depois de seus Descendentes
       * Ordem:
       *     1) Percorre a Sub-árvores da Esquerda
       *     2) Percorre a Sub-árvores da Direita
       *     3) Visita a Raiz
       */
      public LinkedList<T> posFixado(){
        LinkedList<T> lista = new LinkedList<T>();
          Nodo<T> raiz = referenciaRaiz;
          preFixado(raiz,lista);
          return lista;
      }
      public void posFixado(Nodo<T> raiz, LinkedList<T> lista){
            if(raiz != null){
                preFixado(raiz.nodoEsquerda, lista);
                preFixado(raiz.nodoDireita, lista);
                lista.adicionar(raiz.getElemento());
            }
      }

      /**
       * Método de Caminhamento Central
       * No Central, percorre as arvores da esquerda, depois a raiz e depois a arvore a direita
       * Ordem:
       *        1) Percorre as Sub-árvores da Esquerda
       *        2) Visita a Raiz
       *        3) Percorre as Sub-árvores da Direita
       */
      public LinkedList<T> central(){
        LinkedList<T> lista = new LinkedList<T>();
        Nodo<T> raiz = referenciaRaiz;
        preFixado(raiz,lista);
        return lista;
      }
      public void central(Nodo<T> raiz, LinkedList<T> lista){
          if(raiz != null){
              preFixado(raiz.getEsquerda(), lista);
              lista.addInicio(raiz.getElemento());
              preFixado(raiz.getDireita(), lista);
          }
      }

      /**
       * Método de Caminhamento de Largura
       * Visita os Nodos pelos Niveis da Árvore, da esquerda para a direita
       */
      public LinkedList<T> largura(){
        //Criado uma Fila, para ir controlando quais elementos ja foram usados
        Filas<T> filaAuxiliar = new Filas<T>();
        //Iniciado uma LinkedList para armazenar o resultado final do caminhamento
        LinkedList<T> lista = new LinkedList();
        //Criado um Nodo atual, para controlar de qual elemento estamos trabalhando
        Nodo<T> atual = null;

        if(referenciaRaiz != null){ //enquanto a referencia a raiz não for nula
            //adicionamos o elemento da raiz dentro da fila, para iniciar o while
            filaAuxiliar.inserir(referenciaRaiz.getElemento());

            while(!fila.estaVazio()){
                //adicionamos o elemento da raiz dentro do Nodo atual
                atual = new Nodo<T>(fila.retirar());
                //verificamos se o elemento a esquerda do Nodo atual é diferente de nulo
                if(atual.getEsquerda() != null){
                    //se for diferente de nulo, adicionamos o elemento do Nodo a esquerda na fila
                    fila.inserir(atual.getEsquerda().getElemento());
                }
                if(atual.getDireita() != null){
                    fila.inserir(atual.getDireita().getElemento());
                }
                //após verificar e adicionar na fila, adicionamos o elemento do Nodo atual na lista que estamos construindo
                lista.adicionar(atual.getElemento());
            }
            return lista;

        }
      }


     //public T getElemEsquerda(T elemento){

     //}

 }