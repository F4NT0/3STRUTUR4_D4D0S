import com.sun.org.apache.xerces.internal.impl.dv.xs.IntegerDV;

/**
 * Classe da Calculadora que sua Pilha
 * 
 * Simbolos: =,+,-,*,/
 * estes Simbolos devem fazer com que peguem dois valores da pilha e os calcule
 * Todo número entrado deve ser armazenado dentro da pilha, um por um
 * os dois valores no topo da lista devem ser tirados quando um dos simbolos acima são chamados
 * 
 */
public class Calc_Pilha{
    Pilha_Ex pilha = new Pilha_Ex<Integer>();
    //método construtor
    public Calc_Pilha(){}


    /**
     * Método para calcular uma multiplicação usando pilha
     */
    public int mult(){
        int valor1 = pilha.pop();
        int valor2 = pilha.pop();
        int mult = valor1 * valor2;
        pilha.push(mult);
        return mult;
    }

    /**
     * Método para calcular uma soma de valores
     */
    public int sum(){
    }

    /**
     * Método para calcular um subtração de valores
     */
    public int sub(int valor1,int valor2){return valor1-valor2;}

    /**
     * Método para calcular uma divisão de valores
     */
    public int div(int valor1,int valor2){return valor1/valor2;}

    /**
     * Método para pegar um valor do topo da pilha
     */
    public int pegarTopo(){return pilha.topo();}

    /**
     * Método para selecionar qual operador será escolhido
     */



}