public class Fundo extends ElementoBasico {

    public Fundo(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grass.jpg", linInicial, colInicial, tabuleiro);
        // super(id, "fundo.jpg", linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        // implementar método que abre mostra o número
        throw new UnsupportedOperationException("Unimplemented method 'acao'");
    }
}
