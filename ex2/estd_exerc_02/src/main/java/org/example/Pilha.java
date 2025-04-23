package org.example;

public class Pilha<T> {
    private int topo;
    private T[] elementos;

    public Pilha(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        topo = -1;
    }

    public void empilhar(T elemento) {
        if (topo == elementos.length - 1){
            throw new IllegalStateException("Pilha cheia");
        }
        elementos[++topo] = elemento;
    }

    public T desempilhar() {
        if (estaVazia()){
            throw new IllegalStateException("Pilha vazia");
        }
        return elementos[topo--];
    }

    public boolean estaVazia(){
        return topo == -1;
    }

    public T topo(){
        if (estaVazia()) return null;
        return elementos[topo];
    }
}
