package io.github.cursodsousa.libraryapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) // entrega as data, com base na operação!

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    @Size(max = 30, message = "O nome deve ter no máximo 30 caracteres.")
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER)
    private List<Livro> livros;

    //Auditoria - Recurso de ação, hora de cadastro, hora de atualização


    @CreatedDate // Registra a hora no momento que o usuario fez o cadastro, momento atual
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedBy
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "id_usuario")
    private  UUID idUsuario;


}
