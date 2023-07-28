package alura.challange.backend.api.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfiguracaoCors implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Mapeia todos os endpoints da sua API
                .allowedOrigins("*") // Define as origens permitidas (ou use um valor específico, ex: "http://seufront.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Define os métodos HTTP permitidos
                .allowedHeaders("*"); // Define os cabeçalhos permitidos (ou use um valor específico, ex: "Authorization", "Content-Type")
    }
}
