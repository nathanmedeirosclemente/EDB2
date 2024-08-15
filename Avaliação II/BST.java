class Produto {
    int codigo;
    String nome;
    int quantidade;

    Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }
}

class Nodo {
    Produto produto;
    Nodo esquerda;
    Nodo direita;

    Nodo(Produto produto) {
        this.produto = produto;
        esquerda = direita = null;
    }
}

class BST {
    private Nodo raiz;

    // Método para inserir ou atualizar um produto
    public void inserir(int codigo, String nome, int quantidade) {
        raiz = inserirRecursivo(raiz, new Produto(codigo, nome, quantidade));
    }

    private Nodo inserirRecursivo(Nodo raiz, Produto produto) {
        if (raiz == null) {
            raiz = new Nodo(produto);
            return raiz;
        }

        if (produto.codigo < raiz.produto.codigo) {
            raiz.esquerda = inserirRecursivo(raiz.esquerda, produto);
        } else if (produto.codigo > raiz.produto.codigo) {
            raiz.direita = inserirRecursivo(raiz.direita, produto);
        } else {
            raiz.produto.quantidade += produto.quantidade; // Atualiza a quantidade
        }

        return raiz;
    }

    // Método para buscar um produto pelo código
    public Produto buscar(int codigo) {
        Nodo nodo = buscarRecursivo(raiz, codigo);
        return (nodo != null) ? nodo.produto : null;
    }

    private Nodo buscarRecursivo(Nodo raiz, int codigo) {
        if (raiz == null || raiz.produto.codigo == codigo) {
            return raiz;
        }

        if (codigo < raiz.produto.codigo) {
            return buscarRecursivo(raiz.esquerda, codigo);
        } else {
            return buscarRecursivo(raiz.direita, codigo);
        }
    }

    // Método para remover um produto pelo código
    public void remover(int codigo) {
        raiz = removerRecursivo(raiz, codigo);
    }

    private Nodo removerRecursivo(Nodo raiz, int codigo) {
        if (raiz == null) return raiz;

        if (codigo < raiz.produto.codigo) {
            raiz.esquerda = removerRecursivo(raiz.esquerda, codigo);
        } else if (codigo > raiz.produto.codigo) {
            raiz.direita = removerRecursivo(raiz.direita, codigo);
        } else {
            // Nodo encontrado
            if (raiz.esquerda == null) return raiz.direita;
            if (raiz.direita == null) return raiz.esquerda;

            raiz.produto = menorCodigoNodo(raiz.direita).produto;
            raiz.direita = removerRecursivo(raiz.direita, raiz.produto.codigo);
        }

        return raiz;
    }

    // Método para exibir os produtos em ordem crescente de código
    public void exibirEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
    }

    private void exibirEmOrdemRecursivo(Nodo raiz) {
        if (raiz != null) {
            exibirEmOrdemRecursivo(raiz.esquerda);
            System.out.println("Código: " + raiz.produto.codigo + ", Nome: " + raiz.produto.nome + ", Quantidade: " + raiz.produto.quantidade);
            exibirEmOrdemRecursivo(raiz.direita);
        }
    }

    // Método para encontrar o produto com o menor código
    public Produto menorCodigo() {
        if (raiz == null) return null;
        Nodo nodo = menorCodigoNodo(raiz);
        return nodo.produto;
    }

    private Nodo menorCodigoNodo(Nodo raiz) {
        while (raiz.esquerda != null) {
            raiz = raiz.esquerda;
        }
        return raiz;
    }

    // Método para encontrar o produto com o maior código
    public Produto maiorCodigo() {
        if (raiz == null) return null;
        Nodo nodo = maiorCodigoNodo(raiz);
        return nodo.produto;
    }

    private Nodo maiorCodigoNodo(Nodo raiz) {
        while (raiz.direita != null) {
            raiz = raiz.direita;
        }
        return raiz;
    }
}
