package abstractfactory;

// Produto concreto da família Volkswagen para a linha Sedan.
// Equivalente ao FiatCronos, mas do lado da Volks - mesma ideia de família,
// implementação e valores diferentes.
public class VolksVirtus implements Sedan {

    @Override
    public void exibirPortaMalas() {
        System.out.println("Volkswagen Virtus (Sedan) - Porta-malas: 521 litros");
    }
}
