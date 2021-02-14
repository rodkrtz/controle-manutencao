package br.com.rodkrtz.projuris.controle.manutencao.model.entity;

import br.com.rodkrtz.projuris.controle.manutencao.utils.GeradorDeChave;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Rodrigo Kreutzfeld
 */
@Data
@MappedSuperclass
public class AuditEntity implements Serializable {

    @Column(name = "chave_id")
    private String chaveId = GeradorDeChave.gerar();

    @Column(name = "data_criacao")
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

}
