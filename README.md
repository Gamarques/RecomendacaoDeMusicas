# RecomendacaoDeMusicas

Sistema criado utilizando JAVA & MySQL.
É um projeto da faculdade SAO JUDAS na qual a idéia é: obter recomendações de musicas baseadas no seus Gêneros preferidos. Essa recomendação traz uma lista de músicas ordenada pela média das notas dos usúarios.

Para usar você precisara criar no MySQL as tabelas:

tb_tipoUser(id INT PK, tipo VARCHAR);

tb_user(id INT PK, tipoUserId INT FK[tb_tipoUser.id]); 

tb_genero(id INT PK, descricao VARCHAR);

tb_musica(id INT PK, titulo VARCHAR, artista VARCHAR, generoId INT FK[tb_genero.id]);

tb_user_musica(id INT PK,userId INT FK [tb_user.id], musicaId INT FK[tb_musica.id], nota INT);

tb_user_genero(id INT PK, userId INT FK[tb_user.id], generoId INT FK[tb_genero.id]);



