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
public class User_Musica {
    /*int idPRIMARY KEY AUTO_INCREMENT,
    userId INT,
    musicaId INT,
    nota INT,
    foreign key(userId) references tb_user(id),
    foreign key(musicaId) references tb_musica(id)*/
    
    private int id;
    private int musicaId;
    private int nota;
    private int userId;
    private double media;
    
    public User_Musica(int id, int musicaId, int nota, int userId, double media){
        this.id = id;
        this.musicaId = musicaId;
        this.nota = nota;
        this.userId = userId;
        this.media = media;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMusicaId() {
        return musicaId;
    }

    public void setMusicaId(int musicaId) {
        this.musicaId = musicaId;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
    
}
