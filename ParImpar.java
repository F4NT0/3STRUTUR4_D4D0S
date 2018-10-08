/**
 *	DADO UM VETOR COM NÚMEROS PARES E IMPARES, ESCREVA UM MÉTODO
 *
 *	1) PARA COLOCAR TODOS OS NÚMEROS PARES Á FRENTE DO VETOR
 *	2) PARA COLOCAR TODOS OS NÚMEROS IMPARES DEPOIS DO VETOR
 *	3) UM MÉTODO COM VETOR AUXILIAR
 *	4) UM MÉTODO SEM VETOR AUXILIAR
 */
public class ParImpar {
	//MÉTODO COM VETOR AUXILIAR
	public static int[] separaParImpar(int[] vetor){
		int cont = 0;
		int i = 0;
		int j = 0;
		int[] impar = new int[vetor.length/2];
		int[] par = new int[vetor.length/2];
		int[] vetAux = new int[vetor.length];
		while(cont < vetor.length){
			if(vetor[cont] % 2 == 0){
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
		for(int p = 0; p < impar.length ; p++){
			vetAux[maxPar] = impar[p];
			maxPar++;
		}
		return vetAux;	
	}

	
	public static void main(String[] args){
			int[] vetor = {1,2,3,4,5,6,7,8,9,10};
			int[] parImpar = separaParImpar(vetor);

			for(int i = 0 ; i < parImpar.length ; i++){
			System.out.println(parImpar[i]);
			}
	
		}
 }
