package alura.challange.backend.api.domain.destinos;

public record DadosDetalhamentoDestinos(Long id, String foto, String nome, String preco) {
    public DadosDetalhamentoDestinos(Destinos destinos){
        this(destinos.getId(), destinos.getFoto(), destinos.getNome(), destinos.getPreco());
    }
}
