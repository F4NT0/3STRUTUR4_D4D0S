/**
 * Classe de Teste da Classe Filas
 */
public class AppFila{
    public static void main(String[] args){
        Filas fila = new Filas<>();

        //Teste do método de inserir valores na fila
        System.out.println("Teste do metodo inserir(e)");
        fila.inserir(4);
        fila.inserir(3);
        fila.inserir(2);
        System.out.println("Primeiro elemento antes de inserir: " + fila.pegarPrimeiro());
        fila.inserir(1);
        System.out.println("Primeiro elemento depois de inserir: " + fila.pegarPrimeiro());
        for(int i = 0 ; i < fila.tamanho() ; i++){
            System.out.println("Nodo " + i + ": " + fila.pegar(i));
        }

        //Teste do pegar o ultimo elemento e o primeiro elemento
        System.out.println("Teste do pegarPrimeiro() e pegarUltimo()");
        System.out.println("Primeiro elemento: " + fila.pegarPrimeiro());
        System.out.println("Ultimo elemento: " + fila.pegarUltimo());
        //Teste do método de retirar valores da fila
        System.out.println("Teste do metodo remover()");
        System.out.println("Tamanho da Fila: " + fila.tamanho());
        System.out.println("Fila: ");
        for(int i = 0 ; i < fila.tamanho() ; i++){
            System.out.println("Nodo: " + i + ": " + fila.pegar(i));
        }
        System.out.println("Removendo da Fila Pela primeira Vez: ");
        System.out.println("Elemento removido: " + fila.retirar());
        System.out.println("Tamanho da Fila: " + fila.tamanho());
        for(int i = 0 ; i < fila.tamanho() ; i++){
            System.out.println("Nodo " + i + ": "+fila.pegar(i));
        }
        System.out.println("Removendo da Fila Pela segunda vez: ");
        System.out.println("Elemento removido: " + fila.retirar());
        System.out.println("Tamanho da Fila: " + fila.tamanho());
        for(int i = 0 ; i < fila.tamanho() ; i++){
            System.out.println("Nodo: " + i + ": " +fila.pegar(i));
        }

        //Teste de limpeza da Fila:
        System.out.println("Teste do metodo limpar()");
        System.out.println("Tamanho da Fila: " + fila.tamanho());
        fila.limpar();
        System.out.println("Tamanho da Fila: " + fila.tamanho());        
        //teste de verificação se está vazio ou não
        System.out.println("Teste do metodo estaVazio()");
        System.out.println("Criando Fila: ");
        fila.inserir(4);
        fila.inserir(3);
        fila.inserir(2);
        fila.inserir(1);
        for(int i = 0 ; i < fila.tamanho() ; i++){
            System.out.println("Nodo: " + i + ": " +fila.pegar(i));
        }
        System.out.println("Fila Vazia? " + fila.estaVazio());
        System.out.println("Limpando Fila: ");
        fila.limpar();
        System.out.println("Fila Vazia? " + fila.estaVazio());
   
    }
}