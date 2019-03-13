/**
 * BEM VINDO A BIBLIOTECA DE MÉTODOS DE ALGORITMOS E ESTRUTURA DE DADOS
 * AQUI SE ENCONTRA TODOS OS MÉTODOS FEITOS DESTE REPOSITÓRIO
 */

public class MetodosBiblioteca{
	/*
	 * MÉTODO DE PESQUISA BINÁRIA
	 */
	public static int binarySearch(int[] vetor, int valor){
		int menorPos = 0 ; //MENOR POSIÇÃO DO VETOR
		int maiorPos = vetor.length - 1; //MAIOR POSIÇÃO DO VETOR
		int meio = menorPos + ((maiorPos - menorPos)/2);//VALOR DO MEIO

		
		while(menorPos <= maiorPos){
			//SE O VALOR FOR MAIOR QUE MEIO
			if(vetor[meio] > valor){maiorPos = meio - 1;}
			//SE O VALOR FOR MENOR QUE O MEIO
			else if(vetor[meio] < valor){menorPos = meio + 1;}
			//SE O VALOR FOR O MEIO
			else{return meio;}

			meio = menorPos + ((maiorPos - menorPos)/2);
		}
		return -1; //SE NÃO TIVER O VALOR NO VETOR
	}

	/*
	 * MÉTODO PARA ORDENAR NA FORMA PAR-IMPAR VETORES ORDENADOS
	 */
	public static int[] separaParImpar(int[] vetor){
		int cont = 0;
		int i = 0;
		int j = 0;

		int[] impar = new int[vetor.length/2];
		int[] par = new int[vetor.length/2];
		int[] vetAux = new int[vetor.length];

		while(cont < vetor.length){
			if(vetor[cont] % 2 == 0 ){
				par[i] = vetor[cont];
				i++;
			}
			if(vetor[cont] % 2 == 1){
				impar[j] = vetor[cont];
				j++;
			}
			cont++;
		}

		for(int p = 0 ; p < par.length ; p++){
			vetAux[p] = par[p];
		}

		int maxPar = par.length;

		for(int p = 0 ; p < impar.length ; p++){
			vetAux[maxPar] = impar[p];
			maxPar++;
		}
		return vetAux;
	}

} 
