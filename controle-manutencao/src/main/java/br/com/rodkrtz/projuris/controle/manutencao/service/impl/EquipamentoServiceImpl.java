package br.com.rodkrtz.projuris.controle.manutencao.service.impl;

import br.com.rodkrtz.projuris.controle.manutencao.dao.ClienteDao;
import br.com.rodkrtz.projuris.controle.manutencao.dao.EquipamentoDao;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Cliente;
import br.com.rodkrtz.projuris.controle.manutencao.model.entity.Equipamento;
import br.com.rodkrtz.projuris.controle.manutencao.model.request.AddEquipamentoRequest;
import br.com.rodkrtz.projuris.controle.manutencao.service.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

/**
 * @author Rodrigo Kreutzfeld
 */
@Component
public class EquipamentoServiceImpl implements EquipamentoService {

    @Autowired
    private EquipamentoDao equipamentoDao;

    @Autowired
    private ClienteDao clienteDao;

    @Override
    public Equipamento findByNumeroSerie(String numeroSerie) {
        return equipamentoDao.findByNumeroSerie(numeroSerie);
    }

    @Override
    public Equipamento addEquipamento(AddEquipamentoRequest addEquipamentoRequest) {

        Cliente cliente = clienteDao.findByEmail(addEquipamentoRequest.getEmailCliente());
        if (cliente == null) {
            throw new NoSuchElementException("Não foi encontrado um cliente com esse email ".concat(addEquipamentoRequest.getEmailCliente()));
        }

        Equipamento equipamento = equipamentoDao.findByNumeroSerie(addEquipamentoRequest.getNumeroSerieEquipamento());
        if (equipamento != null) {
            throw new IllegalArgumentException("Já existe um equipamento registrado com esse número de série");
        }

        equipamento = new Equipamento()
                .setCliente(cliente)
                .setMarca(addEquipamentoRequest.getMarcaEquipamento())
                .setNome(addEquipamentoRequest.getNomeEquipamento())
                .setTipo(addEquipamentoRequest.getTipoEquipamento())
                .setNumeroSerie(addEquipamentoRequest.getNumeroSerieEquipamento());

        equipamentoDao.save(equipamento);

        return equipamento;

    }
}
