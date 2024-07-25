public class Exercicio_3 {
    public static boolean estaOrdenado(int[] Vetor) {
        for (int i = 1; i < Vetor.length; i++) {
            if (Vetor[i] < Vetor[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] Vetor1 = { 1, 2, 3, 4, 5 };
        System.out.println("Vetor 1 está ordenado? " + estaOrdenado(Vetor1) + "\n"); 

        int[] Vetor2 = { 1, 3, 2, 4, 5 };
        System.out.println("Vetor 2 está ordenado? " + estaOrdenado(Vetor2) + "\n");

        int[] Vetor3 = { 5, 4, 3, 2, 1 };
        System.out.println("Vetor 3 está ordenado? " + estaOrdenado(Vetor3) + "\n");

        int[] Vetor4 = { 1 };
        System.out.println("Vetor 4 está ordenado? " + estaOrdenado(Vetor4) + "\n");

        int[] vetor5 = new int[31];

        for (int i = 0; i <= 30; i++) {
            vetor5[i] = i * 2 + 1;
        }
        System.out.println("Vetor 5 está ordenado? " + estaOrdenado(vetor5) + "\n");
    }
}
