package alura.challange.backend.api.domain.destinos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DestinosRepository extends JpaRepository<Destinos, Long> {

    @Query(value = """
            SELECT * FROM Destinos d WHERE LOWER(d.nome) LIKE LOWER(CONCAT('%', :nome, '%'))
            """, nativeQuery = true)
    List<Destinos> getDestinoByNome(String nome);
}
