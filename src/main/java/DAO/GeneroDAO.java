/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Genero;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class GeneroDAO {
    
    public static ArrayList<Genero> obterGenero() throws Exception{
        ArrayList<Genero> generos = new ArrayList();
        String sql = "SELECT * FROM tb_genero";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        int id = rs.getInt("id");
                        String descricao = rs.getString("descricao");
                        Genero genero = new Genero(id, descricao);
                        generos.add(genero);
                    }
                    return generos;
                }
        
    }
    
    
    
    public static void inserir(Genero genero) throws Exception{
        String sqlInsert = "INSERT INTO tb_genero(descricao) VALUES (?)";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sqlInsert)){
            ps.setString(1, genero.getDescricao());
            ps.execute();
            ps.close();
        }
    }
    
   public static boolean existe (Genero genero) throws Exception{
       String sql = "SELECT * FROM tb_genero WHERE descricao = ?";
       try(Connection conn = ConexaoBD.obterConexao();
               PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setString(1, genero.getDescricao());
           try(ResultSet rs = ps.executeQuery()){
               return rs.next();
           }
       }
   }
   
    
    
    
}
