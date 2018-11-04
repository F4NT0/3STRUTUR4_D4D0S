import java.util.Scanner;
/**
 * Classe Teste para a Calculadora
 * coloca um numero,um operador e outro numero, um por um
 * quando colocar o simbolo de igual(=) ele devolve o resultado
 */
public class App_Ex_Pilha{
    public static void main(String[] args){

        //Iniciando a Classe De Pilha
        Pilha_Ex pilha = new Pilha_Ex<Integer>();
        Calc_Pilha calc = new Calc_Pilha();

        Scanner in = new Scanner(system.in);
        boolean sistema = true;
        System.out.println("Entrada: ");
        String entrada = in.next();
        if(calc.number(entrada){
            pilha.push(entrada);
        }
        if(entrada.hasNext()){
            switch(entrada){
                case "*": calc.mult();
                          break;
                case "/": calc.div();
                          break;
                case "-": calc.sub();
                          break;
                case "+": calc.sum();
                          break;
                case "=": calc.igual();
                          sistema = false;
                          break;
                default: System.out.println("Este não é um operador Válido!");
                        
            }
        }
    }
}