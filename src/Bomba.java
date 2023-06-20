import javax.swing.ImageIcon;

public class Bomba extends ElementoBasico {

    public Bomba(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "fechado.jpg", linInicial, colInicial, tabuleiro);
    }

    ImageIcon imagem = Tabuleiro
            .createImageIcon("minesweeper.jpg");

    @Override
    public void acao(ElementoBasico outro) {
        System.out.println("BOOM");
        System.out.println("Você perdeu!");
        this.setIcon(imagem);
    }
}
