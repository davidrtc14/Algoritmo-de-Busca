import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AlgoritimoDeBusca {
    public static void main(String[] args) {
        ArrayList<Integer> lista = gerarListaAleatoria(50);
        System.out.println("Lista original: " + lista);

        int numeroBuscado = 40;
        int iteracoesLinear = buscaLinear(lista, numeroBuscado);
        System.out.println("Busca Linear - Iterações: " + iteracoesLinear);

        bubbleSort(lista);
        System.out.println("Lista ordenada: " + lista);

        int iteracoesBinaria = buscaBinaria(lista, numeroBuscado);
        System.out.println("Busca Binária - Iterações: " + iteracoesBinaria);
    }

    public static ArrayList<Integer> gerarListaAleatoria(int tamanho) {
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();

        while (lista.size() < tamanho) {
            int numero = random.nextInt(tamanho) + 1;
            if (!lista.contains(numero)) {
                lista.add(numero);
            }
        }
        return lista;
    }

    public static int buscaLinear(ArrayList<Integer> lista, int valor) {
        int iteracoes = 0;
        for (int i = 0; i < lista.size(); i++) {
            iteracoes++;
            if (lista.get(i) == valor) {
                break;
            }
        }
        return iteracoes;
    }

    public static void bubbleSort(ArrayList<Integer> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
    }

    public static int buscaBinaria(ArrayList<Integer> lista, int valor) {
        int inicio = 0, fim = lista.size() - 1;
        int iteracoes = 0;

        while (inicio <= fim) {
            iteracoes++;
            int meio = (inicio + fim) / 2;

            if (lista.get(meio) == valor) {
                break;
            } else if (lista.get(meio) < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return iteracoes;
    }
}
