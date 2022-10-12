package br.com.gestaocarro.repository;

import br.com.gestaocarro.domain.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository("CarroRepository")
public interface CarroRepository extends JpaRepository<Carro, UUID> {

    @Modifying
    @Transactional
    @Query(value = "update Carro c set c.preco = :preco where c.carroId = :id")
    void updateByPreco(UUID id, float preco);

    static Carro findByPreco(float preco) {
        return null;
    }
}
