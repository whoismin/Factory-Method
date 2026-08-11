package abstractfactory;

// Produto concreto da família Volkswagen para a linha Hatch.
public class VolksPolo implements Hatch {

    @Override
    public void exibirConsumo() {
        System.out.println("Volkswagen Polo (Hatch) - Consumo médio: 13,8 km/l (cidade)");
    }
}
