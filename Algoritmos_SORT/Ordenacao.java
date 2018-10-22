import java.util.Random;

/**
 * Classe com os Métodos de Ordenação de Vetores
 */
public class Ordenacao implements InterfaceOrdenacao{

    //Método Construtor
    public Ordenacao(){}

    /**
     * Método para criar um vetor com valores Aleatórios
     * Serve para depois poder usar os métodos de ordenação
     */
    public int[] geraVetor(int tamanho,int limiteValores){
        //variáveis
        int valor_random; //variavel para armazenar o valor random
        int[] vetor = null;
        int contador = 0; //contador que serve para andar até o tamanho do vetor

        //Variavel randomica para ser criado um valor Random dentro do 
        Random random = new Random();

        //Se o tamanho do vetor for maior ou igual a zero
        if(tamanho >= 0){
            //criamos o vetor com o tamanho entrado em parâmetro
            vetor = new int[tamanho];

            //enquanto o contador for menor que o tamanho
            //ele irá adicionar o valor randomico na variavel valor_random
            while(contador < tamanho){
                //pegando o valor randomico dentro da variavel de valor randomico
                valor_random = random.nextInt(limiteValores)+1;
                //pegamos o contador(no inicio zerado) para colocar o valor randomico
                //dentro da posição do vetor
                vetor[contador++] = valor_random;
            }
        }
        return vetor;

    }

    /**
     * Método de Ordenação do BubbleSort
     */
    public void bubblesort(int[] vetor){
        //criamos um auxiliar
        int auxiliar = 0;
        //criamos um for que anda pelo vetor até o fim
        for(int verificador1 = 0 ; verificador1 < vetor.length ; verificador1++){
            //dentro dele criamos um for que irá andar até o penultimo
            for(int verificador2 = 0 ; verificador2 < vetor.length-1 ; verificador2++){
                //verificamos se a posição do verificador2 é maior que o proximo
                if(vetor[verificador2] > vetor[verificador2+1]){
                    //o auxiliar recebe o valor do vetor[verificador2]
                    auxiliar = vetor[verificador2];
                    //o vetor maior(vetor[verificador2]) recebe o valor do proximo
                    vetor[verificador2] = vetor[verificador2+1];
                    //o proximo vetor recebe o valor armazenado do auxiliar
                    vetor[verificador2+1] = auxiliar;
                }
                
            }
        }

    }

    /**
     * Método de Ordenação do InsertionSort
     */
    public void insertionSort(int[] vetor){
        //variaveis para andar pelo vetor
        int posicao,contador,chave;
        //posicao serve para pegar uma posição especifica do vetor
        //contador serve para andar pelo vetor
        //chave serve para armazenar o valor que queremos trocar
        //criado um for para andar pelo vetor da segunda posição em diante
        for(contador = 1 ; contador < vetor.length; contador++){
            //pegamos o valor da posição do contador
            chave = vetor[contador];
            //pegamos a posição do vetor anterior e armazenamos na posição
            posicao = contador-1;
            //enquanto a posição for maior que zero e o valor for maior que o valor da chave
            while((posicao >= 0) && (vetor[posicao] > chave)){
                //armazenamos o valor da posição do vetor no proximo
                vetor[posicao+1] = vetor[posicao];
                //diminuimos o valor da posição
                posicao = posicao -1;
            }
            //armazenamos no fina o valor da chave na proxima posicao do vetor
            vetor[posicao+1] = chave;

        }
    }

    /**
     * Método de Ordenação do MergeSort
     */
    public void mergeSort(int[] vetor){
        //chamamos o segundo método do mergesort
        mergeSort(vetor, 0, vetor.length-1);
    }

    /**
     * Segundo método do MergeSort chamado pelo outro MergeSort
     */
    public void mergeSort(int[] vetor,int inicio,int fim){
        //inicio e fim são para verificar o tamanho do vetor
        //se o inicio for menor que o fim
        if(inicio < fim){
            //o meio do vetor é a soma do inicio e do fim divido por 2
            int meio = (inicio + fim)/2;
            //é chamado por recursão o segundo metodo do Mergesort duas vezes
            mergeSort(vetor,inicio,meio);
            mergeSort(vetor, meio+1, fim);
            //chamamos o terceiro metodo para mergeSort chamado merge
            merge(vetor,inicio,meio,fim);
        }
    }

    /**
     * Método privado de Merge para MergeSort
     */
    private void merge(int[] vetor,int inicio,int meio,int fim){

    }
    /**
     * Método de Ordenação QuickSort
     */
    public void quickSort(int[] vetor, int menor, int maior){
        //criamos uma variavel para armazenarmos qual o meio do vetor
        int meio;
        //se a subtração do maior com o menor for maior que zero
        if((maior-menor) > 0){
            //o meio é o resultado do método divide
            meio = divide(vetor,menor,maior);
            //chamamos por recursão o metodo quickSort mais duas vezes
            quickSort(vetor, menor, meio-1);
            quickSort(vetor, meio+1, maior);
        }
    }
    /**
     * Método de divisão auxiliar ao Quicksort
     */
    public int divide(int[] vetor,int menor,int maior){
        //criamos as variaveis de uso
        int posicao,maiorAtual,primeiroMaior;
        //posicao é a posição desejada do vetor
        //maiorAtual é o valor do maior da entrada
        //primeiroMaior é armazenado o menor, que anteriormente ja foi o maior
        primeiroMaior = menor;
        maiorAtual = maior;
        //a posição do vetor começa pela posição do menor da entrada e vai até o maior
        //fazendo assim uma verificação se o valor da posição atual  é menor que o valor da maior posição
        for(posicao = menor ; posicao < maior ; posicao++){
            //se o valor da posição neste momento for maior que a maxima posição do vetor
            if(vetor[posicao] < vetor[maiorAtual]){
                //é chamado o método troca
                troca(vetor,posicao,primeiroMaior);
                //o valor do primeiro maior é atualizado
                primeiroMaior = primeiroMaior+1;
            }
        }
        //chamamos o método de troca de novo
        troca(vetor,maiorAtual,primeiroMaior);
        //retorna o valor do primeiroMaior
        return primeiroMaior;
    }


}