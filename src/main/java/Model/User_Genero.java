/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author gabri
 */
public class User_Genero {
    private int id;
    private int userId;
    private int generoId;
    private String generoDescricao;
    
    public User_Genero(int id, int userId,int generoId,String generoDescricao){
        this.id = id;
        this.userId = userId;
        this.generoId = generoId;
        this.generoDescricao = generoDescricao;
    }

    public String getGeneroDescricao() {
        return generoDescricao;
    }

    public void setGeneroDescricao(String generoDescricao) {
        this.generoDescricao = generoDescricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }
    
    public String toString(){
        return this.generoDescricao;
    }
}
