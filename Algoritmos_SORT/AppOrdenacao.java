/**
 * Classe de teste da Classe Ordenacao
 */
public class AppOrdenacao{
    public static void main(String[] args){
        Ordenacao ordena = new Ordenacao();

        //Teste do metodo de criar vetores randomicos
        System.out.println("Teste do metodo geraVetor(int tamanho,int limite)");
        int[] vetor = ordena.geraVetor(8,8);
        for(int i = 0 ; i < vetor.length ; i++){
            System.out.print(vetor[i]+"|");
        }

        //Teste do metodo de ordenacao do bubblesort
        System.out.println("\n Teste do metodo bubblesort(int[] vetor) ");
        ordena.bubblesort(vetor);
        for(int i = 0 ; i < vetor.length ; i++){
            System.out.print(vetor[i]+"|");
        }

        //Teste do metodo de ordenacao do insertionSort
        System.out.println("\n Teste do metodo de insertionSort(int[] vetor)");
        ordena.insertionSort(vetor);
        for(int i = 0 ; i < vetor.length ; i++){
            System.out.print(vetor[i]+"|");
        }

    }
}