package alura.challange.backend.api.controller;

import alura.challange.backend.api.domain.destinos.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/destinos")
@SecurityRequirement(name = "bearer-key")
public class DestinosController {

    /**
     * Classe de endpoints de depoimentos
     */

    @Autowired
    DestinosRepository destinosRepository;

    /**
     * Método para cadastrar destinos
     */
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDestinos dados, UriComponentsBuilder uriBuilder){
        var destinos = new Destinos(dados);
        destinosRepository.save(destinos);
        var uri = uriBuilder.path("/destinos/{id}").buildAndExpand(destinos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDestinos(destinos));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemDestinos>> listar(Pageable paginacao){
        var page = destinosRepository.findAll(paginacao).map(DadosListagemDestinos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDestinos dados){
        var destinos = destinosRepository.getReferenceById(dados.id());
        destinos.atualizarDestinos(dados);
        return ResponseEntity.ok(new DadosDetalhamentoDestinos(destinos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        destinosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Destinos>> detalhar(@PathVariable String nome){
        List<Destinos> destinos = destinosRepository.getDestinoByNome(nome);
        if (destinos.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destinos);
    }
}
