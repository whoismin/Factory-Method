package abstractfactory;

/**
 * Produto Abstrato adicionado na Parte 3 da atividade.
 *
 * Representa a nova família de carros do tipo SUV, exigida pelo mercado.
 * A criação desta interface obrigou a alteração de MontadoraFactory e de
 * TODAS as suas implementações concretas (ver observação no README sobre
 * a limitação do padrão Abstract Factory).
 */
public interface SUV {
    void exibirDesempenho();
}
