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
public class Musica {

     private String titulo;
     private String genero;
     private int codigo;
     private String artista;

    public Musica(int codigo,String titulo, String genero,String artista){
    
    this.titulo = titulo;
    this.genero = genero;
    this.codigo = codigo;
    this.artista = artista;
    }
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
     
  
     
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
     

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String toString(){
        return String.format(this.titulo + " - " + this.artista);
    }
}
