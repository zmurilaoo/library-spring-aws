package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.GeneroLivro;
import io.github.cursodsousa.libraryapi.model.Livro;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

//
//    @Test
//    public void salvarLivroTest() {
//        Livro livro = new Livro();
//
//        livro.setIsbn("909098-87689");
//        livro.setGenero(GeneroLivro.BIOGRAFIA);
//        livro.setTitulo("Mais Esperto Que o Diabo");
//        livro.setPreco(BigDecimal.valueOf(30));
//        livro.setData_publicacao(LocalDate.of(1930, 8, 21));
//
//        Autor autor = autorRepository.findById(UUID.fromString("e95e1ea1-fe9b-431c-a10a-80b8b708aadb")).orElse(null);
//
//        livro.setAutor(autor);
//
//        livroRepository.save(livro);
//
//
//    }
//
//    @Test
//    void CascadeTest() {
//
//        Livro livro = new Livro();
//
//        livro.setIsbn("909098-87689");
//        livro.setGenero(GeneroLivro.BIOGRAFIA);
//        livro.setTitulo("Os segredos da mente milionária");
//        livro.setPreco(BigDecimal.valueOf(30));
//        livro.setData_publicacao(LocalDate.of(1930, 8, 21));
//
//        Autor autor =  new Autor();
//
//        autor.setNome("João");
//        autor.setNascionalidade("Brasileira");
//        autor.setDataNascimento(LocalDate.of(2006, 12, 25));
//
//        livro.setAutor(autor);
//
//        livroRepository.save(livro);
//
//    }
//
//    @Test
//    void updateTest() {
//
//        var id = UUID.fromString("29b62a6e-d685-4078-9b36-e739846711e0") ;
//
//        Optional<Autor> possivelAutor = autorRepository.findById(id);
//
//        if (possivelAutor.isPresent()) {
//            Autor autorEncotrado =  possivelAutor.get();
//
//            System.out.println("Dados do Autor: " + autorEncotrado);
//
//            autorEncotrado.setNascionalidade("Brasileiro");
//
//            autorRepository.save(autorEncotrado);
//        }
//
//    }
//
//    @Test
//    void updateAutorTest() {
//        UUID id = UUID.fromString("2ca6d4e7-2530-403a-800b-6036a47c6dc1");
//        var LivraPraAtualizar = livroRepository.findById(id).orElse(null);
//
//        UUID idAutor = UUID.fromString("7b04b8fb-dd52-4cc8-96c8-8c3f5f405676");
//        Autor usuario = autorRepository.findById(idAutor).orElse(null);
//
//        LivraPraAtualizar.setAutor(usuario);
//
//        livroRepository.save(LivraPraAtualizar);
//
//    }
//
//    @Test
//    void deletar() {
//        UUID id =UUID.fromString("");
//        livroRepository.deleteById(id);
//    }
//
//
////    @Test
////    void deletarCascade() {
////        UUID id = UUID.fromString("");
////
////        livroRepository.deleteById(id);
////    }
//
//    @Test
//    @Transactional
//    void buscarLivro() {
//        UUID id = UUID.fromString("79ceff8a-4958-4d01-a0a9-17bde2842b4d");
//
//        Livro livro = livroRepository.findById(id).orElse(null);
//
//        System.out.println("Livro");
//
//        System.out.println(livro.getTitulo());
//
//
//        System.out.println(livro.getAutor().getNome());
//
//    }
//
//    @Test
//    void pesquisarPorTitulo(){
//        List<Livro> lista = livroRepository.findByTitulo("48 leis do poder");
//        lista.forEach(System.out::println);
//
//    }
//
//    @Test
//    void buscarPorIsbn() {
//        List<Livro> livros = livroRepository.findByIsbn("909098-87689");
//        livros.forEach(System.out::println);
//
//
//    }
//
//    @Test
//    void buscarPorTituloAndPreco() {
//        var preco = BigDecimal.valueOf(26);
//
//        List<Livro> lista = livroRepository.findByTituloAndPreco("Poder e manipulção", preco);
//
//        lista.forEach(System.out::println);
//
//    }
//    @Test
//    void listarLivrosPorTituloAndPreco() {
//        var resultado = livroRepository.listarLivroPorTitutoloAndPreco();
//        resultado.forEach(System.out::println);
//
//
//    }
//    @Test
//    void listarAutoresLivro(){
//        var info = livroRepository.listarAutoresLivro();
//
//        info.forEach(System.out::println);
//
//    }
//    @Test
//    void listarNomesNaoRepetidos(){
//        var resultado = livroRepository.listarNomesDiferentesLivros();
//        resultado.forEach(System.out::println);
//
//    }
//    @Test
//    void listarAutoeresBrasileiro() {
//        var autores = livroRepository.listarGenerosAutoresBrasileiro();
//
//        autores.forEach(System.out::println);
//
//    }
//
//    @Test
//    void listarPorGeneroQueryParam() {
//        var autores = livroRepository.findByGenero(String.valueOf(GeneroLivro.FICCAO), "dataPublicacao");
//
//        autores.forEach(System.out::println);
//    }

}
