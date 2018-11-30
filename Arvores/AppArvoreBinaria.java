public class AppArvoreBinaria{
    public static void main(String args[]){
        Integer[] vetor = {1,2,3,4,5,6,7,8,9,10};
        arvoreBinaria<Integer> teste = new arvoreBinaria<Integer>(vetor);
        //teste do caminhamento prefixado
        LinkedList<Integer> valor = new LinkedList<Integer>();
        valor = teste.prefixado();
        for(int i = 0 ; i < valor.tamanho(); i++){
            System.out.println(valor.pegar(i));
        }


    }
}