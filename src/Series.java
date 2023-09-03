import javax.swing.*;

public class Series {
    private String nome;
    private int numeroDeEpisodios;
    private int numeroDeTemporadas;
    private int avaliacao;

    public Series() {
    }
    public Series(String nome, int numeroDeEpisodios, int numeroDeTemporadas) {
        this.nome = nome;
        this.numeroDeEpisodios = numeroDeEpisodios;
        this.numeroDeTemporadas = numeroDeTemporadas;
        this.avaliacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeEpisodios() {
        return numeroDeEpisodios;
    }

    public void setNumeroDeEpisodios(int numeroDeEpisodios) {
        this.numeroDeEpisodios = numeroDeEpisodios;
    }

    public int getNumeroDeTemporadas() {
        return numeroDeTemporadas;
    }

    public void setNumeroDeTemporadas(int numeroDeTemporadas) {
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao() {
        String[] opcao = {"1 Estrela", "2 Estrelas", "3 Estrelas", "4 Estrelas", "5 Estrelas"};
        int total = JOptionPane.showOptionDialog(null, "Avalie a série:", "Avaliação de Série",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[4]);

        if (total != -1) {
            avaliacao += total + 1;
            JOptionPane.showMessageDialog(null, "Você avaliou a série com " + (total + 1) + " estrela(s).");
        }
    }

    public String toString() {
        return "[Nome da série: " + this.nome + "]" +
                "\n[Números de episodios: " + this.numeroDeEpisodios + "]" +
                "\n[Números de temporadas: " + this.numeroDeTemporadas + "]" +
                "\n[Avaliação: " + this.avaliacao + " estrela(s)]" +
                "\n=====================================";
    }
}