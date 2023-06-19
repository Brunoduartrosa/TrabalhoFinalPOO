import javax.swing.ImageIcon;

public class Bomba extends ElementoBasico {

    ImageIcon imagem = Tabuleiro.createImageIcon("minesweeper.png");

    public Bomba(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grass.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        System.out.println("BOOM");
        System.out.println("Você perdeu!");
        this.setIcon(imagem);
    }
}
