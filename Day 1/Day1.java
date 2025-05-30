/*
 * Codigo criado para resolução do Day 1 do Advent of Code do ano de 2024
 * https://adventofcode.com/2024/day/1
 * Criado no dia 11/05/2025
 * Autor: stdinJ
 * Utilizei ArrayList para ler  o arquivo "input.txt", onde está localizado o input do Day 1
 * Assim, deixando uma leitura dinamica do arquivo
 * Utilizei o Algoritmo de ordenação Bubble Sort para a ordenação das Arrays
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1File {
    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
        ArrayList<Integer> array2 = new ArrayList<>();

        try {
            File file = new File("input.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    array1.add(Integer.valueOf(parts[0]));
                    array2.add(Integer.valueOf(parts[1]));
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            return;
        }

        // Ordena usando Bubble Sort
        bubbleSort(array1);
        bubbleSort(array2);

        int sum = 0;
        for (int i = 0; i < array1.size(); i++) {
            sum += Math.abs(array1.get(i) - array2.get(i));
        }

        System.out.println("Total distance: " + sum);
    }

    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    // troca
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }
}
