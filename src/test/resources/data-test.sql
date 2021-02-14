insert into funcionario (nome, funcao, email) values ('Funcionario 1', 'Técnico', 'func1@email.com.br');
insert into funcionario (nome, funcao, email) values ('Funcionario 2', 'Técnico', 'func2@email.com.br');
insert into funcionario (nome, funcao, email) values ('Funcionario 3', 'Recepcionista', 'func3@email.com.br');

insert into cliente (nome, endereco, telefone, email) values ('Nome Teste 1', 'Endereco 1', '04711111111', 'email1@email1.com.br');
insert into cliente (nome, endereco, telefone, email) values ('Nome Teste 2', 'Endereco 2', '04722222222', 'email2@email2.com.br');
insert into cliente (nome, endereco, telefone, email) values ('Nome Teste 3', 'Endereco 3', '04733333333', 'email3@email3.com.br');

insert into equipamento (nome, tipo, marca, numero_serie, id_cliente) values ('equip1', 'impressora', 'HP', 'xzy123', 1);
insert into equipamento (nome, tipo, marca, numero_serie, id_cliente) values ('equip2', 'notebook', 'DELL', 'abc321', 2);

insert into ordem_servico (chave_id, id_equipamento, id_funcionario, desc_problema) values ('12345678', 1, null, 'Não liga')


