import java.util.Scanner;
import java.util.Random;

public class TesteTarefa {
    public static void main(String[] args) {
        NossoVetor v;
        int tamanhoDoVetor = 1600000;
        int quantidadeDeIteracoes = 1;
        NossoVetor listaBubble = new NossoVetor(tamanhoDoVetor);
        NossoVetor listaSelection = new NossoVetor(tamanhoDoVetor);
        NossoVetor listaInsertion = new NossoVetor(tamanhoDoVetor);

        // for(int i=0; i<quantidadeDeIteracoes; i++){
        //     v = new NossoVetor(tamanhoDoVetor);
        //     NossoVetor v_aux = new NossoVetor(tamanhoDoVetor);
        //     v.preencheVetor();
        //     v_aux.copiaVetor(v);
            
        //     //System.out.println(v);

        //     long comparacoes_bubble = v.bubbleSort();
        //     listaBubble.insere(comparacoes_bubble);
        //     System.out.println("Comparações bubble sort: " + comparacoes_bubble);
        //     v.copiaVetor(v_aux);

        //     long comparacoes_selection = v.selectionSort();
        //     listaSelection.insere(comparacoes_selection);
        //     System.out.println("Comparações selection sort: " + comparacoes_selection);
        //     v.copiaVetor(v_aux);

        //     long comparacoes_insertion = v.insertionSort();
        //     listaInsertion.insere(comparacoes_insertion);
        //     System.out.println("Comparações insertion sort: " + comparacoes_insertion);
        //     v.copiaVetor(v_aux);

        //     System.out.println("-------------------\n");
        // }

        // System.out.println("Lista Bubble: " + listaBubble);
        // System.out.println("Lista Selection: " + listaSelection);
        // System.out.println("Lista Insertion: " + listaInsertion);


        Random random = new Random();
        v = new NossoVetor(tamanhoDoVetor);
        v.preencheVetor();
        long valor = v.buscaPeloIndice(random.nextInt(tamanhoDoVetor));
        v.buscaLinear(valor);
        System.out.println(v.insertionSort());
        v.buscaBinaria(valor);
        


    }
}
