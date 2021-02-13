package br.com.rodkrtz.projuris.controle.manutencao.dao;

import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioDao {

    Funcionario findByEmail(String email);

    void save(Funcionario funcionario);
}
