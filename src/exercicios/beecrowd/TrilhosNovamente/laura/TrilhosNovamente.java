package exercicios.beecrowd.TrilhosNovamente.laura;

import java.util.*;

public class TrilhosNovamente
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> pilhaInicial = new Stack<>();
        Stack<Character> pilhaFinal = new Stack<>();

        int n;

        while((n = sc.nextInt()) != 0) {
            sc.nextLine();
            String stringInicial = sc.nextLine();
            //colocando todos os elementos na pilha inicial
            for(int i=0; i<n; i++) {
                pilhaInicial.push(stringInicial.charAt(i));
            }

            String stringFinal = sc.nextLine();

            for(int i=0; i<n; i++) {
                //enquanto a pilha inicial nao está vazia
                if(!pilhaInicial.isEmpty()) {
                    for(int j=0; j < n; j++) {
                        //é necessario pesquisar na string inicial a letra necessaria da string final
                        if(stringInicial.charAt(j) != stringFinal.charAt(i)) {
                            pilhaFinal.push(pilhaInicial.elementAt(j));
                            pilhaInicial.pop();
                            System.out.print("I");
                        }
                        else {
                            pilhaFinal.push(pilhaInicial.elementAt(j));
                            pilhaInicial.pop();
                            System.out.print("I");
                            pilhaFinal.pop();
                            System.out.print("R");
                            break; //passar para a proxima iteracao de i
                        }
                    }
                }
                //agora todos os elementos estao na estacao e podem ser retirados para o outro trem

                else if(!pilhaFinal.isEmpty()) {
                    //enquatno a pilha final n está vazia
                    if(pilhaFinal.lastElement() == stringFinal.charAt(i)) {
                        pilhaFinal.pop();
                        System.out.print("R");
                        break;
                    }
                }
            }
        }
    }
}
