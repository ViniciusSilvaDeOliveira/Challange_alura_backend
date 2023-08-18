package alura.challange.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest //subir o contexto completo do spring para fazer a simulação
@AutoConfigureMockMvc
class DepoimentoControllerTest {

    @Autowired
    private MockMvc mvc; //Simula requisições usando o MVC

    @Test
    @DisplayName("Testando o método GET, deveria retornar código 200")
    @WithMockUser //simula um usuário logado
    void testarMetodoGet() {

    }
}