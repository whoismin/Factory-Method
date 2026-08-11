package abstractfactory;

/**
 * Fábrica Abstrata (Abstract Factory).
 *
 * Define o contrato que toda montadora deve seguir para produzir sua
 * família completa de veículos (Sedan, Hatch e, a partir da Parte 3, SUV).
 *
 * OBSERVAÇÃO IMPORTANTE:
 * 
 * O método criarSUV() foi acrescentado após a implementação inicial das
 * fábricas concretas. Isso obrigou a alteração de TODAS as classes que
 * implementam esta interface (FiatFactory e VolksFactory), pois em Java
 * uma interface exige que todo método declarado seja implementado por
 * quem a assina. Essa é justamente a principal limitação do Abstract
 * Factory: adicionar um novo tipo de produto à família tem impacto em
 * cascata sobre todas as fábricas concretas já existentes.
 */
public interface MontadoraFactory {
    Sedan criarSedan();
    Hatch criarHatch();
    SUV criarSUV();
}
