public class Exercicio_2 {
    public static int buscaBinariaIterativa(int[] vetor, int x) {
        int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            if (vetor[meio] == x) {
                return meio;
            }

            if (vetor[meio] < x) {
                esquerda = meio + 1;
            }

            else {
                direita = meio - 1;
            }
        }

        return -1;
    }

    public static int buscaBinariaRecursiva(int[] vetor, int x, int esquerda, int direita) {

        if (esquerda > direita) {
            return -1;
        }

        int meio = esquerda + (direita - esquerda) / 2;

        if (vetor[meio] == x) {
            return meio;
        }

        if (vetor[meio] < x) {
            return buscaBinariaRecursiva(vetor, x, meio + 1, direita);
        }

        else {
            return buscaBinariaRecursiva(vetor, x, esquerda, meio - 1);
        }
    }

    public static void main(String[] args) {
        int[] vetorA = new int[31];

        for (int i = 0; i <= 30; i++) {
            vetorA[i] = i * 2 + 1;
        }

        int x1 = 7;
        System.out.println("Resultado 1: " + buscaBinariaIterativa(vetorA, x1));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x1, 0, vetorA.length -1));

        int x2 = 55;
        System.out.println("Resultado 2: " + buscaBinariaIterativa(vetorA, x2));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x2, 0, vetorA.length -1));

        int x3 = 31;
        System.out.println("Resultado 3: " + buscaBinariaIterativa(vetorA, x3));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x3, 0, vetorA.length -1));

        int x4 = 41;
        System.out.println("Resultado 4: " + buscaBinariaIterativa(vetorA, x4));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x4, 0, vetorA.length -1));

        int x5 = 0;
        System.out.println("Resultado 5: " + buscaBinariaIterativa(vetorA, x5));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x5, 0, vetorA.length -1));

        int x6 = 32;
        System.out.println("Resultado 6: " + buscaBinariaIterativa(vetorA, x6));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x6, 0, vetorA.length -1));

        int x7 = -1;
        System.out.println("Resultado 7: " + buscaBinariaIterativa(vetorA, x7));
        System.out.println("Resultado 1: " + buscaBinariaRecursiva(vetorA, x7, 0, vetorA.length -1));
    }
}