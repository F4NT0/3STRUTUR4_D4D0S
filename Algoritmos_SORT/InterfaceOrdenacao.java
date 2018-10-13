/**
 * Classe de Interface dos Métodos de Ordenação
 */
public interface InterfaceOrdenacao{
    public int[] geraVetor(int tamanho,int limiteValores);
    public void bubblesort(int[] vetor);
    public void insertionSort(int[] vetor);
    public void mergeSort(int[] vetor);
    public void mergeSort(int[] vetor,int inicio,int fim);
    public void quickSort(int[] vetor, int menor, int maior);

}