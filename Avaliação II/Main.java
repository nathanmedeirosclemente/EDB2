public class Main {
    public static void main(String[] args) {
        ArvoreBinariaDeBusca estoque = new ArvoreBinariaDeBusca();
        estoque.inserirProduto(new Produto(101, "Notebook", 50));
        estoque.inserirProduto(new Produto(50, "Mouse", 200));
        estoque.inserirProduto(new Produto(200, "Teclado", 150));

        Produto p = estoque.buscarProduto(50);

        if (p != null) {
            System.out.println("Produto encontrado: " + p.getNome() + ", Quantidade: " + p.getQuantidade() + "\n");
        }
        estoque.exibirProdutosEmOrdem();
        estoque.removerProduto(101);
        estoque.exibirProdutosEmOrdem();
        estoque.menorCodigo();
        estoque.maiorCodigo();
    }
}