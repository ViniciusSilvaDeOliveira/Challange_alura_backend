package alura.challange.backend.api.domain.destinos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DestinosRepository extends JpaRepository<Destinos, Long> {

    @Query(value = """
            select * from Destinos d where d.nome = :nome
            """, nativeQuery = true)
    Destinos getDestinoByNome(String nome);
}
