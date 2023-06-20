import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fundo extends ElementoBasico {
    private boolean aberto = false;
    private int numeroBombas = 0;

    public Fundo(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grass.jpg", linInicial, colInicial, tabuleiro);
    }

    ImageIcon imagemAberto = Tabuleiro.createImageIcon("wall.jpg");

    public void abrir() {
        this.aberto = true;
        this.setIcon(imagemAberto);
    }

    @Override
    public void acao(ElementoBasico outro) {
        this.abrir();
    }
}
