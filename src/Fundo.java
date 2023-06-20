import javax.swing.ImageIcon;

public class Fundo extends ElementoBasico {
    private boolean aberto = false;

    public Fundo(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grass.jpg", linInicial, colInicial, tabuleiro);
    }

    ImageIcon imagemAberto = Tabuleiro
            .createImageIcon("wall.jpg");

    @Override
    public void acao(ElementoBasico outro) {
        this.aberto = true;
        // implementar método que mostra todos os números ao redor
        this.setIcon(imagemAberto);

    }
}
