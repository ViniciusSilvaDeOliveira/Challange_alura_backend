package alura.challange.backend.api.domain.depoimentos;

public record DadosListagemDepoimentos(Long id, String foto, String depoimento, String nome) {
    public DadosListagemDepoimentos(Depoimentos depoimentos){
        this(depoimentos.getId(), depoimentos.getFoto(), depoimentos.getDepoimento(), depoimentos.getNome());
    }
}
