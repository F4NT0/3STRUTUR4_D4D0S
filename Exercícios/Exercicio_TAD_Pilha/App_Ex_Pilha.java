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
        Calc_Pilha calc = new Calc_Pilha();

        Scanner in = new Scanner(System.in);
        boolean sistema = true;
        while(sistema){
            System.out.println("Entrada: ");
            String entrada = in.nextLine();
            if(calc.number(entrada)){
                Double valor = Double.parseDouble(entrada);
                pilha.push(valor);
            }else{
                char operador = entrada.charAt(0);
                switch(operador){
                    case '*': calc.mult();
                          break;
                    case '/': calc.div();
                          break;
                    case '-': calc.sub();
                          break;
                    case '+': calc.sum();
                          break;
                    case '=': calc.igual();
                          sistema = false;
                          break;
                    default: System.out.println("Este não é um operador Válido!");
                }
            }
            sistema = true;
        }     
        
    }
}