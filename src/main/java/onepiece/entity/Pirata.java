package onepiece.entity;

import jakarta.persistence.*;
import onepiece.enums.Raca;
import onepiece.enums.StatusPirata;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pirata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Raca raca;

    @Column(nullable = false)
    private String tripulacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPirata status;

    @OneToMany(mappedBy = "pirata", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Missao> missoes = new ArrayList<>();

    public Long getId() {
        return id;
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

    public List<Missao> getMissoes() {
        return missoes;
    }
}
