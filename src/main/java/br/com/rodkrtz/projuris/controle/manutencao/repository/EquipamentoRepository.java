package br.com.rodkrtz.projuris.controle.manutencao.repository;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rodrigo Kreutzfeld
 */
public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    Equipamento findByNumeroSerie(String numeroSerie);
}
