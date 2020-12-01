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
public class Recomendacao {
    private double media;
    private String titulo;
    private String artista;
    
    public Recomendacao(double media, String titulo, String artista){
        this.artista = artista;
        this.media = media;
        this.titulo = titulo;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    
    public String toString(){
        return String.format("%s  -  %s  -  %.1f", this.titulo, this.artista, this.media);
    }
}
