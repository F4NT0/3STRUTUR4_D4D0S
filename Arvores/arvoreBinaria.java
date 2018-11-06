/**
 * Classe de uma Árvore Binária
 */
 public class arvoreBinaria<T>{
     //Variáveis
     private Nodo raiz; //Nodo onde vai ficar armazenado qual é a Raiz



     //Classe Interna do Nodo
     public class Nodo{
         //Referencia ao Nodo Pai do Nodo atual
         private Nodo pai;
         //Referencia ao Nodo da Esquerda
         private Nodo nodoEsquerda;
         //Referencia ao Nodo da Direita
         private Nodo nodoDireita;
         //elemento
         private T elemento;

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

     //Metodo Construtor da Arvore Binaria
     public arvoreBinaria(){
         
     }

     //Métodos

 }