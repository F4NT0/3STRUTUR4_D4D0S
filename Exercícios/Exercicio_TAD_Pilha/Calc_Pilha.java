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
    //variaveis
    Pilha_Ex<Double> pilha;
    //método construtor
    public Calc_Pilha(Pilha_Ex<Double> pilha){
        this.pilha = pilha;
    }


    /**
     * Método para calcular uma multiplicação usando pilha
     * O valor é armazenado de volta na pilha
     */
    public void mult(){
        double valor1 = pilha.pop();
        double valor2 = pilha.pop();
        double mult = valor1 * valor2;
        pilha.push(mult);
    }

    /**
     * Método para calcular uma soma de valores usando pilha
     * O valor é armazenado de volta na pilha
     */
    public void sum(){
        double valor1 = pilha.pop();
        double valor2 = pilha.pop();
        double sum = valor1 + valor2;
        pilha.push(sum);
    }

    /**
     * Método para calcular um subtração de valores usando pilha
     * o segundo valor retirado é o primeiro operando
     * o primeiro valor retirado é o segundo operando
     */
    public void sub(){
        double valor1 = pilha.pop();
        double valor2 = pilha.pop();
        double sub = valor2 - valor1;
        pilha.push(sub);
    }

    /**
     * Método para calcular uma divisão de valores
     */
    public void div(){
        double valor1 = pilha.pop();
        double valor2 = pilha.pop();
        if(valor1 < valor2){
            double div = valor2/valor1; 
        }
        pilha.push(div);
    }

    /**
     * Método de igualdade para retornar o valor final que está na pilha
     */
    public double igual(){
        return pilha.topo();
    }

    /**
     * Método para verificar se a entrada é um número
     */
    public boolean number(String s){
        //try-catch caso não for um número
        try{
            Double valor = Double.parseDouble(s); 
        }
        catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    /**
     * Método de Print para info do programa
     */
    public void imprime(){
        System.out.println("Informa\u00c7\u00e3o: ");
        System.out.println("N\u00fameros ser\u00e3o adicionados na Pilha");
        System.out.println("Operadores far\u00e3o os C\u00e1lculos e ser\u00e1 armazenado na Pilha");
        System.out.println("Operadores V\u00e1lidos: \n* : Multiplica\u00c7\u00e3o \n/: Divis\u00e3o \n+: Adi\u00c7\u00e3o \n-: Subtra\u00c7\u00e3o");
        System.out.println("Para ver os resultados, selecione o =");
    }
}