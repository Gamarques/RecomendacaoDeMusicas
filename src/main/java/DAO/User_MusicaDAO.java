 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Musica;
import Model.User;
import Model.User_Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class User_MusicaDAO {
      
    public static int pegarUserId(String login) throws Exception{
        int pegarUserId = 0;
        String sql = "SELECT * FROM tb_user WHERE login = ?";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, login);
                ResultSet rs = ps.executeQuery();{
                    while(rs.next()){
                    int id = rs.getInt("id");
                    pegarUserId = id;
                }
        }return pegarUserId;
    }
   }
    
    public static boolean jaAvaliou (User_Musica user_musica) throws Exception{
        String sql = "SELECT * FROM tb_user_musica WHERE userId = ? AND musicaId = ?";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, user_musica.getUserId());
            ps.setInt(2, user_musica.getMusicaId());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
    
    
    
    public static void inserir(User_Musica user_musica) throws Exception{
        String sql = "INSERT INTO tb_user_musica(userId, musicaId, nota) VALUES (?, ?, ?)";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, user_musica.getUserId());
            ps.setInt(2, user_musica.getMusicaId());
            ps.setInt(3, user_musica.getNota());
            ps.execute();
            ps.close();
        }
    }
    
    public static ArrayList<Musica> obterMusica(int usuarioId) throws Exception{
        ArrayList<Musica> musicas = new ArrayList<>();
        String sql = "SELECT * \n" +
"from tb_musica mus\n" +
"inner join\n" +
"tb_user_genero ug on ug.generoId = mus.generoId\n" +
"where ug.userId=?";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, usuarioId);
                ResultSet rs = ps.executeQuery();{
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
    
}
