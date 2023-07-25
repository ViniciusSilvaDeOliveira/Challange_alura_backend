package alura.challange.backend.api.domain.depoimentos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDepoimento(
        @NotNull
        Long id,

        String foto,
        String depoimento
) {
}
