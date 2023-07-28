package alura.challange.backend.api.controller;

import alura.challange.backend.api.domain.depoimentos.*;
import alura.challange.backend.api.service.DepoimentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/depoimentos")
public class DepoimentoController {

    /**
     * Classe de endpoints de depoimentos
     */

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @Autowired
    private DepoimentoService depoimentoService;

    /**
     * Método POST para enviar um depoimento para o banco
     */
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDepoimentos dados, UriComponentsBuilder uriBuilder){
        var depoimentos = new Depoimentos(dados);
        depoimentoRepository.save(depoimentos);
        var uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(depoimentos.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoDepoimentos(depoimentos));
    }

    /**
     * Método GET para listar os depoimentos
     */
    @GetMapping
    public ResponseEntity <Page<DadosListagemDepoimentos>> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = depoimentoRepository.findAll(paginacao).map(DadosListagemDepoimentos::new);
        return ResponseEntity.ok(page);
    }

    /**
     * Método GET para trazer três depoimentos aleatórios ao ser chamado
     */
    @GetMapping("/depoimentos-home")
    public ResponseEntity<List<Depoimentos>> listarAleatorios(){
        return ResponseEntity.ok(depoimentoService.obterDepoimentosRandomicos());
    }

    /**
     * Método PUT para realizar as akterações de depoimento através do ID
     */
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarDepoimento dados){
        var depoimento = depoimentoRepository.getReferenceById(dados.id());
        depoimento.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoDepoimentos(depoimento));
    }

    /**
     * Método DELETE para excluir
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        depoimentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Método GET para retornar um unico id
     */
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var depoimento = depoimentoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDepoimentos(depoimento));
    }

}
