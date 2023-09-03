import javax.swing.*;
public class Teste {
    private static Vetor vetor = new Vetor(10);
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao programa, Crie uma lista com suas séries favoritas aqui!", "Séries", JOptionPane.INFORMATION_MESSAGE);
        int resp = 0;
        do {
            String valores [] = {"Adicionar Séries", "Remover Séries", "Buscar uma série", "Exibir lista completa", "Sair"};
            Object escolha = JOptionPane.showInputDialog (null, "O que deseja fazer?", "Séries", JOptionPane.WARNING_MESSAGE, null, valores, valores[0]);

            if (escolha.equals("Adicionar Séries")) {
                adicionarSeries();
            } else if (escolha.equals("Remover Séries")) {
                removerSeries();
            } else if (escolha.equals("Buscar uma série")) {
                encontrarSeries();
            } else if (escolha.equals("Exibir lista completa")) {
                exibirListaSeries();
            } else if (escolha.equals("Sair")){
                resp = 1;
            }
        } while (resp == 0);
    }
    private static void adicionarSeries() {
        StringBuilder seriesAdicionadas = new StringBuilder();
        Series serie;

        while (true) {
            String nome = JOptionPane.showInputDialog("Digite o nome da série: ");
            int numeroDeEpisodios = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de episódios: "));
            int numeroDeTemporadas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de temporadas: "));

            serie = new Series(nome, numeroDeEpisodios, numeroDeTemporadas);
            serie.setAvaliacao();

            try {
                vetor.adiciona(serie);
                seriesAdicionadas.append(serie).append("\n");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

            int resposta = JOptionPane.showConfirmDialog(null, "Você deseja adicionar mais séries?", "Séries", JOptionPane.YES_NO_OPTION);

            if (resposta != JOptionPane.YES_OPTION) {
                break;
            }
        }

        if (seriesAdicionadas.length() == 1) {
            JOptionPane.showMessageDialog(null, "Você adicionou as seguinte série favorita:\n\n" + seriesAdicionadas.toString(), "Série", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Você adicionou as seguintes séries favoritas:\n\n" + seriesAdicionadas.toString(), "Séries", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void removerSeries() {
        String nomeSerie = JOptionPane.showInputDialog("Digite o nome da série a ser removida:").trim().toLowerCase();

        try {
            int posicaoParaRemover = vetor.buscarSerieNome(nomeSerie);
            if (posicaoParaRemover != -1) {
                vetor.removerElementos(posicaoParaRemover);
                JOptionPane.showMessageDialog(null, "Série removida com sucesso.", "Séries", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Série não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void encontrarSeries() {
        while (true) {
            String nomeSerie = JOptionPane.showInputDialog("Digite o nome da série que deseja procurar: ").trim().toLowerCase();
            Series encontrarSerie = vetor.buscarSerie(nomeSerie);
            if (encontrarSerie != null) {
                JOptionPane.showMessageDialog(null,"Série encontrada:" + "\n" + encontrarSerie);
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja encontrar outra série? ");

                if (resposta != JOptionPane.YES_OPTION) {
                    break;
                }
            } else {
                int resposta = JOptionPane.showConfirmDialog(null, "Série não encontrada, deseja encontrar novamente? ");

                if (resposta != JOptionPane.YES_OPTION) {
                    break;
                }
            }
        }
    }
    private static void exibirListaSeries() {
        if (vetor.tamanho() == 0) {
            JOptionPane.showMessageDialog(null, "Você não tem séries adicionadas");
        } else {
            JOptionPane.showMessageDialog(null, vetor.toString());
        }
    }
}