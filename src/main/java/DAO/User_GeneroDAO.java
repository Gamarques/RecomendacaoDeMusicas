/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User_Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class User_GeneroDAO {
    
    public static ArrayList<User_Genero> obterUser_Genero() throws Exception{
    ArrayList<User_Genero> user_generos = new ArrayList<>();
    String sql = "select tb_user_genero.id,tb_user_genero.userId, tb_user_genero.generoId, tb_genero.descricao, tb_user.login\n" +
"from tb_user_genero\n" +
"right join tb_genero\n" +
"on tb_user_genero.generoId = tb_genero.id\n" +
"inner join tb_user\n" +
"on tb_user_genero.userId = tb_user.id\n" +
"ORDER BY tb_user_genero.id;";
    try(Connection conn = ConexaoBD.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){{
                while(rs.next()){
                int id = rs.getInt("id");
                int userId = rs.getInt("userId");
                int generoId = rs.getInt("generoId");
                String generoDescricao = rs.getString("descricao");
                User_Genero uG = new User_Genero(id, userId, generoId, generoDescricao);
                user_generos.add(uG);
                }
            }return user_generos;
    }
    }
    
    public static void inserir(User_Genero user_genero) throws Exception{
    String sql = "INSERT INTO tb_user_genero(userId, generoId) VALUES (? , ?)";
    try(Connection conn = ConexaoBD.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
        ps.setInt(1, user_genero.getUserId());
        ps.setInt(2, user_genero.getGeneroId());
        ps.execute();
        ps.close();
    }
   
}
        public static boolean jaAvaliou(int usuarioId) throws Exception{
            String sql = "SELECT * FROM tb_user_genero WHERE userId =?";
            try(Connection conn = ConexaoBD.obterConexao();
                    PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, usuarioId);
                try(ResultSet rs = ps.executeQuery()){
                    return rs.next();
                }
            }
        }
        public static boolean jaAdicionado(User_Genero user_genero) throws Exception{
        String sql = "SELECT * FROM tb_user_genero WHERE userId = ? and generoId = ?";
        try(Connection conn = ConexaoBD.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, user_genero.getUserId());
            ps.setInt(2, user_genero.getGeneroId());
            try(ResultSet rs = ps.executeQuery()){
                return rs.next();
            }
        }
    }
        
        	public static ArrayList<User_Genero> obterUser_Genero2(int variavel) throws Exception{
	 ArrayList<User_Genero> user_generos = new ArrayList<>();
	 String sql = "select tb_user_genero.id,tb_user_genero.userId, tb_user_genero.generoId, tb_genero.descricao, tb_user.login\n" +
"from tb_user_genero\n" +
"right join tb_genero\n" +
"on tb_user_genero.generoId = tb_genero.id\n" +
"inner join tb_user\n" +
"on tb_user_genero.userId = tb_user.id\n" +
"where userId = ?\n" +
"ORDER BY tb_user_genero.id;";
	try(Connection conn = ConexaoBD.obterConexao();
	PreparedStatement ps = conn.prepareStatement(sql)){
	ps.setInt(1, variavel);
	try(ResultSet rs = ps.executeQuery()){
	while(rs.next()){
                int id = rs.getInt("id");
                int userId = rs.getInt("userId");
                int generoId = rs.getInt("generoId");
                String generoDescricao = rs.getString("descricao");
                User_Genero uG = new User_Genero(id, userId, generoId, generoDescricao);
                user_generos.add(uG);
                }
            }return user_generos;
    }
    }
                
                
}
