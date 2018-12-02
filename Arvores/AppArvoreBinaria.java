public class AppArvoreBinaria{
    public static void main(String args[]){
        Integer[] vetor = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArvoreBinaria<Integer> teste = new ArvoreBinaria<Integer>(vetor);
        //teste do caminhamento prefixado
        LinkedList<Integer> valor = new LinkedList<Integer>();
        valor = teste.prefixado();
        for(int i = 0 ; i < valor.tamanho(); i++){
            System.out.println(valor.pegar(i));
        }


    }
}