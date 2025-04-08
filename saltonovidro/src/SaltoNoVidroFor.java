import java.util.Locale;
import java.util.Scanner;

public class SaltoNoVidroFor {

    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {

        int escolhaJogador;
        int pisoQuebrado;
        int ganhou = 0; //flag 0 = ganhou | 1 = perdeu.

        System.out.println("Escolha com sabedoria e sobreviva ao desafio!");

        for (int rodada = 1; rodada <= 3; rodada++) {
            System.out.println("Nível " + rodada + ", vidro (1, 2 ou 3)?");
            escolhaJogador = scanner.nextInt();
            pisoQuebrado = (int) (Math.floor(Math.random() * 3)) + 1;

            if (escolhaJogador == pisoQuebrado) {
                System.out.println("Vidro quebrou! O jogo acabou pra você.");
                rodada = 1000;
                ganhou = 1;
            } else {
                System.out.println("Você sobreviveu esta rodada!");
            }
        }
        if (ganhou == 0) {
            System.out.println("Você sobreviveu até o final!");
        }
    }
}