package br.com.gabrielmsantos.carrinho_compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinhoDeCompras;

    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        carrinhoDeCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!carrinhoDeCompras.isEmpty()) {
            for (Item i : carrinhoDeCompras) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            carrinhoDeCompras.removeAll(itensParaRemover);
        } else {
            System.out.printf("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double total = 0d;
        for (Item i : carrinhoDeCompras) {
            total += (i.getPreco() * i.getQuantidade());
        }

        return total;
    }

    public void exibirItens() {
        if (!carrinhoDeCompras.isEmpty()) {
            System.out.println(carrinhoDeCompras);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "carrinhoDeCompras=" + carrinhoDeCompras +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Tomate", 10.3, 1);
        carrinhoDeCompras.adicionarItem("Tomate", 10.3, 2);
        carrinhoDeCompras.adicionarItem("Morango", 15.0, 1);

        System.out.printf("\nVoce tem " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Morango");

        System.out.printf("\nAgora voce tem " + carrinhoDeCompras.calcularValorTotal());
    }


}
