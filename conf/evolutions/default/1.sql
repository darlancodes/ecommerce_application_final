# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table item_estoque (
  id                        bigint auto_increment not null,
  quantidade                bigint,
  produto_codigo_barras     bigint,
  constraint pk_item_estoque primary key (id))
;

create table produto (
  codigo_barras             bigint auto_increment not null,
  nome                      varchar(255),
  categoria                 varchar(255),
  descricao                 varchar(255),
  foto                      varbinary(255),
  constraint pk_produto primary key (codigo_barras))
;

create table usuario (
  id                        bigint auto_increment not null,
  usuario                   varchar(255),
  password                  varchar(255),
  tipo_usuario              tinyint(1) default 0,
  constraint pk_usuario primary key (id))
;

alter table item_estoque add constraint fk_item_estoque_produto_1 foreign key (produto_codigo_barras) references produto (codigo_barras) on delete restrict on update restrict;
create index ix_item_estoque_produto_1 on item_estoque (produto_codigo_barras);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table item_estoque;

drop table produto;

drop table usuario;

SET FOREIGN_KEY_CHECKS=1;

