/*
 * Codigo criado para resolução do Day 2 do Advent of Code do ano de 2024
 * https://adventofcode.com/2024/day/2
 * Criado no dia 12/05/2025
 * Autor: stdinJ
 * No dia 2, em questão de Logica, fiquei um tempo para entender como eu iria fazer a analise para
 * identificar se os valores seriam crescentes ou decrescentes sem precisar fazer muitos If's
 * 
 */

import java.io.*;

public class Dia2File {
    public static void main(String[] args) {

        int seguros = 0;
        int inseguros = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String linha;

            // Lê o arquivo linha por linha
            while ((linha = br.readLine()) != null) {
                // Converte a linha em uma lista de inteiros
                String[] partes = linha.split(" ");
                int[] lista = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    lista[i] = Integer.parseInt(partes[i]);
                }

                // Assume que o relatório é seguro até que alguma regra de segurança seja violada
                boolean safe = true;
                
                // Guarda a direção da sequência (true se for crescente, false se for decrescente)
                // Definido com base na primeira diferença válida entre dois números consecutivos
                boolean crescente = false;
                
                // Indica se ainda estamos no primeiro par de números da sequência
                // Usado para definir a direção inicial (crescente ou decrescente) apenas uma vez
                boolean primeiroPar = true;


                // Verificação das diferenças entre os números
                for (int j = 0; j < lista.length - 1; j++) {
                    int diferenca = lista[j + 1] - lista[j];

                    if (diferenca == 0 || Math.abs(diferenca) > 3) { //se não houver variação, ou se houver e for > 3 é inseguro
                        safe = false;
                        break;
                    }

                    if (primeiroPar) {
                        crescente = diferenca > 0;
                        primeiroPar = false;
                    } else {
                        if ((crescente && diferenca < 0) || (!crescente && diferenca > 0)) {
                            safe = false;
                            break;
                        }
                    }
                }

                if (safe) {
                    seguros++;
                } else {
                    inseguros++;
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("Relatórios seguros: " + seguros);
        System.out.println("Relatórios inseguros: " + inseguros);
    }
}
