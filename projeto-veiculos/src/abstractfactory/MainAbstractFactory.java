package abstractfactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Classe cliente do padrão Abstract Factory.
 *
 * O usuário escolhe a montadora (Fiat ou Volkswagen) em um JComboBox e,
 * a partir daí, os botões acionam a fábrica correspondente para gerar
 * Sedan, Hatch ou SUV. O cliente depende apenas da interface
 * MontadoraFactory, nunca instancia FiatFactory ou VolksFactory
 * diretamente fora do ponto de seleção da montadora.
 */
public class MainAbstractFactory extends JFrame {

    private final JTextArea areaSaida;
    private final JComboBox<String> comboMontadora;
    private MontadoraFactory fabricaAtual;

    public MainAbstractFactory() {
        super("Abstract Factory - Fábrica de Montadoras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 420);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        comboMontadora = new JComboBox<>(new String[]{"Fiat", "Volkswagen"});
        comboMontadora.addActionListener(e -> atualizarFabrica());

        areaSaida = new JTextArea();
        areaSaida.setEditable(false);
        areaSaida.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(areaSaida);

        JButton btnSedan = new JButton("Criar Sedan");
        JButton btnHatch = new JButton("Criar Hatch");
        JButton btnSuv = new JButton("Criar SUV");

        // Repare que os três listeners abaixo chamam sempre "fabricaAtual",
        // nunca "new FiatCronos()" ou coisa parecida. É por isso que trocar
        // a montadora no combo muda o resultado sem alterar uma linha sequer
        // destes botões.
        btnSedan.addActionListener(e -> fabricaAtual.criarSedan().exibirPortaMalas());
        btnHatch.addActionListener(e -> fabricaAtual.criarHatch().exibirConsumo());
        btnSuv.addActionListener(e -> fabricaAtual.criarSUV().exibirDesempenho());

        JPanel painelTopo = new JPanel();
        painelTopo.add(new JLabel("Montadora:"));
        painelTopo.add(comboMontadora);

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnSedan);
        painelBotoes.add(btnHatch);
        painelBotoes.add(btnSuv);

        add(painelTopo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        redirecionarSaidaPadrao();
        atualizarFabrica();
    }

    /**
     * Redireciona o System.out para a JTextArea, permitindo visualizar
     * na janela o resultado dos métodos de cada Produto Concreto.
     */
    private void redirecionarSaidaPadrao() {
        OutputStream saida = new OutputStream() {
            @Override
            public void write(int b) {
                areaSaida.append(String.valueOf((char) b));
                areaSaida.setCaretPosition(areaSaida.getDocument().getLength());
            }
        };
        System.setOut(new PrintStream(saida, true));
    }

    /**
     * Troca a fábrica concreta de acordo com a montadora selecionada no combo.
     * Este é o único trecho da classe que efetivamente decide entre
     * FiatFactory e VolksFactory - todo o resto do código só enxerga
     * a interface MontadoraFactory.
     */
    private void atualizarFabrica() {
        String selecionado = (String) comboMontadora.getSelectedItem();
        fabricaAtual = "Fiat".equals(selecionado) ? new FiatFactory() : new VolksFactory();
        System.out.println("----------------------------------------");
        System.out.println("Montadora selecionada: " + selecionado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainAbstractFactory().setVisible(true));
    }
}
