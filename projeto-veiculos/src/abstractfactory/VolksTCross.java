package abstractfactory;

// Produto concreto da família Volkswagen para a linha SUV.
// Assim como o FiatPulse, essa classe foi adicionada na Parte 3 do trabalho,
// quando o desafio pediu para incluir a linha SUV nas duas montadoras.
public class VolksTCross implements SUV {

    @Override
    public void exibirDesempenho() {
        System.out.println("Volkswagen T-Cross (SUV) - Motor 1.0 TSI, 128 cv");
    }
}
