package onepiece.controller;

import jakarta.validation.Valid;
import onepiece.dto.PirataDTO;
import onepiece.enums.Raca;
import onepiece.service.PirataService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pirata")
public class PirataController {

    private final PirataService pirataService;

    public PirataController(PirataService pirataService) {
        this.pirataService = pirataService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PirataDTO criar(@Valid @RequestBody PirataDTO dto) {
        return pirataService.criar(dto);
    }

    @PutMapping("/{id}")
    public PirataDTO atualizar(@PathVariable Long id,
                               @Valid @RequestBody PirataDTO dto) {
        return pirataService.atualizar(id, dto);
    }

    @GetMapping("/{id}")
    public PirataDTO buscarPorId(@PathVariable Long id) {
        return pirataService.buscarPorId(id);
    }

    @GetMapping
    public List<PirataDTO> listarTodos() {
        return pirataService.listarTodos();
    }

    @GetMapping("/raca/{raca}")
    public List<PirataDTO> buscarPorRaca(@PathVariable Raca raca) {
        return pirataService.buscarPorRaca(raca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        pirataService.deletar(id);
    }
}
