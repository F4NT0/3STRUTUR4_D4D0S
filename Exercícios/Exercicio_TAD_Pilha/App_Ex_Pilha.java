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
        Calc_Pilha calc = new Calc_Pilha(pilha);

        Scanner in = new Scanner(System.in);
        boolean sistema = false;
        while(sistema == false){
            System.out.println("Entrada: ");
            String entrada = in.nextLine();
            if(calc.number(entrada)){
                Double valor = Double.parseDouble(entrada);
                pilha.push(valor);
            }else{
                char operador = entrada.charAt(0);
                switch(operador){
                    case '*': 
                    calc.mult();
                          break;
                    case '/': 
                    calc.div();
                            break;
                    case '-': 
                    calc.sub();
                        break;
                    case '+': 
                    calc.sum();
                          break;
                    case '=': 
                    System.out.println(calc.igual());
                          sistema = true;
                          break;
                    default: System.out.println("Este não é um operador Válido!");
                }
            }
        }     
        
    }
}