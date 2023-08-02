package alura.challange.backend.api.domain.destinos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDestinos(
        @NotNull
        Long id,
        String foto,
        String preco
) {
}
