package alura.challange.backend.api.controller;

import alura.challange.backend.api.domain.depoimentos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity <Page<DadosListagemDepoimentos>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = depoimentoRepository.findAll(paginacao).map(DadosListagemDepoimentos::new);
        return ResponseEntity.ok(page);
    }

}
