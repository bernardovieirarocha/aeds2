package exercicios.beecrowd.FilaSus;

import java.util.ArrayList;
import java.util.Scanner;

class Paciente {
    public int ChegadaHoras;
    public int ChegadaMinutos;
    public int tempoLimiteCritico;
    public Paciente(int horas, int minutos, int tempoLimiteCritico) {
        this.ChegadaHoras = horas;
        this.ChegadaMinutos = minutos;
        this.tempoLimiteCritico = tempoLimiteCritico;
    }
}

public class FilaSus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       while (sc.hasNext()){
           int qtdPacientes = sc.nextInt();
           ArrayList<Paciente> pacientes = new ArrayList<>();

           for (int i = 0; i < qtdPacientes; i++) {
               int horas = sc.nextInt();
               int minutos = sc.nextInt();
               int tempoLimiteCritico = sc.nextInt();
               pacientes.add(new Paciente(horas, minutos, tempoLimiteCritico));
           }

           int foraDoLimite = 0;

           int tempoChegadaOriginal = pacientes.get(0).ChegadaHoras * 60 + pacientes.get(0).ChegadaMinutos;
           int quantosAtendimentos = 1;
           pacientes.remove(0);
           for (Paciente pc : pacientes) {
               int tempoChegadaAtual = pc.ChegadaHoras * 60 + pc.ChegadaMinutos;
               int tempoAtendimento = quantosAtendimentos * 30 + tempoChegadaOriginal;

               if ( tempoChegadaAtual + pc.tempoLimiteCritico < tempoAtendimento ) {
                   foraDoLimite++;
               }

               quantosAtendimentos++;
           }
            System.out.println(foraDoLimite);
       }

    }

}
