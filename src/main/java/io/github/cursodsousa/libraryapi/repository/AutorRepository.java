package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.dto.AutorDto;
import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface  AutorRepository extends JpaRepository<Autor, UUID> {

    List<Autor> findByNomeAndNacionalidade(String nome, String nacionalidade);

    List<Autor> findByNome(String nome);

    List<Autor> findByNacionalidade(String nacionalidade);

    Optional<Autor> findByNomeAndDataNascimentoAndNacionalidade(String nome,
                                                                LocalDate dataNascimento,
                                                                String nacionalidade);
}
