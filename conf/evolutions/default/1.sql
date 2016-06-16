# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table administrador (
  id                        bigint auto_increment not null,
  login                     varchar(255),
  matricula                 varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  constraint pk_administrador primary key (id))
;

create table carrinho (
  id                        bigint auto_increment not null,
  quantidade                integer,
  constraint pk_carrinho primary key (id))
;

create table categoria (
  id                        bigint auto_increment not null,
  none                      varchar(255),
  constraint pk_categoria primary key (id))
;

create table cliente (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  password                  varchar(255),
  email                     varchar(255),
  carrinho_id               bigint,
  constraint uq_cliente_carrinho_id unique (carrinho_id),
  constraint pk_cliente primary key (id))
;

create table endereco (
  id                        bigint auto_increment not null,
  rua                       varchar(255),
  cidade                    varchar(255),
  estado                    varchar(255),
  cep                       varchar(255),
  cliente_id                bigint,
  administrador_id          bigint,
  constraint pk_endereco primary key (id))
;

create table estoque (
  id                        bigint auto_increment not null,
  quantidade                bigint,
  constraint pk_estoque primary key (id))
;

create table item_produto (
  id                        bigint auto_increment not null,
  quantidade                bigint,
  estoque_id                bigint,
  constraint pk_item_produto primary key (id))
;

create table produto (
  id                        bigint auto_increment not null,
  nome                      varchar(255),
  categoria_id              bigint,
  preco                     double,
  descricao                 varchar(255),
  foto                      varbinary(255),
  itemproduto_id            bigint,
  constraint pk_produto primary key (id))
;

alter table cliente add constraint fk_cliente_carrinho_1 foreign key (carrinho_id) references carrinho (id) on delete restrict on update restrict;
create index ix_cliente_carrinho_1 on cliente (carrinho_id);
alter table endereco add constraint fk_endereco_cliente_2 foreign key (cliente_id) references cliente (id) on delete restrict on update restrict;
create index ix_endereco_cliente_2 on endereco (cliente_id);
alter table endereco add constraint fk_endereco_administrador_3 foreign key (administrador_id) references administrador (id) on delete restrict on update restrict;
create index ix_endereco_administrador_3 on endereco (administrador_id);
alter table item_produto add constraint fk_item_produto_estoque_4 foreign key (estoque_id) references estoque (id) on delete restrict on update restrict;
create index ix_item_produto_estoque_4 on item_produto (estoque_id);
alter table produto add constraint fk_produto_categoria_5 foreign key (categoria_id) references categoria (id) on delete restrict on update restrict;
create index ix_produto_categoria_5 on produto (categoria_id);
alter table produto add constraint fk_produto_itemproduto_6 foreign key (itemproduto_id) references item_produto (id) on delete restrict on update restrict;
create index ix_produto_itemproduto_6 on produto (itemproduto_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table administrador;

drop table carrinho;

drop table categoria;

drop table cliente;

drop table endereco;

drop table estoque;

drop table item_produto;

drop table produto;

SET FOREIGN_KEY_CHECKS=1;

