public class Estoque {

    public static void main(String[] args) {
        BST estoque = new BST();

        // Inserindo produtos no estoque
        estoque.inserir(101, "Geladeira", 50);
        estoque.inserir(55, "iPhone", 30);
        estoque.inserir(200, "Chinelo", 20);
        estoque.inserir(101, "Camisinha", 10);  // Atualiza a quantidade do Produto A

        // Exibindo produtos em ordem
        System.out.println("Produtos em ordem crescente de código:");
        estoque.exibirEmOrdem();

        // Buscar um produto pelo código
        System.out.println("\nBuscando o Produto com código 101:");
        Produto produto = estoque.buscar(101);
        if (produto != null) {
            System.out.println("Código: " + produto.codigo + ", Nome: " + produto.nome + ", Quantidade: " + produto.quantidade);
        } else {
            System.out.println("Produto não encontrado.");
        }

        // Exibir produto com menor código
        System.out.println("\nProduto com o menor código:");
        Produto menorProduto = estoque.menorCodigo();
        if (menorProduto != null) {
            System.out.println("Código: " + menorProduto.codigo + ", Nome: " + menorProduto.nome + ", Quantidade: " + menorProduto.quantidade);
        }

        // Exibir produto com maior código
        System.out.println("\nProduto com o maior código:");
        Produto maiorProduto = estoque.maiorCodigo();
        if (maiorProduto != null) {
            System.out.println("Código: " + maiorProduto.codigo + ", Nome: " + maiorProduto.nome + ", Quantidade: " + maiorProduto.quantidade);
        }

        // Remover um produto
        System.out.println("\nRemovendo o Produto com código 55:");
        estoque.remover(55);

        // Exibir produtos em ordem após remoção
        System.out.println("\nProdutos em ordem crescente de código após remoção:");
        estoque.exibirEmOrdem();
    }
}
