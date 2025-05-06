package org.view;

import org.dao.LivroDAO;
import org.model.Livro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAO();

        // Para adicionar um novo livro ao banco de dados, crie uma instância de Livro
        // com os dados desejados (título, autor, ano de publicação e preço)
        // e chame o método salvar() do LivroDAO.
        // Exemplo:
        // Livro novoLivro = new Livro("Nome do Livro", "Autor do Livro", 2025, 49.90);
        // dao.salvar(novoLivro);


        Livro livro1 = new Livro("1984", "George Orwell", 1949, 29.90);
        Livro livro2 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937, 35.50);

        dao.salvar(livro1);
        dao.salvar(livro2);

        System.out.println("\n--- Lista de livros:");
        List<Livro> livros = dao.listarTodos();
        livros.forEach(System.out::println);

        livro1.setPreco(31.90);
        dao.atualizar(livro1);

        System.out.println("\n--- Livro atualizado:");
        System.out.println(dao.buscarPorId(livro1.getId()));

        dao.remover(livro2.getId());

        System.out.println("\n--- Lista final de livros:");
        dao.listarTodos().forEach(System.out::println);
    }
}