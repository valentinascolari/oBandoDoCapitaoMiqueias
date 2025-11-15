package onepiece.entity;

import jakarta.persistence.*;
import onepiece.enums.NivelPerigo;
import onepiece.enums.StatusMissao;
import onepiece.enums.TipoMissao;

@Entity
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelPerigo nivelPerigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoMissao tipoMissao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusMissao statusMissao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;

    public Long getId() {
        return id;
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

    public Pirata getPirata() {
        return pirata;
    }

    public void setPirata(Pirata pirata) {
        this.pirata = pirata;
    }
}
