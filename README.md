# Factory-Method

# Padrões de Projeto Criacionais: Factory Method e Abstract Factory

**Disciplina:** Padrões de Projeto (Design Patterns)
**Atividade:** Factory Method / Abstract Factory
**Dupla de alunos:** Yasmin Oliveira e Leticia Borges
**IDE utilizada:** NetBeans
**Linguagem:** Java (Swing)

---

## 1. Objetivo da atividade

Este repositório reúne a implementação de dois padrões criacionais do GoF (Gang of Four):

- **Factory Method**, aplicado à criação de veículos (`Carro` e `Moto`);
- **Abstract Factory**, aplicado à criação de famílias de veículos por montadora (Fiat e Volkswagen), incluindo o desafio proposto na Parte 3 (inclusão da linha **SUV**).

O código está organizado em dois pacotes independentes, cada um com sua própria classe `main` e interface gráfica em Swing:

```
src/
 ├── factorymethod/
 │    ├── Veiculo.java
 │    ├── Carro.java
 │    ├── Moto.java
 │    ├── VeiculoFactory.java
 │    └── MainFactoryMethod.java
 └── abstractfactory/
      ├── Sedan.java
      ├── Hatch.java
      ├── SUV.java
      ├── FiatCronos.java
      ├── FiatArgo.java
      ├── FiatPulse.java
      ├── VolksVirtus.java
      ├── VolksPolo.java
      ├── VolksTCross.java
      ├── MontadoraFactory.java
      ├── FiatFactory.java
      ├── VolksFactory.java
      └── MainAbstractFactory.java
```

---

## 2. Parte 1 — Factory Method

A interface `Veiculo` define o contrato `exibirDetalhes()`, implementado pelas classes concretas `Carro` e `Moto`. A criação dos objetos é delegada à classe `VeiculoFactory`, que centraliza a decisão de qual classe instanciar a partir de uma `String` (`"CARRO"` ou `"MOTO"`).

A classe `MainFactoryMethod` é o cliente: sua interface Swing possui dois botões que chamam `fabrica.criarVeiculo(tipo)`. Em nenhum momento o cliente executa `new Carro()` ou `new Moto()` diretamente — toda a criação passa pela fábrica.

### Diagrama de classes — Factory Method
<img width="619" height="762" alt="d1 drawio" src="https://github.com/user-attachments/assets/f5f9c255-7e22-415f-ac04-43fb262770a3" />


## 3. Parte 2 — Abstract Factory

Foram criadas duas famílias de produtos:

- **Sedan** (`exibirPortaMalas()`)
- **Hatch** (`exibirConsumo()`)

E duas famílias de montadoras, cada uma com sua fábrica concreta:

| Montadora  | Sedan       | Hatch      |
|------------|-------------|------------|
| Fiat       | FiatCronos  | FiatArgo   |
| Volkswagen | VolksVirtus | VolksPolo  |

A interface `MontadoraFactory` define os métodos `criarSedan()` e `criarHatch()`, implementados por `FiatFactory` e `VolksFactory`.

---

## 4. Parte 3 — Desafio: adicionando a linha SUV

Com a mudança no mercado, foi necessário incluir um novo tipo de produto — **SUV** — em ambas as famílias (`FiatPulse` e `VolksTCross`).

**O que essa mudança evidenciou na prática:**

Diferente do Factory Method (onde bastaria alterar apenas a fábrica), no Abstract Factory a inclusão de um novo tipo de produto exige alterar a **interface** `MontadoraFactory` (adicionando `criarSUV()`), o que obriga **todas** as fábricas concretas já existentes — `FiatFactory` e `VolksFactory` — a implementar o novo método, mesmo que já estivessem prontas e testadas.

Esse é um efeito colateral conhecido do padrão Abstract Factory: ele facilita a troca de **famílias inteiras** de produtos (baixo acoplamento entre cliente e classes concretas), mas dificulta a adição de **novos tipos de produto** dentro dessas famílias, pois o impacto se propaga em cascata para todas as fábricas concretas. Em outras palavras, o padrão otimiza a extensibilidade "na horizontal" (novas montadoras) em detrimento da extensibilidade "na vertical" (novos tipos de produto).

### Diagrama de classes — Abstract Factory (já com SUV)

<img width="1425" height="717" alt="d1-Página-2 drawio" src="https://github.com/user-attachments/assets/208fc3d5-cf28-49ec-a76e-b1152523f420" />

---

## 5. Como executar no NetBeans

1. Abra o NetBeans e crie um novo projeto Java com Ant: **File → New Project → Java with Ant → Java Application**.
2. Dê um nome ao projeto (ex.: `PadroesCriacionaisVeiculos`) e desmarque a criação automática da classe principal.
3. Copie as pastas `factorymethod` e `abstractfactory` (com todos os `.java`) para dentro de `src` do projeto criado.
4. No NetBeans, clique com o botão direito em `MainFactoryMethod.java` → **Run File** para testar a Parte 1.
5. Clique com o botão direito em `MainAbstractFactory.java` → **Run File** para testar as Partes 2 e 3.

---

## 6. Resumo comparativo dos padrões

| Aspecto              | Factory Method                          | Abstract Factory                                  |
|-----------------------|------------------------------------------|-----------------------------------------------------|
| Objetivo              | Criar um objeto de um único tipo/produto | Criar famílias inteiras de objetos relacionados     |
| Ponto de variação     | O tipo do produto (`Carro`, `Moto`)      | A família de produtos (montadora)                    |
| Facilidade de extensão| Fácil adicionar novo produto             | Fácil adicionar nova família; difícil adicionar novo tipo de produto na família (ver Parte 3) |

---

## 7. Estrutura de pacotes e organização do código

- **`factorymethod`** — contém toda a solução da Parte 1.
- **`abstractfactory`** — contém toda a solução das Partes 2 e 3.
- Todas as classes estão comentadas com Javadoc explicando sua responsabilidade dentro do padrão.
