package factorymethod;

/**
 * Produto Concreto: Moto.
 * Implementa o contrato definido pela interface Veiculo.
 */
public class Moto implements Veiculo {

    @Override
    public void exibirDetalhes() {
        System.out.println("Veículo criado: Moto");
        System.out.println(" - Categoria: veículo de duas rodas");
        System.out.println(" - Capacidade média: 1 a 2 passageiros");
        System.out.println(" - Uso recomendado: deslocamentos rápidos em áreas urbanas");
    }
}
