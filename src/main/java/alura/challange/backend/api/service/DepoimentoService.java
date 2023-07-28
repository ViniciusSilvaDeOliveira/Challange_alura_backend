package alura.challange.backend.api.service;

import alura.challange.backend.api.domain.depoimentos.DepoimentoRepository;
import alura.challange.backend.api.domain.depoimentos.Depoimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class DepoimentoService {

    @Autowired
    DepoimentoRepository depoimentoRepository;

    public List<Depoimentos> obterDepoimentosRandomicos() {
        List<Depoimentos> depoimentos = depoimentoRepository.findAll();
        if (depoimentos.isEmpty()){
            return new ArrayList<>();
        }

        List<Depoimentos> depoimentosRandomicos = new ArrayList<>();
        Random random = new Random();
        while (depoimentosRandomicos.size() < 3){
            Depoimentos depoimento = depoimentos.get(random.nextInt(depoimentos.size()));
            if (!depoimentosRandomicos.contains(depoimento)){
                depoimentosRandomicos.add(depoimento);
            }
        }
        return depoimentosRandomicos;
    }
}
