import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class JankenPon {
    public static String escolherJogadaAleatoria(String[] escolhasPossiveis){
        Random random = new Random();
        int indiceAleatorio = random.nextInt(escolhasPossiveis.length);
        return escolhasPossiveis[indiceAleatorio];
    }
    public static void main(String[] args) {
        int idade;
        String[] escolhasPossiveis = {"PEDRA", "PAPEL", "TESOURA"};
        String escolhaJogador;
        boolean escolhaEhValida;
        char jogarNovamente;
        int contadorVitorias = 0;
        int contadorDerrotas = 0;
        int contadorEmpates = 0;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite sua idade");
        idade = scanner.nextInt();


        if (idade >= 18) {
            System.out.println("Bem-vindo ao Janken Pon!");

            do {
                escolhaEhValida = false;
                while (!escolhaEhValida) {
                    System.out.println("Escolha sua jogada: [PEDRA] | [PAPEL] | [TESOURA]");
                    escolhaJogador = scanner.next().toUpperCase();
                    escolhaEhValida = Arrays.asList(escolhasPossiveis).contains(escolhaJogador);
                    if (escolhaEhValida) {
                        System.out.println("Jogada com sucesso!");
                        String escolhaComputador = escolherJogadaAleatoria(escolhasPossiveis);
                        System.out.println("O computador escolheu " + escolhaComputador);
                        if (escolhaJogador.equals(escolhaComputador)) {
                            System.out.println("Empate!");
                            contadorEmpates++;
                        }
                        if (escolhaJogador.equals("PEDRA")) {
                            if (escolhaComputador.equals("PAPEL")) {
                                System.out.println("Computador ganhou!");
                                contadorDerrotas++;
                            } else if (escolhaComputador.equals("TESOURA")) {
                                System.out.println("Você ganhou!");
                                contadorVitorias++;
                            }
                        }
                        if (escolhaJogador.equals("PAPEL")) {
                            if (escolhaComputador.equals("TESOURA")) {
                                System.out.println("Computador ganhou!");
                                contadorDerrotas++;
                            } else if (escolhaComputador.equals("PEDRA")) {
                                System.out.println("Você ganhou!");
                                contadorVitorias++;
                            }
                        }
                        if (escolhaJogador.equals("TESOURA")) {
                            if (escolhaComputador.equals("PEDRA")) {
                                System.out.println("Computador ganhou!");
                                contadorDerrotas++;
                            } else if (escolhaComputador.equals("PAPEL")) {
                                System.out.println("Você ganhou!");
                                contadorVitorias++;
                            }
                        }
                    } else {
                        System.out.println("Jogada inválida! Tente novamente!");
                    }

                }
                System.out.println("Gostaria de jogar novamente? S / N");
                jogarNovamente = scanner.next().toUpperCase().charAt(0);
            } while (jogarNovamente == 'S');
            int contadorPartidas = contadorVitorias + contadorDerrotas + contadorEmpates;
            System.out.println("Você jogou " + contadorPartidas + " partidas.");
            System.out.println("Você venceu " + contadorVitorias + ", empatou " + contadorEmpates + " e perdeu " + contadorDerrotas + " partidas.");
            System.out.println("Projeto desenvolvido durante a 9ª Imersão Dev da Alura. Obrigado por jogar!");

        } else {
            System.out.println("Você precisa ser maior de 18 anos!");
        }
    }
}