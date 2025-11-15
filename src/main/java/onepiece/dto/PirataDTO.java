package onepiece.dto;

import onepiece.enums.Raca;
import onepiece.enums.StatusPirata;

import java.util.List;

public class PirataDTO {

    private Long id;
    private String nome;
    private Raca raca;
    private String tripulacao;
    private StatusPirata status;
    private List<MissaoDTO> missoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public String getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(String tripulacao) {
        this.tripulacao = tripulacao;
    }

    public StatusPirata getStatus() {
        return status;
    }

    public void setStatus(StatusPirata status) {
        this.status = status;
    }

    public List<MissaoDTO> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<MissaoDTO> missoes) {
        this.missoes = missoes;
    }
}
