package org.example;

class Documento {
    private String nome;
    private int tamanho;

    public Documento(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String toString() {
        return nome + " (" + tamanho + "KB)";
    }
}


