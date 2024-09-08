package br.com.bibibloteca.repository;

import br.com.bibibloteca.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILivroReposity extends JpaRepository<Livro, Long> {
}
