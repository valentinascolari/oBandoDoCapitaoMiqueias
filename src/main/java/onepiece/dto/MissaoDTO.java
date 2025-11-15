package onepiece.dto;

import onepiece.enums.NivelPerigo;
import onepiece.enums.StatusMissao;
import onepiece.enums.TipoMissao;

public class MissaoDTO {

    private Long id;
    private NivelPerigo nivelPerigo;
    private TipoMissao tipoMissao;
    private StatusMissao statusMissao;
    private Long pirataId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NivelPerigo getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(NivelPerigo nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }

    public TipoMissao getTipoMissao() {
        return tipoMissao;
    }

    public void setTipoMissao(TipoMissao tipoMissao) {
        this.tipoMissao = tipoMissao;
    }

    public StatusMissao getStatusMissao() {
        return statusMissao;
    }

    public void setStatusMissao(StatusMissao statusMissao) {
        this.statusMissao = statusMissao;
    }

    public Long getPirataId() {
        return pirataId;
    }

    public void setPirataId(Long pirataId) {
        this.pirataId = pirataId;
    }
}
