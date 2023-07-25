package alura.challange.backend.api.controller;

import alura.challange.backend.api.domain.depoimentos.DadosCadastroDepoimentos;
import alura.challange.backend.api.domain.depoimentos.DadosDetalhamentoDepoimentos;
import alura.challange.backend.api.domain.depoimentos.DepoimentoRepository;
import alura.challange.backend.api.domain.depoimentos.Depoimentos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDepoimentos dados, UriComponentsBuilder uriBuilder){
        var depoimentos = new Depoimentos(dados);
        depoimentoRepository.save(depoimentos);
        var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimentos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDepoimentos(depoimentos));
    }

}
