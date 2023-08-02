package alura.challange.backend.api.domain.depoimentos;

public record DadosDetalhamentoDepoimentos(Long id, String foto, String depoimento, String nome) {
    public DadosDetalhamentoDepoimentos(Depoimentos depoimento){
        this(depoimento.getId(), depoimento.getFoto(), depoimento.getDepoimento(), depoimento.getNome());
    }
}
