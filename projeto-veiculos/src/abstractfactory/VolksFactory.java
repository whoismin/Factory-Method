package abstractfactory;

/**
 * Fábrica Concreta responsável por produzir a família completa de
 * veículos da montadora Volkswagen.
 */
public class VolksFactory implements MontadoraFactory {

    @Override
    public Sedan criarSedan() {
        return new VolksVirtus();
    }

    @Override
    public Hatch criarHatch() {
        return new VolksPolo();
    }

    @Override
    public SUV criarSUV() {
        // Mesma situação da FiatFactory: método novo, criado na Parte 3
        // por causa da mudança na interface MontadoraFactory.
        return new VolksTCross();
    }
}
