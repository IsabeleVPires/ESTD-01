package org.example;

public class Fila<T> {
    private T[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public Fila(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public void enfileirar(T elemento) {
        if (tamanho == elementos.length) {
            throw new IllegalStateException("Fila cheia");
        }
        elementos[fim] = elemento;
        fim = (fim + 1) % elementos.length;
        tamanho++;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("Fila vazia");
        }
        T temp = elementos[inicio];
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return temp;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int tamanho() {
        return tamanho;
    }

    public void mostrarFila() {
        System.out.print("Fila: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[(inicio + i) % elementos.length] + " ");
        }
        System.out.println();
    }
}

