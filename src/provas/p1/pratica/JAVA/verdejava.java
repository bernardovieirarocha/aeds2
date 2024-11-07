package provas.p1.pratica.JAVA;

import java.util.Scanner;
import java.util.Stack;

public class verdejava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdExpressoes = sc.nextInt();
        // Consumir o \n de input do usuario
        sc.nextLine();
        
        boolean ehvalido = true;
        for (int i =0 ; i < qtdExpressoes; i++){
            String expressao = sc.nextLine();
            
            // booeleano controlador para fechamento sem abertura
            ehvalido = true;

            // Criacao da pilha para cada um dos caracteres permitidos
            Stack<Character> pilhaParenteses = new Stack<>();
            Stack<Character> pilhaColchetes = new Stack<>();
            Stack<Character> pilhaChaves = new Stack<>();

            for (int j = 0 ; j < expressao.length() ; j++){
                
                // Empilha caso encontra um parenteses aberto
                if (expressao.charAt(j) == '('){
                    pilhaParenteses.push('(');
                } 
                
                // Invalida a expressao caso haja um fechamento sem abertura previa
                if (expressao.charAt(j) == ')' && pilhaParenteses.isEmpty()) {
                    ehvalido = false;
                } 

                // Desempilha caso encontre o fechamento dada uma abertura previamente encontrada.
                if (expressao.charAt(j) == ')' && !pilhaParenteses.isEmpty()){
                    pilhaParenteses.pop();
                }

                // Empilha caso encontra um colchetes aberto
                if (expressao.charAt(j) == '['){
                    pilhaColchetes.push('[');
                } 
                
                // Invalida a expressao caso haja um fechamento sem abertura previa
                if (expressao.charAt(j) == ']' && pilhaColchetes.isEmpty()) {
                    ehvalido = false;
                } 
                
                // Desempilha caso encontre o fechamento dada uma abertura previamente encontrada.
                if (expressao.charAt(j) == ']' && !pilhaColchetes.isEmpty()){
                    pilhaColchetes.pop();
                }
                
                // Empilha caso encontra um chaves aberto
                if (expressao.charAt(j) == '{'){
                    pilhaChaves.push('{');
                } 
                // Invalida a expressao caso haja um fechamento sem abertura previa
                if (expressao.charAt(j) == '}' && pilhaChaves.isEmpty()) {
                    ehvalido = false;
                } 
                // Desempilha caso encontre o fechamento dada uma abertura previamente encontrada.
                if (expressao.charAt(j) == '}' && !pilhaChaves.isEmpty()){
                    pilhaChaves.pop();
                }

            }
            
            if (ehvalido && pilhaParenteses.isEmpty() && pilhaColchetes.isEmpty() && pilhaChaves.isEmpty()) {
                System.out.println("S");
            } else {
                System.out.println("N");
            }
            pilhaChaves.clear();
            pilhaParenteses.clear();
            pilhaColchetes.clear();
        }
        
    }
}