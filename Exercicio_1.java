public class Exercicio_1 {
    public static int buscaRecursiva(int[] vetor, int x, int index) {
        if (index >= vetor.length) {
            return -1; // Não encontrou o elemento
        }
        if (vetor[index] == x) {
            return index; // Encontrou o elemento
        }
        return buscaRecursiva(vetor, x, index + 1); // Chamada recursiva
    }

    public static void main(String[] args) {
        int[] vetorA1 = {4, 2, 7, 1, 3, 9};
        int x1 = 7;
        System.out.println("Resultado 1: " + buscaRecursiva(vetorA1, x1, 0));
    
        int[] vetorA2 = {4, 2, 7, 1, 3, 9};
        int x2 = 5;
        System.out.println("Resultado 2: " + buscaRecursiva(vetorA2, x2, 0));
    
        int[] vetorA3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x3 = 9;
        System.out.println("Resultado 3: " + buscaRecursiva(vetorA3, x3, 0));
    
        int[] vetorA4 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int x4 = 1;
        System.out.println("Resultado 4: " + buscaRecursiva(vetorA4, x4, 0));
    
        int[] vetorA5 = {};
        int x5 = 1;
        System.out.println("Resultado 5: " + buscaRecursiva(vetorA5, x5, 0));
    }
}