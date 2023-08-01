package alura.challange.backend.api.domain.destinos;

import jakarta.validation.constraints.NotBlank;
public record DadosCadastroDestinos(
        @NotBlank
        String foto,
        @NotBlank
        String nome,
        @NotBlank
        String preco
) {
}
