package onepiece.service;

import onepiece.dto.MissaoDTO;
import onepiece.entity.Missao;
import onepiece.entity.Pirata;
import onepiece.enums.NivelPerigo;
import onepiece.enums.StatusMissao;
import onepiece.exception.ResourceNotFoundException;
import onepiece.repository.MissaoRepository;
import onepiece.repository.PirataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final PirataRepository pirataRepository;

    public MissaoService(MissaoRepository missaoRepository, PirataRepository pirataRepository) {
        this.missaoRepository = missaoRepository;
        this.pirataRepository = pirataRepository;
    }

    public MissaoDTO criar(MissaoDTO dto) {
        Pirata pirata = pirataRepository.findById(dto.getPirataId())
                .orElseThrow(() -> new ResourceNotFoundException("Pirata não encontrado"));

        Missao missao = new Missao();
        missao.setNivelPerigo(dto.getNivelPerigo());
        missao.setTipoMissao(dto.getTipoMissao());
        missao.setStatusMissao(dto.getStatusMissao());
        missao.setPirata(pirata);

        Missao salva = missaoRepository.save(missao);
        return toDTO(salva);
    }

    public MissaoDTO atualizar(Long id, MissaoDTO dto) {
        Missao missao = missaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Missão não encontrada"));

        Pirata pirata = pirataRepository.findById(dto.getPirataId())
                .orElseThrow(() -> new ResourceNotFoundException("Pirata não encontrado"));

        missao.setNivelPerigo(dto.getNivelPerigo());
        missao.setTipoMissao(dto.getTipoMissao());
        missao.setStatusMissao(dto.getStatusMissao());
        missao.setPirata(pirata);

        Missao salva = missaoRepository.save(missao);
        return toDTO(salva);
    }

    public MissaoDTO buscarPorId(Long id) {
        Missao missao = missaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Missão não encontrada"));
        return toDTO(missao);
    }

    public List<MissaoDTO> listarTodas() {
        return missaoRepository.findAll().stream().map(this::toDTO).toList();
    }

    public List<MissaoDTO> buscarPorNivel(NivelPerigo nivel) {
        return missaoRepository.findByNivelPerigo(nivel).stream().map(this::toDTO).toList();
    }

    public List<MissaoDTO> buscarPorStatus(StatusMissao status) {
        return missaoRepository.findByStatusMissao(status).stream().map(this::toDTO).toList();
    }

    private MissaoDTO toDTO(Missao missao) {
        MissaoDTO dto = new MissaoDTO();
        dto.setId(missao.getId());
        dto.setNivelPerigo(missao.getNivelPerigo());
        dto.setTipoMissao(missao.getTipoMissao());
        dto.setStatusMissao(missao.getStatusMissao());
        dto.setPirataId(missao.getPirata().getId());
        return dto;
    }
}
