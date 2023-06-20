import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class App extends JFrame implements ActionListener {
    private Tabuleiro tabuleiro;
    Random r = new Random();
    // private Personagem personagem;

    public App() {
        super();
        // Define dificuldade
        Object[] opcoes = { "1 - Fácil", "2 - Médio", "3 - Difícil" };

        int escolha = JOptionPane.showOptionDialog(null, "Selecione a dificuldade:", "Dificuldade",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        System.out.println(escolha);
        Tabuleiro.setDificuldade(escolha);

        // Cria o tabuleiro
        tabuleiro = new Tabuleiro();

        JPanel painelGeral = new JPanel();
        painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS));
        painelGeral.add(tabuleiro);

        for (int i = 0; i < Tabuleiro.getNumbombas(); i++) {
            tabuleiro.insereElemento(
                    new Bomba("Bomba", r.nextInt(Tabuleiro.getMaxcol()), r.nextInt(Tabuleiro.getMaxlin()), tabuleiro));
        }

        // Exibe a janela
        this.add(painelGeral);

        this.setSize(1100, 1100);
        this.setTitle("Campo Minado");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        tabuleiro.atualizaVisualizacao();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        tabuleiro.atualizaVisualizacao();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}