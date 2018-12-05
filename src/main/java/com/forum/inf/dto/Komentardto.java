package com.forum.inf.dto;

/**
 *
 * @author tayo
 */
public class Komentardto {
    private String judul,isi;

    public Komentardto() {
    }

    public Komentardto(String judul, String isi) {
        this.judul = judul;
        this.isi = isi;
    }    
    
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
    
}
