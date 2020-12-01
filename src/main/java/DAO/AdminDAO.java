/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Musica;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class AdminDAO {
      public static void inserir(Musica musica) throws Exception{
    String sqlInsert = "INSERT INTO tb_musica(titulo,generoId,artista) VALUES (?, ?,?)";
    try(Connection conn = ConexaoBD.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sqlInsert)){
       
        ps.setString(1, musica.getTitulo());
        ps.setString(2, musica.getGenero());
        ps.setString(3, musica.getArtista());
        ps.execute();
        ps.close();
    }
    }
      
      
      public static void remover(Musica musica) throws Exception{
        String sqlRemove = "DELETE FROM tb_musica WHERE titulo = ? AND artista = ?";
        try(Connection conn = ConexaoBD.obterConexao();
        PreparedStatement ps = conn.prepareStatement(sqlRemove)){
                ps.setString(1, musica.getTitulo());
                ps.setString(2, musica.getArtista());
                ps.execute();
                ps.close();
        }
        }
      
       public static boolean existe(Musica musica) throws Exception{
       String sqlSelect = "SELECT * FROM tb_musica WHERE titulo = ?";
       try(Connection conn = ConexaoBD.obterConexao();
           PreparedStatement ps = conn.prepareStatement(sqlSelect)){
                ps.setString(1, musica.getTitulo());
                try(ResultSet rs = ps.executeQuery()){
               return rs.next();
           }
       }
   } 
       

}
