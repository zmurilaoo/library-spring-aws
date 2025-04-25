package io.github.cursodsousa.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livros")
@Data
@NoArgsConstructor


public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "dataPublicacao")
    private LocalDate data_publicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private  GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    //Cascade - "puxar" - Qualquer operação do livro será puxado o autor
    @ManyToOne(fetch = FetchType.EAGER)//(cascade = CascadeType.ALL)
    // para 1 - No caso um autor pode ter muitos livros.
    @JoinColumn(name = "id_autor")
    private Autor autor;

}
