package org.example;

public class Lampada extends Dispositivo {

    public Lampada(int id, String nome) {
        super(id, nome);
    }

    @Override
    public void conectar() {
        System.out.println(nome + " conectada à rede.");
    }

    @Override
    public void desconectar() {
        System.out.println(nome + " desconectada da rede.");
    }

    @Override
    public void executarAcao() {
        if (ligado) {
            System.out.println(nome + " está acesa.");
        } else {
            System.out.println(nome + " está apagada.");
        }
    }
}

