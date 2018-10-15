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
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }

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
 
        //testando o método estaVazio()
        System.out.println("Teste do estaVazio()");
        System.out.println("Lista vazia?: " + listaEncadeada.estaVazio());
        
        //testando o método remover(T e)
        System.out.println("Teste do remover(T e)");
        System.out.println("Tamanho: " + listaEncadeada.tamanho());
        System.out.println("Removido o elemento do Nodo 1?: " + listaEncadeada.remover(1));
        System.out.println("Tamanho: " + listaEncadeada.tamanho());

        //testando o método tamanho()
        System.out.println("Teste do tamanho()");
        System.out.println("Tamanho: " + listaEncadeada.tamanho());

        //testando o método adicionar 2
        System.out.println("Teste do adicionar(index,elemento)");
        listaEncadeada.limpar();
        listaEncadeada.adicionar(1);
        listaEncadeada.adicionar(2);
        listaEncadeada.adicionar(3);
        listaEncadeada.adicionar(4);
        System.out.println("Total de Elementos: " + listaEncadeada.tamanho());
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        listaEncadeada.adicionar(2,2);
        System.out.println("Total de Elementos: " + listaEncadeada.tamanho());
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }

        //Teste do Método remover(index)
        System.out.println("Teste do remover(index)");
        System.out.println("Total de Elementos: " + listaEncadeada.tamanho());
        System.out.println("Elemento removido do Nodo 3: " + listaEncadeada.remover(2));
        System.out.println("Total de Elementos: " + listaEncadeada.tamanho());

        //Teste do método indexDe(T e)
        System.out.println("Teste do indexDe(e)");
        for(int i = 0 ; i < listaEncadeada.tamanho(); i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        System.out.println("Index do Elemento 2: " +listaEncadeada.indexDe(2));   
        //Teste do método definir(index,elemento)
        System.out.println("Teste do definir(index,elemento)");
        for(int i = 0 ; i < listaEncadeada.tamanho(); i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        System.out.println("Definir o Nodo 1 como 3, qual o antigo elemento?: " + listaEncadeada.definir(1,3));
        for(int i = 0 ; i < listaEncadeada.tamanho(); i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        System.out.println("Colocando o Valor antigo de volta: " + listaEncadeada.definir(1,2));
        for(int i = 0 ; i < listaEncadeada.tamanho(); i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        //Teste do método addInicio(e)
        System.out.println("Teste do addInicio(e)");

        listaEncadeada.limpar();
        listaEncadeada.adicionar(2);
        listaEncadeada.adicionar(3);
        listaEncadeada.adicionar(4);
        System.out.println("Tamanho da Lista: " + listaEncadeada.tamanho());
        for(int i = 0 ; i < listaEncadeada.tamanho(); i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        listaEncadeada.addInicio(1);
        System.out.println("Tamanho da lista: " + listaEncadeada.tamanho());
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        //Teste dos Método pegarInicio e pegarFim
        System.out.println("Teste dos pegarInicio() e pegarFim()");
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        System.out.println("Primeiro Elemento: " + listaEncadeada.pegarInicio());
        System.out.println("Ultimo Elemento: " + listaEncadeada.pegarFim());

        //Teste do Método removerInicio()
        System.out.println("Teste do removerInicio()");
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        System.out.println("Removeu?: " + listaEncadeada.removerInicio());
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        //Teste do Método removerFim()
        System.out.println("Teste do removerFim()");
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
        System.out.println("Removeu?: " + listaEncadeada.removerFim());
        for(int i = 0 ; i < listaEncadeada.tamanho();i++){
            System.out.println("Nodo " + i + ": " + listaEncadeada.pegar(i));
        }
    }
}