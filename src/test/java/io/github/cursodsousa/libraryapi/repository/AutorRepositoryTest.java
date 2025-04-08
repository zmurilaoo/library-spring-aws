package io.github.cursodsousa.libraryapi.repository;

import io.github.cursodsousa.libraryapi.model.Autor;
import io.github.cursodsousa.libraryapi.model.GeneroLivro;
import io.github.cursodsousa.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest(){

      Autor autor =  new Autor();

      autor.setNome("João Fiorentino");
      autor.setNascionalidade("Brasileiro");
      autor.setDataNascimento(LocalDate.of(2000, 2, 12));

      var autorSalvo = autorRepository.save(autor);

      System.out.println("Autor salvo: "+ autorSalvo);


    }

    @Test
    public void atualizarLista() {

        var id = UUID.fromString("493fac07-8589-4ce0-b951-38980719f362") ;

        Optional<Autor> possivelAutor = autorRepository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncotrado =  possivelAutor.get();

            System.out.println("Dados do Autor: " + autorEncotrado);

            autorEncotrado.setNascionalidade("Estadunidense");

            autorRepository.save(autorEncotrado);
        }
    }

    @Test
    public void listaAutores() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }


    @Test
    public void quantidadeAutores() {
        System.out.println("Contagem de autores: " + autorRepository.count());

    }

    @Test
    public void deleteTest() {
        var id = UUID.fromString("493fac07-8589-4ce0-b951-38980719f362") ;
        autorRepository.deleteById(id);

    }

    @Test
    void salvarLivrosTest() {
        Autor autor =  new Autor();

        autor.setNome("Asthon Hill");
        autor.setNascionalidade("Americano");
        autor.setDataNascimento(LocalDate.of(1996, 9, 9));


        Livro livro = new Livro();

        livro.setIsbn("909098-87689");
        livro.setGenero(GeneroLivro.BIOGRAFIA);
        livro.setTitulo("Poder e Manipulação");
        livro.setPreco(BigDecimal.valueOf(24));
        livro.setData_publicacao(LocalDate.of(1970, 8, 21));
        livro.setAutor(autor);

        Livro livro2 = new Livro();

        livro2.setIsbn("909098-87689");
        livro2.setGenero(GeneroLivro.BIOGRAFIA);
        livro2.setTitulo("48 leis do poder");
        livro2.setPreco(BigDecimal.valueOf(50));
        livro2.setData_publicacao(LocalDate.of(2000, 7, 7));
        livro2.setAutor(autor);


        Livro livro3 = new Livro();

        livro3.setIsbn("909098-88909");
        livro3.setGenero(GeneroLivro.FICCAO);
        livro3.setTitulo("Flash");
        livro3.setPreco(BigDecimal.valueOf(44));
        livro3.setData_publicacao(LocalDate.of(2000, 9, 7));
        livro3.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);
        autor.getLivros().add(livro3);

        autorRepository.save(autor);
        livroRepository.saveAll(autor.getLivros());

    }
}
