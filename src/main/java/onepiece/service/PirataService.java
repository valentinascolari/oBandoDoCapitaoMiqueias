package onepiece.service;

import onepiece.dto.MissaoDTO;
import onepiece.dto.PirataDTO;
import onepiece.entity.Missao;
import onepiece.entity.Pirata;
import onepiece.enums.Raca;
import onepiece.exception.ResourceNotFoundException;
import onepiece.repository.PirataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PirataService {

    private final PirataRepository pirataRepository;

    public PirataService(PirataRepository pirataRepository) {
        this.pirataRepository = pirataRepository;
    }

    public PirataDTO criar(PirataDTO dto) {
        Pirata pirata = new Pirata();
        pirata.setNome(dto.getNome());
        pirata.setRaca(dto.getRaca());
        pirata.setTripulacao(dto.getTripulacao());
        pirata.setStatus(dto.getStatus());
        Pirata salvo = pirataRepository.save(pirata);
        return toDTO(salvo);
    }

    public PirataDTO atualizar(Long id, PirataDTO dto) {
        Pirata pirata = pirataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pirata não encontrado"));

        pirata.setNome(dto.getNome());
        pirata.setRaca(dto.getRaca());
        pirata.setTripulacao(dto.getTripulacao());
        pirata.setStatus(dto.getStatus());
        Pirata salvo = pirataRepository.save(pirata);
        return toDTO(salvo);
    }

    public PirataDTO buscarPorId(Long id) {
        Pirata pirata = pirataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pirata não encontrado"));
        return toDTO(pirata);
    }

    public List<PirataDTO> listarTodos() {
        return pirataRepository.findAll().stream().map(this::toDTO).toList();
    }

    public List<PirataDTO> buscarPorRaca(Raca raca) {
        return pirataRepository.findByRaca(raca).stream().map(this::toDTO).toList();
    }

    public void deletar(Long id) {
        if (!pirataRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pirata não encontrado");
        }
        pirataRepository.deleteById(id);
    }

    private PirataDTO toDTO(Pirata pirata) {
        PirataDTO dto = new PirataDTO();
        dto.setId(pirata.getId());
        dto.setNome(pirata.getNome());
        dto.setRaca(pirata.getRaca());
        dto.setTripulacao(pirata.getTripulacao());
        dto.setStatus(pirata.getStatus());

        List<MissaoDTO> missoes = pirata.getMissoes()
                .stream()
                .map(this::toMissaoDTO)
                .collect(Collectors.toList());

        dto.setMissoes(missoes);
        return dto;
    }

    private MissaoDTO toMissaoDTO(Missao missao) {
        MissaoDTO dto = new MissaoDTO();
        dto.setId(missao.getId());
        dto.setNivelPerigo(missao.getNivelPerigo());
        dto.setTipoMissao(missao.getTipoMissao());
        dto.setStatusMissao(missao.getStatusMissao());
        dto.setPirataId(missao.getPirata().getId());
        return dto;
    }
}
