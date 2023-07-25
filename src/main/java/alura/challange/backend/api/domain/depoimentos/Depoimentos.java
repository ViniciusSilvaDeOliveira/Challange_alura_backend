package alura.challange.backend.api.domain.depoimentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Table(name = "depoimentos")
@Entity(name = "Depoimentos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Depoimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String depoimento;
    private String nome;

    public Depoimentos(DadosCadastroDepoimentos dados) {
        this.foto = dados.foto();
        this.depoimento = dados.depoimento();
        this.nome = dados.nome();
    }

    public void atualizarInformacoes(DadosAtualizarDepoimento dados) {
        if (dados.foto() != null){
            this.foto = dados.foto();
        }

        if (dados.depoimento() != null){
            this.depoimento = dados.depoimento();
        }
    }
}
