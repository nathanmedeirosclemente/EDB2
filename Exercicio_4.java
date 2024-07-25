import java.util.HashMap;
import java.util.Map;

public class Exercicio_4 {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonacci(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N deve ser um valor inteiro positivo.");
        }
        if (N == 1 || N == 2) {
            return 1; // Os dois primeiros números de Fibonacci são 1
        }
        if (memo.containsKey(N)) {
            return memo.get(N);
        }
        int result = fibonacci(N - 1) + fibonacci(N - 2);
        memo.put(N, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(5): " + fibonacci(5)); // Deve imprimir 5
        System.out.println("Fibonacci(10): " + fibonacci(10)); // Deve imprimir 55
        System.out.println("Fibonacci(20): " + fibonacci(20)); // Deve imprimir 6765
    }
}