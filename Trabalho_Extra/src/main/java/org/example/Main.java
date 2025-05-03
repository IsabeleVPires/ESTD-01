package org.example;

public class Main {
    public static void main(String[] args) {
        // Criando dispositivos
        Lampada lampada1 = new Lampada(1, "Lâmpada da cozinha");
        Lampada lampada2 = new Lampada(2, "Lâmpada do banheiro");

        // Conectando dispositivos
        lampada1.conectar();
        lampada2.conectar();

        // Ligando e executando ações
        lampada1.ligar();
        lampada1.executarAcao();

        lampada2.desligar();
        lampada2.executarAcao();

        // Desconectando dispositivos
        lampada1.desconectar();
        lampada2.desconectar();
    }
}
