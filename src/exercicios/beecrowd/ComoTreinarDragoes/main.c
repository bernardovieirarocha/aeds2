#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int *numbers = (int *) malloc( 1000 * sizeof(int) );
    int n_atual;
    int qtd_numeros = 0;
    do
    {
        scanf("%d", &n_atual);
        numbers[qtd_numeros] = n_atual;
    } while (numbers[qtd_numeros++] != 0);
    
    for (int i = 0 ; i < qtd_numeros -1 ; ++i) {
        if (numbers[i] % 2 == 0) {
            printf("P\n");
        } else {
            printf("I\n");
        }
    }
  

    return 0;
}

/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////


/////

// #include <stdio.h>
// #include <stdlib.h>

// struct Dragao {
//     int diasParaTreinar;
//     int multaPorDiaEspera;
// } typedef Dragao;

// // Custom sorting function to sort by the T/F ratio in ascending order
// void insertionSort(Dragao *dragoes, int n) {
//     for (int i = 1; i < n; i++) {
//         Dragao key = dragoes[i];
//         int j = i - 1;
        
//         // Calculate the ratio T/F for the current dragon
//         double keyRatio = (double)key.diasParaTreinar / key.multaPorDiaEspera;

//         // Move elements with a higher T/F ratio to the right
//         while (j >= 0) {
//             double currentRatio = (double)dragoes[j].diasParaTreinar / dragoes[j].multaPorDiaEspera;
//             if (currentRatio <= keyRatio) {
//                 break;
//             }
//             dragoes[j + 1] = dragoes[j];
//             j--;
//         }
//         dragoes[j + 1] = key;
//     }
// }

// int main() {
//     Dragao* dragoes = malloc(sizeof(Dragao) * 100000);
//     int i = 0;

//     // Reading data until EOF
//     while (scanf("%d %d", &dragoes[i].diasParaTreinar, &dragoes[i].multaPorDiaEspera) == 2) {
//         i++;
//     }

//     // Sorting dragons by T/F ratio in ascending order
//     insertionSort(dragoes, i);

//     long long totalMulta = 0;
//     long long tempoTotal = 0;

//     // Calculating the minimum fine with dragons in optimal order
//     for (int j = 0; j < i; j++) {
//         totalMulta += tempoTotal * dragoes[j].multaPorDiaEspera;
//         tempoTotal += dragoes[j].diasParaTreinar;
//     }

//     printf("%lld\n", totalMulta);
    
//     free(dragoes);  // Freeing allocated memory
//     return 0;
// }


// package exercicios.beecrowd.InfixaPosfixa;

// import java.util.Stack;

// public class InfixaPosfixa {

//     public static int precedence(char c) {
//         switch (c) {
//             case '+':
//             case '-':
//                 return 1;
//             case '*':
//             case '/':
//                 return 2;
//             case '^':
//                 return 3;
//         }
//         return -1;
//     }

//     public static void main(String[] args) {
//         Stack<Character> stack = new Stack<>();
//         String infix = "(2*4/a^b)/(2*c)";
//         StringBuilder postfix = new StringBuilder();

//         for (int i = 0; i < infix.length(); i++) {
//             char c = infix.charAt(i);
//             if (Character.isLetterOrDigit(c)) {
//                 postfix.append(c);
//             } else if (c == '(') {
//                 stack.push(c);
//             } else if (c == ')') {
//                 while (!stack.isEmpty() && stack.peek() != '(') {
//                     postfix.append(stack.pop());
//                 }
//                 if (!stack.isEmpty() && stack.peek() != '(') {
//                     return; // invalid expression
//                 } else {
//                     stack.pop();
//                 }
//             } else {
//                 while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
//                     postfix.append(stack.pop());
//                 }
//                 stack.push(c);
//             }
//         }

//         // Pop all the remaining operators from the stack
//         while (!stack.isEmpty()) {
//             if (stack.peek() == '(') {
//                 return; // invalid expression
//             }
//             postfix.append(stack.pop());
//         }

//         System.out.println(postfix.toString());
//     }
// }


// package exercicios.beecrowd.FilaSus;

// import java.util.ArrayList;
// import java.util.Scanner;

// class Paciente {
//     public int ChegadaHoras;
//     public int ChegadaMinutos;
//     public int tempoLimiteCritico;
//     public Paciente(int horas, int minutos, int tempoLimiteCritico) {
//         this.ChegadaHoras = horas;
//         this.ChegadaMinutos = minutos;
//         this.tempoLimiteCritico = tempoLimiteCritico;
//     }
// }

// public class FilaSus {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//        while (sc.hasNext()){
//            int qtdPacientes = sc.nextInt();
//            ArrayList<Paciente> pacientes = new ArrayList<>();

//            for (int i = 0; i < qtdPacientes; i++) {
//                int horas = sc.nextInt();
//                int minutos = sc.nextInt();
//                int tempoLimiteCritico = sc.nextInt();
//                pacientes.add(new Paciente(horas, minutos, tempoLimiteCritico));
//            }

//            int foraDoLimite = 0;

//            int tempoChegadaOriginal = pacientes.get(0).ChegadaHoras * 60 + pacientes.get(0).ChegadaMinutos;
//            int quantosAtendimentos = 1;
//            pacientes.remove(0);
//            for (Paciente pc : pacientes) {
//                int tempoChegadaAtual = pc.ChegadaHoras * 60 + pc.ChegadaMinutos;
//                int tempoAtendimento = quantosAtendimentos * 30 + tempoChegadaOriginal;

//                if ( tempoChegadaAtual + pc.tempoLimiteCritico < tempoAtendimento ) {
//                    foraDoLimite++;
//                }

//                quantosAtendimentos++;
//            }
//             System.out.println(foraDoLimite);
//        }

//     }

// }

// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int N = sc.nextInt(); // número de motoristas
//         int K = sc.nextInt(); // número de veículos que o estacionamento comporta
//         Stack<Integer> estacionamento = new Stack<>(); // Pilha para controlar os horários de saída dos carros
//         boolean podeEstacionarTodos = true; // Controle para verificar se todos motoristas conseguem estacionar
        
//         // Condição de parada (último caso de teste com N = 0 e K = 0)
//         while (N != 0 && K != 0) {

//             for (int i = 0; i < N; i++) {
//                 int hEntrada = sc.nextInt(); // Hora de chegada do motorista
//                 int hSaida = sc.nextInt();   // Hora de saída do motorista

//                 // Remove carros que saem antes do motorista atual entrar
//                 while (!estacionamento.isEmpty() && estacionamento.peek() <= hEntrada) {
//                     estacionamento.pop(); // Remove o último carro que saiu antes da chegada atual
//                 }

//                 // Verifica se o estacionamento está cheio
//                 if (estacionamento.size() >= K) {
//                     podeEstacionarTodos = false; // Estacionamento lotado, motorista não consegue estacionar
//                 } else {
//                     // Verifica se o carro atual poderá sair sem bloquear a saída de outro carro
//                     if (!estacionamento.isEmpty() && estacionamento.peek() < hSaida) {
//                         podeEstacionarTodos = false; // Carro não poderá sair sem bloquear outro
//                     } else {
//                         estacionamento.push(hSaida); // Adiciona o horário de saída do carro na pilha
//                     }
//                 }
//             }

//             // Imprime "Sim" se todos motoristas conseguiram estacionar, "Nao" caso contrário
//             if (podeEstacionarTodos) {
//                 System.out.println("Sim");
//             } else {
//                 System.out.println("Nao");
//             }

//             // Lê o próximo caso de teste
//             N = sc.nextInt();
//             K = sc.nextInt();
//         }

//         sc.close();
//     }
// }

