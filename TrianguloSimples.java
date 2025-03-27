import java.util.Scanner; import java.util.Arrays;

public class TrianguloSimples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            // Exibe o menu
            System.out.println("\n=== Análise de Triângulos ===");
            System.out.println("1 - Classificar Triângulo");
            System.out.println("2 - Verificar se é Retângulo");
            System.out.println("3 - Verificar se é do tipo 3, 4, 5");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            if (opcao >= 1 && opcao <= 3) {
                // Pega os valores dos lados do triângulo
                System.out.print("Digite o primeiro lado: ");
                int lado1 = scanner.nextInt();
                System.out.print("Digite o segundo lado: ");
                int lado2 = scanner.nextInt();
                System.out.print("Digite o terceiro lado: ");
                int lado3 = scanner.nextInt();

                // Verifica se realmente forma um triângulo
                if (!formaTriangulo(lado1, lado2, lado3)) {
                    System.out.println("Esses valores não formam um triângulo.");
                    continue;
                }

                // Executa a opção escolhida
                if (opcao == 1) {
                    System.out.println("O triângulo é: " + classificarTriangulo(lado1, lado2, lado3));
                } else if (opcao == 2) {
                    if (eRetangulo(lado1, lado2, lado3)) {
                        System.out.println("O triângulo é retângulo.");
                    } else {
                        System.out.println("O triângulo NÃO é retângulo.");
                    }
                } else if (opcao == 3) {
                    if (eh345(lado1, lado2, lado3)) {
                        System.out.println("O triângulo segue o padrão 3, 4, 5.");
                    } else {
                        System.out.println("O triângulo NÃO segue o padrão 3, 4, 5.");
                    }
                }
            }
        } while (opcao != 0); // Sai quando o usuário digita 0

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    // Função para verificar se os lados realmente formam um triângulo
    public static boolean formaTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Função para identificar qual tipo de triângulo é
    public static String classificarTriangulo(int a, int b, int c) {
        if (a == b && b == c) {
            return "Equilátero (todos os lados iguais)";
        } else if (a == b || a == c || b == c) {
            return "Isósceles (dois lados iguais)";
        } else {
            return "Escaleno (todos os lados diferentes)";
        }
    }

    // Verifica se o triângulo é retângulo usando Pitágoras (erro nesse código)
    public static boolean eRetangulo(int a, int b, int c) {
        int[] lados = {a, b, c};
        Arrays.sort(lados); // Ordena os lados do menor para o maior
        return (lados[0] * lados[0] + lados[1] * lados[1]) == (lados[2] * lados[2]);
    }

    // Verifica se o triângulo tem os lados 3, 4 e 5
    public static boolean eh345(int a, int b, int c) {
        return (a == 3 && b == 4 && c == 5) ||
               (a == 3 && b == 5 && c == 4) ||
               (a == 4 && b == 3 && c == 5) ||
               (a == 4 && b == 5 && c == 3) ||
               (a == 5 && b == 3 && c == 4) ||
               (a == 5 && b == 4 && c == 3);
    }
} 
