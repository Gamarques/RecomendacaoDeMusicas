/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import Model.Recomendacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author gabri
 */
public class RecomendacaoDAO {
    public static ArrayList<Recomendacao> obterRecomendacao(int usuarioId) throws Exception{
        ArrayList<Recomendacao> recomendacoes = new ArrayList<>();
        String sql = "select DISTINCT	COALESCE(m.Media,0) as media,\n" +
"musica.Titulo, musica.artista from	\n" +
"		tb_user us \n" +
"			inner join \n" +
"		tb_user_genero ug on us.Id = ug.userId  \n" +
"				inner join\n" +
"		tb_genero gen on gen.id = ug.generoId \n" +
"				left  join\n" +
"	    tb_user_musica mus on us.Id = mus.userId \n" +
"				inner join\n" +
"		tb_musica musica on musica.generoId = gen.id\n" +
"		left join \n" +
"		(SELECT um.musicaId as musicaId, (Sum(um.nota)/ Count(um.musicaId)) as Media FROM  tb_user_musica um group by um.musicaId) m on m.musicaId = musica.Id\n" +
"Where	us.id = ? \n" +
"		and musica.Id not in(Select musicaId from tb_user_musica where userId=?)\n" +
"        order by m.Media desc";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, usuarioId);
            ps.setInt(2, usuarioId);
            ResultSet rs = ps.executeQuery();{
                    while(rs.next()){
                        String titulo = rs.getString("titulo");
                        String artista = rs.getString("artista");
                        Double media = rs.getDouble("media");
                        Recomendacao recomendacao = new Recomendacao(media, titulo, artista);
                        recomendacoes.add(recomendacao);
                        
                    }
                    return recomendacoes;
                }
            
        }
    }
}
