package onepiece.repository;

import onepiece.entity.Missao;
import onepiece.enums.NivelPerigo;
import onepiece.enums.StatusMissao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MissaoRepository extends JpaRepository<Missao, Long> {

    List<Missao> findByNivelPerigo(NivelPerigo nivelPerigo);

    List<Missao> findByStatusMissao(StatusMissao statusMissao);
}
