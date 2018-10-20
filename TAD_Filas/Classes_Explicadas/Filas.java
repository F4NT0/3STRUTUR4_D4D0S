/**
 * Classe de Implementação de Filas
 * Filas são um caso particular de lista no qual
 * a movimentação acontece somente no inicio e no fim
 * 
 * POLITICA DE ACESSO AOS DADOS: FIFO
 * First-In,First-Out: primeiro a entrar será o primeiro a sair
 * Os elementos são retirados na ordem que entram
 */
 public class Filas<T> implements FilaTAD<T>{
    LinkedList lista = new LinkedList<>();
    private int totalElementos;
    private Nodo primeiro,ultimo;
     
     //Método construtor
     public Filas(){
        primeiro = null;
        ultimo = null;
        totalElementos = 0;
     }

     public void inserir(T elemento){
         
     }



     
 }