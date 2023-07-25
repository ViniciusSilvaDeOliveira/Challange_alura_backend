package alura.challange.backend.api.domain.depoimentos;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDepoimentos(
        @NotBlank
        String foto,
        @NotBlank
        String depoimento,
        @NotBlank
        String nome
) {
}
