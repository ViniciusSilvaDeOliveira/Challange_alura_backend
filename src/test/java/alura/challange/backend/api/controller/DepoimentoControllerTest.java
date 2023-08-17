package alura.challange.backend.api.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;


@SpringBootTest //subir o contexto completo do spring para fazer a simulação
@AutoConfigureMockMvc
class DepoimentoControllerTest {

    @Autowired
    private MockMvc mvc; //Simula requisições usando o MVC

    @Test
    @DisplayName("Deveria devolver codigo http 400 quando recebe informacoes invalidas")
    @WithMockUser //simula um usuário logado
    void agendar_cenario1() throws Exception {
        var response = mvc.perform((RequestBuilder) post("/depoimentos"))
                                                .andReturn().getResponse(); //pega o response e guarda na variavel
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}