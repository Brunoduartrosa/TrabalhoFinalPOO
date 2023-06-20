import javax.swing.JOptionPane;

public class Bomba extends ElementoBasico {

    public Bomba(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "fechado.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        System.out.println("BOOM");
        System.out.println("Você perdeu!");
        this.setIcon(Tabuleiro.createImageIcon("bomba.png"));
        JOptionPane.showMessageDialog(null, "BOOM! Você perdeu!", "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
