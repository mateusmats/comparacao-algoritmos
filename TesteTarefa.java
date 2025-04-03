import java.util.Random;

public class TesteTarefa {

    public static void main(String[] args) {
        NossoVetor v;
        int tamanhoDoVetor = 800000; // A Machion pediu 100mil, 200mil, 400mil, 800mil e 1,6milhão.
        int quantidadeDeIteracoes = 5; // A Machion pediu 10 iterações para 1,6milhão e 30 para o resto.

        // Estou estocando o custo de cada algoritmo numa lista. Como são 3 algoritmos, temos 3 listas:
        NossoVetor listaBubble = new NossoVetor(tamanhoDoVetor);
        NossoVetor listaSelection = new NossoVetor(tamanhoDoVetor);
        NossoVetor listaInsertion = new NossoVetor(tamanhoDoVetor);

        NossoVetor listaBuscaLinear = new NossoVetor(tamanhoDoVetor);
        NossoVetor listaBuscaBinaria = new NossoVetor(tamanhoDoVetor);

        // É aqui que vai acontecer as iterações (10 para 1,6milhão e 30 para o resto)
        for (int i = 0; i < quantidadeDeIteracoes; i++) {
            v = new NossoVetor(tamanhoDoVetor);
            NossoVetor v_aux = new NossoVetor(tamanhoDoVetor); //Esse vetor auxiliar serve para permitir a restauração do vetor ordenado para o vetor desordenado:

            v.preencheVetor();
            v_aux.copiaVetor(v);

            System.out.println("Algoritmos de Ordenação:");

            //Comparações do bubble sort:
            long comparacoes_bubble = v.bubbleSort();
            listaBubble.insere(comparacoes_bubble);
            System.out.println(
                "Comparações bubble sort: " + comparacoes_bubble
            );
            v.copiaVetor(v_aux); // aqui o vetor ordenado (v) é resetado para o seu estado anterior desordenado (v_aux)

            //Comparações do selection sort:
            long comparacoes_selection = v.selectionSort();
            listaSelection.insere(comparacoes_selection);
            System.out.println(
                "Comparações selection sort: " + comparacoes_selection
            );
            v.copiaVetor(v_aux); // aqui o vetor ordenado (v) é resetado para o seu estado anterior desordenado (v_aux)

            //Comparações do insertion sort:
            long comparacoes_insertion = v.insertionSort();
            listaInsertion.insere(comparacoes_insertion);
            System.out.println(
                "Comparações insertion sort: " + comparacoes_insertion
            );

            System.out.println("-------------------\n");

            System.out.println("Algoritmos de Busca:");

            // Agora, temos as iterações dos algoritmos de busca (busca linear e busca binária)
            Random random = new Random();
            long valorASerBuscado = v.buscaPeloIndice(
                random.nextInt(tamanhoDoVetor)
            );
            long custoBuscaBinaria = v.buscaBinaria(valorASerBuscado);
            long custoBuscaBinariaTotal =
                custoBuscaBinaria + comparacoes_insertion;
            listaBuscaBinaria.insere(custoBuscaBinariaTotal);
            System.out.println(
                "Custo busca binária, apenas: " + custoBuscaBinaria
            );
            System.out.println(
                "Custo busca binária + custo de ordenação: " +
                custoBuscaBinariaTotal
            );

            v.copiaVetor(v_aux); // aqui o vetor ordenado (v) é resetado para o seu estado anterior desordenado (v_aux)

            long custoBuscaLinear = v.buscaLinear(valorASerBuscado);
            listaBuscaLinear.insere(custoBuscaLinear);
            System.out.println("Custo busca linear: " + custoBuscaLinear);
            System.out.println("--------------------\n");
        }

        System.out.println("Lista Bubble: " + listaBubble);
        System.out.println("Lista Selection: " + listaSelection);
        System.out.println("Lista Insertion: " + listaInsertion);

        System.out.println("Lista Busca Linear: " + listaBuscaLinear);
        System.out.println("Lista Busca Binaria: " + listaBuscaBinaria);
    }
}
