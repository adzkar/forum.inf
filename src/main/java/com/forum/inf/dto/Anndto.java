package com.forum.inf.dto;

import java.util.Date;

/**
 *
 * @author tayo
 */
public class Anndto {
    private int id;
    private String judul, isi;
    private Date tgl;

    public Anndto() {
    }

    public Anndto(int id, String judul, String isi, Date tgl) {
        this.id = id;
        this.judul = judul;
        this.isi = isi;
        this.tgl = tgl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }
    
    
    
}
