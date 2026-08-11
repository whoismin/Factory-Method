package abstractfactory;

// Produto concreto da família Fiat para a linha Sedan.
// A ideia aqui é simples: cada montadora tem seu próprio "sabor" de Sedan,
// e o cliente nunca decide diretamente qual classe usar - quem faz isso é a FiatFactory.
public class FiatCronos implements Sedan {

    @Override
    public void exibirPortaMalas() {
        // Valor de porta-malas baseado na ficha técnica real do modelo,
        // só para deixar a demonstração mais próxima da realidade.
        System.out.println("Fiat Cronos (Sedan) - Porta-malas: 525 litros");
    }
}
