package abstractfactory;

// Produto concreto da família Fiat para a linha Hatch.
public class FiatArgo implements Hatch {

    @Override
    public void exibirConsumo() {
        System.out.println("Fiat Argo (Hatch) - Consumo médio: 13,5 km/l (cidade)");
    }
}
