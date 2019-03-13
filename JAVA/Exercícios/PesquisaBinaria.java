/**
 * ALGORITMO DE PESQUISA BINÁRIA EM UM VETOR ORDENADO
 * -> Deve retornar a posição se um valor específico esta dentro do vetor
 * -> Se não existir o valor no vetor, retorna -1
 *
 *  ESTRATÉGIA: 1) Calcula a posição central do vetor
 *  		2) Se o valor desejado for menor que o elemento do centro:
 *  			2.a) Repete o procedimento para metade inferior do vetor
 *  			2.b) Senão, repete para a metade superior do vetor 
 */

import java.util.Scanner;

public class PesquisaBinaria{
	//Método da Pesquisa Binária
	public static int binarySearch(int[] vetor, int valor){
		int menorPos = 0; //menor posição do vetor
		int maiorPos = vetor.length-1; //maior posição do vetor, depois do 0
		int meio = menorPos + ((maiorPos-menorPos)/2);//Valor do meio do vetor
		while(menorPos <= maiorPos){
			if(vetor[meio] > valor){ //Se o valor for maior que meio
				maiorPos = meio - 1;
			}else if(vetor[meio] < valor){ //Se o valor for menor que meio
				menorPos = meio + 1;
			}else{return meio;} //Se o valor for igual ao meio

			meio = menorPos + ((maiorPos-menorPos)/2); //Novo calculo do meio

		}
		return -1;
	}

	//TESTE
	public static void main(String[] args){
	   Scanner in = new Scanner(System.in);
	   	System.out.println("Entre um valor para pesquisar: ");
	   	 int valor = in.nextInt();

		 //Vetor
		 int[] vetor = {1,2,3,4,5,6,7,8,9,10};
		 
		 //Chamada do método
		 int saida = binarySearch(vetor,valor);

		 System.out.println("Posição: " + saida);
	}
} 
