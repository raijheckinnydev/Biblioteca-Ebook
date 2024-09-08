package br.com.bibibloteca.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_LIVRO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String nome;

    @Column(name = "AUTOR", nullable = false, length = 50)
    private String autor;

    @Column(name = "GENERO", nullable = false, length = 50)
    private String genero;

    @Column(name = "DATALANCAMENTO", nullable = false, length = 50)
    private LocalDate dataLancamento;

    @Column(name = "CAPA",  nullable = false, length = 50)
    private byte[] capa;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Capitulo> capitulos;
}
