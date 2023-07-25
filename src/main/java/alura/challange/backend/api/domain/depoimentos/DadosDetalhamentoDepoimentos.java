package alura.challange.backend.api.domain.depoimentos;

import org.springframework.web.multipart.MultipartFile;

public record DadosDetalhamentoDepoimentos(Long id, String foto, String depoimento, String nome) {
    public DadosDetalhamentoDepoimentos(Depoimentos depoimentos){
        this(depoimentos.getId(), depoimentos.getFoto(), depoimentos.getDepoimento(), depoimentos.getNome());
    }
}
