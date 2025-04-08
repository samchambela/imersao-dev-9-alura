import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SaltoNoVidroWhile {

    static Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    static List<String> jogadores = new ArrayList<String>();
    static List<Integer> placarJogadores = new ArrayList<>();

    public static void salvarDadosJogadores(String nomeJogador, int placarJogador) {
        jogadores.add(nomeJogador);
        placarJogadores.add(placarJogador);
    }

    public static void main(String[] args) {

        List<Integer> escolhasPossiveis = List.of(1, 2, 3);
        int rodada = 1;
        boolean escolhaEhValida;
        int escolhaJogador;
        int pisoQuebrado;
        char jogarNovamente = 'S';

        System.out.println("Escolha com sabedoria e sobreviva ao desafio!");
        System.out.println("Insira seu nome:");
        String nomeJogador = scanner.next();

        do {
            escolhaEhValida = false;
            while (!escolhaEhValida && rodada <= 3) {
                System.out.println("Rodada: " + rodada);
                System.out.println("Nível " + rodada + ", vidro (1, 2 ou 3)?");
                escolhaJogador = scanner.nextInt();
                pisoQuebrado = (int) (Math.floor(Math.random() * 3)) + 1;
                escolhaEhValida = escolhasPossiveis.contains(escolhaJogador);

                if (escolhaEhValida) {
                    if (escolhaJogador == pisoQuebrado) {
                        System.out.println("Vidro quebrou! O jogo acabou pra você.");
                        salvarDadosJogadores(nomeJogador, rodada-1);
                        System.out.println(nomeJogador + rodada);
                        System.out.println("Gostaria de jogar de novo? S / N");
                        jogarNovamente = scanner.next().toUpperCase().charAt(0);
                        while (jogarNovamente != 'S' && jogarNovamente != 'N') {
                            System.out.println("Gostaria de jogar de novo? S / N");
                            jogarNovamente = scanner.next().toUpperCase().charAt(0);
                        }
                        rodada = 1;
                        break;
                    } else {
                        if (rodada < 3) {
                            System.out.println("Você sobreviveu esta rodada! " + "O piso frágil era o " + pisoQuebrado+".");
                            rodada++;
                        } else {
                            System.out.println("Você sobreviveu até o final! " + "O piso frágil era o " + pisoQuebrado+".");
                            salvarDadosJogadores(nomeJogador, rodada-1);
                            System.out.println(nomeJogador + rodada);
                            System.out.println("Gostaria de jogar de novo? S / N");
                            jogarNovamente = scanner.next().toUpperCase().charAt(0);
                            while (jogarNovamente != 'S' && jogarNovamente != 'N') {
                                System.out.println("Gostaria de jogar de novo? S / N");
                                jogarNovamente = scanner.next().toUpperCase().charAt(0);
                            }
                            rodada = 1;
                            break;
                        }
                    }
                } else {
                    System.out.println("Você escorregou e caiu.");
                    salvarDadosJogadores(nomeJogador, rodada-1);
                    System.out.println(nomeJogador + rodada);
                    System.out.println("Gostaria de jogar de novo? S / N");
                    jogarNovamente = scanner.next().toUpperCase().charAt(0);
                    while (jogarNovamente != 'S' && jogarNovamente != 'N') {
                        System.out.println("Gostaria de jogar de novo? S / N");
                        jogarNovamente = scanner.next().toUpperCase().charAt(0);
                    }
                    rodada = 1;
                    break;
                }
            }
        } while (jogarNovamente == 'S');
    }
}

//guardar(ok) EXIBIR a informação de quantas rodadas conseguiu sobreviver