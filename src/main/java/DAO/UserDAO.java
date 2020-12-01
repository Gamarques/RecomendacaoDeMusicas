/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Model.User;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class UserDAO {
    
    
    public static void inserir(User user) throws Exception{
    String sqlInsert = "INSERT INTO tb_user(tipoUserId,login, senha) VALUES (2, ?, ?)";
    try(Connection conn = ConexaoBD.obterConexao();
            PreparedStatement ps = conn.prepareStatement(sqlInsert)){
       
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getSenha());
        ps.execute();
        ps.close();
    }
    }
    
   public static boolean existe(User user) throws Exception{
       String sqlSelect = "SELECT * FROM tb_user WHERE login = ? AND senha = ?";
       try(Connection conn = ConexaoBD.obterConexao();
           PreparedStatement ps = conn.prepareStatement(sqlSelect)){
           ps.setString(1, user.getLogin());
           ps.setString(2, user.getLogin());
           try(ResultSet rs = ps.executeQuery()){
               return rs.next();
           }
       }
   }
   
   
}

