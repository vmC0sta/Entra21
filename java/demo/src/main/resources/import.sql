INSERT INTO tb_contato(id,nome,email,fone) values (1,'maria','maria@gmail.com','(47) 99607-5616');
INSERT INTO tb_contato(id,nome,email,fone) values (2,'joao','joao@gmail.com','(47) 98733-5616');
INSERT INTO tb_local(id,nome,rua,numero,bairro,cidade,estado,cep) values (1,'Casa','Estrada Blumenau','540','Santana','Rio do Sul','Santa Catarina','89160-332');
INSERT INTO TB_COMPROMISSO (DATA,HORA,LOCAL_ID,DESCRICAO, STATUS) VALUES ('2023-12-13', '11:00:00', 1, 'JOGAR VIDEOGAME',0);
INSERT INTO COMPROMISSO_CONTATO VALUES (1,2);
INSERT INTO COMPROMISSO_CONTATO VALUES (1,1);