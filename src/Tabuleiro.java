import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro extends JPanel {
    private static int MAXLIN = 20;
    private static int MAXCOL = 20;
    private static int NUMBOMBAS = 100;
    private ElementoBasico[][] celulas;

    // private Personagem principal;

    public Tabuleiro() {
        super();
        // Cria o conjunto de células vazia e as insere no layout
        celulas = new ElementoBasico[MAXLIN][MAXCOL];
        this.setLayout(new GridLayout(MAXLIN, MAXCOL));
        for (int i = 0; i < MAXLIN; i++) {
            for (int j = 0; j < MAXCOL; j++) {

                celulas[i][j] = new Fundo("Fundo[" + i + "][" + j + "]", i, j, this);
                this.add(celulas[i][j]);
            }
        }
    }

    private static Map<String, ImageIcon> proxi = new HashMap<>();

    public static ImageIcon createImageIcon(String path) {
        if (proxi.containsKey(path)) {
            return proxi.get(path);
        }

        java.net.URL imgURL = App.class.getResource("imagens/" + path);
        if (imgURL != null) {
            ImageIcon aux = new ImageIcon(imgURL);
            aux = ElementoBasico.resize(aux, 32, 32);
            proxi.put(path, aux);
            return aux;
        } else {
            System.err.println("Couldn't find file: " + path);
            System.exit(0);
            return null;
        }
    }

    public static int getMaxlin() {
        return MAXLIN;
    }

    public static int getMaxcol() {
        return MAXCOL;
    }

    public static int getNumbombas() {
        return NUMBOMBAS;
    }

    public boolean posicaoValida(int lin, int col) {
        if ((lin < 0) || (col < 0) ||
                (lin >= MAXLIN) || (col >= MAXCOL)) {
            return false;
        } else {
            return true;
        }
    }

    // Retorna referencia em determinada posição
    public ElementoBasico getElementoNaPosicao(int lin, int col) {
        if (!posicaoValida(lin, col)) {
            return null;
        }
        return celulas[lin][col];
    }

    public ElementoBasico insereElemento(ElementoBasico elemento) {
        int lin = elemento.getLin();
        int col = elemento.getCol();
        if (!posicaoValida(lin, col)) {
            throw new IllegalArgumentException("Posicao invalida:" + lin + " ," + col);
        }
        ElementoBasico elementoAnterior = celulas[lin][col];
        celulas[lin][col] = elemento;
        return elementoAnterior;
    }

    public static void setDificuldade(int value) {
        switch (value) {
            case 0:
                NUMBOMBAS = 5;
                MAXLIN = 5;
                MAXCOL = 5;
                break;
            case 1:
                NUMBOMBAS = 30;
                MAXLIN = 10;
                MAXCOL = 10;
                break;
            case 2:
                NUMBOMBAS = 100;
                MAXLIN = 20;
                MAXCOL = 20;
                break;
        }
    }

    public void atualizaVisualizacao() {
        // Atualiza o conteúdo do JPanel (ver algo melhor)
        this.removeAll(); // erase everything from your JPanel
        this.revalidate();
        this.repaint();// I always do these steps after I modify my JPanel
        for (int i = 0; i < MAXLIN; i++) {
            for (int j = 0; j < MAXCOL; j++) {
                this.add(celulas[i][j]);
            }
        }
    }
}
