public class ArvoreBinariaDeBusca {
    private class No {
        private Produto produto;
        private No esquerda, direita, pai;

        No(Produto produto) {
            this.produto = produto;
        }

        // Getters e Setters
        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public No getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(No esquerda) {
            this.esquerda = esquerda;
        }

        public No getDireita() {
            return direita;
        }

        public void setDireita(No direita) {
            this.direita = direita;
        }

        public No getPai() {
            return pai;
        }

        public void setPai(No pai) {
            this.pai = pai;
        }
    }

    private No raiz;

    // Método para inserir ou atualizar um produto
    public void inserirProduto(Produto produto) {
        raiz = inserirRecursivo(raiz, produto, null);
    }

    private No inserirRecursivo(No no, Produto produto, No pai) {
        if (no == null) {
            No novoNo = new No(produto);
            novoNo.setPai(pai);
            return novoNo;
        }

        if (produto.getCodigo() < no.getProduto().getCodigo()) {
            // Código menor, insere na subárvore esquerda
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), produto, no));
        } else if (produto.getCodigo() > no.getProduto().getCodigo()) {
            // Código maior, insere na subárvore direita
            no.setDireita(inserirRecursivo(no.getDireita(), produto, no));
        } else {
            // Código igual, atualiza a quantidade
            no.getProduto().setQuantidade(no.getProduto().getQuantidade() + produto.getQuantidade());
        }

        return no;
    }

    // Método para buscar um produto pelo código
    public Produto buscarProduto(int codigo) {
        No no = buscarRecursivo(raiz, codigo);
        if (no != null) {
            System.out.println();
            return no.getProduto();
        } else {
            System.out.println("Produto não encontrado");
            return null;
        }
    }

    private No buscarRecursivo(No raiz, int codigo) {
        if (raiz == null || raiz.getProduto().getCodigo() == codigo) {
            return raiz;
        }

        if (codigo < raiz.getProduto().getCodigo()) {
            return buscarRecursivo(raiz.getEsquerda(), codigo);
        } else {
            return buscarRecursivo(raiz.getDireita(), codigo);
        }
    }

    // Método para remover um produto pelo código
    public void removerProduto(int codigo) {
        raiz = removerRecursivo(raiz, codigo);
    }

    private No removerRecursivo(No raiz, int codigo) {
        if (raiz == null)
            return raiz;

        if (codigo < raiz.getProduto().getCodigo()) {
            raiz.setEsquerda(removerRecursivo(raiz.getEsquerda(), codigo));
        } else if (codigo > raiz.getProduto().getCodigo()) {
            raiz.setDireita(removerRecursivo(raiz.getDireita(), codigo));
        } else {
            // No encontrado
            if (raiz.getEsquerda() == null)
                return raiz.getDireita();
            if (raiz.getDireita() == null)
                return raiz.getEsquerda();

            No menorNo = menorCodigoNo(raiz.getDireita());
            raiz.setProduto(menorNo.getProduto());
            raiz.setDireita(removerRecursivo(raiz.getDireita(), raiz.getProduto().getCodigo()));
        }

        return raiz;
    }

    // Método para exibir os produtos em ordem crescente de código
    public void exibirProdutosEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirEmOrdemRecursivo(No raiz) {
        if (raiz != null) {
            exibirEmOrdemRecursivo(raiz.getEsquerda());
            System.out.println("Código: " + raiz.getProduto().getCodigo() + ", Nome: " + raiz.getProduto().getNome()
                    + ", Quantidade: " + raiz.getProduto().getQuantidade());
            exibirEmOrdemRecursivo(raiz.getDireita());
        }
    }

    // Método para encontrar o produto com o menor código
    public void menorCodigo() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            No no = menorCodigoNo(raiz);
            Produto produto = no.getProduto();
            System.out.println("Menor código: " + produto.getCodigo() + ", Nome do produto: " + produto.getNome()
                    + ", Quantidade: " + produto.getQuantidade());
        }
    }

    private No menorCodigoNo(No raiz) {
        while (raiz.getEsquerda() != null) {
            raiz = raiz.getEsquerda();
        }
        return raiz;
    }

    // Método para encontrar o produto com o maior código
    public void maiorCodigo() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
        } else {
            No no = maiorCodigoNo(raiz);
            Produto produto = no.getProduto();
            System.out.println("Maior código: " + produto.getCodigo() + ", Nome do produto: " + produto.getNome()
                    + ", Quantidade: " + produto.getQuantidade());
        }
    }

    private No maiorCodigoNo(No raiz) {
        while (raiz.getDireita() != null) {
            raiz = raiz.getDireita();
        }
        return raiz;
    }
}