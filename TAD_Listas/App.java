/**
 * Classe de teste da Classe LinkedList
 */
public class App{
    public static void main(String[] args){
        //chamando a classe LinkedList
        LinkedList<Integer> listaEncadeada= new LinkedList<Integer>();

        //testando o método adicionar(E e)
        System.out.println("Tamanho Inicial: " + listaEncadeada.tamanho());
        listaEncadeada.adicionar(1);
        listaEncadeada.adicionar(2);
        listaEncadeada.adicionar(3);
        System.out.println("Tamanho Final: " + listaEncadeada.tamanho());
        System.out.println("Elemento do Nodo 1: " + listaEncadeada.pegar(0));
        System.out.println("Elemento do Nodo 2: " + listaEncadeada.pegar(1));
        System.out.println("Elemento do Nodo 3: " + listaEncadeada.pegar(2));
    }
}