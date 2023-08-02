package alura.challange.backend.api.domain.destinos;

public record DadosListagemDestinos(Long id, String foto, String nome, String preco) {

    public DadosListagemDestinos(Destinos destinos){
        this(destinos.getId(), destinos.getFoto(), destinos.getNome(), destinos.getPreco());
    }
}
