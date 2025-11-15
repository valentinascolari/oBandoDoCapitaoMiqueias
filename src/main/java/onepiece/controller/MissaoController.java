package onepiece.controller;

import jakarta.validation.Valid;
import onepiece.dto.MissaoDTO;
import onepiece.enums.NivelPerigo;
import onepiece.enums.StatusMissao;
import onepiece.service.MissaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MissaoDTO criar(@Valid @RequestBody MissaoDTO dto) {
        return missaoService.criar(dto);
    }

    @PutMapping("/{id}")
    public MissaoDTO atualizar(@PathVariable Long id,
                               @Valid @RequestBody MissaoDTO dto) {
        return missaoService.atualizar(id, dto);
    }

    @GetMapping("/{id}")
    public MissaoDTO buscarPorId(@PathVariable Long id) {
        return missaoService.buscarPorId(id);
    }

    @GetMapping
    public List<MissaoDTO> listarTodas() {
        return missaoService.listarTodas();
    }

    @GetMapping("/danger/{nivel}")
    public List<MissaoDTO> buscarPorNivel(@PathVariable("nivel") NivelPerigo nivel) {
        return missaoService.buscarPorNivel(nivel);
    }

    @GetMapping("/status/{status}")
    public List<MissaoDTO> buscarPorStatus(@PathVariable("status") StatusMissao status) {
        return missaoService.buscarPorStatus(status);
    }
}
