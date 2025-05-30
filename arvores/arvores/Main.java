public class Main {

    public static void main(String[] args) {
        ArvoreGenerica arvore = new ArvoreGenerica();

        No<String> empresa = (No<String>) arvore.adicionarRaiz("Empresa");
        No<String> rh = (No<String>) arvore.adicionarFilho(empresa, "RH");
        No<String> recrutamento = (No<String>) arvore.adicionarFilho(rh, "Recrutamento");
        No<String> estagios = (No<String>) arvore.adicionarFilho(recrutamento, "Estágios");
        No<String> beneficios = (No<String>) arvore.adicionarFilho(rh, "Benefícios");
        No<String> convenios = (No<String>) arvore.adicionarFilho(beneficios, "Convênios");

        No<String> ti = (No<String>) arvore.adicionarFilho(empresa, "TI");
        No<String> desenvolvimento = (No<String>) arvore.adicionarFilho(ti, "Desenvolvimento");
        No<String> frontend = (No<String>) arvore.adicionarFilho(desenvolvimento, "Front-end");
        No<String> angular = (No<String>) arvore.adicionarFilho(frontend, "Angular");
        No<String> backend = (No<String>) arvore.adicionarFilho(desenvolvimento, "Back-end");
        No<String> suporte = (No<String>) arvore.adicionarFilho(ti, "Suporte");

        No<String> financeiro = (No<String>) arvore.adicionarFilho(empresa, "Financeiro");
        No<String> contabilidade = (No<String>) arvore.adicionarFilho(financeiro, "Contabilidade");
        No<String> impostos = (No<String>) arvore.adicionarFilho(contabilidade, "Impostos");

        // 2. Impressão em pré-ordem
        System.out.println("Pré-ordem:");
        arvore.percorrerPreOrdem(arvore.getRaiz());

        // 2. Impressão em pós-ordem
        System.out.println("\n\nPós-ordem:");
        arvore.percorrerPosOrdem(arvore.getRaiz());

        // 4. Imprimir apenas nós folha
        System.out.println("\n\nNós folha:");
        arvore.imprimirNosFolha(arvore.getRaiz());

        // 5. Exemplo: Profundidade de "Angular"
        int profundidadeAngular = arvore.profundidade(angular);
        System.out.println("\nProfundidade de 'Angular': " + profundidadeAngular);
    }
}