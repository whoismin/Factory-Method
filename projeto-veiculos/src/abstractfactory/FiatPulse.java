package abstractfactory;

// Produto concreto da família Fiat para a linha SUV.
// Essa classe não existia na versão inicial do projeto - ela surgiu na Parte 3,
// quando a linha de SUV entrou no catálogo e a família Fiat precisou de mais um produto.
public class FiatPulse implements SUV {

    @Override
    public void exibirDesempenho() {
        System.out.println("Fiat Pulse (SUV) - Motor 1.0 Turbo 200, 130 cv");
    }
}
