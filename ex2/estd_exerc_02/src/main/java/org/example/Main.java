package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== TESTE DA PILHA =====");
        Pilha<Integer> pilha = new Pilha<>(5);
        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);
        System.out.println("Desempilhando: " + pilha.desempilhar());
        System.out.println("Pilha está vazia? " + pilha.estaVazia());

        System.out.println("\n===== TESTE DO EDITOR DE TEXTO (DESFAZER/REFAZER) =====");
        EditorTexto editor = new EditorTexto(10);
        editor.inserirTexto("Olá");
        editor.inserirTexto(", mundo!");
        editor.desfazer();
        editor.refazer();
        editor.inserirTexto(" Como vai?");
        editor.desfazer();
        editor.desfazer();

        System.out.println("\n===== TESTE DA FILA DE IMPRESSÃO =====");
        Fila<Documento> filaImpressao = new Fila<>(5);
        filaImpressao.enfileirar(new Documento("Relatório.pdf", 200));
        filaImpressao.enfileirar(new Documento("Slide.pptx", 350));
        filaImpressao.enfileirar(new Documento("Foto.png", 120));
        filaImpressao.mostrarFila();
        System.out.println("Imprimindo: " + filaImpressao.desenfileirar());
        System.out.println("Imprimindo: " + filaImpressao.desenfileirar());
        filaImpressao.mostrarFila();
    }
}

