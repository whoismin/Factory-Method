package factorymethod;

/**
 * Produto Concreto: Carro.
 * Implementa o contrato definido pela interface Veiculo.
 */
public class Carro implements Veiculo {

    @Override
    public void exibirDetalhes() {
        System.out.println("Veículo criado: Carro");
        System.out.println(" - Categoria: automóvel de passeio (4 rodas)");
        System.out.println(" - Capacidade média: 5 passageiros");
        System.out.println(" - Uso recomendado: trajetos urbanos e rodoviários");
    }
}
