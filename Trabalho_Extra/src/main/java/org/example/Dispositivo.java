package org.example;

public abstract class Dispositivo implements Conectavel {
    protected int id;
    protected String nome;
    protected boolean ligado;

    public Dispositivo(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.ligado = false;
    }

    public void ligar() {
        ligado = true;
        System.out.println(nome + " ligado.");
    }

    public void desligar() {
        ligado = false;
        System.out.println(nome + " desligado.");
    }

    public abstract void executarAcao();
}
