import java.util.Random;

public class NossoVetor {

    private int ocupacao;
    private long[] vetor;

    //primeiro construtor
    public NossoVetor(int tamanho) {
        vetor = new long[tamanho];
        ocupacao = 0;
    }

    //segundo construtor
    //substitui o construtor padrão do java (que é, ex: NossoVetor meuvetor = new NossoVetor())
    public NossoVetor() {
        //a linha abaixo chama o contrutor acima ('this', nesse caso, se refere a um possível construtor), ou seja, se o programador construir uma instância de "NossoVetor" sem definir o tamanho, por padrão o tamanho será de 10
        this(10);
    }

    public long getOcupacao() {
        return ocupacao;
    }

    public long getTamanho() {
        return vetor.length;
    }

    public boolean estaCheio() {
        return ocupacao == vetor.length;
    }

    public boolean estaVazio() {
        return ocupacao == 0;
    }

    public void insere(long i) {
        if (estaCheio()) {
            redimensionaVetor(vetor.length * 2);
        }
        vetor[ocupacao++] = i;
    }

    //remove o último elemento inserido no vetor
    public long remove() {
        long i = -1;
        if (!estaVazio()) {
            // '--' antes do nome, usa o valor e depois aplica o decremento
            i = vetor[--ocupacao];
            if (vetor.length >= 4 && ocupacao <= vetor.length / 4) {
                redimensionaVetor(vetor.length / 2);
            }
        }
        //se i=-1, quer dizer que o vetor está vazio
        return i;
    }

    private void redimensionaVetor(int novoTamanho) {
        //copiar os elementos dentro do vetor[] para temp[] (temp de temporário)
        long[] temp = new long[novoTamanho];
        for (int i = 0; i < ocupacao; i++) {
            temp[i] = vetor[i];
        }
        vetor = temp;
    }

    //toda classe java tem o método toString, que é chamado automaticamente quando um objeto é concatenado numa String. Então vamos sobrescrevê-lo para, quando printarmos um vetor, ele não nos dê o endereço de memória, mas os dados do vetor.
    public String toString() {
        String s = "[" + vetor[0];
        for (int i = 1; i < ocupacao; i++) {
            s += ", " + vetor[i];
        }
        return s + "]" + "\n";
    }

    // Percorre o vetor buscando por um número específico que foi enviado como
    // parâmetro (long i), retorna a posição do vetor onde o número foi encontrado
    public long buscaLinear(long numeroPesquisado) {
        int contador = 0;
        if (estaVazio()) {
            System.out.println("Vetor esta vazio!!");
        } else { // buscar o número dentro do vetor
            // busca com complexidade linear
            for (int x = 0; x < ocupacao; x++) {
                contador++;
                if (vetor[x] == numeroPesquisado) {
                    // número encontrado \o/
                    //return x;
                    return contador;
                }
            }
        }
        return -1; // -1 quer dizer que o número não foi encontrado no vetor
    }

    public long buscaBinaria(long numeroPesquisado) {
        int contador = 0;
        long baixo = 0;
        long alto = vetor.length - 1;
        while (baixo <= alto) {
            contador++;
            long meio = baixo + (alto - baixo) / 2;
            long valor = vetor[(int) meio];
            //System.out.println("meio: " + meio);
            if (valor < numeroPesquisado) baixo = meio + 1;
            else if (valor > numeroPesquisado) alto = meio - 1;
            else {
                //return meio;
                return contador;
            }
        }

        return -1;
    }

    public void preencheVetor() {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(vetor.length * 10);
        }
        ocupacao = vetor.length;
    }

    public long bubbleSort() {
        long contador = 0;
        for (int i = 1; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - i; j++) {
                contador++;
                if (vetor[j] > vetor[j + 1]) {
                    long temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    contador += 3;
                }
            }
        }
        return contador;
    }

    public long selectionSort() {
        long contador = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vetor.length; j++) {
                contador++;
                if (vetor[j] < vetor[min]) {
                    min = j;
                    contador++;
                }
            }
            long x = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = x;
            contador += 3;
        }
        return contador;
    }

    public long insertionSort() {
        long contador = 0;
        for (int i = 1; i < vetor.length; i++) {
            long x = vetor[i];
            int j;
            for (j = i - 1; j >= 0 && vetor[j] > x; j--) {
                vetor[j + 1] = vetor[j];
                contador++;
                contador++;
            }
            vetor[j + 1] = x;
            contador++;
        }
        return contador;
    }

    public long buscaPeloIndice(int indice) {
        return vetor[indice];
    }

    public void copiaVetor(NossoVetor outroVetor) {
        for (int i = 0; i < outroVetor.vetor.length; i++) {
            this.vetor[i] = outroVetor.vetor[i];
        }
    }
}
