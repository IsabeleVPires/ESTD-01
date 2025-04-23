package org.example;

public class EditorTexto {
    private Pilha<String> pilhaDesfazer;
    private Pilha<String> pilhaRefazer;
    private String textoAtual;
    private int capacidade;

    public EditorTexto(int capacidade){
        this.capacidade = capacidade;
        pilhaDesfazer = new Pilha<>(capacidade);
        pilhaRefazer = new Pilha<>(capacidade);
        textoAtual = "";
    }

    public void inserirTexto(String novoTexto){
        pilhaDesfazer.empilhar(textoAtual);
        pilhaRefazer = new Pilha<>(capacidade); // limpa a pilhaRefazer
        textoAtual += novoTexto;
        System.out.println("Texto atual: " + textoAtual);
    }

    public void desfazer(){
        if(!pilhaDesfazer.estaVazia()){
            pilhaRefazer.empilhar(textoAtual);
            textoAtual = pilhaDesfazer.desempilhar();
            System.out.println("Desfeito, texto atual: " + textoAtual);
        } else {
            System.out.println("Nada para desfazer.");
        }
    }

    public void refazer(){
        if(!pilhaRefazer.estaVazia()){
            pilhaDesfazer.empilhar(textoAtual);
            textoAtual = pilhaRefazer.desempilhar();
            System.out.println("Refeito, texto atual: " + textoAtual);
        } else {
            System.out.println("Nada para refazer.");
        }
    }
}
