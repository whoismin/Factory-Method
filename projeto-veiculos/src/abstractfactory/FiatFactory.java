package abstractfactory;

/**
 * Fábrica Concreta responsável por produzir a família completa de
 * veículos da montadora Fiat.
 */
public class FiatFactory implements MontadoraFactory {

    @Override
    public Sedan criarSedan() {
        return new FiatCronos(); // aqui é o único lugar do projeto que conhece a classe FiatCronos
    }

    @Override
    public Hatch criarHatch() {
        return new FiatArgo();
    }

    @Override
    public SUV criarSUV() {
        // Método incluído na Parte 3. Antes da mudança, esta classe só tinha
        // criarSedan() e criarHatch() - precisou ser atualizada para acompanhar
        // a interface MontadoraFactory.
        return new FiatPulse();
    }
}
