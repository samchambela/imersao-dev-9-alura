import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class JankenPoke {
    public static String escolherJogadaAleatoria(String[] escolhasPossiveis) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(escolhasPossiveis.length);
        return escolhasPossiveis[indiceAleatorio];
    }

    public static BufferedImage redimensionarImagem (BufferedImage imagem, int width, int height) {
        BufferedImage imagemRedimensionada = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = imagemRedimensionada.createGraphics();
        graphics.drawImage(imagem, 0, 0, width, height, null);
        graphics.dispose();
        return imagemRedimensionada;
    }

    public static char[][] converterParaAscii(BufferedImage imagem) {
        char[] asciiChars = " ░▒▓██".toCharArray();
        int width = imagem.getWidth();
        int height = imagem.getHeight();
        char[][] chars = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixelColor = new Color(imagem.getRGB(x, y));
                int escalaDeCinza = (int) (pixelColor.getRed() * 0.299 + pixelColor.getGreen() * 0.587 + pixelColor.getBlue() * 0.114);
                int index = (int) (escalaDeCinza / 255.0 * (asciiChars.length - 1));
                chars[y][x] = asciiChars[index];
            }
        }
        return chars;
    }

    public static void imagemParaAscii(String caminhoImagem) throws IOException {
        int width = 90;
        int height = 30;
        BufferedImage imagem = ImageIO.read(new File(caminhoImagem));
        BufferedImage imagemRedimensionada = redimensionarImagem(imagem, width, height);
        char[][] imagemAscii = converterParaAscii(imagemRedimensionada);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(imagemAscii[y][x]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        String nome;
        String[] escolhasPossiveis = {"BULBASAUR", "CHARMANDER", "SQUIRTLE"};
        String escolhaJogador;
        boolean escolhaEhValida;
        char jogarNovamente = 'S';
        int contadorVitorias = 0;
        int contadorDerrotas = 0;
        int contadorEmpates = 0;
        String imagemBulbasaur = "C:\\imersaodev9-alura\\jankenpoke\\src\\assets\\img\\bulba.png";
        String imagemCharmander = "C:\\imersaodev9-alura\\jankenpoke\\src\\assets\\img\\charm.png";
        String imagemSquirtle = "C:\\imersaodev9-alura\\jankenpoke\\src\\assets\\img\\squi.png";

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("__________________________________");
        System.out.println("Boas-vindas ao torneio JankenPoké!");
        System.out.println("__________________________________");
        System.out.println("Se registre no desafio! Digite seu nome:");
        nome = scanner.next();

        do {
            escolhaEhValida = false;
            while (!escolhaEhValida) {
                System.out.println("____________________________________________________________");
                System.out.println("Escolha seu pokémon: [BULBASAUR] | [CHARMANDER] | [SQUIRTLE]");
                escolhaJogador = scanner.next().toUpperCase();
                escolhaEhValida = Arrays.asList(escolhasPossiveis).contains(escolhaJogador);
                if (escolhaEhValida) {
                    System.out.println(escolhaJogador + " eu escolho você!!");
                    Thread.sleep(1000);
                    if (escolhaJogador.equals("BULBASAUR")) {
                        imagemParaAscii(imagemBulbasaur);
                    } else if (escolhaJogador.equals("CHARMANDER")) {
                        imagemParaAscii(imagemCharmander);
                    } else {
                        imagemParaAscii(imagemSquirtle);
                    }
                    Thread.sleep(1000);
                    System.out.println("________________________________________");
                    System.out.println("Seu oponente está escolhendo um pokémon!");
                    Thread.sleep(3000);
                    String escolhaComputador = escolherJogadaAleatoria(escolhasPossiveis);
                    System.out.println("O seu oponente escolheu " + escolhaComputador);
                    Thread.sleep(1000);
                    if (escolhaComputador.equals("BULBASAUR")) {
                        imagemParaAscii(imagemBulbasaur);
                    } else if (escolhaComputador.equals("CHARMANDER")) {
                       imagemParaAscii(imagemCharmander);
                    } else {
                        imagemParaAscii(imagemSquirtle);
                    }
                    if (escolhaJogador.equals(escolhaComputador)) {
                        System.out.println("________________________________________");
                        System.out.println("Oh, não! Os dois pokémon se nocautearam!");
                        contadorEmpates++;
                    }
                    if (escolhaJogador.equals("BULBASAUR")) {
                        if (escolhaComputador.equals("CHARMANDER")) {
                            System.out.println("___________________________________");
                            System.out.println("Treine mais! Seu adversário venceu!");
                            contadorDerrotas++;
                        } else if (escolhaComputador.equals("SQUIRTLE")) {
                            System.out.println("____________________________");
                            System.out.println("É superefetivo! Você venceu!");
                            contadorVitorias++;
                        }
                    }
                    if (escolhaJogador.equals("CHARMANDER")) {
                        if (escolhaComputador.equals("SQUIRTLE")) {
                            System.out.println("___________________________________");
                            System.out.println("Treine mais! Seu adversário venceu!");
                            contadorDerrotas++;
                        } else if (escolhaComputador.equals("BULBASAUR")) {
                            System.out.println("____________________________");
                            System.out.println("É superefetivo! Você venceu!");
                            contadorVitorias++;
                        }
                    }
                    if (escolhaJogador.equals("SQUIRTLE")) {
                        if (escolhaComputador.equals("BULBASAUR")) {
                            System.out.println("___________________________________");
                            System.out.println("Treine mais! Seu adversário venceu!");
                            contadorDerrotas++;
                        } else if (escolhaComputador.equals("CHARMANDER")) {
                            System.out.println("____________________________");
                            System.out.println("É superefetivo! Você venceu!");
                            contadorVitorias++;
                        }
                    }
                } else {
                    System.out.println("__________________________________________________");
                    System.out.println("A pokébola escorregou da sua mão! Jogue novamente!");
                }

            }
            System.out.println("__________________________________________");
            System.out.println(nome + ", gostaria de batalhar de novo? S / N");
            jogarNovamente = scanner.next().toUpperCase().charAt(0);
        } while (jogarNovamente == 'S');
        int contadorPartidas = contadorVitorias + contadorDerrotas + contadorEmpates;
        System.out.println("_____________________");
        System.out.println("HISTÓRICO DE BATALHAS");
        System.out.println("_____________________");
        System.out.println();
        System.out.println(nome + " batalhou " + contadorPartidas + " vez(es).");
        System.out.println(nome + " venceu " + contadorVitorias + ", empatou " + contadorEmpates + " e perdeu " + contadorDerrotas + " batalha(s).");
        System.out.println();
        System.out.println("#################################################################################");
        System.out.println("## Projeto desenvolvido durante a 9ª Imersão Dev da Alura. Obrigado por jogar! ##");
        System.out.println("#################################################################################");

    }
}