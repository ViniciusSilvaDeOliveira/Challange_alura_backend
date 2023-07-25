package alura.challange.backend.api.domain.depoimentos;

import org.springframework.web.multipart.MultipartFile;

public record DadosDetalhamentoDepoimentos(String foto, String depoimento, String nome) {
    public DadosDetalhamentoDepoimentos(Depoimentos depoimentos){
        this(depoimentos.getFoto(), depoimentos.getDepoimento(), depoimentos.getNome());
    }
}
