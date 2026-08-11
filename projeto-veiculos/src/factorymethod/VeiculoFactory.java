package factorymethod;

/**
 * Fábrica responsável por encapsular a criação dos objetos que implementam
 * Veiculo. É aqui que o padrão Factory Method se concretiza: o cliente
 * (classe MainFactoryMethod) delega a decisão de "qual classe instanciar"
 * para este método, em vez de usar o operador "new" diretamente sobre
 * Carro ou Moto.
 *
 * Vantagem principal: se um novo tipo de veículo precisar ser adicionado
 * no futuro (ex.: Caminhao), basta alterar esta fábrica, sem impactar
 * o código cliente que já está em produção.
 */
public class VeiculoFactory {

    /**
     * Cria uma instância de Veiculo de acordo com o tipo informado.
     *
     * @param tipo "CARRO" ou "MOTO" (não sensível a maiúsculas/minúsculas)
     * @return instância concreta de Veiculo correspondente ao tipo
     * @throws IllegalArgumentException caso o tipo informado seja inválido
     */
    public Veiculo criarVeiculo(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo de veículo não pode ser nulo.");
        }

        switch (tipo.trim().toUpperCase()) {
            case "CARRO":
                return new Carro(); // este é o único ponto do projeto onde "new Carro()" aparece
            case "MOTO":
                return new Moto();  // e o único onde "new Moto()" aparece
            default:
                // Evita que um erro de digitação no tipo passe despercebido
                // e vá gerar um NullPointerException lá na frente.
                throw new IllegalArgumentException("Tipo de veículo inválido: " + tipo);
        }
    }
}
