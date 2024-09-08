package br.com.bibibloteca.repository;

import br.com.bibibloteca.domain.Capitulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICapituloRepository extends JpaRepository<Capitulo, Long> {
}
