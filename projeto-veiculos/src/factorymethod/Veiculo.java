package factorymethod;

/**
 * Produto Abstrato do padrão Factory Method.
 *
 * Toda classe concreta que representar um tipo de veículo (Carro, Moto, etc.)
 * deve implementar esta interface, garantindo que o cliente sempre trabalhe
 * com o tipo Veiculo, e nunca diretamente com as classes concretas.
 */
public interface Veiculo {

    /**
     * Exibe as características principais do veículo.
     * Cada classe concreta decide o que e como exibir.
     */
    void exibirDetalhes();
}
