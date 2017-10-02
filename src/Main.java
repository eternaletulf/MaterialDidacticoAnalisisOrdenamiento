import algoritmo.Algoritmo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private static File file = new File("numbers.txt");

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        int opcion;
        int arreglo[];

        long tiempoInicio;
        long tiempoFinal;
        long diferencia;

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                arreglo = lecturaDesdeTeclado();

                tiempoInicio = System.currentTimeMillis();
                System.out.println(tiempoInicio);
                Algoritmo.sort(arreglo);
                tiempoFinal = System.currentTimeMillis();
                System.out.println(tiempoFinal);

                diferencia = (tiempoFinal - tiempoInicio)/1000;

                System.out.println("El programa se demoro: " + diferencia);
                Arrays.stream(arreglo)
                        .forEach(System.out::println);
                break;

            case 2:
                arreglo = lecturaDesdeArchivo();

                tiempoInicio = System.currentTimeMillis();
                Algoritmo.sort(arreglo);
                tiempoFinal = System.currentTimeMillis();

                diferencia = tiempoFinal - tiempoInicio;

                System.out.println("El programa se demoro: " + diferencia);
                break;

            default:
                System.out.println("idiota");
                System.exit(1);
                break;
        }
        sc.close();
    }

    private static int[] lecturaDesdeTeclado() {
        Scanner sc = new Scanner(System.in);

        int tamanyo = sc.nextInt();
        int arreglo[] = new int[tamanyo];

        for (int i = 0; i < tamanyo; i++) {
            arreglo[i] = sc.nextInt();
        }

        sc.close();
        return arreglo;
    }

    private static int[] lecturaDesdeArchivo() throws FileNotFoundException {
        Scanner scFile = new Scanner(file);

        int arreglo[] = new int[100];
        int i = 0;

        while (scFile.hasNextLine() && i < 100) {
            arreglo[i] = scFile.nextInt();
            i++;
        }

        scFile.close();
        return arreglo;
    }
}
