/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class MusicaDAO {
    
    
    public static ArrayList<Musica> obterMusica() throws Exception{
        ArrayList<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * FROM tb_musica";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        int codigo = rs.getInt("id");
                        String titulo = rs.getString("titulo");
                        String genero = Integer.toString(rs.getInt("generoId"));
                        String artista = rs.getString("artista");
                        Musica musica = new Musica(codigo, titulo, genero,artista);
                        musicas.add(musica);
                    }
                    return musicas;
        }
    }
}
