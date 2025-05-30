import java.util.ArrayList;

public class ArvoreGenerica<E> implements Arvore<E> {

    private No<E> raiz;
    private Integer tamanho;

    public ArvoreGenerica() {
        raiz = null;
        tamanho = 0;
    }

    public Posicao<E> adicionarRaiz(E elemento) {
        if (raiz != null) {
            throw new IllegalStateException("A árvore já possui uma raiz");
        }
        raiz = new No<>(elemento, null);
        tamanho = 1;
        return raiz;
    }

    public Posicao<E> adicionarFilho(Posicao<E> posicaoPai, E elemento) {
        No<E> pai = validarNo(posicaoPai);
        No<E> filho = new No<>(elemento, pai);
        pai.adicionarFilho(filho);
        tamanho++;
        return filho;
    }

    private No<E> validarNo(Posicao<E> posicao) {
        if (!(posicao instanceof No)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        return (No<E>) posicao;
    }

    public void percursoPreOrdem(Posicao<E> posicao) {
        System.out.print(posicao.getElemento() + " ");

        for (Posicao<E> filho : filhos(posicao)) {
            percursoPreOrdem(filho);
        }
    }

    @Override
    public Posicao<E> raiz() {
        return raiz;
    }

    @Override
    public Posicao<E> pai(Posicao<E> posicao) {
        return validarNo(posicao).getPai();
    }

    @Override
    public Iterable<Posicao<E>> filhos(Posicao<E> posicao) {
        return new ArrayList<>(validarNo(posicao).getFilhos());
    }

    @Override
    public Boolean ehFolha(Posicao<E> posicao) {
        return validarNo(posicao).ehFolha();
    }

    @Override
    public Boolean temFilhos(Posicao<E> posicao) {
        return !validarNo(posicao).getFilhos().isEmpty();
    }

    @Override
    public Boolean temPai(Posicao<E> posicao) {
        return validarNo(posicao).getPai() != null;
    }

    @Override
    public Boolean ehRaiz(Posicao<E> posicao) {
        return posicao == raiz;
    }

    @Override
    public Integer tamanho() {
        return tamanho;
    }

    @Override
    public Boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public Integer altura(Posicao<E> posicao) {
        if (ehFolha(posicao)) return 0;
        Integer altura = 0;
        for (Posicao<E> filho : filhos(posicao)) {
            altura = Math.max(altura, altura(filho));
        }
        return 1 + altura;
    }

    @Override
    public Integer profundidade(Posicao<E> posicao) {
        if (ehRaiz(posicao)) return 0;
        return 1 + profundidade(pai(posicao));
    }

    public No<E> getRaiz() {
        return raiz;
    }

    public void percorrerPreOrdem(No<String> no) {
        percorrerPreOrdemComSetas(no, 0);
    }

    private void percorrerPreOrdemComSetas(No<String> no, int nivel) {
        if (no != null) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            if (nivel > 0) {
                System.out.print("→ ");
            }
            System.out.println(no.getElemento());

            for (No<String> filho : no.getFilhos()) {
                percorrerPreOrdemComSetas(filho, nivel + 1);
            }
        }
    }

    public void percorrerPosOrdem(No<String> no) {
        percorrerPosOrdemComSetas(no, 0);
    }

    private void percorrerPosOrdemComSetas(No<String> no, int nivel) {
        if (no != null) {
            for (No<String> filho : no.getFilhos()) {
                percorrerPosOrdemComSetas(filho, nivel + 1);
            }

            for (int i = 0; i < nivel; i++) {
                System.out.print("  ");
            }
            if (nivel > 0) {
                System.out.print("← ");
            }
            System.out.println(no.getElemento());
        }
    }

    public void imprimirNosFolha(No<String> no) {
        if (no != null) {
            if (no.ehFolha()) {
                System.out.println(no.getElemento());
            }
            for (No<String> filho : no.getFilhos()) {
                imprimirNosFolha(filho);
            }
        }
    }

    public int profundidade(No<String> no) {
        int profundidade = 0;
        No<String> atual = no;
        while (atual.getPai() != null) {
            profundidade++;
            atual = atual.getPai();
        }
        return profundidade;
    }

}
