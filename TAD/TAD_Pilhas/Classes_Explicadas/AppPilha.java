/**
 * Classe de Teste da Classe Pilhas
 */
public class AppPilha{
    public static void main(String[] args){
        Pilhas pilha = new Pilhas<>();
        //Teste do método push(e)
        System.out.println("Teste do metodo push(e)");
        System.out.println("Tamanho da Pilha: " + pilha.tamanho());
        pilha.push(4);
        pilha.push(3);
        pilha.push(2);
        pilha.push(1);
        System.out.println("Tamanho da Pilha: " + pilha.tamanho());
        for(int i = 0 ; i < pilha.totalElementos; i++){
            System.out.println("Nodo "+i+": "+pilha.pegar(i));
        }

        //Teste do método topo()
        System.out.println("Teste do metodo topo()");
        System.out.println("Elementos da Pilha: ");
        for(int i = 0 ; i < pilha.totalElementos; i++){
            System.out.println("Nodo "+i+": "+pilha.pegar(i));
        }
        System.out.println("Qual o elemento no topo da pilha? " + pilha.topo());
        //Teste do método pop()
        System.out.println("Teste do metodo pop()");
        System.out.println("Tamanho da Pilha: " + pilha.tamanho());
        for(int i = 0 ; i < pilha.totalElementos; i++){
            System.out.println("Nodo "+i+": "+pilha.pegar(i));
        }
        System.out.println("Elemento da Pilha removido: " + pilha.pop());
        System.out.println("Tamanho da Pilha: " + pilha.tamanho());
        for(int i = 0 ; i < pilha.totalElementos; i++){
            System.out.println("Nodo "+i+": "+pilha.pegar(i));
        }
        System.out.println("Elemento da Pilha removido: " + pilha.pop());
        System.out.println("Tamanho da Pilha: " + pilha.tamanho());
        for(int i = 0 ; i < pilha.totalElementos; i++){
            System.out.println("Nodo "+i+": "+pilha.pegar(i));
        }



    }
}