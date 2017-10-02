package algoritmo;

public class Algoritmo {

    public static int[] sort(int[] input) {

        int tamayno = input.length;

        for (int i = 0; i < tamayno; i++) {
            for (int j = i + 1; j < tamayno; j++) {

                if (input[i] > input[j]) {
                    int burbuja = input[i];
                    input[i] = input[j];
                    input[j] = burbuja;
                }
            }

        }
        return input;
    }

}
