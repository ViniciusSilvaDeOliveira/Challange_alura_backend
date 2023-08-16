package alura.challange.backend.api.domain.destinos;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class DestinosRepositoryTest {

    @Autowired
    private DestinosRepository destinosRepository;

//    @Test
//    @DisplayName("Selecionar destino disponivel no banco de dados")
//    void getDestinoByNomeCenario1() {
//        var destinoEncontrado = destinosRepository.getDestinoByNome("Bahia");
//
//        assertThat(destinoEncontrado).isNull();
//    }
}