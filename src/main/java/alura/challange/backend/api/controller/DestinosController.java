package alura.challange.backend.api.controller;

import alura.challange.backend.api.domain.destinos.DadosCadastroDestinos;
import alura.challange.backend.api.domain.destinos.DadosDetalhamentoDestinos;
import alura.challange.backend.api.domain.destinos.Destinos;
import alura.challange.backend.api.domain.destinos.DestinosRepository;
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
@RequestMapping("/destinos")
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


}
