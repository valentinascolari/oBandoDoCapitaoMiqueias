package onepiece.repository;

import onepiece.entity.Pirata;
import onepiece.enums.Raca;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PirataRepository extends JpaRepository<Pirata, Long> {

    List<Pirata> findByRaca(Raca raca);
}