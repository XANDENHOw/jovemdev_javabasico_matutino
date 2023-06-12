CREATE TABLE "e-commerce".cat_prod (
    id serial4 NOT NULL,
    categoria varchar NOT NULL,
    CONSTRAINT cat_prod_pk PRIMARY KEY (id)
);

CREATE TABLE "e-commerce".cidade (
    id serial4 NOT NULL,
    nome varchar NOT NULL,
    uf varchar(2) NOT NULL,
    CONSTRAINT cidade_pk PRIMARY KEY (id)
);


CREATE TABLE "e-commerce".endereco (
    id serial4 NOT NULL,
    rua varchar NOT NULL,
    bairro varchar NOT NULL,
    cidade int4 NOT NULL,
    CONSTRAINT endereco_pk PRIMARY KEY (id),
    CONSTRAINT endereco_fk FOREIGN KEY (cidade) REFERENCES "e-commerce".cidade(id)
);

CREATE TABLE "e-commerce".cliente (
    id serial4 NOT NULL,
    nome varchar NOT NULL,
    sexo varchar(1) NOT NULL,
    datanascimento date NOT NULL,
    endereco int4 NOT NULL,
    CONSTRAINT cliente_pk PRIMARY KEY (id),
    CONSTRAINT cliente_fk FOREIGN KEY (endereco) REFERENCES "e-commerce".endereco(id)
);

CREATE TABLE "e-commerce".produto (
    id serial4 NOT NULL,
    nome varchar NOT NULL,
    valor numeric NOT NULL,
    estoque int4 NOT NULL,
    categoria int4 NOT NULL,
    CONSTRAINT produto_pk PRIMARY KEY (id),
    CONSTRAINT produto_fk FOREIGN KEY (categoria) REFERENCES "e-commerce".cat_prod(id)
);

CREATE TABLE "e-commerce".venda (
    id serial4 NOT NULL,
    data_venda date NOT NULL,
    cliente int4 NOT NULL,
    CONSTRAINT venda_pk PRIMARY KEY (id),
    CONSTRAINT venda_fk FOREIGN KEY (cliente) REFERENCES "e-commerce".cliente(id)
);

CREATE TABLE "e-commerce".pedido (
    id serial4 NOT NULL,
    id_produto int4 NOT NULL,
    quantidade int4 NOT NULL,
    id_venda int4 NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (id),
    CONSTRAINT pedido_fk FOREIGN KEY (id_produto) REFERENCES "e-commerce".produto(id),
    CONSTRAINT pedido_fk_1 FOREIGN KEY (id_venda) REFERENCES "e-commerce".venda(id)
);

CREATE TABLE "e-commerce".telefone (
    id serial4 NOT NULL,
    numero varchar NOT NULL,
    id_cliente int4 NOT NULL,
    CONSTRAINT telefone_pk PRIMARY KEY (id),
    CONSTRAINT telefone_fk FOREIGN KEY (id_cliente) REFERENCES "e-commerce".cliente(id)
);

insert into cat_prod (categoria) values ('Ferramenta'), ('Móvel'), ('Decoração'),
	('Limpeza'), ('Higiene pessoal'), ('Alimento'), ('Categoria7'), ('Categoria8'),
	('Categoria9'), ('Categoria10');
	
insert into produto (nome, valor, estoque, categoria) values ('Enxada', 50.99, 10, 1),
	('Armário', 199.90, 5, 2), ('Decoracao1', 29.75, 20, 3), ('ProdCat7', 10.90, 4, 7),
	('ProdutoCat10', 499.99, 3, 10), ('Pá', 49.90, 15, 1), ('Furadeira', 199.90, 10, 1);
	
insert into cidade (nome, uf) values ('Tubarão', 'SC'), ('Laguna', 'SC'), ('Curitiba', 'PR'),
	('São Paulo', 'SP'), ('Rio de Janeiro', 'RJ'), ('Florianópolis', 'SC');

insert into endereco (rua, bairro, cidade) values ('Rua 1', 'Oficinas', 1), 
	('Rua 2', 'Canasvieiras', '6'), ('Rua 3', 'Zona Leste', 4);

insert into cliente (nome, sexo, datanascimento, endereco) values 
	('Cliente 1', 'M', '1997-07-18', 1), 
	('Cliente 2', 'F', '1980-06-30', 2);
	
insert into telefone (id_cliente, numero) values (1, '(48) 99988-7766'),
	(2, '(48) 91122-3344');

insert into venda (id, data_venda, cliente) values (1, '2023-06-12', 1);

insert into pedido(id_venda, id_produto, quantidade) values (1, 1, 3),
	(1, 6, 3), (1, 7, 3);

insert into venda (id, data_venda, cliente) values (3, '2023-06-12', 1);

insert into pedido(id_venda, id_produto, quantidade) values (3, 1, 3),
	(3, 6, 3);

insert into venda (id, data_venda, cliente) values (2, '2023-06-12', 2);

insert into pedido(id_venda, id_produto, quantidade) values (2, 4, 2), 
	(2, 3, 3), (2, 2, 1);

select cli.nome, cid.nome
from cidade cid
inner join endereco on endereco.cidade = cid.id
inner join cliente cli on cli.endereco = endereco.id 
where cid.nome = 'Tubarão';

select venda.id, venda.data_venda, cli.nome as nome_cliente,
	prod.nome as produto_nome, ped.quantidade 
from venda 
inner join cliente cli on cli.id = venda.cliente 
inner join pedido ped on ped.id_venda = venda.id 
inner join produto prod on prod.id = ped.id_produto 
where venda.cliente = 1;
	
select prod.nome, cat.categoria
from produto prod
right join cat_prod cat on cat.id = prod.categoria 
order by prod.nome;

--venda por cidade
select venda.id, venda.data_venda, cli.nome as nome_cliente,
	prod.nome as produto_nome, ped.quantidade, cid.nome  
from venda 
inner join cliente cli on cli.id = venda.cliente 
inner join pedido ped on ped.id_venda = venda.id 
inner join produto prod on prod.id = ped.id_produto 
inner join endereco on endereco.id = cli.endereco
inner join cidade cid on cid.id = endereco.cidade 
order by cid.nome;

--venda por data
select venda.id, venda.data_venda, cli.nome as nome_cliente,
    prod.nome as produto_nome, ped.quantidade, cid.nome  
from venda 
inner join cliente cli on cli.id = venda.cliente 
inner join pedido ped on ped.id_venda = venda.id 
inner join produto prod on prod.id = ped.id_produto 
inner join endereco on endereco.id = cli.endereco
inner join cidade cid on cid.id = endereco.cidade 
where venda.data_venda between '2023-06-01' and '2023-09-01';

--valor venda por categoria
select cat.categoria, sum(prod.valor) as total_vendas
from produto prod
inner join pedido ped on ped.id_produto = prod.id
inner join cat_prod cat on cat.id = prod.categoria 
group by cat.categoria
order by total_vendas desc;


