/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author gabri
 */
public class ConexaoBD{
    private static String login = "";
    private static String senha = "";
    private static String host = "";
    private static String porta = "";
    private static String bd = "";
    
   /* public  Connection obtemConexao(){
        try{
        Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+porta+"/"+bd, login, senha);
        return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
*/
    public static Connection obterConexao() throws Exception{
        String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=America/Sao_Paulo", 
                host,
                porta,
                bd);
        return DriverManager.getConnection(url, login, senha);   
    }
    
    

}

