/**
 * Classe de teste da Classe LinkedList
 */
public class App{
    public static void main(String[] args){
        //chamando a classe LinkedList
        LinkedList<Integer> listaEncadeada= new LinkedList<Integer>();

        //testando o método adicionar(E e)
        System.out.println("Teste do adicionar(T e)");
        System.out.println("Tamanho Inicial: " + listaEncadeada.tamanho());
        listaEncadeada.adicionar(1);
        listaEncadeada.adicionar(2);
        listaEncadeada.adicionar(3);
        System.out.println("Tamanho Final: " + listaEncadeada.tamanho());
        System.out.println("Teste do Pegar(int index)");
        System.out.println("Elemento do Nodo 1: " + listaEncadeada.pegar(0));
        System.out.println("Elemento do Nodo 2: " + listaEncadeada.pegar(1));
        System.out.println("Elemento do Nodo 3: " + listaEncadeada.pegar(2));

        //testando o método limpar
        System.out.println("Teste do  limpar():");
        System.out.println("Tamanho Conhecido: " + listaEncadeada.tamanho());
        listaEncadeada.limpar();
        System.out.println("Tamanho Atual: " + listaEncadeada.tamanho());

        //testando o método contem(T e)
        System.out.println("Teste do contem(T e)");
        listaEncadeada.adicionar(1);
        listaEncadeada.adicionar(2);
        listaEncadeada.adicionar(3);
        System.out.println("Existe o Elemento 3 na lista?: " + listaEncadeada.contem(3));
 
        //testano o método estaVazio()
        System.out.println("Teste do estaVazio()");
        System.out.println("Lista vazia?: " + listaEncadeada.estaVazio());
        
        


    }
}