public class Vetor {
    private Object[] elementos;
    private int tamanho;

//    Adicionar a capacidade de elementos
    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

//    Adicionar elementos
    public void adiciona(Object elemento) throws Exception {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            ++this.tamanho;
        } else {
            throw new Exception("Vetor está cheio");
        }
    }

//    Tamanho
    public int tamanho() {
        return tamanho;
    }

//    Aumentar a capacidade
    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

//    toString
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int i=0; i<this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append("\n");
        }

        if(this.tamanho> 0){
            s.append(this.elementos[this.tamanho-1]);
        }

        return s.toString();
    }

//    Remover elementos
    public void removerElementos(int posicao) throws Exception {
        if (posicao >= 0 && posicao < this.tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) { // Altere aqui de i-- para i++
                this.elementos[i] = this.elementos[i + 1];
            }
            this.tamanho--;
            this.elementos[this.tamanho] = null; // Limpe a última posição para evitar referências nulas
        } else {
            throw new Exception("Posição Inválida");
        }
    }
    public int buscarSerieNome(String nome) {
        for (int i = 0; i < this.tamanho; i++) {
            Series serie = (Series) elementos[i];
            if (serie.getNome().trim().equalsIgnoreCase(nome)) {
                return i; // Retorna a posição quando o nome é encontrado
            }
        }
        return -1; // Retorna -1 se o nome não for encontrado
    }

//    Encontrar Série
    public Series buscarSerie(String nome) {
        for (int i = 0; i < this.tamanho; i++) {
            if (elementos[i] instanceof Series) {
                Series serie = (Series) elementos[i];
                if(serie.getNome().trim().equalsIgnoreCase(nome)) {
                    return serie; // Retorna serie se for encontrado
                }
            }
        }
        return null; // Retorna null se o nome não for encontrado
    }

//    Buscar elementos
    public Object buscarElementos(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return elementos[posicao];
        } else {
            throw new Exception("Posição Inválida");
        }
    }

//    Adicionar no inicio
    public boolean adicionarInicio(int posicao, Object elemento) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for(int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i+1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Posição Inválida");
        }
        return true;
    }
}