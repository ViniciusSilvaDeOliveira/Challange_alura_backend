package alura.challange.backend.api.domain.destinos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "destinos")
@Entity(name = "Destinos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Destinos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foto;
    private String nome;
    private String preco;

    public Destinos(DadosCadastroDestinos dados){
        this.foto = dados.foto();
        this.nome = dados.nome();
        this.preco = dados.preco();
    }
}
