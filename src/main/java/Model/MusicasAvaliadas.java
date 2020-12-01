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
public class MusicasAvaliadas {
    private int musicaId;
    private int nota;
    private int userId;
    public MusicasAvaliadas(int musicaId, int nota, int userId){
        this.musicaId = musicaId;
        this.nota = nota;
        this.userId = userId;
    }
}
