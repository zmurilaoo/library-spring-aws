package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.GeneroLivro;
import io.github.cursodsousa.libraryapi.model.Livro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {


    boolean existByAutor(Autor autor);

    // QueryMethods

//    List<Livro> findByAutor(Autor autor);
//
//    List<Livro> findByTitulo(String titulo);
//
//    List<Livro> findByIsbn(String isbn);
//
//
//    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

//    @Query("select l from Livro as l order by l.titulo")
//    List<Livro> listarLivroPorTitutoloAndPreco();
//
//    // Oque significa join
//    @Query("select a from Livro l  join l.autor a")
//    List<Autor> listarAutoresLivro();
//
//    @Query("select distinct l.titulo from Livro l ")
//    List<Livro> listarNomesDiferentesLivros();
//
//    @Query("""
//            select l.genero
//            from Livro l
//            join a.autor a
//            where a.nacionalidade = 'Brasileira'
//            order by l.genero
//            """)
//    List<String> listarGenerosAutoresBrasileiro();

//    @Query("""
//            select l from Livro where l.genero = :genero order by :paramOrdenacao
//            """)
//    List<Livro> findByGenero(@Param("genero") String genero,
//                             @Param("paramOrdenacao") String paramOrdenacao);
//
////
////
////    @Query("select l from Livro wheere l.genero =:?1 order by 2?")
////    List<Livro> findByGenero(String genero, String paramOdencao);
////
//    @Modifying
//    @Transactional
//    @Query("delete from Livro where genero = ?1 ")
//    void deletarGenero(GeneroLivro genero);
//
//    @Modifying
//    @Transactional
//    @Query("update Livro set dataPublicacao = ?1")
//    void upadata(LocalDate novaData);


}
