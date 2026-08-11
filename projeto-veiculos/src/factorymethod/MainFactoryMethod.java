package factorymethod;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Classe cliente do padrão Factory Method.
 *
 * A interface gráfica em Swing apenas aciona a fábrica (VeiculoFactory);
 * em nenhum momento este código realiza "new Carro()" ou "new Moto()"
 * diretamente, cumprindo o requisito da atividade.
 */
public class MainFactoryMethod extends JFrame {

    private final JTextArea areaSaida;
    private final VeiculoFactory fabrica;

    public MainFactoryMethod() {
        super("Factory Method - Fábrica de Veículos");
        this.fabrica = new VeiculoFactory();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        areaSaida = new JTextArea();
        areaSaida.setEditable(false);
        areaSaida.setFont(new Font("Consolas", Font.PLAIN, 13));
        JScrollPane scroll = new JScrollPane(areaSaida);

        JButton btnCarro = new JButton("Criar Carro");
        JButton btnMoto = new JButton("Criar Moto");

        btnCarro.addActionListener(e -> criarEExibir("CARRO"));
        btnMoto.addActionListener(e -> criarEExibir("MOTO"));

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnCarro);
        painelBotoes.add(btnMoto);

        add(scroll, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        redirecionarSaidaPadrao();
    }

    /**
     * Redireciona o System.out para a JTextArea, permitindo visualizar na
     * janela o resultado do método exibirDetalhes() de cada Produto Concreto.
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
     * Solicita à fábrica a criação do veículo e exibe seus detalhes.
     * A variável "veiculo" é sempre do tipo Veiculo (a interface),
     * mesmo que o objeto criado por trás seja um Carro ou uma Moto.
     */
    private void criarEExibir(String tipo) {
        Veiculo veiculo = fabrica.criarVeiculo(tipo);
        System.out.println("----------------------------------------");
        veiculo.exibirDetalhes();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFactoryMethod().setVisible(true));
    }
}
