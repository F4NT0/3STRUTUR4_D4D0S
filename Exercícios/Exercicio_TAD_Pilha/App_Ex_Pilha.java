import java.util.Scanner;
/**
 * Classe Teste para a Calculadora
 * coloca um numero,um operador e outro numero, um por um
 * quando colocar o simbolo de igual(=) ele devolve o resultado
 */
public class App_Ex_Pilha{
    public static void main(String[] args){

        //Iniciando a Classe De Pilha
        Pilha_Ex pilha = new Pilha_Ex<Double>();
        //iniciando Calculadora
        Calc_Pilha calc = new Calc_Pilha(pilha);

        Scanner in = new Scanner(System.in);
        boolean sistema = false;

        System.out.println("--------------------------------");
        System.out.println("BEM VINDO A CALCULADORA DE PILHA");
        System.out.println("--------------------------------");

        calc.imprime();
        while(sistema == false){
            System.out.print("Entrada: ");
            String entrada = in.nextLine();
            if(calc.number(entrada)){
                Double valor = Double.parseDouble(entrada);
                pilha.push(valor);
                System.out.println("Valor Adicionado na Pilha!");
            }else{
                char operador = entrada.charAt(0);
                switch(operador){
                    case '*': 
                    calc.mult();
                    System.out.println("Multiplicação Foi Realizada!");
                          break;
                    case '/': 
                    calc.div();
                    System.out.println("Divisão Foi Realizada!");
                            break;
                    case '-': 
                    calc.sub();
                    System.out.println("Subtração Foi Realizada!");
                        break;
                    case '+': 
                    calc.sum();
                    System.out.println("Adição Foi Realizada!");
                          break;
                    case '=': 
                    System.out.println("O resultado é " + calc.igual());
                          sistema = true;
                          break;
                    default: System.out.println("Este não é um operador Válido!");
                }
            }
        }     
        
    }
}