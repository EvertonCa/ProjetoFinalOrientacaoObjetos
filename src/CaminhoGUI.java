public class CaminhoGUI {
    public CaminhoGUI(String direcao, int tamanho)
    {
        this.direcao = direcao;
        this.tamanho = tamanho;
    }

    public String getDirecao() {
        return direcao;
    }

    public int getTamanho() {
        return tamanho;
    }

    private String direcao;
    private int tamanho;
}
