package br.com.bibibloteca.services;

import br.com.bibibloteca.domain.Livro;

import java.util.List;

public interface ILivroService {
    public void cadastrar(Livro book);
    public Livro buscarPorId(Long id);
    public void alterar(Livro livro);
    public void remover(Long id);
    public List<Livro> buscarTodos();
}
