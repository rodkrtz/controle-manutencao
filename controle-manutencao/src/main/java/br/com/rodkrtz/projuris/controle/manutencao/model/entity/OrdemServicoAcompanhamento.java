package br.com.rodkrtz.projuris.controle.manutencao.model.entity;

import br.com.rodkrtz.projuris.controle.manutencao.model.enums.OSStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Rodrigo Kreutzfeld
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "ordem_servico")
public class OrdemServicoAcompanhamento extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ordem_servico")
    private OrdemServico ordemServico;

    @Column(name = "status")
    private OSStatus status;

    @Column(name = "desc_status")
    private String descricaoStatus;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;
}
